public class Empleado {
    //Atributos
    private String nombre;
    private double edad;
    private double sueldo;
    private boolean contratado;

    //Constructor
    public Empleado(String nom, double ed, double su){
        if(nom!=null){
            nombre=nom;
        }

        if(ed>=0){
            edad=ed;
        }

        if(su>=1000 && su<=2500){
            sueldo=su;
        }else if(su<1000){
            sueldo=1000;
        }else if(su>2500){
            sueldo=2500;
        }

        contratado=false;
    }

    //Metodos
    public String categoria(){
        String cat=null;

        if(edad<22){
            cat="principiante";
        }else if(edad>=22 && edad<=40){
            cat="intermedio";
        }else{
            cat="senior";
        }

        return cat;
    }

    public double aumento(int por){
        double diferencia=0;
        double anterior=sueldo;

        if(por>0){
            if(sueldo<2500){
                sueldo=sueldo+(sueldo*(por*0.01));
                if(sueldo>2500){
                    sueldo=2500;
                }

                diferencia=sueldo-anterior;
            }
        }

        return diferencia;
    }

    public String getNombre(){
        return nombre;
    }

    public double getEdad(){
        return edad;
    }

    public double getSueldo(){
        return sueldo;
    }

    public boolean getContratado(){
        return contratado;
    }

    public void contrata(){
        contratado=true;
    }

    public void despide(){
        contratado=false;
    }
}