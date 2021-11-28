/**
* @author: Alicia Garrido 
* Se obtienen todos tipos de objetos que hay, y se consulta el nombre, 
* posicion y valor de cada uno de ellos.
* Se crea una serie de personas en las que tanto la edad como el nombre no son
* validos. Se consulta edad y nombre de todas las personas creadas.
* Se muestra por pantalla el resultado de cada accion.
*/
import java.util.*;
import java.text.*;
public class p01{
  private static String mrf(double db){
     Locale lengua=new Locale("en");
     DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
     DecimalFormat formato=new DecimalFormat("0.000",chars);

     return(formato.format(db).toString());
  }
  
  public static void main(String[] args){
    ArrayList<Persona> poi=new ArrayList<>();
    String name=new String("");
    boolean flag=false;
    Persona one=null;
    Tipo[] tipos=Tipo.values();
    for(int i=0;i<tipos.length;i++){
      System.out.println(tipos[i].name()+" -> posicion["+tipos[i].ordinal()+"]; valor="+tipos[i].getValor());
    }
    for(int i=0;i>-10;i--){
      one=new Persona(i,name,flag);
      flag=!flag;
      poi.add(one);
    }
    for(int i=0;i<poi.size();i++){
      one=poi.get(i);
      if(one!=null)
        System.out.println(one.getNombre()+" tiene "+p01.mrf(one.getEdad())+" y es "+one.getGenes());
    }
    
  }
}
