import java.util.ArrayList;

public class Querube extends Celestial{

    private int influenciados;

    public Querube(String nom){
        super(nom);

        influenciados=0;
    }

    public double influye(Objeto obj){
        if(obj instanceof Emisor==true){
            Emisor emi;
            emi=(Emisor)obj;

            emi.purifica();

            int ond=emi.getOndas()+1;
            emi.cambiaOndas(ond);
        }else{
            int influ=obj.getInfluencia();
            if(influ<0){
                obj.influenciaPositiva();
            }else{
                obj.sumarInfluencia(2);
            }
        }

        double vEmocional=obj.calculaValorEmocional();
        this.sumaAura(vEmocional);

        influenciados=influenciados+1;

        return vEmocional;

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

            per.actualizaEstado();
            
        }else if(per instanceof Influenciable==true){
            Influenciable influ;
            influ=(Influenciable)per;
            if(influ.getDeidad()==null){
                influ.setDeidad(this);
                setAdeptos(influ);
            }else{
                Celestial celes=influ.getDeidad();
                double aura=celes.getAura();
                double decima=aura/10;
                per.actualizaEstadoConValorDouble(decima);
                celes.restaAura(decima);
            }
        }

        est=per.getEstadoSM();

        return est;

        //No entiendo lo de por defecto devuelve 0
    } 

    public int getInfluenciados(){
        return influenciados;
    }

    public ArrayList<String> obsequia(Tienda t){
        ArrayList<Influenciable> adepts=getAdeptos();
        ArrayList<String> nombres=new ArrayList<String>();

        for(int i=0;i<adepts.size();i++){
            ArrayList<Influenciable> familia=adepts.get(i).getFamilia();
            Influenciable primero=familia.get(0);
            Objeto primer=t.getExistencias()[0][0];
            t.elimina(0,0);
            boolean encontrado=primero.encuentra(primer);

            if(encontrado==true){
                nombres.add(primero.getNombre());
            }
        }

        return nombres;
    }

    //Metodos auxiliares

    public void setInfluenciados(int num){
        influenciados=num;
    }
}