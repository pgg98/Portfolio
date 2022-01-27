/**
* @author: Alicia Garrido
* Se crean una serie de objetos, una persona y una tienda. La persona encuentra algunos objetos
* y la tienda intenta almacenar todos los objetos en distintas posiciones, 
* que pueden ser correctas o no, de sus existencias.
* Se consulta la descripcion de las existencias de la tienda. Se muestra por pantalla
* el resultado de cada accion
*/
import java.text.*;
import java.util.*;
public class p04{
  private static String mrf(double db){
     Locale lengua=new Locale("en");
     DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
     DecimalFormat formato=new DecimalFormat("0.000",chars);

     return(formato.format(db).toString());
  }
  
  private static void creaCosas(ArrayList<Objeto> array){
    String[] names={"colgante","cumple","kia ceed","chalet","camisa","tomates","reloj","sombrilla","billete50","perro",
                    "cofre","aniversario","seat leon","apartamento","vestido","caviar","corbata","iman","billete20","gato"};
    int j=0,enza=3;
    Tipo[] tipos=Tipo.values();
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipos[j++],names[i],enza++);
      array.add(obj);
      if(j>=tipos.length){
         j=0;
         enza=5;
      }
    }
  }

  private static void muestraDescripcion(Objeto o){
    if(o!=null){
     ArrayList<String> desc=o.getDescripcion();
     if(desc!=null){
       System.out.print("Descripcion ->");
       for(int i=0;i<desc.size();i++)
          System.out.print(" "+desc.get(i));
     }
    }
    System.out.println();
  }
  
  private static void consultaExistencias(Tienda hiper){
    Objeto[][] exis=hiper.getExistencias();
    if(exis!=null){
      for(int i=0;i<exis.length;i++){
        for(int j=0;j<exis[i].length;j++){
          System.out.print("["+i+","+j+"] -> ");
          p04.muestraDescripcion(exis[i][j]);
        }
      }
    }
  }
  public static void main(String[] args){
    ArrayList<Objeto> cosas=new ArrayList<>();
    Tienda colmado=new Tienda(3,5,1);
    Persona anonima=new Persona(17.8,"Ed",false);
    int f=-1,c=0,i=0;
    String lugar=null;
    Objeto guarda=null;
    p04.creaCosas(cosas);
    System.out.println(anonima.getNombre()+" se encuentra un "+cosas.get(17).getNombre()+" -> "+anonima.encuentra(cosas.get(17)));
    if(cosas.get(1).getPoseedor()!=null)
        System.out.println("El poseedor del "+cosas.get(17).getNombre()+" es "+cosas.get(1).getPoseedor());
    while(f<3){
      if(i<cosas.size())
        guarda=cosas.get(i);
      lugar=colmado.almacena(guarda,f,c);
      c++;i++;
      if(lugar!=null)
        System.out.println(guarda.getNombre()+" almacenado en "+lugar);
      else{
        System.out.println(guarda.getNombre()+" no almacenado en ("+f+","+(c-1)+")");
        f++;
        c=0;
      }
    }
    p04.consultaExistencias(colmado);
  }
  
}
