public class PagoInsuficienteException extends Exception{
    
    public PagoInsuficienteException(){

    }
    
    public PagoInsuficienteException(double num){
        super(String.valueOf(num));
    }
}