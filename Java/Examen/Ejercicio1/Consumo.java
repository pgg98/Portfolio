import org.xml.sax.ext.LexicalHandler;

public class Consumo {
    public static void main(String[] args) throws ObjetoNoValidoException {
        MaquinaExpendedora makina=new MaquinaExpendedora(5);

        Producto prod1=new Producto("leche", 1);
        Producto prod2=new Producto("azucar", 2);
        Producto prod3=new Producto("miel", 3);
        Producto prod4=new Producto("avena", 4);
        Producto prod5=new Producto("lechuga", 5);
    }
}