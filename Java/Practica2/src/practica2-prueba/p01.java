/**
* @author Alicia Garrido
* Se crea una serie de emisores, se obtiene el valor emocional de todos ellos.
* Se modifican las ondas de todos ellos de distintas formas. Se vuelve a
* obtener el valor emocional de todos ellos.
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
  private static void muestraDescripcion(Emisor o){
    if(o!=null){
     ArrayList<String> desc=o.getDescripcion();
     if(desc!=null){
       System.out.print("Descripcion ->");
       for(int i=0;i<desc.size();i++)
          System.out.print(" "+desc.get(i));
     }
     System.out.print(" "+o.getOndas());
     double v=o.calculaValorEmocional();
     System.out.print(" -> "+p01.mrf(v));
    }
    System.out.println();
  }
  
  private static void creaEmisores(ArrayList<Emisor> array){
    String[] names={"collar","bodas de plata","Peugeot 308","Villa Marta","falda","patatas","anillo","mini torre Eiffel","75.5","Cuqui",
                    "cruz","nacimiento","Mazda mx5","Casa Mila","sueter","bacalao","gemelos","peluche Gizmo","46.2","Firulais",
                    "pendientes","boda","mini cooper","Le Manoir"};
    int j=0,enza=3;
    Tipo[] tipos=Tipo.values();
    for(int i=0;i<names.length;i++){
      Emisor obj=new Emisor(tipos[j++],names[i],enza++);
      array.add(obj);
      if(j>=tipos.length){
         j=0;
         enza++;
      }
    }
  }
  
  public static void main(String[] args){
    ArrayList<Emisor> cosas=new ArrayList<>();
    
    p01.creaEmisores(cosas);
    for(int i=0;i<cosas.size();i++)
      p01.muestraDescripcion(cosas.get(i));
    
    for(int i=cosas.size()-1;i>cosas.size()/2;i--){
       Emisor actual=cosas.get(i);
       System.out.println(actual.getNombre()+" cambia sus ondas a "+actual.cambiaOndas(-i));   
    }
    for(int i=0;i<=cosas.size()/2;i++){
       Emisor actual=cosas.get(i);
       System.out.println(actual.getNombre()+" cambia sus ondas a "+actual.cambiaOndas(i));   
    }
    for(int i=0;i<cosas.size();i++)
      p01.muestraDescripcion(cosas.get(i));
  }
}