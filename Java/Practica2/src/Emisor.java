import java.util.ArrayList;

public class Emisor extends Objeto{

    private int ondas;
    private Tienda lugar;

    public Emisor(Tipo tip, String nom, int influ){
        super(tip,nom,influ);

        ondas=1;

        lugar=null;
    }


    public double getValorIntrinseco(){
        double VI=super.calculaValorEmocional();   

        return VI;
    }

    public double calculaValorEmocional(){
        double CVE=super.calculaValorEmocional(); 

        double nuevo=CVE*ondas;

        return nuevo;
    }

    public int getOndas(){
        return ondas;
    }

    public boolean setLugar(Tienda t){
        //Hay que modificar Almacena de Tienda
        boolean resul=false;

        if(t==null && lugar!=null){
            //Objeto este=this; Upcasting por si fuera necesario
            int fila=lugar.buscaFila(this);
            int columna=lugar.buscaColumna(this);
            lugar.elimina(fila, columna);

            lugar=t;
            resul=true;
        }else if(lugar==null && t!=null){
            lugar=t;
            resul=true;
        }

        return resul;
    }

    public int emana(){
        int fila=-1;
        int columna=-1;
        int cent=-1;
        int objs=0;
        int onds=this.ondas; //Math.abs(ondas);
        if(this.ondas<0){
            onds=-this.ondas;
        }        

        if(this.lugar!=null){
            Objeto[][] exis=lugar.getExistencias();

            for(int i=0;i<exis.length /*&& cent==-1*/;i++){
                for(int j=0;j<exis[0].length /*&& cent==-1*/;j++){
                    if(/*exis[i][j].equals(this)==true*/ exis[i][j]==this){
                        fila=i;
                        columna=j;
                        cent=0;
                    }
                }
            }

            for(int i=fila-onds;i<=fila+onds/*+1*/;i++){
                if(i>=0 && i<exis.length){
                    for(int j=columna-onds;j<=columna+onds/*+1*/;j++){
                        if(/*i>=0 &&*/ j>=0 /*&& i<exis.length*/ && j<exis[0].length){
                            if(exis[i][j]!=null && exis[i][j]!=this /*&& exis[i][j] instanceof Emisor==false*/){
                                int multi=exis[i][j].getInfluencia()*this.ondas;
                                if(multi>exis[i][j].getInfluencia()){
                                    objs++;
                                }
                                exis[i][j].multiplicaInfluencia(onds);
                            }
                        }
                    }
                }
            }
        }

        return objs;
    }

    

    public void purifica(){
        if(ondas<0){
            ondas=ondas*(-1);
        }
    }

    public void envilece(){
        if(ondas>=0){
            ondas=ondas*(-1);
        }
    }

    public int cambiaOndas(int ond){
        int Vactual;

        Vactual=ondas+ond;

        if(Vactual<-3){
            Vactual=-3;
        }

        if(Vactual>3){
            Vactual=3;
        }

        ondas=Vactual;

        return Vactual;
    }

    public Tienda getLugar(){
        return lugar;
    }

}