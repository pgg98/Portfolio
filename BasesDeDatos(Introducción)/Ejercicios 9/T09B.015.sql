SELECT codp,p.nombre
FROM provincia p,usuario u
WHERE u.provincia=p.codp
GROUP BY codp,p.nombre
HAVING COUNT(email)>50