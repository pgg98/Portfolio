/**
* @author Alicia Garrido
* Se crean una serie de objetos, emisores y una tienda. La tienda almacena
* los objetos a partir de la misma posicion siempre hasta que llena sus existencias. 
* A continuacion se invoca emana del primer emisor almacenado en la tienda. El influenciable
* adquiere uno de los emisores almacenados en la tienda.
* Se muestra por pantalla el resultado de cada accion.
*/
import java.util.*;
import java.text.*;
public class p02{
  private static String mrf(double db){
     Locale lengua=new Locale("en");
     DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
     DecimalFormat formato=new DecimalFormat("0.000",chars);

     return(formato.format(db).toString());
  }
  private static void muestraDescripcion(Objeto o){
    if(o!=null){
     ArrayList<String> desc=o.getDescripcion();
     if(desc!=null){
       System.out.print("Descripcion ->");
       for(int i=0;i<desc.size();i++)
          System.out.print(" "+desc.get(i));
     }
     if(o instanceof Emisor){
       System.out.print(" "+((Emisor)o).getOndas()+" "+(((Emisor)o).getLugar()!=null));
     }
    }
    System.out.println();
  }
  
  private static void creaObjetos(ArrayList<Objeto> array){
    String[] names={"collar","bodas de plata","Peugeot 308","Villa Marta","falda","patatas","anillo","mini torre Eiffel","75.5","Cuqui",
                    "cruz","nacimiento","Mazda mx5","Casa Mila","sueter","bacalao","gemelos","peluche Gizmo","46.2","Firulais",
                    "pendientes","boda","mini cooper","Le Manoir"};
    int[] enza={3,2,6,8,3,6,8,5,1,9,6,3,1,6,9,3,4,5,2,8,3,5,6,2};
    int j=0;
    Objeto obj=null;
    Tipo[] tipos=Tipo.values();
    int tp=0;
    for(int i=0;i<names.length&&i<enza.length;i++){
      if(tp<2)
        obj=new Objeto(tipos[j++],names[i],enza[i]);
      else{
        obj=new Emisor(tipos[j++],names[i],enza[i]);
        tp=0;
      }
      array.add(obj);
      if(j>=tipos.length){
         j=0;
      }
      tp++;
    }
  }
  private static Emisor almacena(Tienda hiper,ArrayList<Objeto> cosas){
    Emisor primer=null;
    if(hiper!=null){
      int f=0,c=0;
      String lugar=null;
      Objeto buxaca=null;
      for(int i=0;i<cosas.size();i++){
        buxaca=cosas.get(i);
        lugar=hiper.almacena(buxaca,f,c);
        if(lugar!=null){
           System.out.println(buxaca.getNombre()+" almacenado en "+lugar);
           if(primer==null && buxaca instanceof Emisor)
             primer=(Emisor)buxaca;
        }
        else
           System.out.println(buxaca.getNombre()+" no almacenado");
      }
    }
    return primer;
  }
  
  private static void consultaExistencias(Tienda hiper){
    Objeto[][] exis=hiper.getExistencias();
    if(exis!=null){
      for(int i=0;i<exis.length;i++){
        for(int j=0;j<exis[i].length;j++){
          System.out.print("["+i+","+j+"] -> ");
          p02.muestraDescripcion(exis[i][j]);
        }
      }
    }
  }
  private static void consultaPertenencias(Persona p){
    Objeto[] per=p.getPertenencias();
    if(per!=null)
      for(int i=0;i<per.length;i++)
          p02.muestraDescripcion(per[i]);
  }
  
  public static void main(String[] args){
    ArrayList<Objeto> cosas=new ArrayList<>();
    Tienda colmado=new Tienda(5,5,6.5);
    Influenciable poi=new Influenciable(22.6,new String("Morna"),true);
    Emisor emite=null;
    p02.creaObjetos(cosas);
    emite=p02.almacena(colmado,cosas);
    p02.consultaExistencias(colmado);
    if(emite!=null)
      System.out.println(emite.getNombre()+" afecta a "+emite.emana()+" objetos a su alrededor");
    p02.consultaExistencias(colmado);
    Tipo comprado=Tipo.ACCESORIO;
    boolean compra=poi.adquiere(colmado,comprado);
    System.out.println(poi.getNombre()+" compra un "+comprado.name()+" -> "+compra);
    p02.consultaPertenencias(poi);
  }
}