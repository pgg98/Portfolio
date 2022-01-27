import java.util.ArrayList;

public abstract class Celestial{
    private String nombre;
    private double aura;
    private ArrayList<Influenciable> adeptos;

    public Celestial(String nom){
        if(nom==null || nom.isEmpty()){
            nom="Ser superior";
        }else{
            nombre=nom;
        }

        aura=0;

        adeptos=new ArrayList<Influenciable>();
    }

    public String enfrentamiento(Celestial celes,int num){
        String devolver=null;

        if(celes!=null){
            if(this!=celes){
                for(int i=0;i<adeptos.size();i++){
                    adeptos.get(i).restaEstadoConValorDouble(2);
                    this.sumaAura(2);
                    if(this instanceof Querube==true){
                        Querube quer;
                        quer=(Querube)this;
                        int sum=quer.getInfluenciados();
                        this.sumaAura(sum);
                        quer.setInfluenciados(0);
                    }
                }

                for(int i=0;i<celes.getAdeptos().size();i++){
                    celes.getAdeptos().get(i).restaEstadoConValorDouble(2);
                    celes.sumaAura(2);
                    if(celes instanceof Querube==true){
                        Querube quer;
                        quer=(Querube)celes;
                        int sum=quer.getInfluenciados();
                        celes.sumaAura(sum);
                        quer.setInfluenciados(0);
                    }
                }

                if(this.getAura()>celes.getAura()){
                    ArrayList<Influenciable> adepts=new ArrayList<Influenciable>();
                    if(num>0){
                        for(int i=0;i<num;i++){
                            adepts.add(quitarUltimoAdepto(celes));
                        }

                        for(int i=0;i<adepts.size();i++){
                            this.adeptos.add(adepts.get(i));
                        }
                    }

                    devolver=this.nombre;
                }else if(this.getAura()<celes.getAura()){
                    ArrayList<Influenciable> adepts=new ArrayList<Influenciable>();
                    if(num>0){
                        for(int i=0;i<num;i++){
                            adepts.add(quitarUltimoAdepto(this));
                        }

                        for(int i=0;i<adepts.size();i++){
                            celes.setAdeptos(adepts.get(i));
                        }
                    }

                    devolver=celes.getNombre();
                }else if(this.getAura()==celes.getAura()){
                    String ret=celes.getNombre()+"-"+this.getNombre();
                    devolver=ret;
                }

                int num1=this.getAdeptos().size();
                int num2=celes.getAdeptos().size();

                this.restaAura(num1);
                celes.restaAura(num2);

                
            }else{
                String ret=celes.getNombre()+"+"+this.getNombre();
                devolver=ret;
            }

        }

        return devolver;
    }

    public String getNombre(){
        return nombre;
    }

    public double getAura(){
        return aura;
    }

    public ArrayList<Influenciable> getAdeptos(){
        return adeptos;
    }
    
    public abstract double influye(Objeto obj);

    public abstract double influye(Persona per);


    //METODOS AUXILIARES

    public void sumaAura(double num){
        aura=aura+num;
    }

    public void sumaAura(int num){
        aura=aura+num;
    }

    public void restaAura(double num){
        aura=aura-num;
    }

    public void setAdeptos(Influenciable influ){
        adeptos.add(influ);
    }

    public void addPrincipioAdeptos(Influenciable influ){
        Influenciable[] newArray = new Influenciable[adeptos.size() + 1];
        newArray[0]=influ;
        for(int i = 0;i<adeptos.size();i++){
            // agregamos los demas elementos despues del indice 0
            adeptos.add(i, newArray[i+1]);
        }
    }

    public Influenciable quitarUltimoAdepto(Celestial celes){
        ArrayList<Influenciable> adepts=celes.getAdeptos();
        int tamaño=adepts.size();
        Influenciable influ=adepts.get(tamaño-1);
        celes.eliminaAdepto(tamaño-1);

        return influ;
    }

    public void eliminaAdepto(int pos){
        adeptos.set(pos, null);
    }
}