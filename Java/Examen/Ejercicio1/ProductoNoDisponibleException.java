public class ProductoNoDisponibleException extends Exception{
    
    public ProductoNoDisponibleException(){

    }
    
    public ProductoNoDisponibleException(String nom){
        super(nom);
    }
}