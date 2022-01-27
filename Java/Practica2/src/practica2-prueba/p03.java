/**
* @author Alicia Garrido
* Se crean dos influenciables y un celestial. El celestial influye a ambos
* influenciables, que se emparejan y mantienen una relacion. Se consulta
* estado, deidad, pareja, relaciones y familia de ambos influenciables. 
* Se muestra por pantalla el resultado de cada accion.
*/
import java.util.*;
import java.text.*;
public class p03{
  private static String mrf(double db){
     Locale lengua=new Locale("en");
     DecimalFormatSymbols chars=new DecimalFormatSymbols(lengua);
     DecimalFormat formato=new DecimalFormat("0.000",chars);

     return(formato.format(db).toString());
  }
  private static void consultaInfluenciable(Influenciable bee){
    if(bee!=null){
      Celestial pagano=bee.getDeidad();
      Influenciable contrario=bee.getPareja();
      ArrayList<Persona> amigos=bee.getRelaciones();
      ArrayList<Influenciable> fills=bee.getFamilia();
      double v=bee.getEstado();
      System.out.print(bee.getNombre()+"("+bee.getGenes()+")");
      if(contrario!=null)
        System.out.print(" o<->o "+contrario.getNombre()+"("+contrario.getGenes()+")");
      System.out.print(" - "+p03.mrf(v));
      if(pagano!=null)
        System.out.print(" - "+pagano.getNombre()+"("+pagano.getClass().getName()+")");
      System.out.println();
      System.out.println("Relaciones:");
      if(amigos!=null && amigos.size()>0){
        for(int i=0;i<amigos.size();i++)
          System.out.print(amigos.get(i).getNombre()+" ");
        System.out.println();
      }
      System.out.println("Hijos:");
      if(amigos!=null && fills.size()>0){
        for(int i=0;i<fills.size();i++)
          System.out.print(fills.get(i).getNombre()+" ");
        System.out.println();          
      }
      
    }
  }
  public static void main(String[] args){
    Influenciable inicia=new Influenciable(33.5,new String("Ron"),false);
    Influenciable secunda=new Influenciable(26.3,new String("Marni"),true);
    Celestial deu=new Querube(new String("Galadriel"));
    Celestial santo=new Querube(new String("Uriel"));
    ArrayList<Influenciable> seguidores=null;
    double neoestado=deu.influye(inicia);
    System.out.println(deu.getNombre()+" ha influido en "+inicia.getNombre()+" y su estado ahora es "+p03.mrf(neoestado));
    neoestado=santo.influye(secunda);
    System.out.println(santo.getNombre()+" ha influido en "+secunda.getNombre()+" y su estado ahora es "+p03.mrf(neoestado));
    seguidores=deu.getAdeptos();
    if(seguidores!=null)
      for(int i=0;i<seguidores.size();i++)
       System.out.println(seguidores.get(i).getNombre()+" es adepto de "+deu.getNombre());
    seguidores=santo.getAdeptos();
    if(seguidores!=null)
      for(int i=0;i<seguidores.size();i++)
       System.out.println(seguidores.get(i).getNombre()+" es adepto de "+santo.getNombre());
    boolean pareja=inicia.empareja(secunda);
    System.out.println(inicia.getNombre()+" se empareja con "+secunda.getNombre()+" -> "+pareja);    
    neoestado=inicia.relaciona(secunda);
    System.out.println(inicia.getNombre()+" se relaciona con "+secunda.getNombre()+" -> "+p03.mrf(neoestado));
    p03.consultaInfluenciable(inicia);
    p03.consultaInfluenciable(secunda);
    seguidores=inicia.getFamilia();
    if(seguidores!=null && seguidores.size()>0)
      for(int i=0;i<seguidores.size();i++)
        p03.consultaInfluenciable(seguidores.get(i));
  }
}