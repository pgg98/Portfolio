import java.util.ArrayList;
import java.util.Collections;

public class Programador extends Empleado {
    //Atributos
    private ArrayList<String> lenguajes;

    //Constructor hijo
    public Programador(String nom, double ed, double su){
        super(nom, ed, su);

        lenguajes=new ArrayList<String>();
    }

    //Metodos
    public double aumento(int por){
        int subir=por+(int)(lenguajes.size()/2);

        double diferencia=super.aumento(subir);

        return diferencia;
    }

    public boolean agregaLenguaje(String len){
        boolean resul=false;
        boolean esta=false;

        if(len!=null){
            for(int i=0;i<lenguajes.size();i++){
                if(lenguajes.get(i).equals(len)==true){
                    esta=true;
                }
            }

            if(esta==false){
                lenguajes.add(len);
                resul=true;
            }
        }

        return resul;
    }

    public boolean borraLenguaje(String len){
        boolean resul=false;

        if(len!=null){
            for(int i=0;i<lenguajes.size();i++){
                if(lenguajes.get(i).equals(len)==true){
                    lenguajes.remove(i);
                    resul=true;
                }
            }
        }

        return resul;
    }

    public String[] lenguajesConocidos(){
        String[] conocidos=new String[lenguajes.size()];

        for(int i=0;i<lenguajes.size();i++){
            conocidos[i]=lenguajes.get(i);
        }

        //Collections.sort(conocidos); Falta ordenar por orden alfabetico

        return conocidos;
    }
}