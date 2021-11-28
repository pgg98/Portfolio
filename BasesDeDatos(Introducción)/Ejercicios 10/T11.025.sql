SELECT 'no' respuesta
FROM dual
WHERE NOT EXISTS (SELECT 1 FROM memoria)