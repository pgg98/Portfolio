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
        if(masPasta>=0){
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

        if(existencias!=null && existencias.length!=0 && existencias[0].length!=0){
            for(int i=0;i<existencias.length;i++){
                for(int j=0;j<existencias[0].length;j++){
                    if(tip!=null && existencias[i][j]!=null && existencias[i][j].getTipo().equalsIgnoreCase(tip.name())==true){   
                        coincidencias.add(existencias[i][j]);
                    }
                }
            
            }
        }

        if(coincidencias.size()==0){
            coincidencias=null;
        }

        return coincidencias;
    }

    public int[] inventario(){
        int[] inven=new int[10];

        //if(existencias!=null && existencias.length!=0 && existencias[0].length!=0){
            ArrayList<Objeto> uno=new ArrayList<Objeto>();
            uno=this.getObjetos(Tipo.RELICARIO);
            if(uno!=null){
                inven[0]=uno.size();
            }

            ArrayList<Objeto> dos=new ArrayList<Objeto>();
            dos=this.getObjetos(Tipo.TARJETA);
            if(dos!=null){
                inven[1]=dos.size();
            }

            ArrayList<Objeto> tres=new ArrayList<Objeto>();
            tres=this.getObjetos(Tipo.COCHE);
            if(tres!=null){
                inven[2]=tres.size();
            }

            ArrayList<Objeto> cuatro=new ArrayList<Objeto>();
            cuatro=this.getObjetos(Tipo.CASA);
            if(cuatro!=null){
                inven[3]=cuatro.size();
            }
        
            ArrayList<Objeto> cinco=new ArrayList<Objeto>();
            cinco=this.getObjetos(Tipo.ROPA);
            if(cinco!=null){
                inven[4]=cinco.size();
            }

            ArrayList<Objeto> seis=new ArrayList<Objeto>();
            seis=this.getObjetos(Tipo.ALIMENTO);
            if(seis!=null){
                inven[5]=seis.size();
            }

            ArrayList<Objeto> siete=new ArrayList<Objeto>();
            siete=this.getObjetos(Tipo.ACCESORIO);
            if(siete!=null){
                inven[6]=siete.size();
            }

            ArrayList<Objeto> ocho=new ArrayList<Objeto>();
            ocho=this.getObjetos(Tipo.RECUERDO);
            if(ocho!=null){
                inven[7]=ocho.size();
            }

            ArrayList<Objeto> nueve=new ArrayList<Objeto>();
            nueve=this.getObjetos(Tipo.DINERO);
            if(nueve!=null){
                inven[8]=nueve.size();
            }

            ArrayList<Objeto> diez=new ArrayList<Objeto>();
            diez=this.getObjetos(Tipo.MASCOTA);
            if(diez!=null){
                inven[9]=diez.size();
            }  
        //}

        return inven;
    }

    public String almacena(Objeto obj,int fil,int col){
        String posF=null;
        int pos1=-1;
        boolean almacenado=false;

        if(obj!=null && obj.getPoseedor()==null){
            if(fil<existencias.length && col<existencias[0].length && fil>=0 && col>=0){
                if(existencias[fil][col]==null){
                    existencias[fil][col]=obj;
                    String filas=String.valueOf(fil);
                    String columnas=String.valueOf(col);
                    posF="("+filas+","+columnas+")";
                    almacenado=true;  
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
                                    almacenado=true;  
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
                                    almacenado=true; 
                                }
                            }
                        }      
                    }
                }
            }
        }

        if(almacenado==true && obj instanceof Emisor==true){
            ((Emisor) obj).setLugar(this); //Downcasting
        }

        return posF;
    }

    public Objeto[] desinventaria(Tipo tip){
        Objeto[] eliminados=null;
        int nl, cont=0;
        if(tip!=null){
            nl=0;
            for(int i=0;i<existencias.length;i++){
                for(int j=0;j<existencias[0].length;j++){
                    if(existencias[i][j]!=null && tip.name().equals(existencias[i][j].getTipo())==true){
                        nl++;
                    }
                }
            }

            if(nl>0){
                eliminados=new Objeto[nl];
                for(int i=0;i<existencias.length;i++){
                    for(int j=0;j<existencias[0].length;j++){
                        if(existencias[i][j]!=null && tip.name().equals(existencias[i][j].getTipo())==true){  
                            eliminados[cont]=existencias[i][j];
                            cont++;
                            existencias[i][j]=null;
                        }
                    }
                }
            }
        }

        return eliminados;
    }

    public Objeto elimina(int fila,int columna){
        Objeto eliminado=null;

        if(fila<existencias.length && columna<existencias[0].length && fila>=0 && columna>=0){
            if(existencias[fila][columna]!=null){
                eliminado=existencias[fila][columna];
                existencias[fila][columna]=null;
            }
        }
        

        return eliminado;
    }

    public boolean busca(String descripcion){
        Boolean resul=false;
        ArrayList<String> descripTA;
        String descripT=null;

        if(descripcion!=null){
            for(int i=0;i<existencias.length;i++){
                for(int j=0;j<existencias[0].length;j++){
                    if(existencias[i][j]!=null){
                        descripTA=existencias[i][j].getDescripcion();
                        descripT=descripTA.get(0)+" "+descripTA.get(1)+" "+descripTA.get(2)+" "+descripTA.get(3);
                    }

                    if(descripT!=null && descripT.equals(descripcion)==true){
                        resul=true;
                    }
                }
            }
        }

        return resul;
        
    }


    //METODOS AUXILIARES

    public int buscaFila(Objeto obj){
        int fila=-1;
        for(int i=0;i<existencias.length && fila<0;i++){
            for(int j=0;j<existencias[0].length && fila<0;j++){
                if(obj==existencias[i][j]){
                    fila=i;
                }
            }
        }

        return fila;
    }

    public int buscaColumna(Objeto obj){
        int columna=-1;
        for(int i=0;i<existencias.length && columna<0;i++){
            for(int j=0;j<existencias[0].length && columna<0;j++){
                if(obj==existencias[i][j]){
                    columna=j;
                }
            }
        }

        return columna;
    }
}