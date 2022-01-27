SELECT DISTINCT l.pueblo
FROM usuario u1,usuario u2,localidad l
WHERE u1.email!=u2.email
	AND u1.pueblo=u2.pueblo AND u1.provincia=u2.provincia
	AND u1.pueblo=l.codm AND u1.provincia=l.provincia