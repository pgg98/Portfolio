SET SERVEROUTPUT ON;

DECLARE 
   auxmesactual meses.mes%type:= 'January';
   auxmes meses.mes%type;
   auxmesnuevo meses.mes%type:='Enero';
   auxnohaydoce exception;
   auxcuantosmeses NUMBER(3);

BEGIN
   -- Comprobamos que el mes exista. Si no existe, salta la excepción
   
   select mes into auxmes from meses where mes = auxmesactual;
   
   -- Como hemos pasado de la sentencia anterior sin error, modificamos
   
   update meses set mes = auxmesnuevo where mes = auxmesactual;
   
   -- Contamos ahora el número de meses de la tabla
   
   select count(*) into auxcuantosmeses from meses;
   
   if auxcuantosmeses < 12 then raise auxnohaydoce; end if;
   
   EXCEPTION WHEN
       no_data_found THEN
             raise_application_error(-20001,'El mes '|| auxmesactual || ' no existe.');
       WHEN auxnohaydoce THEN
           dbms_output.put_line('La tabla de meses está incompleta. Hay '|| auxcuantosmeses || ' meses.');    
END;

