/**
* @author Alicia Garrido
* Se crean objetos/emisores y un celestial de tipo Querube.
* El celestial influye en los objetos. Se consulta descripcion de los
* objetos, numero de objetos influenciados por el querube y su aura.
* Se muestra por pantalla el resultado de cada accion.
*/
import java.util.*;
import java.text.*;
public class p05{
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
    boolean flag=false;
    int tp=0;
    for(int i=0;i<names.length;i++){
      if(tp<3)
        obj=new Objeto(tipos[j++],names[i],enza++);
      else{
        obj=new Emisor(tipos[j++],names[i],enza++);
        tp=0;
        ((Emisor)obj).cambiaOndas(enza);
      }
      array.add(obj);
      if(j>=tipos.length){
         j=0;
         enza++;
      }
      tp++;
      enza=-enza;
    }
  }
  public static void main(String[] args){
    ArrayList<Objeto> cosas=new ArrayList<>();
    Querube deu=new Querube(new String("Hodniel"));
    p05.creaObjetos(cosas);
    for(int i=0;i<cosas.size();i++)
      p05.muestraDescripcion(cosas.get(i));
    for(int i=0;i<cosas.size();i++){
       Objeto actual=cosas.get(i);
       double valor=deu.influye(actual);
       System.out.println(deu.getNombre()+" influye en "+actual.getNombre()+" -> "+p05.mrf(valor));   
    }
    for(int i=0;i<cosas.size();i++)
      p05.muestraDescripcion(cosas.get(i));
    double aura=deu.getAura();
    System.out.println(deu.getNombre()+" ha influido en "+deu.getInfluenciados()+" y su aura es "+p05.mrf(aura));
  }
}