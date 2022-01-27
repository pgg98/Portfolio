import java.util.ArrayList;

public class Tienda{
    //Atributos
    private Objeto[][] existencias;
    private double ganancias;
    private static ArrayList<Tienda> negocios=new ArrayList<Tienda>();

    //Metodos
        //Constructor
        public Tienda(int numF,int numC,double ganan){
            if(numF<=0){
                numF=3;
            }
            if(numC<=0){
                numC=4;
            }
            existencias=new Objeto[numF][numC];

            if(ganan>0){
                ganancias=ganan;
            }else{
                ganancias=0;
            }

            negocios.add(this); 
        }

    public double getGanancias(){
        return ganancias;
    }

    public void setGanancias(double masPasta){
        if(masPasta>0){
            ganancias=ganancias+masPasta;
        }
    }

    public Objeto[][] getExistencias(){
        return existencias;
    }

    public double getGananciaTotal(){
        double gananciasT=0;

        for(int i=0;i<negocios.size();i++){
            gananciasT=gananciasT+negocios.get(i).ganancias; 
        }

        return gananciasT;
    }

    public ArrayList<Objeto> getObjetos(Tipo tip){
        ArrayList<Objeto> coincidencias=new ArrayList<Objeto>();

        for(int i=0;i<existencias.length;i++){
            for(int j=0;j<existencias[0].length;j++){
                if(existencias[i][j].getTipo().equalsIgnoreCase(tip.name())==true){  //EE 
                    coincidencias.add(existencias[i][j]);
                }
            }
            
        }

        return coincidencias;
    }

    public int[] inventario(){
        int[] inven=new int[10];

        ArrayList<Objeto> uno=new ArrayList<Objeto>();
        uno=this.getObjetos(Tipo.RELICARIO);
        inven[0]=uno.size();

        ArrayList<Objeto> dos=new ArrayList<Objeto>();
        dos=getObjetos(Tipo.TARJETA);
        inven[1]=dos.size();

        ArrayList<Objeto> tres=new ArrayList<Objeto>();
        tres=getObjetos(Tipo.COCHE);
        inven[2]=tres.size();

        ArrayList<Objeto> cuatro=new ArrayList<Objeto>();
        cuatro=getObjetos(Tipo.CASA);
        inven[3]=cuatro.size();
        
        ArrayList<Objeto> cinco=new ArrayList<Objeto>();
        cinco=getObjetos(Tipo.ROPA);
        inven[4]=cinco.size();

        ArrayList<Objeto> seis=new ArrayList<Objeto>();
        seis=getObjetos(Tipo.ALIMENTO);
        inven[5]=seis.size();

        ArrayList<Objeto> siete=new ArrayList<Objeto>();
        siete=getObjetos(Tipo.ACCESORIO);
        inven[6]=siete.size();

        ArrayList<Objeto> ocho=new ArrayList<Objeto>();
        ocho=getObjetos(Tipo.RECUERDO);
        inven[7]=ocho.size();

        ArrayList<Objeto> nueve=new ArrayList<Objeto>();
        nueve=getObjetos(Tipo.DINERO);
        inven[8]=nueve.size();

        ArrayList<Objeto> diez=new ArrayList<Objeto>();
        diez=getObjetos(Tipo.MASCOTA);
        inven[9]=diez.size();  

        return inven;
    }

    public String almacena(Objeto obj,int fil,int col){
        String posF=null;
        int pos1=-1;

        if(obj.getPoseedor()==null && obj!=null){
            if(fil<existencias.length && col<existencias[0].length && fil>=0 && col>=0){
                if(existencias[fil][col]==null){
                    existencias[fil][col]=obj;
                    String filas=String.valueOf(fil);
                    String columnas=String.valueOf(col);
                    posF="("+filas+","+columnas+")";  
                }else{
                    for(int i=fil;i<existencias.length && pos1 == -1;i++){
                        if(i==fil){
                            for(int j=col;j<existencias[0].length && pos1 == -1;j++){
                                if(existencias[i][j]==null){
                                    pos1=1;
                                    existencias[i][j]=obj;
                                    String filass=String.valueOf(i);
                                    String columnass=String.valueOf(j);
                                    posF="("+filass+","+columnass+")";  
                                }
                            }
                        }else{
                            for(int j=0;j<existencias[0].length && pos1==-1;j++){
                                if(existencias[i][j]==null){
                                    pos1=1;
                                    existencias[i][j]=obj;
                                    String filass=String.valueOf(i);
                                    String columnass=String.valueOf(j);
                                    posF="("+filass+","+columnass+")";  
                                }
                            }
                        }      
                    }
                }
            }
        }

        return posF;
    }

    public Objeto[] desinventaria(Tipo tip){
        Objeto[] eliminados=null;
        int cont=0;

        for(int i=0;i<existencias.length;i++){
            for(int j=0;j<existencias[0].length;j++){
                if(existencias[i][j]!=null && tip.name().equals(existencias[i][j].getTipo())==true){  
                    eliminados[cont]=elimina(i,j);
                    cont++;
                }
                    

            }
        }

        return eliminados;
    }

    public Objeto elimina(int fila,int columna){
        Objeto eliminado=null;

        if(fila<=existencias.length && columna<=existencias[0].length && fila>=0 && columna>=0){
            if(existencias[fila][columna]!=null){
                eliminado=existencias[fila][columna];
                existencias[fila][columna]=null;
            }
        }
        

        return eliminado;
    }

    public boolean busca(String descripcion){
        boolean resul=false;
        String[] campos=descripcion.split(" ");

        Tipo tip=Tipo.valueOf(campos[0]);
        double val=Double.parseDouble(campos[1]);
        /*Nombre es un String, campos[2] no necesita conversión*/
        int influ=Integer.parseInt(campos[3]);

        for(int i=0;i<existencias.length;i++){
            for(int j=0;j<existencias[0].length;j++){
                if(tip.name().equals(existencias[i][j].getTipo())==true && val==existencias[i][j].getValorIntrinseco() && campos[2]==existencias[i][j].getNombre() && influ==existencias[i][j].getInfluencia()){
                    resul=true;
                }
            }
        }

        return resul;
        
    }
}