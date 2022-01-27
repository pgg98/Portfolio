import java.util.ArrayList;

public class Influenciable extends Persona{
    private Celestial deidad;
    private Influenciable pareja;
    private ArrayList<Persona> relaciones;
    private ArrayList<Influenciable> familia;

    public Influenciable(double hedad,String nom,boolean gen){
        super(hedad,nom,gen);

        hedad=0;

        pareja=null;

        relaciones=new ArrayList<Persona>();

        familia= new ArrayList<Influenciable>();
    }

    public boolean encuentra(Objeto obj){
        boolean resul;

        if(deidad==null || obj instanceof Emisor==false){
            resul=super.encuentra(obj);
        }else if(deidad!=null && obj instanceof Emisor==true && (obj.getPoseedor()==null || obj.getPoseedor().equals(""))){
            //No se si se refiere a esto:
            Emisor emi;
            emi=(Emisor)obj;
            if(deidad instanceof Querube==true){
                emi.purifica();
            }else if(deidad instanceof Diablo==true){
                emi.envilece();
            }

            this.addPrincipioPertenen(obj);

            obj.setPoseedor(this.getNombre());  

            resul=true;
        }else{
            resul=false;
        }

        return resul;
    }

    public boolean adquiere(Tienda t,Tipo emi){
        int i,j,posi,posj;
        posi=posj=0;
        boolean hecho=false;
        double coste,estado;
        coste=1000000;
        Objeto barato=null;

        if(emi!=null && t!=null){
            Objeto[][] objetos=t.getExistencias();

            //Saco el objeto de menor coste y su posición
            for (i = 0; i<objetos.length /*&& !hecho*/; i++){
                for(j=0;j<objetos[0].length /*&& !hecho*/;j++){
                    if(objetos[i][j]!=null && objetos[i][j].getTipo().equals(emi.name()) && objetos[i][j] instanceof Emisor && Math.abs(objetos[i][j].getValorIntrinseco())<coste){
                        coste=Math.abs(objetos[i][j].getValorIntrinseco());
                        barato=objetos[i][j];
                        posi=i;
                        posj=j;
                    }
                }
            }

            //Transaccion
            if(barato!=null && this.getEstadoSM()>=coste /*&& barato.getTipo().equalsIgnoreCase(emi.name())==true*/){ 
                estado = this.getEstadoSM()-coste;
                this.setEstado(estado);

                this.addPertenencias(barato);

                barato.setPoseedor(this.getNombre());

                objetos[posi][posj]=null;

                t.setGanancias(coste);

                Emisor pablo=(Emisor)barato;
                pablo.setLugar(null);
            
                hecho=true;
            }
        }

        return hecho;
    }

    public boolean empareja(Influenciable influen){
        boolean resul=false;

        if(influen!=null){
            if(influen!=this){
                if(influen.getPareja()==null && this.getPareja()==null){
                    if(sonFamilia(this, influen)==false){
                        if((influen.getDeidad() instanceof Querube==true && this.getDeidad() instanceof Querube==true) || (influen.getDeidad() instanceof Diablo==true && this.getDeidad() instanceof Diablo==true)){
                            eliminarDeRelaciones(this, influen);

                            this.setPareja(influen);
                            influen.setPareja(this);

                            this.actualizaEstadoConValor(3);
                            influen.actualizaEstadoConValor(3);
            
                            resul=true;
                        }
                    }  
                }
            }
        }

        return resul;
    }

