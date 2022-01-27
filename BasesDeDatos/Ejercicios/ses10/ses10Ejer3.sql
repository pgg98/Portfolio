create or replace function Dame_tamanyo_minmax(pTipo in number) return number is

xReturn number:=0;

begin 

    if pTipo=1 then
        select MIN(tamanyo) into xReturn
        from disponible_para;
    end if;
    
    if pTipo=2 then
        select MAX(tamanyo) into xReturn
        from disponible_para;
    end if;
    
    return xReturn;
end;
    