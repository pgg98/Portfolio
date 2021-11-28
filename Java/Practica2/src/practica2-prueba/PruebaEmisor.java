
public class PruebaEmisor {
	public  static void main(String [] args) {
		System.out.println("Creamos los emisores y cambiamos sus ondas: ");
		Emisor ob1 = new Emisor(null, null, 3);
		Emisor em1 = new Emisor(null, null, 3);
		System.out.println(ob1.getOndas());
		System.out.println(ob1.cambiaOndas(1));
		System.out.println(ob1.cambiaOndas(7));
		System.out.println(ob1.cambiaOndas(-9));
		System.out.println(ob1.cambiaOndas(1));
		System.out.println("Valor emocional del emisor: "+ob1.calculaValorEmocional());
		em1.cambiaOndas(-9);
        Objeto ob2 = new Objeto(Tipo.ACCESORIO, "Ennio", 2);
        Objeto ob3 = new Objeto(Tipo.COCHE,"", -4 );
        Objeto ob4 = new Objeto(Tipo.CASA, null, 7);
        Objeto ob5 = new Objeto(Tipo.ALIMENTO,"JOSE", 4 );
        Objeto ob6 = new Objeto(Tipo.ACCESORIO, "Caballero", -8);
        Objeto ob7 = new Objeto(Tipo.ACCESORIO, "Caballero", -10);
        Objeto ob8 = new Objeto(Tipo.ACCESORIO, "Caballero", 10);
        Objeto ob10 = new Objeto(Tipo.ACCESORIO, "Caballero", -10);
        Objeto ob12 = new Objeto(Tipo.ALIMENTO,"Danny", 56);
        Objeto ob13 = new Objeto(Tipo.ALIMENTO,"Danny", -16);
        
        
        Tienda tienda1 = new Tienda(-1, 0, 20.6);
        Tienda tienda2 = new Tienda(-1, 0, 20.6);
        System.out.println();
        System.out.println("Almacemamos los objetos:");
        System.out.println(tienda1.almacena(ob2, 0, 0)); 
        System.out.println(tienda1.almacena(ob3, 0, 0)); 
        System.out.println(tienda1.almacena(ob4, 0, 0));
        System.out.println(tienda1.almacena(ob1, 0, 0)); 
        System.out.println(tienda1.almacena(ob5, 0, 0)); 
        System.out.println(tienda1.almacena(ob6, 0, 0)); 
        System.out.println(tienda1.almacena(ob7, 0, 0)); 
        System.out.println(tienda1.almacena(ob8, 0, 0));
        System.out.println(tienda1.almacena(ob10, 0, 0));
        System.out.println(tienda1.almacena(ob12, 2, 2));
        System.out.println(tienda1.almacena(ob13, 2, 3)); 
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
        System.out.println("Realizamos emana con unas ondas -2");
        System.out.println("Numero de objetos afectados: "+ob1.emana());
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
        System.out.println("Comprobamos purifica siendo 2: ");
        ob1.purifica();
        System.out.println(ob1.getOndas());
        System.out.println("Comprobamos evilece siendo -2 otra vez: ");
        ob1.envilece();
        System.out.println(ob1.getOndas());
        System.out.println("Comprobamos que esta dentro de la tienda en su variable lugar: ");
        System.out.println(ob1.getLugar().getExistencias().length);
        System.out.println();
        System.out.println("Volvemos a comprobar emana con mas nulls, diferentes sitios y ondas -3");
        System.out.println();
        Objeto ob15 = new Objeto(Tipo.COCHE,"", -4 );
        Objeto ob16 = new Objeto(Tipo.CASA, null, -7);
        Objeto ob17 = new Objeto(Tipo.ALIMENTO,"JOSE", 4 );
        Objeto ob18 = new Objeto(Tipo.ACCESORIO, "Caballero", 8);
        Objeto ob19 = new Objeto(Tipo.ACCESORIO, "Caballero", 10);
        Objeto ob20 = new Objeto(Tipo.ACCESORIO, "Caballero", -10);
        Objeto ob21 = new Objeto(Tipo.ACCESORIO, "Caballero", -10);
        Objeto ob22 = new Objeto(Tipo.ALIMENTO,"Danny", -56);
        
        tienda2.almacena(em1, 0, 0); 
        tienda2.almacena(ob15, 0, 2); 
        tienda2.almacena(ob16, 0, 3);
        tienda2.almacena(ob17, 1, 2); 
        tienda2.almacena(ob18, 1, 3); 
        tienda2.almacena(ob19, 2, 0); 
        tienda2.almacena(ob20, 2, 1); 
        tienda2.almacena(ob21, 2, 2);
        tienda2.almacena(ob22, 2, 3);
        
        for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda2.getExistencias()[i][j] != null) {
        			System.out.print(tienda2.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
        System.out.println();
        System.out.println(em1.emana());
        System.out.println();
        for(int i=0; i<tienda1.getExistencias().length;i++) {
        	for(int j=0; j<tienda1.getExistencias()[0].length;j++) {
        		if(tienda2.getExistencias()[i][j] != null) {
        			System.out.print(tienda2.getExistencias()[i][j].getInfluencia()+" ");
        		}
        		else {
        			System.out.print("null ");
        		}
        	}
        	System.out.println();
        }
	}
}