    public double relaciona(Persona per){
        //Estado anterior
        double estadoAnterior=this.getEstadoSM();
        //System.out.println(estadoAnterior);

        int cent=-1;
        boolean igual1=false;
        boolean igual2=false;
        boolean deid=false;
        for(int i=0;i<relaciones.size() && cent==-1;i++){
            if(relaciones.get(i)==per){
                igual1=true;
                cent=0;
            }
        }

        if(per!=this.pareja){
            igual2=true;
        }

        if(igual1==false && igual2==true){
            relaciones.add(per);
        }

        Influenciable influ;
        influ=(Influenciable)per;
        if(influ.getDeidad()==null){
            deid=true;
        }

        if(this.deidad instanceof Diablo==true && influ!=this.pareja){
            //Traza
            //System.out.println("ha llegado a diablo de este infleunciable");

            if(per instanceof Influenciable==true){
                //Traza
                //System.out.println("ha llegado a la persona pasada por parametro es un influenciable");

                if(influ.getDeidad() instanceof Diablo==true){
                    //Traza
                    //System.out.println("ha llegado a la deidad de esta persona es un diablo");

                    int cont1=relaciones.size();
                    int cont2=influ.getRelaciones().size();
                    this.actualizaEstadoConValor(cont1);
                    per.actualizaEstadoConValor(cont2);
                }else if(influ.getDeidad() instanceof Querube==true){
                    //Traza
                    //System.out.println("ha llegado a la deidad de esta persona es un diablo");

                    int cont1=familia.size();
                    int cont2=influ.getFamilia().size();
                    this.actualizaEstadoConValor(cont1);
                    per.actualizaEstadoConValor(cont2);
                }
            }else if(per instanceof Influenciable==false || deid==true){
                //Traza
                //System.out.println("ha llegado a la persona no es un influenciable o lo es pero no tiene deidad");

                double est=this.getEstadoSM()/2;
                per.actualizaEstadoConValorDouble(est);
                this.restaEstadoConValorDouble(est);
            }else if(influ==this.pareja){
                //Traza
                //System.out.println("ha llegado a la persona pasada por parametro es su pareja");

                if((this.getGenes()=='M' && per.getGenes()=='V') || (this.getGenes()=='V' && per.getGenes()=='M')){
                    //Traza
                    System.out.println("ha llegado a ha tenido un hijo");

                    String nom=null;
                    char gen;
                    boolean genes=false;
                    double edad;
                    Celestial deidadd=null;

                    if(this.getGenes()=='M' && per.getGenes()=='V'){
                        nom=per.getNombre()+" "+this.getNombre();
                    }else if(this.getGenes()=='V' && per.getGenes()=='M'){
                        nom=this.getNombre()+" "+per.getNombre();
                    }

                    if(this.getEstadoSM()<per.getEstadoSM()){
                        gen=this.getGenes();
                        if(gen=='M'){
                            genes=true;
                        }
                    }else if(this.getEstadoSM()>=per.getEstadoSM()){
                        gen=per.getGenes();
                        if(gen=='M'){
                            genes=true;
                        }
                    }

                    double pos=(this.getEdad()+per.getEdad())%10;
                    //No tengo claro como sacar ahora el valor de Edades de esa posición
                    double[] edades=this.getEdades();
                    int po=(int)pos;
                    edad=edades[po];

                    Influenciable hijo=new Influenciable(edad, nom, genes);

                    if(this.getEstadoSM()<per.getEstadoSM()){
                        deidadd=influ.getDeidad();
                    }else if(this.getEstadoSM()>=per.getEstadoSM()){
                        deidadd=this.getDeidad();
                    }

                    hijo.setDeidad(deidadd);

                    this.añadirFamilia(hijo);
                    influ.añadirFamilia(hijo);

                    this.actualizaEstadoConValorDouble(3.5);
                    per.actualizaEstadoConValorDouble(3.5);
                }else{
                    //Traza
                    //System.out.println("ha llegado a no ha tenido un hijo");
                    this.actualizaEstadoConValorDouble(1.5);
                    per.actualizaEstadoConValorDouble(1.5);
                }
            }
        }else if(this.deidad instanceof Querube==true){
            //Traza
            //System.out.println("ha llegado a la deidad de este influenciable es un querube");

            if(per instanceof Influenciable==true && influ!=this.pareja){
                //Traza
                //System.out.println("ha llegado a la persona pasada por parametro es un inlfuenciable");
                if(influ.getDeidad() instanceof Querube==true){
                    //Traza
                    //System.out.println("ha llegado a la persona-influ tiene una deidad querube");
                    //if(sonFamilia(influ, this)==false){
                        //Traza
                        //System.out.println("ha llegado a no son familia");

                        int cont1=0;
                        int cont2=0;
                        
                        for(int i=0;i<this.getRelaciones().size();i++){
                            Influenciable influen;
                            influen=(Influenciable)this.getRelaciones().get(i);

                            boolean igual3=false;

                            for(int j=0;j<this.getFamilia().size();j++){
                                if(influen==this.getFamilia().get(j)){
                                    igual3=true;
                                }
                            }

                            if(influen.getDeidad() instanceof Querube==true && igual1==false){
                                cont1++;
                            }
                        } 
                        
                        for(int i=0;i<influ.getRelaciones().size();i++){
                            Influenciable influen;
                            influen=(Influenciable)influ.getRelaciones().get(i);

                            boolean igual4=false;

                            for(int j=0;j<influ.getFamilia().size();j++){
                                if(influen==influ.getFamilia().get(j)){
                                    igual4=true;
                                }
                            }

                            if(influen.getDeidad() instanceof Querube==true && igual2==false){
                                cont2++;
                            }
                        } 

                        this.actualizaEstadoConValor(cont1);
                        //System.out.println("Contador1 "+cont1);
                        per.actualizaEstadoConValor(cont2);
                        //System.out.println("Contador2 "+cont2);
                    //}
                }else if(influ.getDeidad() instanceof Diablo==true){
                    //Traza
                    //System.out.println("ha llegado a la persona-influ tiene una deidad diablo");
                    int centi=-1;
                    int pos=0;
                    for(int i=0;i<this.getDeidad().getAdeptos().size() /*&& centi=-1*/;i++){
                        if(this==this.getDeidad().getAdeptos().get(i)){
                            pos=i;
                            centi=0;
                        }
                    }

                    if(cent==0){
                        this.getDeidad().eliminaAdepto(pos);
                    }

                    this.setDeidad(null);

                    this.actualizaEstadoConValor(1);
                    per.actualizaEstadoConValor(1);
                }
            }else if(per instanceof Influenciable==false || deid==true){
                //Traza
                //System.out.println("ha llegado a la persona pasada por parametro no es un inlfuenciable o lo es pero sin deidad");
                
                this.actualizaEstadoConValor(1);
                per.restaEstadoConValor(1);
            }else if(influ==this.pareja){
                //Traza
                //System.out.println("ha llegado a son pareja");

                if((this.getGenes()=='M' && per.getGenes()=='V') || (this.getGenes()=='V' && per.getGenes()=='M')){
                    //Traza
                    //System.out.println("ha llegado a tiene un hijo");
                    String nom=null;
                    char gen;
                    boolean genes=false;
                    double edad;
                    Celestial deidadd=null;

                    if(this.getGenes()=='M' && per.getGenes()=='V'){
                        nom=this.getNombre()+"-"+per.getNombre();
                    }else if(this.getGenes()=='V' && per.getGenes()=='M'){
                        nom=per.getNombre()+"-"+this.getNombre();
                    }

                    if(this.getEstadoSM()>per.getEstadoSM()){
                        gen=per.getGenes();
                        if(gen=='M'){
                            genes=true;
                        }
                    }else if(this.getEstadoSM()<=per.getEstadoSM()){
                        gen=this.getGenes();
                        if(gen=='M'){
                            genes=true;
                        }
                    }

                    double pos=(this.getEdad()+per.getEdad())%10;
                    //No tengo claro como sacar ahora el valor de Edades de esa posición
                    double[] edades=this.getEdades();
                    int po=(int)pos;
                    edad=edades[po];

                    Influenciable hijo=new Influenciable(edad, nom, genes);

                    if(this.getEstadoSM()>per.getEstadoSM()){
                        deidadd=influ.getDeidad();
                    }else if(this.getEstadoSM()<=per.getEstadoSM()){
                        deidadd=this.getDeidad();
                    }

                    hijo.setDeidad(deidadd);

                    this.añadirFamilia(hijo);
                    influ.añadirFamilia(hijo);

                    this.actualizaEstadoConValor(4);
                    per.actualizaEstadoConValor(4);
                }else{
                    //Traza
                    //System.out.println("ha llegado a no tienen un hijo");

                    this.actualizaEstadoConValor(2);
                    per.actualizaEstadoConValor(2);
                }
            }
        }else{ //No tiene deidad
            //Traza
            //System.out.println("ha llegado a este influenciable no tiene deidad");

            this.actualizaEstadoConValorDouble(0.5);
            per.actualizaEstadoConValorDouble(0.5);
        }

        double estadoActual=this.getEstadoSM();
        //System.out.println(estadoActual);

        double devuelve=estadoActual-estadoAnterior;
        //System.out.println(devuelve);

        return devuelve;
    }

