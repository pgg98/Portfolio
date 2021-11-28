import java.util.ArrayList;

public class Objeto{
    //Atributos
    private Tipo tipo;
    private String nombre;
    private int influencia;
    private String poseedor;

    //Metodos
        //Constructor
        public Objeto(Tipo tip, String nomb,int influen){
            
            
            influencia=influen;

            if(tip==null){
                tipo=Tipo.TARJETA;
            }else{
                tipo=tip;
            }


            if(nomb==null || nomb.isEmpty()){
                nombre="intrascendente";
            }else{
                nombre=nomb;
            }

            poseedor=null;
        }

    public String getTipo(){
        String tip=String.valueOf(tipo);

        return tip;
    }

    public String getNombre(){
        return nombre;
    }

    public double getValorIntrinseco(){
        return tipo.getValor();             
    }

    public int getInfluencia(){
        return influencia;
    }

    public String getPoseedor(){
        return poseedor;
    }

    public void setPoseedor(String dueño){
        poseedor=dueño;
    }

    public double calculaValorEmocional(){
        double valorE;

        valorE=(tipo.getValor()*influencia)/100; //tbm puede ser this.getValorIntrinseco

        return valorE;
    }

    public ArrayList<String> getDescripcion(){
        ArrayList<String> Descripcion=new ArrayList<String>();

        
        String influ=String.valueOf(influencia);
        Descripcion.add(tipo.name());
        Descripcion.add(String.valueOf(tipo.getValor())); 
        Descripcion.add(nombre);
        Descripcion.add(influ);
        

        return Descripcion;
    }

    public boolean cambiaInfluencia(int num){
        int sum=influencia+num;
        boolean resul;

        if(sum>influencia){
            resul=true;
        }else{
            resul=false;
        }

        return resul;
    }
}