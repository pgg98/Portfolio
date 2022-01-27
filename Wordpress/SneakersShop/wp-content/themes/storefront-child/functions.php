<?php
// Exit if accessed directly
if ( !defined( 'ABSPATH' ) ) exit;

// BEGIN ENQUEUE PARENT ACTION
// AUTO GENERATED - Do not modify or remove comment markers above or below:

if ( !function_exists( 'chld_thm_cfg_locale_css' ) ):
    function chld_thm_cfg_locale_css( $uri ){
        if ( empty( $uri ) && is_rtl() && file_exists( get_template_directory() . '/rtl.css' ) )
            $uri = get_template_directory_uri() . '/rtl.css';
        return $uri;
    }
endif;
add_filter( 'locale_stylesheet_uri', 'chld_thm_cfg_locale_css' );

// END ENQUEUE PARENT ACTION


//Login y Logout
add_filter( 'wp_nav_menu_items', 'dcms_items_login_logout', 10, 2);

function dcms_items_login_logout( $items, $args ) {

	if ($args->theme_location == 'primary') {
		if (is_user_logged_in())
		{
			$items .= '<li class="menu-item btn-menu btn-logout">
						<a href="'. wp_logout_url(get_permalink()) .'">'. __("Log Out") .'</a>
						</li>';
		}
		else
		{
			$items .= '<li class="menu-item btn-menu btn-login">
						<a href="'. wp_login_url(get_permalink()) .'">'. __("Log In") .'</a>
						</li>';
		}
	}

	return $items;
}
//Fin login y logout

add_action('pre_get_posts', 'add_my_post_types_to_query');
function add_my_post_types_to_query($query){
	if (is_home() && $query->is_main_query())
		$query->set('post_type', array('post', 'promociones'));
	return $query;
	
}


// Shortcode for exclusive content
	add_shortcode( 'exclusive' , 'logged_in_content' );
	function logged_in_content ($atts , $content = null) {
		$user = wp_get_current_user();
		if( ! empty( $user ) && in_array( "promotor", (array) $user->roles ) ) {
			return '<p>' . $content .'</p>';
		}else return;
	
	}


	function cptui_register_my_cpts_promo() {

		/**
		 * Post Type: Promociones.
		 */
	
		$labels = [
			"name" => __( "Promociones", "custom-post-type-ui" ),
			"singular_name" => __( "Promocion", "custom-post-type-ui" ),
			"menu_name" => __( "Promociones", "custom-post-type-ui" ),
			"all_items" => __( "Todas las promociones", "custom-post-type-ui" ),
			"add_new" => __( "Añadir nuevo", "custom-post-type-ui" ),
			"add_new_item" => __( "Añadir nueva promocion", "custom-post-type-ui" ),
			"edit_item" => __( "Editar promocion", "custom-post-type-ui" ),
			"new_item" => __( "Nueva promocion", "custom-post-type-ui" ),
			"view_item" => __( "Ver promocion", "custom-post-type-ui" ),
			"view_items" => __( "Ver promociones", "custom-post-type-ui" ),
			"search_items" => __( "Buscar promociones", "custom-post-type-ui" ),
		];
	
		$args = [
			"label" => __( "Promociones", "custom-post-type-ui" ),
			"labels" => $labels,
			"description" => "",
			"public" => true,
			"publicly_queryable" => true,
			"show_ui" => true,
			"show_in_rest" => true,
			"rest_base" => "",
			"rest_controller_class" => "WP_REST_Posts_Controller",
			"has_archive" => "promos",
			"show_in_menu" => true,
			"show_in_nav_menus" => true,
			"delete_with_user" => false,
			"exclude_from_search" => false,
			"capability_type" => "promo",
			"map_meta_cap" => true,
			"hierarchical" => false,
			"rewrite" => [ "slug" => "promo", "with_front" => true ],
			"query_var" => true,
			"supports" => [ "title", "editor", "thumbnail" ],
			"show_in_graphql" => false,
		];
	
		register_post_type( "promo", $args );
	}
	
	add_action( 'init', 'cptui_register_my_cpts_promo' );
	