    public boolean intercambio(Persona per,Tipo tip1,Tipo tip2){
        int pos1=0;
        int pos2=0;
        boolean bol1 = false;
        boolean bol2 = false;
        Objeto obj1=null;
        Objeto obj2=null;
        int cent1=-1;
        int cent2=-1;
        boolean resul=false;

        Influenciable influ;
        influ=(Influenciable)per;
        if(influ!=this && tip1!=tip2){
            if (per!=null && tip1!=null && tip2!=null) { 
                for (int i = 0; i < this.getPertenencias().length && cent1==-1; i++) {
                    bol1 = this.getPertenencias()[i].getTipo().equals(tip1.name());    
                    if (bol1 == true) {
                        pos1 = i;
                        cent1=1;
                    }
                }
    
                for (int j = 0; j < per.getPertenencias().length && cent2==-1; j++) {
                    bol2 = per.getPertenencias()[j].getTipo().equals(tip2.name());
                    if (bol2 == true) {
                        pos2 = j;
                        cent2=1;
                    }
                }
    
            }
    
            if (bol1 == true && bol2 == true) {
                obj1=this.getPertenencias()[pos1];
                obj2=per.getPertenencias()[pos2];

                this.addPertenenciasConPosicion(obj2, pos1);
                per.addPertenenciasConPosicion(obj1, pos2);

                this.getPertenencias()[pos1].setPoseedor(this.getNombre());
                per.getPertenencias()[pos2].setPoseedor(per.getNombre());
    
                resul=true;
            }
        }

        return resul;
    }

