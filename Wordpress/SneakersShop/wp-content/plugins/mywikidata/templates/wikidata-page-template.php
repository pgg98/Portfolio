<?php
/**
 * Template Name: Wikidata Page
 *
 */
?>

<?php get_header() ?>


<article class="page type-page status-publish hentry">
    <header class="entry-header">
		<h1 class="entry-title">Buscador de autores</h1>
		
	</header><!-- .entry-header -->
	
	<div class="entry-content">
		Consulta los autores por movimientos literarios y recupera información de Wikidata
	</div><!-- .entry-content -->
	
	<form method="post" name="front_end" action="" >
		<p>
		<label for="numresults">Movimiento:</label><br>
		<select class="postform" name="movement">
		  <option value="Q530936" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q530936') echo ' selected="selected"'; ?>>Siglo de Oro</option>
		  <option value="Q37068" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q37068') echo ' selected="selected"'; ?>>Romanticismo</option>
		  <option value="Q2302005" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q2302005') echo ' selected="selected"'; ?>>Generación del 50</option>
		  <option value="Q1126248" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q1126248') echo ' selected="selected"'; ?>>Generación del 98</option>
		  <option value="Q667661" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q667661') echo ' selected="selected"'; ?>>Realismo literario</option>
		  <option value="Q397469" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q397469') echo ' selected="selected"'; ?>>Neorromanticismo</option>
		  <option value="Q5600643" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q5600643') echo ' selected="selected"'; ?>>Modernismo</option>
		  <option value="Q1122677" <?php if (isset($_POST['movement']) && $_POST['movement'] == 'Q1122677') echo ' selected="selected"'; ?>>Modernismo catalán</option>
		</select>
		</p>
		
		<p>
		<label for="numresults">Número resultados:</label><br>
		<select class="postform" name="numresults">
		  <option value="10">10</option>
		  <option value="20">20</option>
		  <option value="50">50</option>
		  <option value="100">100</option>
		  <option value="all">Todos</option>
		</select>
		</p>
		<input type="hidden" name="new_search" value="1"/>
		<button class="search-submit" type="submit">Buscar</button>
	</form>
	
<?php

	if(isset($_POST['new_search']) == '1') {
		$movement = $_POST['movement'];
		
		if(isset($numresults))
			$numresults = $_POST['numresults'];
		else
			$numresults = 10;
		
		mywikidata_movement_wikidata_call($movement, $numresults);
	}
?>
		
	
            
</div>


<?php get_footer() ?>