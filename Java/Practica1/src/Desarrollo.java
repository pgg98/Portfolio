import java.util.ArrayList;
import java.util.*;

public class Desarrollo {

	public static void main(String[] args) {
        /*Una forma de ahorra tiempo es escribir en un fichero de texto los datos y despues ejecutar:
        javac Desarrollo<"fichero.txt"*/

        ArrayList<Objeto> objetos=new ArrayList<Objeto>();
        ArrayList<Persona> personas=new ArrayList<Persona>();
        ArrayList<Tienda> tiendas=new ArrayList<Tienda>();

        Scanner scan=new Scanner(System.in); 
        String opcion=scan.nextLine();
        while(scan.hasNext()){
            String lector=scan.nextLine();
            /*transformar los tipos de datos, crear el objeto del tipo que sea tras aplicar el split sobre el lector
            y añadirlo al arrayList correspondiente*/

            String[] leido=lector.split(";");

            if(leido[0].equalsIgnoreCase("Objeto")==true){
                Tipo t=Tipo.valueOf(leido[1]);
                Integer influ=Integer.parseInt(leido[3]);

                Objeto obj=new Objeto(t, leido[2], influ);

                objetos.add(obj);

            }else if(leido[0].equalsIgnoreCase("Persona")==true){
                Double edad=Double.parseDouble(leido[1]);
                Boolean genes=Boolean.parseBoolean(leido[3]);

                Persona per=new Persona(edad, leido[2], genes);

                personas.add(per);

            }else if(leido[0].equalsIgnoreCase("Tienda")==true){
                Integer num1=Integer.parseInt(leido[1]);
                Integer num2=Integer.parseInt(leido[2]);
                Double num3=Double.parseDouble(leido[3]);

                Tienda tienda=new Tienda(num1, num2, num3);

                tiendas.add(tienda);

            }

        }

        /*Aquí hacer un switch para ordenar el tipo que sea(por nombre, por tal..., coger algoritmo de ordenación-como Collection*/
        
        switch(opcion){
            case "1":

            Objeto[] objs=new Objeto[objetos.size()];

            for(int h=0;h<objetos.size();h++){
                objs[h]=objetos.get(h);
            }

            int i, j; 
            Objeto aux;
            for (i = 0; i < objs.length - 1; i++) {
                for (j = 0; j < objs.length - i - 1; j++) {
                    if (objs[j + 1].getNombre().compareTo(objs[j].getNombre()) < 0) {
                        aux = objs[j + 1];
                        objs[j + 1] = objs[j];
                        objs[j] = aux;
                    }
                }
            }

            /*Imprimir por pantalla*/
            ArrayList<String> objetitos=new ArrayList<String>();
            int k,l;
            for(k=0;k<objs.length;k++){
                objetitos=objs[k].getDescripcion();
                for(l=0;l<objetitos.size();l++){
                    System.out.print(objetitos.get(l));
                    System.out.print(" ");
                }
                System.out.println();
            }

            break;

            case "2":
            Persona[] pers=new Persona[personas.size()];

            for(int h=0;h<personas.size();h++){
                pers[h]=personas.get(h);
            }

            int o, p; 
            Persona aucs;
            for (o = 0; o < pers.length - 1; o++) {
                for (p = 0; p < pers.length - o - 1; p++) {
                    if (pers[p + 1].getEdad() > pers[p].getEdad()) { 
                        aucs = pers[p + 1];
                        pers[p + 1] = pers[p];
                        pers[p] = aucs;
                    }
                }
            }

            /*Imprimir por pantalla*/
            ArrayList<String> personitas=new ArrayList<String>();
            int m,n;
            for(m=0;m<pers.length;m++){
                personitas.add(pers[m].getNombre());
                String edad=String.valueOf(pers[m].getEdad());
                personitas.add(edad);
                String genes=Character.toString(pers[m].getGenes());
                personitas.add(genes);
                String estado=String.valueOf(pers[m].getEstado());
                personitas.add(estado);
                for(n=0;n<personitas.size();n++){
                    System.out.print(personitas.get(n));
                    System.out.print(" ");
                }
                System.out.println();
            }
            break;

            case "3":
            Tienda[] tiends=new Tienda[tiendas.size()];

            for(int h=0;h<tiendas.size();h++){
                tiends[h]=tiendas.get(h);
            }

            int q, w; 
            Tienda haucs;

            

            for (q = 0; q < tiends.length - 1; q++) {
                for (w = 0; w < tiends.length - w - 1; w++) {
                    //if (tiends[w + 1].getEdad() < tiends[w].getEdad()) { //Hay que multiplicar las filas y
                        haucs = tiends[w + 1];                             // las columnas de exiestencias de Tienda
                        tiends[w + 1] = tiends[w];                         //para sacar la capacidad pero no se como hacerlo
                        tiends[w] = haucs;
                    //}
                }
            }

            /*Imprimir por pantalla*/
            ArrayList<String> tienditas=new ArrayList<String>();
            int z,x;
            for(z=0;z<pers.length;z++){
                //Cosas que representar
                for(x=0;x<personitas.size();x++){
                    System.out.print(tienditas.get(x));
                    System.out.print(" ");
                }
                System.out.println();
            }
            break;

            default:
            /*Aquí copia los 3 seguidos, sin más*/
            break;
        }
    }
}