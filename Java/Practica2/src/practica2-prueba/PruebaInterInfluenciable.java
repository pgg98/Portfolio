
public class PruebaInterInfluenciable {
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
	    Influenciable Danny = new Influenciable (24, "Danny", false);
	    Influenciable Caballero = new Influenciable (25, "Caballero", false);
	    Danny.adquiere(tienda1, Tipo.TARJETA);
	    Danny.adquiere(tienda1, Tipo.MASCOTA);
	    Danny.adquiere(tienda1, Tipo.MASCOTA);
	    Danny.adquiere(tienda1, Tipo.MASCOTA);
	    
	    Caballero.adquiere(tienda1, Tipo.MASCOTA);
	    Caballero.adquiere(tienda1, Tipo.TARJETA);
	    Caballero.adquiere(tienda1, Tipo.TARJETA);
	    
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
	    System.out.println("Poseedor de el ultimo objeto de Danny: " + Danny.getPertenencias()[3].getPoseedor());
	    System.out.println("Poseedor de el ultimo objeto de Cabballero: " + Caballero.getPertenencias()[2].getPoseedor());
	    System.out.println();
	    System.out.println("Pertenencias de Danny antes del intercambio: ");
	    for(int i =0;i<Danny.getPertenencias().length;i++) {
	    	System.out.println(Danny.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println("Pertenencias de Caballero antes del intercambio: ");
	    for(int i =0;i<Caballero.getPertenencias().length;i++) {
	    	System.out.println(Caballero.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println(Danny.intercambio(Caballero, Tipo.TARJETA, Tipo.MASCOTA));
	    
	    System.out.println();
	    System.out.println("Pertenencias de Danny despues del intercambio: ");
	    for(int i =0;i<Danny.getPertenencias().length;i++) {
	    	System.out.println(Danny.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println("Pertenencias de Caballero despues del intercambio: ");
	    for(int i =0;i<Caballero.getPertenencias().length;i++) {
	    	System.out.println(Caballero.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println("Poseedor de el ultimo objeto de Danny: " + Danny.getPertenencias()[3].getPoseedor());
	    System.out.println("Poseedor de el ultimo objeto de Cabballero: " + Caballero.getPertenencias()[2].getPoseedor());
	    System.out.println();
	    System.out.println("Intentamos intercambiar cuando ninguno de los dos tiene ningun objeto de ese tipo: "+ Danny.intercambio(Caballero, Tipo.ACCESORIO, Tipo.ACCESORIO));
	    System.out.println("Pertenencias de Danny despues del intercambio: ");
	    for(int i =0;i<Danny.getPertenencias().length;i++) {
	    	System.out.println(Danny.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println("Pertenencias de Caballero despues del intercambio: ");
	    for(int i =0;i<Caballero.getPertenencias().length;i++) {
	    	System.out.println(Caballero.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println("Todos deberian de ser false: "+ Caballero.intercambio(Danny, Tipo.TARJETA, Tipo.ACCESORIO));
	    System.out.println("Todos deberian de ser false: "+ Caballero.intercambio(Danny, Tipo.ACCESORIO, Tipo.MASCOTA));
	    System.out.println("Pertenencias de Danny despues del intercambio: ");
	    for(int i =0;i<Danny.getPertenencias().length;i++) {
	    	System.out.println(Danny.getPertenencias()[i].getTipo());
	    }
	    System.out.println();
	    System.out.println("Pertenencias de Caballero despues del intercambio: ");
	    for(int i =0;i<Caballero.getPertenencias().length;i++) {
	    	System.out.println(Caballero.getPertenencias()[i].getTipo());
	    }
	}
}
