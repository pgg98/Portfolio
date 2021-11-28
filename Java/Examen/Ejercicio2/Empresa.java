import java.util.ArrayList;

public class Empresa {
    //Atributos
    private String nombre;
    private ArrayList<Empleado> empleados;

    //Constructor
    public Empresa(String nom){
        if(nom!=null){
            nombre=nom;
        }

        empleados=new ArrayList<Empleado>();
    }

    //Metodos
    public boolean Contrata(Empleado em){
        boolean resul=false;

        if(em.getContratado()==false){
            em.contrata();
            empleados.add(em);
        }

        return resul;
    }

    public Empleado despide(String cat, boolean bol){
        Empleado despedido=null;
        boolean prim=false;

        if(bol==true){
            for(int i=0;i<empleados.size() && prim==false;i++){
                if(cat.equals(empleados.get(i).categoria())){
                    despedido=empleados.get(i);
                    empleados.get(i).despide();
                    empleados.remove(i);
                }
            }
        }else{
            for(int i=0;i<empleados.size() && prim==false;i++){
                if(empleados.get(i) instanceof Programador==true){
                    if(cat.equals(empleados.get(i).categoria())){
                        despedido=empleados.get(i);
                        empleados.get(i).despide();
                        empleados.remove(i);
                    }
                }
            }
        }

        return despedido;
    }

    public Empleado[] programadores(){
        Empleado[] contratados=new Empleado[empleados.size()];

        for(int i=0;i<empleados.size();i++){
            if(empleados.get(i) instanceof Programador==true){
                contratados[i]=empleados.get(i);
            }
        }

        return contratados;
    }

    public Empleado[] empleados(){
        Empleado[] contratados=new Empleado[empleados.size()];

        for(int i=empleados.size()-1;i==0;i--){
            if(empleados.get(i) instanceof Programador==false){
                contratados[i]=empleados.get(i);
            }
        }

        return contratados;
    }

    public String getNombre(){
        return nombre;
    }
}