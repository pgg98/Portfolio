SELECT
(SELECT COUNT(*) FROM tv)/(SELECT COUNT(*) FROM articulo)*100 tvPC,
(SELECT COUNT(*) FROM camara)/(SELECT COUNT(*) FROM articulo)*100 camarasPC,
(SELECT COUNT(*) FROM objetivo)/(SELECT COUNT(*) FROM articulo)*100 objetivosPC
