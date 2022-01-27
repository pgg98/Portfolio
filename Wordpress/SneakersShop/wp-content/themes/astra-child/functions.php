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
         
if ( !function_exists( 'child_theme_configurator_css' ) ):
    function child_theme_configurator_css() {
        wp_enqueue_style( 'chld_thm_cfg_separate', trailingslashit( get_stylesheet_directory_uri() ) . 'ctc-style.css', array( 'astra-theme-css','astra-menu-animation' ) );
    }
endif;
add_action( 'wp_enqueue_scripts', 'child_theme_configurator_css', 10 );

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


//Formulario forntend para promociones


//Fin formulario frontend


// Shortcode for exclusive content
	add_shortcode( 'exclusive' , 'logged_in_content' );
	function logged_in_content ($atts , $content = null) {
		$user = wp_get_current_user();
		if( ! empty( $user ) && in_array( "promotor", (array) $user->roles ) ) {
			return '<p>' . $content .'</p>';
		}else return;
	
	}