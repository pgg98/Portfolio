public class MaquinaExpendedora {
    //Atributos
    private Producto[] productos;
    private double caja;

    //Constructor
    public MaquinaExpendedora(int pro){
        if(pro>0){
            productos=new Producto[pro];
        }else{
            productos=new Producto[10];
        }

        caja=50;
    }

    //Metodos
    public boolean repone(String nom, double pre){
        boolean resul=false;
        double coste=pre*0.4;
        boolean esta=false;
        Producto produc=null;
        boolean libre=false;

        for(int i=0;i<productos.length && esta==false;i++){
            if(productos[i].getNombre().equals(nom)==true && productos[i].getPrecio()==pre){
                esta=true;
                produc=productos[i];
            }
        }

        if(esta==true && caja>=coste){
            produc.incrementa(1);
            caja=caja-coste;
            resul=true;
        }else if(esta==false && caja>=coste){
            Producto nuevo=new Producto(nom, pre);

            for(int i=0;i<productos.length && libre==false;i++){
                if(productos[i]==null){
                    productos[i]=nuevo;
                    libre=true;
                }
            }

            nuevo.incrementa(1);
            caja=caja-coste;
            resul=true;
        }

        return resul;
    }

    public double expende(String nom, double pre) throws PagoInsuficienteException, ProductoNoDisponibleException {
        boolean esta=false;
        Producto produc=null;
        double resul=0;
        boolean nopasta=false;
        Producto producCaro=null;

        for(int i=0;i<productos.length && esta==false;i++){
            if(productos[i].getNombre().equals(nom)==true && productos[i].getPrecio()<=pre){
                esta=true;
                produc=productos[i];
            }
        }

        if(esta==true){
            produc.decrementa();
            caja=caja+pre;
            resul=pre-produc.getPrecio();
        }else{
            for(int i=0;i<productos.length && nopasta==false;i++){
                if(productos[i].getNombre().equals(nom)==true && producCaro==null){
                    nopasta=true;
                    producCaro=productos[i];
                }

                if(productos[i].getNombre().equals(nom)==true && producCaro!=null){
                    nopasta=true;
                    if(producCaro.getPrecio()>productos[i].getPrecio()){
                        producCaro=productos[i];
                    }
                }
            }

            if(nopasta==true){
                throw new PagoInsuficienteException(producCaro.getPrecio());
            }
        }

        if(esta==false && nopasta==false){
            throw new ProductoNoDisponibleException(nom);
        }

        

        return resul;
    }

    public double getCaja(){
        return caja;
    }
}