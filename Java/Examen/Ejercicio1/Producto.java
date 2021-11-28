public class Producto {
    //Atributos
    private double precio;
    private String nombre;
    private int cantidad;

    //Constructor
    public Producto(String nom, double pre) throws ObjetoNoValidoException {
        if(nom==null){
            throw new ObjetoNoValidoException("producto no valido");
        }else{
            nombre=nom;
        }

        if(pre>0){
            precio=pre;
        }else{
            precio=1;
        }

        cantidad=0;
    }

    //Metodos
    public boolean incrementa(int num){
        boolean resul=false;

        if(num>0){
            cantidad=cantidad+num;
            resul=true;
        }

        return resul;
    }

    public boolean decrementa(){
        boolean resul=false;

        if(cantidad>0){
            cantidad=cantidad-1;
        }

        return resul;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getCantidad(){
        return cantidad;
    }
}