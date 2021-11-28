/**
* @author Alicia Garrido
* Se crean objetos/emisores, un influenciable y un celestial de tipo Diablo.
* El celestial influye en el influenciable. El influenciable encuentran objetos 
* y se consulta su estado y sus pertenencias. 
* Se muestra por pantalla el resultado de cada accion.
*/
import java.util.*;
import java.text.*;
public class p04{
  private static String mrf(double db){
     Locale lengua=new Locale("en");
     DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
     DecimalFormat formato=new DecimalFormat("0.000",chars);

     return(formato.format(db).toString());
  }
  private static void muestraDescripcion(Objeto o){
    if(o!=null){
     ArrayList<String> desc=o.getDescripcion();
     String amo=o.getPoseedor();
     if(desc!=null){
       System.out.print("Descripcion ->");
       for(int i=0;i<desc.size();i++)
          System.out.print(" "+desc.get(i));
     }
     if(amo!=null)
       System.out.print("; amo: "+amo);
     if(o instanceof Emisor){
       System.out.print("; "+((Emisor)o).getOndas()+"; "+(((Emisor)o).getLugar()!=null));
     }
    }
    System.out.println();
  }
  
  private static void creaObjetos(ArrayList<Objeto> array){
    String[] names={"collar","bodas de plata","Peugeot 308","Villa Marta","falda","patatas","anillo","mini torre Eiffel","75.5","Cuqui"};
    int j=0,enza=3;
    Objeto obj=null;
    Tipo[] tipos=Tipo.values();
    int tp=0;
    for(int i=0;i<names.length;i++){
      if(tp<3)
        obj=new Objeto(tipos[j++],names[i],enza++);
      else{
        obj=new Emisor(tipos[j++],names[i],enza++);
        tp=0;
      }
      array.add(obj);
      if(j>=tipos.length){
         j=0;
         enza++;
      }
      tp++;
    }
  }
  private static void consultaPertenencias(Persona p){
    Objeto[] per=p.getPertenencias();
    if(per!=null)
      for(int i=0;i<per.length;i++)
          p04.muestraDescripcion(per[i]);
  }
  public static void main(String[] args){
    ArrayList<Objeto> cosas=new ArrayList<>();
    Influenciable voi=new Influenciable(26.3,new String("Morna"),true);
    Celestial deu=new Diablo(new String("Samael"));
    ArrayList<Influenciable> seguidores=null;
    p04.creaObjetos(cosas);
    double neoestado=deu.influye(voi);
    System.out.println(deu.getNombre()+" ha influido en "+voi.getNombre()+" y su estado ahora es "+p04.mrf(neoestado));
    seguidores=deu.getAdeptos();
    if(seguidores!=null)
      for(int i=0;i<seguidores.size();i++)
       System.out.println(seguidores.get(i).getNombre()+" es adepto de "+deu.getNombre());
    for(int i=0;i<cosas.size();i++){
       Objeto actual=cosas.get(i);
       System.out.println(voi.getNombre()+" encuentra "+actual.getNombre()+" -> "+voi.encuentra(actual));   
    }
    System.out.println("Pertenencias de "+voi.getNombre()+":");
    p04.consultaPertenencias(voi);
    double estado=voi.getEstado();
    System.out.println("El estado actual de "+voi.getNombre()+" es "+p04.mrf(estado));
  }
}