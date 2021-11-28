public enum Tipo{

    RELICARIO(4.5),TARJETA(3.2),COCHE(9.0),CASA(10),ROPA(6.8),
    ALIMENTO(5.5),ACCESORIO(7),RECUERDO(8),DINERO(10),MASCOTA(5);

    //Atributos
    private double valor;

    //Metodos

        //Constructor
        private Tipo(double num){
            valor=num;
        }
    
    public double getValor(){
        return valor;
    }
}