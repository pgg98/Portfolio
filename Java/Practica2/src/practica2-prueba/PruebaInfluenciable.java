
public class PruebaInfluenciable {
	public  static void main(String [] args) {
		System.out.println("Creamos los emisores y los almacenamos: ");
		Emisor em1 = new Emisor(Tipo.MASCOTA, null, 12);
		Emisor em2 = new Emisor(Tipo.MASCOTA, null, 100);
		Emisor em3 = new Emisor(Tipo.MASCOTA, null, 43);
		Emisor em4 = new Emisor(Tipo.MASCOTA, null, 76);
		Emisor em5 = new Emisor(null, null, 5);
		Emisor em6 = new Emisor(null, null, 4);
		Emisor em7 = new Emisor(null, null, 3);
		Emisor em8 = new Emisor(null, null, 3);
		Emisor em9 = new Emisor(Tipo.MASCOTA, null, 20);
		Emisor em10 = new Emisor(Tipo.MASCOTA, "Caballero", 10);
		Emisor em11 = new Emisor(null, null, 98);
		Emisor em12 = new Emisor(null, null, 2);
		
	   
	    Tienda tienda1 = new Tienda(-1, 0, 20.6);
	    System.out.println();
	    
	    System.out.println(tienda1.almacena(em1, 0, 0)); 
	    System.out.println(tienda1.almacena(em2, 0, 0)); 
	    System.out.println(tienda1.almacena(em3, 0, 0)); 
	    System.out.println(tienda1.almacena(em4, 0, 0)); 
	    System.out.println(tienda1.almacena(em5, 0, 0)); 
	    System.out.println(tienda1.almacena(em6, 0, 0)); 
	    System.out.println(tienda1.almacena(em7, 0, 0)); 
	    System.out.println(tienda1.almacena(em8, 0, 0)); 
	    System.out.println(tienda1.almacena(em9, 0, 0)); 
	    System.out.println(tienda1.almacena(em10, 0, 0)); 
	    System.out.println(tienda1.almacena(em11, 0, 0)); 
	    System.out.println(tienda1.almacena(em12, 0, 0)); 
	    System.out.println();
	    
	    for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda1.getExistencias()[i][j] != null) {
        			System.out.print(tienda1.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
	    System.out.println();
	    System.out.println("Ganancias de la tienda antes: "+ tienda1.getGanancias());
	    Influenciable Danny = new Influenciable (314, null, false);
	    System.out.println("Danny adquiere algo: " + Danny.adquiere(tienda1, Tipo.MASCOTA));
	    System.out.println("Danny adquiere algo: " + Danny.adquiere(tienda1, null));
	    System.out.println("Danny adquiere algo: " + Danny.adquiere(tienda1, Tipo.ALIMENTO));
	    System.out.println("Ganancias de la tienda despues de MASCOTA: "+ tienda1.getGanancias());
	    System.out.println();
	    System.out.println(Danny.getPertenencias()[0].getNombre());
	    System.out.println(Danny.getPertenencias()[0].getPoseedor());
	    System.out.println(Danny.getEstado());
	    System.out.println();
	    System.out.println();
	    
	    for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda1.getExistencias()[i][j] != null) {
        			System.out.print(tienda1.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
	    System.out.println();
	    
	    Danny.adquiere(tienda1, Tipo.TARJETA);
	    System.out.println("Ganancias de la tienda despues de TARJETA: "+ tienda1.getGanancias());
	    System.out.println(Danny.getPertenencias()[0].getNombre());
	    System.out.println(Danny.getPertenencias()[0].getPoseedor());
	    System.out.println(Danny.getEstado());
	    System.out.println();
	    System.out.println();
	    
	    for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda1.getExistencias()[i][j] != null) {
        			System.out.print(tienda1.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
	    System.out.println();
	    
	    Danny.adquiere(tienda1, Tipo.MASCOTA);
	    System.out.println("Ganancias de la tienda despues de MASCOTA: "+ tienda1.getGanancias());
	    System.out.println(Danny.getPertenencias()[0].getNombre());
	    System.out.println(Danny.getPertenencias()[0].getPoseedor());
	    System.out.println(Danny.getEstado());
	    System.out.println();
	    System.out.println();
	    
	    for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda1.getExistencias()[i][j] != null) {
        			System.out.print(tienda1.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
	    System.out.println();
	    Danny.adquiere(tienda1, Tipo.TARJETA);
	    System.out.println("Ganancias de la tienda despues de TARJETA: "+ tienda1.getGanancias());
	    System.out.println(Danny.getPertenencias()[0].getNombre());
	    System.out.println(Danny.getPertenencias()[0].getPoseedor());
	    System.out.println(Danny.getEstado());
	    System.out.println();
	    System.out.println();
	    
	    for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda1.getExistencias()[i][j] != null) {
        			System.out.print(tienda1.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
	    System.out.println();
	    System.out.println("COMPROBAMOS ENCUENTRA");
	    Emisor em13 = new Emisor(null, "Danny-senpai", 2);
	    Emisor em14 = new Emisor(null, "Ennio-senpai", 50000);
	    Objeto ob1 = new Objeto(Tipo.ACCESORIO, "Ennio-kun",2000);
	    
	    Influenciable Caballero = new Influenciable (25, "Caballero", false);
	    
	    System.out.println(Danny.encuentra(ob1));
	    System.out.println(Danny.getPertenencias()[4].getNombre());
	    System.out.println(Danny.encuentra(em13));
	    System.out.println(Danny.getPertenencias()[5].getNombre());
	    System.out.println(Danny.encuentra(null));
	    //TODO HAREMOS QUE CABALLERO TENGA DEIDAD TMB
	    System.out.println(Caballero.encuentra(null));
	    System.out.println(Caballero.encuentra(em14));
	    System.out.println(Danny.encuentra(em14));

	}
	
}
