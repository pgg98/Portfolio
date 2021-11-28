SELECT 'si' respuesta
FROM dual
WHERE EXISTS (SELECT 1 FROM marca)