<?php
 
/*
Plugin Name: University of Alicante Wikidata Plugin
Plugin URI: http://www.ua.es/wikidata
Description: Create a search page for wikidata.
Version: 1.0
Author: Departamento de Lenguajes y Sistemas Informáticos
Author URI: http://www.dlsi.ua.es/
*/
 
require_once 'easyrdf/vendor/autoload.php';


register_activation_hook(__FILE__,'mywikidata_install');

function mywikidata_install() {
   global $wp_version;
   If (version_compare($wp_version, "2.9", "<")) 
    { 
      deactivate_plugins(basename(__FILE__)); // Deactivate plugin
      wp_die("This plugin requires WordPress version 2.9 or higher.");
    }
    
    // create page
    mywikidata_check_pages_live();
}

add_filter( 'template_include', 'mywikidata_page_template');

function mywikidata_page_template( $template ) {

    if ( is_page( 'wikidata-search' )  ) {
        $new_template = plugin_dir_path( __FILE__ ) . 'templates/wikidata-page-template.php';
		return $new_template;
    }

    return $template;
}


function mywikidata_check_pages_live(){
    if(get_page_by_title( 'wikidata-search') == NULL) {
        mywikidata_create_pages_fly('wikidata-search');
    }
}

function mywikidata_create_pages_fly($pageName) {
	$createPage = array(
	  'post_title'    => $pageName,
	  'post_content'  => 'Wikidata Search Example',
	  'post_status'   => 'publish',
	  'post_author'   => 1,
	  'post_type'     => 'page',
	  'post_name'     => $pageName
	);

	// Insert the post into the database
	wp_insert_post( $createPage );
}

function mywikidata_movement_wikidata_call($movement, $numresults){
	
	$sparql = new \EasyRdf\Sparql\Client('http://query.wikidata.org/sparql');
	
	echo "<hr><h2>Listado de autores</h2>";
    echo "<table cellspacing='0' cellpadding='0'>";

		$result = $sparql->query(
			'SELECT * WHERE {'.
			'  ?writer wdt:P106 wd:Q36180 .'.
			'  OPTIONAL {?writer wdt:P18 ?imagen } .'.
			'  OPTIONAL {?writer wdt:P569 ?_date_of_birth .'.
			'            BIND( year(?_date_of_birth) as ?birthYear )}.'.
            '  OPTIONAL {?writer wdt:P570 ?_date_of_death.'.
            '            BIND( year(?_date_of_death) as ?deathYear )}.'.
			'  ?writer wdt:P135 wd:'. $movement .' .'.
			'  ?writer rdfs:label ?label .'.
			'  FILTER ( lang(?label) = "es" )'.
			'} ORDER BY ?label '.
			'LIMIT '.$numresults
		);
		foreach ($result as $row) {
			echo "<tr>";
			if(isset($row->imagen))
			    echo "<td><img heigth='100px' width='100px' src='".$row->imagen."'></td>";
			else 
				echo "<td><img heigth='100px' width='100px' src='".plugin_dir_url( __FILE__ ) . "img/no-imagen.jpg'></td>";
			echo "<td><b class='fn'><a class='url' target='_blank' href='".$row->writer."'>" .$row->label. "</a></b><br>";
			if(isset($row->birthYear))
			    echo $row->birthYear;
			if(isset($row->deathYear))
			    echo ' - ' .$row->deathYear;
			echo "</td></tr>";
		}
	echo "</table>";	
}

?>