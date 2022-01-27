<?php
/**
 * The template for displaying all single posts.
 *
 * @package storefront
 */

get_header(); ?>


<div class="wrap">
	<div id="primary" class="content-area">
		
		
			
		<main id="main" class="site-main" role="main">

		<?php
		while ( have_posts() ) :
			/*the_post();

			do_action( 'storefront_single_post_before' );

			get_template_part( 'content', 'single' );

			do_action( 'storefront_single_post_after' );*/

			the_post();

			$type=get_post_type(get_the_ID());

			if($type=='promo'){
				the_title();

				the_post_thumbnail();

				the_content();
				the_meta();
			}

		endwhile; // End of the loop.
		?>


		</main><!-- #main -->
	</div><!-- #primary -->
</div>
<?php
do_action( 'storefront_sidebar' );
get_footer();
