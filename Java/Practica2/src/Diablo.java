import java.util.ArrayList;

public class Diablo extends Celestial{

    public Diablo(String nom){
        super(nom);
    }

    public double influye(Objeto obj){
        if(obj instanceof Emisor==true){
            Emisor emi;
            emi=(Emisor)obj;

            emi.envilece();
        }else{
            double vEmocional=obj.calculaValorEmocional();
            this.sumaAura(vEmocional);

            int influ=obj.getInfluencia();
            if(influ>0){
                obj.influenciaPositiva();
            }else{
                obj.restarInfluencia(1);
            }
        }

        double vEmocionalDespues=obj.calculaValorEmocional();

        return vEmocionalDespues;

        //No entiendo lo de por defecto devuelve 0
    }

    public double influye(Persona per){
        double est=0;

        if(per instanceof Influenciable==false){
            Objeto[] pertenen=per.getPertenencias();
            for(int i=0;i<pertenen.length;i++){
                double influ=influye(pertenen[i]);
            }
            per.setPertenencias(pertenen);
            
        }else if(per instanceof Influenciable==true){
            Influenciable influ;
            influ=(Influenciable)per;
            if(influ.getDeidad()==null){
                influ.setDeidad(this);
                this.setAdeptos(influ);
            }else{
                double estado=influ.getEstadoSM()/4;
                Celestial celes=influ.getDeidad();
                celes.sumaAura(estado);
                influ.restaEstadoConValorDouble(estado);

                Influenciable pareja=influ.getPareja();
                if(pareja!=null){
                    influ.setPareja(null);
                }
            }
        }

        est=per.getEstadoSM();

        return est;
    }

    public ArrayList<String> diaboliza(){
        ArrayList<Influenciable> adeptos=getAdeptos();
        ArrayList<String> nombres=new ArrayList<String>();

        for(int i=0;i<adeptos.size();i++){
            ArrayList<Influenciable> familia=adeptos.get(i).getFamilia();

            for(int j=0;j<familia.size();j++){
                Celestial deid=familia.get(j).getDeidad();

                if(deid instanceof Diablo==false){ 
                    familia.get(j).setDeidad(this);
                    nombres.add(familia.get(j).getNombre());
                }
            }
        }

        return nombres;
    }
}