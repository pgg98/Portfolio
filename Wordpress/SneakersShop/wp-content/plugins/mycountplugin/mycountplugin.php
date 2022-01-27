<?php
/*
Plugin Name: mycountplugin
Plugin URI: http://www.mycountplugin.com
Description: a plugin to count post views
Version: 1.0
Author:
License: GPL2
*/

add_action("mycp", "mycp_add_view");

/** Adds a view to the post being viewed*/
function mycp_add_view() {
	if(is_single()) {
	global $post;
	$current_views = get_post_meta($post->ID, "mycp_views", true);
	if(!isset($current_views) OR
	empty($current_views) OR
	!is_numeric($current_views) ) {
	$current_views = 0;
	}
	$new_views = $current_views + 1;
	update_post_meta($post->ID, "mycp_views", $new_views);
	return $new_views;
	}
	}
	add_action("wp_head", "mycp_add_view");

/** Retrieve the number of views for a post*/
function mycp_get_view_count() {
	global $post;
	$current_views = get_post_meta($post->ID, "mycp_views", true);
	if(!isset($current_views) OR
	empty($current_views) OR
	!is_numeric($current_views) ) {
	$current_views = 0;
	}
	return $current_views;
	}

/* Shows the number of views for a post */
function mycp_show_views($singular = "view",
$plural = "views",
$before = "This post has: ") {
global $post;
$current_views = mycp_get_view_count();
$views_text = $before . $current_views . " ";
if ($current_views == 1) {
$views_text .= $singular;
}
else {
$views_text .= $plural;
}
echo $views_text;
}

/* Displays a list of posts ordered by post count*/
function mycp_popularity_list($post_count = 10) {
	$args = array(
	"posts_per_page" => 10,
	"post_type" => "promo",
	"post_status" => "publish",
	"meta_key" => "mycp_views",
	"orderby" => "meta_value_num",
	"order" => "DESC"
	);

	$mycp_list = new WP_Query($args);
	if($mycp_list->have_posts()) { echo "<ul>"; }

	//Fecha actual
	//$fecha_actual = strtotime(date("d-m-Y H:i:00",time()));
	$fecha_actual = date("Y")."-".date("m")."-".date("d");
	$fecha_actual2 = date("Y").date("m").date("d");

	while ( $mycp_list->have_posts() ) : $mycp_list->the_post();

		//$key='fecha_fin_de_oferta';
		$fecha_promo=(get_post_meta(get_the_ID(), 'fecha_de_fin_de_oferta', true));

		/*echo $fecha_promo;
		echo "<br>";
		echo $fecha_actual;*/

		//Filtramos fecha
		if($fecha_promo > $fecha_actual || $fecha_promo > $fecha_actual2){
			echo '<li><a href="'.get_permalink(/*$post->ID*/).'">'.the_title('', '',false).'</a></li>';
			the_post_thumbnail();
			mycp_show_views("visita", "visitas", "Este post tiene: ");
			echo "<br>";
		}

	endwhile;
	if($mycp_list->have_posts()) { echo "</ul>";}
}



	add_shortcode('lista', 'mycp_popularity_list');

	function siteURL() {
		return 'https://localhost/wordpress/';
	}

	add_shortcode('numvisitas', 'mycp_get_view_count');
			
	


?>