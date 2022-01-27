<?php
/**
 * Template Name: page-insert-promo-restricted
 *
 * Inserts posts of a Custom Post Type.
 */

if(isset($_POST['new_post']) == '1') {

// Comprobamos el nonce como medida de seguridad
//if ( !isset( $_POST['fpj_form_noncename'] ) || ! wp_verify_nonce( $_POST['fpj_form_noncename'], 'fpj_form' ) ) {
//     echo "no va el nonce";
//     return;
//  }
$title     = $_POST['titulo'];
$content   = $_POST['descripcion'];
$post_type = 'promo';
$precio = $_POST['precio'];  
$fecha_de_fin_de_oferta = $_POST['fecha_de_fin_de_oferta'];  
$descuento = $_POST['descuento'];

$wordpress_upload_dir = wp_upload_dir();
$new_file_name = $_FILES["custom-upload"]["name"];
$new_file_path = $wordpress_upload_dir['path'] . '/' .
$new_file_name;

while( file_exists( $new_file_path )){
	$i++;
	$new_file_path = $wordpress_upload_dir['path'] . '/' . $i . '_' . $new_file_name;
}

$mime = mime_content_type($_FILES["custom-upload"]['tmp_name']);

$new_post = array(
'post_title'    => $title,
'post_content'  => $content,
'post_status'   => 'publish',          
'post_type'     => $post_type 
);

$post_id = wp_insert_post($new_post);
add_post_meta($post_id, 'precio', $precio, true);
add_post_meta($post_id, 'fecha_de_fin_de_oferta', $fecha_de_fin_de_oferta, true);
add_post_meta($post_id, 'descuento', $descuento, true);
// This will redirect you to the newly created post
$post = get_post($post_id);


if(move_uploaded_file( $_FILES["custom-upload"]['tmp_name'], $new_file_path )){
	$upload_id = wp_insert_attachment( array(
		'guid' => $new_file_path,
		'post_mime_type' => $mime,
		'post_title' => sanitize_file_name($new_file_name),
		'post_content' => '',
		'post_status' => 'inherit'
	),
		$new_file_path
	);

	require_once(ABSPATH . 'wp-admin/includes/image.php');
    wp_update_attachment_metadata($upload_id, $new_file_path,wp_generate_attachment_metadata($upload_id,
                        $new_file_path));
    set_post_thumbnail($post_id, $upload_id);
	
}

wp_redirect($post->guid);

}

get_header(); ?>

<div class="wrap">

	<header class="page-header">
		<h1 class="page-title">NUEVA PROMOCIÓN</h1>
	</header><!-- .page-header -->

	<div id="primary" class="content-area">
		<main id="content" class="site-content" role="main">

			<?php
			//--------------------------
			if( is_user_logged_in() ) {
			//--------------------------
			?>
			 <article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>
					<?php
						// Page thumbnail and title.
                        echo '<div class="single-featured-image-header">'; 
                        //the_post_thumbnail( 'twentyseventeen-featured-image' );
						//the_post_thumbnail();
                        echo '</div><!-- .single-featured-image-header -->'; the_title( '<header class="entry-header"><h1 class="entry-title">', '</h1></header><!-- .entry-header -->' );
						?>
					
				<div class="entry-content">
					<form method="post" name="front_end" action="" enctype="multipart/form-data">
						<p>
						<label class="label" for="Titulo"><?php _e("Titulo "); ?></label>
						<input type="text" name="titulo" size="45" />
						</p>
						<p>
						<label class="label" for="Descripcion"><?php _e("Descripcion "); ?></label>
						<textarea rows="4"  cols="66" name="descripcion"/></textarea> 
						</p>
						<p>
						<label class="label" for="Precio"><?php _e("Precio "); ?></label>
						<input type="number" name="precio" size="45" />
						</p>
						<p>
						<label class="label" for="fecha_de_fin_de_oferta"><?php _e("Fecha Fin De Oferta "); ?></label>
						<input type="date" name="fecha_de_fin_de_oferta" size="45" />
						</p>
						<p>
						<label class="label" for="Descuento"><?php _e("Descuento "); ?></label>
						<input type="number" name="descuento" size="45" />
						</p>
						<p>
						<label class="label" for="Imagen"><?php _e("Imagen "); ?></label>
						<input type="file" name="custom-upload" id="custom-upload" />
						</p>
						<input type="hidden" name="new_post" value="1"/>
						<button type="submit">Añadir</button>
					</form>
				<?php
					//the_content();
				?>
				</div><!-- .entry-content -->
  			</article><!-- #post-## -->

			<?php
				//--------------------------
			}
			else echo  '<h1 class="page-title">CONTENIDO SOLO ACCESIBLE A USUARIOS REGISTRADOS</h1>';
			//--------------------------
			?>

		</main><!-- #main -->
	</div><!-- #primary -->
</div><<!-- .wrap -->

<?php
//get_sidebar();
get_footer();
?>