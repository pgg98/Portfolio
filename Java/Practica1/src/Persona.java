import java.util.ArrayList;

public class Persona{
    //Atributos
    private double edad;
    private String nombre;
    private boolean genes;
    private double estado;
    private ArrayList<Objeto> pertenencias;

    // Atributos de clase
    private enum Nombres {
        ALEX, MATY, CAS, BLOOM, LAN, JD, SAM, AL, MANI, BEL;
    }

    private enum Edades {
        ADOLESCENTE(16), JOVEN(19.5), TRABAJADOR(30), ESCOLAR(9.5), EMPRENDEDOR(21), JUBILADO(76), ADULTO(38),
        MADURO(55), MAYOR(64.5), INFANTIL(3);

        private double valorEdades;

        // Constructor Edades
        private Edades(double numV) {
            valorEdades = numV;
        }

        private double getEdadIntrinseco(){
            return valorEdades;
        }
    }

    // Metodos
    // Constructor
    public Persona(double edat, String nom, boolean jenes) {
        edad = edat;
        nombre = nom;
        genes = jenes;

        if (edat <= 0 || edat > 99) {
            int ent = (int) edat; /* Parte entera del double */
            int pos = Math.abs(ent % 10);
            Edades[] edades= Edades.values();
            edad=edades[pos].getEdadIntrinseco();
        }

        if (nom == null || nom.equals("")) {
            //int ent = (int) edad;
            int pos = Math.abs((int)(edad % 10));
            Nombres[] nombres=Nombres.values();
            nombre = nombres[pos].name();
        }

        estado = 5;

        pertenencias = new ArrayList<Objeto>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getEdad() {
        return edad;
    }

    public double getEstado() {
        actualizaEstado();

        return estado;
    }

    public char getGenes() {
        if (genes == true) {
            return 'M';
        } else {
            return 'V';
        }
    }

    public Objeto[] getPertenencias() {
        Objeto[] pertenen=new Objeto[pertenencias.size()];

        if (pertenencias.isEmpty() == false) {
            for(int i=0;i<pertenencias.size();i++){
                pertenen[i]=pertenencias.get(i);
            }

            return pertenen;
        } else {
            return null;
        }
    }

    public void actualizaEstado() {
        for (int i = 0; i < pertenencias.size(); i++) {
            estado = estado + pertenencias.get(i).calculaValorEmocional();
        }

    }

    public static String[] getNombres() {
        Nombres[] valores = Nombres.values();
        String[] nombres = new String[valores.length];

        for (int i = 0; i < valores.length; i++) {
            nombres[i] = valores[i].name();
        }

        return nombres;
    }

    public static double[] getEdades() {
        Edades[] valores = Edades.values();
        double[] edades = null;
        edades=new double[valores.length];

        for (int i = 0; i < valores.length; i++) {
            edades[i] = valores[i].getEdadIntrinseco(); 
        }

        return edades;
    }

    public boolean encuentra(Objeto cosa) {
        if (cosa.getPoseedor() == null || cosa.getPoseedor().equals("")) {
            pertenencias.add(cosa);

            cosa.setPoseedor(this.nombre);

            return true;
        } else {
            return false;
        }
    }

    public Objeto busca(String cosa2) {
        Objeto resul = null;
        for (int i = 0; i < pertenencias.size(); i++) {
            boolean bool = pertenencias.get(i).getNombre().equals(cosa2);
            if (bool == true) {
                resul = pertenencias.get(i);
            }
        }

        return resul;
    }
    

    public boolean intercambio(Persona paco, String cosa3, String cosa4) {
        int pos1=0;
        int pos2=0;
        boolean bol1 = false;
        boolean bol2 = false;
        Objeto obj1=null;
        Objeto obj2=null;

        if (paco!=null && cosa3!=null && cosa4!=null) { 
            for (int i = 0; i < pertenencias.size(); i++) {
                bol1 = pertenencias.get(i).getNombre().equals(cosa3);
                if (bol1 == true) {
                    pos1 = i;
                }
            }

            for (int j = 0; j < paco.pertenencias.size(); j++) {
                bol2 = paco.pertenencias.get(j).getNombre().equals(cosa4);
                if (bol2 == true) {
                    pos2 = j;
                }
            }

        }

        if (bol1 == true && bol2 == true) {
            obj1=pertenencias.get(pos1);
            obj2=paco.pertenencias.get(pos2);

            pertenencias.set(pos1, obj2);
            paco.pertenencias.set(pos2, obj1);

            pertenencias.get(pos1).setPoseedor(nombre);
            paco.pertenencias.get(pos2).setPoseedor(paco.nombre);

            return true;
        } else {
            return false;
        }

    }

    public boolean adquiere(Tienda tienda, Tipo tip) {
        int i,j;
        int posF=0;
        int posC=0;
        Objeto barato=null;
        Objeto[][] objetos=tienda.getExistencias();

        /*Primer digito del valor (como creo que se saca)*/ 
        String num = String.valueOf(edad);
        int iDesplazamiento = Double.valueOf(Math.pow(10, num.length() - 1)).intValue();
        Double digito = edad / iDesplazamiento;

        //Coste
        double coste = Math.abs(objetos[0][0].getValorIntrinseco() - digito);

        //Saco el objeto de menor coste y su posición
        for (i = 0; i < objetos.length; i++) {
            for(j=0;j<objetos[0].length;j++){
                if(coste>Math.abs(objetos[i][j].getValorIntrinseco() - digito)){
                    coste=Math.abs(objetos[i][j].getValorIntrinseco() - digito);
                    posF=i;
                    posC=j;
                    barato=objetos[i][j];
                }
            }
        }

        double costeR=barato.calculaValorEmocional();

        /* Transacción */
        if (estado > costeR && barato.getTipo().equalsIgnoreCase(tip.name())==true) { 
            estado = estado-costeR;

            pertenencias.add(barato); 

            tienda.elimina(posF, posC);
            
            tienda.setGanancias(costeR);
            
            return true;
        }else{
            return false;
        }
    }

    public double pierde(int perdido) {
        double valor=0;
        Objeto obj;
        
        if(perdido<pertenencias.size()){
        obj=pertenencias.get(perdido);
        valor=obj.calculaValorEmocional();
        pertenencias.remove(perdido);
        }

        return valor;
        
    }
    

}