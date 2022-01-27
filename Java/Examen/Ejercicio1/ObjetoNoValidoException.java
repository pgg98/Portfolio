public class ObjetoNoValidoException extends Exception{
    
    public ObjetoNoValidoException(){

    }
    
    public ObjetoNoValidoException(String nom){
        super(nom);
    }
}