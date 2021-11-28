/**
* @author: Alicia Garrido
* Se crean una serie de objetos y una tienda. La tienda almacena los objetos en
* la misma posición siempre hasta que llena sus existencias. 
* A continuación se invoca getObjetos de la tienda
* con cada tipo de objeto y se muestra la descripción de los objetos devueltos.
* Se muestra por pantalla el resultado de cada accion
*/
import java.util.*;
public class p03{
  private static ArrayList<Objeto> reli=null,tar=null,coc=null,cas=null,rop=null,al=null,acc=null,rec=null,din=null,mas=null;
  
  private static void creaRel(){
    reli=new ArrayList<Objeto>();
    String[] names={"collar","cruz","colgante","cofre","joyero"};
    int j=0,enza=3;
    Tipo tipo=Tipo.RELICARIO;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      reli.add(obj);
    }
  }
  private static void creaTar(){
    tar=new ArrayList<Objeto>();
    String[] names={"bodas de plata","aniversario","San Valentin","nacimiento","despedida de soltero","primer trabajo"};
    int j=0,enza=3;
    Tipo tipo=Tipo.TARJETA;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      tar.add(obj);
    }
  }
  private static void creaCoc(){
    coc=new ArrayList<Objeto>();
    String[] names={"fiat panda","nissan almera","renault captur","mercedes gla"};
    int j=0,enza=3;
    Tipo tipo=Tipo.COCHE;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      coc.add(obj);
    }
  }
  private static void creaCas(){
    cas=new ArrayList<Objeto>();
    String[] names={"Casa Laguna"};
    int j=0,enza=10;
    Tipo tipo=Tipo.CASA;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      cas.add(obj);
    }
  }
  private static void creaRop(){
    rop=new ArrayList<Objeto>();
    String[] names={"sueter","camisa","pantalones","vestido","falda","camisola","vestido palabra de honor","minifalda","traje","camiseta","bikini"};
    int j=0,enza=3;
    Tipo tipo=Tipo.ROPA;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      rop.add(obj);
    }
  }
  private static void creaAl(){
    al=new ArrayList<Objeto>();
    String[] names={"pan","galletas","chocolate","palomitas","calabaza","nocilla","miel","aceite","sal","mermelada","caramelo","tortitas"};
    int j=0,enza=3;
    Tipo tipo=Tipo.ALIMENTO;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      al.add(obj);
    }
  }
  private static void creaAcc(){
    acc=new ArrayList<Objeto>();
    String[] names={"lazo","ganchos","gemelos","bufanda","pajarita","corbata","pendientes"};
    int j=0,enza=3;
    Tipo tipo=Tipo.ACCESORIO;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      acc.add(obj);
    }
  }
  private static void creaRec(){
    rec=new ArrayList<Objeto>();
    String[] names={"peluche Simba","entrada concierto","iman nevera","cenicero"};
    int j=0,enza=3;
    Tipo tipo=Tipo.RECUERDO;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      rec.add(obj);
    }
  }
  private static void creaDin(){
    din=new ArrayList<Objeto>();
    String[] names={"10","20","5","50","100","200","500"};
    int j=0,enza=3;
    Tipo tipo=Tipo.DINERO;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      din.add(obj);
    }
  }
  private static void creaMas(){
    mas=new ArrayList<Objeto>();
    String[] names={"Chispa","Cuqui","Firulais","Monster","Brilo","Zan","Bull","Raspa"};
    int j=0,enza=3;
    Tipo tipo=Tipo.MASCOTA;
    for(int i=0;i<names.length;i++){
      Objeto obj=new Objeto(tipo,names[i],enza++);
      mas.add(obj);
    }
  }

  private static void almacena(Tienda hiper,ArrayList<Objeto> cosas){
    if(hiper!=null){
      int f=0,c=0;
      String lugar=null;
      Objeto buxaca=null;
      for(int i=0;i<cosas.size();i++){
        buxaca=cosas.get(i);
        lugar=hiper.almacena(buxaca,f,c);
        if(lugar!=null)
           System.out.println(buxaca.getNombre()+" almacenado en "+lugar);
        else
           System.out.println(buxaca.getNombre()+" no almacenado");
      }
    }
  }
  private static void almacena(Tienda hiper){
    if(hiper!=null){
      p03.almacena(hiper,reli);
      p03.almacena(hiper,cas);
      p03.almacena(hiper,coc);
      p03.almacena(hiper,al);
      p03.almacena(hiper,tar);
      p03.almacena(hiper,mas);
      p03.almacena(hiper,acc);
      p03.almacena(hiper,din);
      p03.almacena(hiper,rop);
      p03.almacena(hiper,rec);
    }
  }
  private static void creaCosas(){
      p03.creaRel();
      p03.creaCas();
      p03.creaCoc();
      p03.creaAl();
      p03.creaTar();
      p03.creaMas();
      p03.creaAcc();
      p03.creaDin();
      p03.creaRop();
      p03.creaRec();
  }
  private static void muestraDescripcion(Objeto o){
    if(o!=null){
     ArrayList<String> desc=o.getDescripcion();
     if(desc!=null){
       System.out.print("Descripcion ->");
       for(int i=0;i<desc.size();i++)
          System.out.print(" "+desc.get(i));
       System.out.println();
     }
    }
  }
  
  
  private static void consulta(Tienda hip){
    if(hip!=null){
      Tipo[] tipos=Tipo.values();
      for(int i=0;i<tipos.length;i++){
        ArrayList<Objeto> ob=hip.getObjetos(tipos[i]);
        if(ob!=null){
          for(int j=0;j<ob.size();j++)
            p03.muestraDescripcion(ob.get(j));
        }
      }
    }
  }
  public static void main(String[] args){
    ArrayList<Objeto> cosas=new ArrayList<>();
    Tienda colmado=new Tienda(7,9,2);
    p03.creaCosas();
    p03.almacena(colmado);
    p03.consulta(colmado);
  }
  
}
