/**
* @author: Alicia Garrido
* Se crean dos objetos de los cuales se consultan sus caracteristicas de distinta forma: el primero
* invocando sus metodos para obtener sus valores, y el segundo obteniendo la descripcion del objeto.
* Se muestra por pantalla el resultado de cada accion.
*/
import java.text.*;
import java.util.*;
public class p02{
  private static String mrf(double db){
     Locale lengua=new Locale("en");
     DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
     DecimalFormat formato=new DecimalFormat("0.000",chars);

     return(formato.format(db).toString());
  }

  private static void muestraObjeto(Objeto o){
     String tob=o.getTipo();
     String amo=o.getPoseedor();
     System.out.println("Datos del objeto "+o.getNombre()+":");
     if(tob!=null)
        System.out.println("Tipo -> "+tob.toLowerCase());
     else
        System.out.println("No tiene tipo");
     System.out.println("Valor -> "+o.getValorIntrinseco());
     System.out.println("Influencia -> "+o.getInfluencia());
     if(amo!=null)
        System.out.println("Poseedor -> "+amo);
     else
        System.out.println("No tiene poseedor");
     double emo=o.calculaValorEmocional();
     System.out.println("Valor emocional -> "+p02.mrf(emo));
  }
  
  private static void muestraDescripcion(Objeto o){
     ArrayList<String> desc=o.getDescripcion();
     if(desc!=null){
       System.out.print("Descripcion ->");
       for(int i=0;i<desc.size();i++)
          System.out.print(" "+desc.get(i));
       System.out.println();
     }
  }
  
  public static void main(String[] args){
     Objeto primero=new Objeto(Tipo.ROPA,"camiseta",5);
     Objeto segundo=new Objeto(Tipo.TARJETA,"aniversario",9);
     
     p02.muestraObjeto(primero);
     p02.muestraDescripcion(segundo);
     
  }
}