    public ArrayList<Influenciable> getFamilia(){
        return familia;
    }

    public ArrayList<Persona> getRelaciones(){
        return relaciones;
    }

    public Celestial getDeidad(){
        return deidad;
    }

    public void setDeidad(Celestial celes){
        deidad=celes;
    }

    public Influenciable getPareja(){
        return pareja;
    }


    //METODOS AUXILIARES

    public boolean sonFamilia(Influenciable uno, Influenciable dos){
        boolean resul=false;
        int cent1=-1;
        int cent2=-1;

        ArrayList<Influenciable> family1=uno.getFamilia();
        ArrayList<Influenciable> family2=dos.getFamilia();

        for(int i=0;i<family2.size() && cent1==-1;i++){
            if(uno==family2.get(i)){
                resul=true;
                cent1=0;
            }
        }

        for(int i=0;i<family1.size() && cent2==-1;i++){
            if(dos==family1.get(i)){
                resul=true;
                cent2=0;
            }
        }

        return resul;
    }

    public void eliminarDeRelaciones(Influenciable uno, Influenciable dos){
        int cent1=-1;
        int cent2=-1;

        for(int i=0;i<dos.relaciones.size() && cent1==-1;i++){
            if(uno==dos.relaciones.get(i)){
                dos.relaciones.remove(i);
                cent1=0;
            }
        }

        for(int i=0;i<uno.relaciones.size() && cent2==-1;i++){
            if(dos==uno.relaciones.get(i)){
                uno.relaciones.remove(i);
                cent2=0;
            }
        }
    }

    public void setPareja(Influenciable influ){
        pareja=influ;
    }

    public void añadirFamilia(Influenciable influ){
        this.familia.add(influ);
    }

}