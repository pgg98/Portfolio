import java.awt.SystemTray;

public class PruebaCelestial {
	public static void main(String [] args) {
		Influenciable Danny = new Influenciable (24, "Danny", true);
		Influenciable Caballero = new Influenciable (25, "Caballero", false);
		Influenciable Ennio = new Influenciable (25, "Ennio", false);
		Influenciable inf1 = new Influenciable (24, null, false);
		Influenciable inf2 = new Influenciable (24, null, true);
		Influenciable inf3 = new Influenciable (24, null, false);
		Influenciable inf4 = new Influenciable (24, null, true);
		Influenciable inf5 = new Influenciable (24, null, true);
		Persona p1 = new Persona (3242, null, false);
		Persona p2 = new Persona (3242, null, false);
		Persona p3 = new Persona (3242, null, false);
		Persona p4 = new Persona (3242, null, false);	
		Diablo d1 = new Diablo("LUCIFER");
		Diablo d2 = new Diablo("");
		Querube q1 = new Querube("Angelito");
		Querube q2 = new Querube("");
		Danny.setDeidad(q1);
		Emisor em1 = new Emisor(Tipo.MASCOTA, null, 12);
		Emisor em2 = new Emisor(Tipo.MASCOTA, null, 100);
		Emisor em3 = new Emisor(Tipo.MASCOTA, null, 43);
		Emisor em4 = new Emisor(Tipo.MASCOTA, null, 76);
		Emisor em5 = new Emisor(null, null, 5);
		Emisor em6 = new Emisor(null, null, 4);
		Emisor em7 = new Emisor(null, null, 3);
		Emisor em8 = new Emisor(null, null, 3);
		Objeto ob1 = new Objeto(null,null,3);
		Objeto ob2 = new Objeto(null,null,-3);
		em1.cambiaOndas(-2);
		em2.cambiaOndas(1);
		p1.encuentra(em1);
		p1.encuentra(em2);
		p1.encuentra(em3);
		p1.encuentra(ob1);
		p1.encuentra(ob2);
		System.out.println("Pertenencias antes de influye:");
		for(int i =0; i<p1.getPertenencias().length;i++) {
			if(p1.getPertenencias()[i] instanceof Emisor) {
				System.out.println("Emisor: "+ ((Emisor)p1.getPertenencias()[i]).getOndas());
			}
			else {
				System.out.println("Objeto: "+ p1.getPertenencias()[i].getInfluencia());
			}
			p1.getPertenencias()[i].getInfluencia();
		}
		System.out.println("COMPROBAMOS QUERUBE:");
		System.out.println("Influeye (Persona) pasando por parametro una persona normal: "+ q1.influye(p1));
		System.out.println("Pertenencias despues de influye:");
		for(int i =0; i<p1.getPertenencias().length;i++) {
			if(p1.getPertenencias()[i] instanceof Emisor) {
				System.out.println("Emisor: "+ ((Emisor)p1.getPertenencias()[i]).getOndas());
			}
			else {
				System.out.println("Objeto: "+ p1.getPertenencias()[i].getInfluencia());
			}
			p1.getPertenencias()[i].getInfluencia();
		}
		System.out.println("Aura de q1 : "+q1.getAura());
		System.out.println();
		System.out.println("Influeye (Persona) pasando por parametro un influenciable sin deidad: "+ q1.influye(inf1));
		System.out.println("Influeye (Persona) pasando por parametro un influenciable sin deidad: "+ q1.influye(Caballero));
		System.out.println("Adeptos de querube 1: "+q1.getAdeptos().size()); 
		System.out.println("Deidad de inf1: "+inf1.getDeidad().getNombre());
		inf2.setDeidad(q2);
		inf4.setDeidad(q2);
		System.out.println("Deidad de inf2: "+inf2.getDeidad().getNombre());
		System.out.println("Influeye (Persona) pasando por parametro un influenciable con deidad: "+ q1.influye(inf2));
		System.out.println("Deidad de inf2: "+inf2.getDeidad().getNombre());
		System.out.println("Influeye (Persona) pasando por parametro un adepto suyo: "+ q1.influye(inf2));
		System.out.println("Adeptos de querube 1: "+q1.getAdeptos().size());
		System.out.println("Aura de q1 : "+q1.getAura());
		System.out.println();
		System.out.println("Creamos los emisores y los almacenamos: ");
		Emisor em13 = new Emisor(Tipo.MASCOTA, null, 12);
		Emisor em14 = new Emisor(Tipo.MASCOTA, null, 100);
		Emisor em15 = new Emisor(Tipo.MASCOTA, null, 43);
		Emisor em9 = new Emisor(Tipo.MASCOTA, null, 20);
		Emisor em10 = new Emisor(Tipo.MASCOTA, "Caballero", 10);
		Emisor em11 = new Emisor(null, null, 98);
		Emisor em12 = new Emisor(null, null, 2);
		System.out.println();
		System.out.println(Danny.empareja(inf1));
		System.out.println(Danny.relaciona(inf1));
		System.out.println(Caballero.empareja(inf4));
		System.out.println(Caballero.relaciona(inf4));
	   
	    Tienda tienda1 = new Tienda(-1, 0, 20.6);
	    System.out.println();
	    
	    System.out.println(tienda1.almacena(em13, 0, 0)); 
	    System.out.println(tienda1.almacena(em14, 0, 0)); 
	    System.out.println(tienda1.almacena(em15, 0, 0)); 
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
	    System.out.println("Hacemos obsequia de querube: "+ q1.obsequia(tienda1));
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
	    System.out.println(Danny.getFamilia().get(0).getPertenencias()[0].getInfluencia());
	    System.out.println(Caballero.getFamilia().get(0).getPertenencias()[0].getInfluencia());
	    System.out.println();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    Emisor em17 = new Emisor(Tipo.MASCOTA, null, 12);
	    Emisor em18 = new Emisor(Tipo.MASCOTA, null, 12);
	    Emisor em19 = new Emisor(Tipo.MASCOTA, null, 12);
	    Objeto ob3 = new Objeto(null,null,3);
	    Objeto ob4 = new Objeto(null,null,3);
	    Objeto ob20 = new Objeto(null,null,-3);
	    em17.cambiaOndas(-2);
		em18.cambiaOndas(1);
		p2.encuentra(em17);
		p2.encuentra(em18);
		p2.encuentra(em19);
		p2.encuentra(ob3);
		p2.encuentra(ob4);
		p2.encuentra(ob20);
	    System.out.println("COMPROBAMOS DIABLO:");
	    System.out.println();
	    System.out.println(d1.getNombre());
	    System.out.println("Pertenencias antes de influye:");
		for(int i =0; i<p2.getPertenencias().length;i++) {
			if(p2.getPertenencias()[i] instanceof Emisor) {
				System.out.println("Emisor: "+ ((Emisor)p2.getPertenencias()[i]).getOndas());
			}
			else {
				System.out.println("Objeto: "+ p2.getPertenencias()[i].getInfluencia());
			}
			p2.getPertenencias()[i].getInfluencia();
		}
		System.out.println("Aura de d1 : "+ d1.getAura());
		System.out.println("Influeye (Persona) pasando por parametro una persona normal: "+ d1.influye(p2));
		System.out.println("Pertenencias despues de influye:");
		for(int i =0; i<p2.getPertenencias().length;i++) {
			if(p2.getPertenencias()[i] instanceof Emisor) {
				System.out.println("Emisor: "+ ((Emisor)p2.getPertenencias()[i]).getOndas());
			}
			else {
				System.out.println("Objeto: "+ p2.getPertenencias()[i].getInfluencia());
			}
			p2.getPertenencias()[i].getInfluencia();
		}
		System.out.println("Aura de d1 : "+ d1.getAura());
		System.out.println();
		System.out.println("Deidad de inf3: "+inf3.getDeidad());
		System.out.println("Influeye (Persona) pasando por parametro un influenciable sin deidad: "+ d1.influye(inf3));
		System.out.println("Influeye (Persona) pasando por parametro un influenciable sin deidad: "+ d1.influye(Ennio));
		System.out.println("Adeptos de diablo 1: "+q1.getAdeptos().size()); 
		System.out.println("Deidad de inf3: "+inf3.getDeidad().getNombre());
		System.out.println("Estado de inf2 antes de pasar por diablo 1: "+ inf2.getEstado());
		System.out.println("Influeye (Persona) pasando por parametro un influenciable con deidad: "+ d1.influye(inf2));
		System.out.println("Estado de inf2 despues de pasar por diablo 1: "+ inf2.getEstado());
		System.out.println("Influeye (Persona) pasando por parametro un adepto suyo: "+ d1.influye(inf3));
		System.out.println("Adeptos de diablo 1: "+d1.getAdeptos().size());
		System.out.println("Aura de d1 : "+d1.getAura());
		System.out.println();
		inf5.setDeidad(d2);
		Ennio.empareja(inf5);
		Ennio.relaciona(inf5);
		System.out.println(Ennio.getFamilia().get(0).getDeidad().getNombre());
		System.out.println("Comprobamos DIABOLIZA DE DIABLO: "+d1.diaboliza());
		System.out.println(Ennio.getFamilia().get(0).getDeidad().getNombre());
		System.out.println();
		System.out.println();
		
		
		
		
		
		System.out.println("Aura de diablo: "+d1.getAura());
		System.out.println("Aura de querube: "+q1.getAura());
		System.out.println("Estado del primer adepto de diablo: "+d1.getAdeptos().get(0).getEstado());
		System.out.println();
		System.out.println("POR ULTIMO LA BATALLA FINAL:");
		System.out.println(q1.enfrentamiento(d1, 1));
		System.out.println("Adeptos de diablo: "+d1.getAdeptos().size());
		System.out.println("Estado de los adeptos de diablo: "+d1.getAdeptos().get(0).getEstado());
		System.out.println("Adeptos de querube: "+q1.getAdeptos().size());
		System.out.println("Influenciados de querube: "+ q1.getInfluenciados());
		System.out.println();
		
		
		System.out.println("Aura de diablo: "+d1.getAura());
		System.out.println("Aura de querube: "+q1.getAura());
		System.out.println("Llamamos a enfrentamiento al reves: "+d1.enfrentamiento(q1, 1));
		System.out.println("Aura de diablo: "+d1.getAura());
		System.out.println("Aura de querube: "+q1.getAura());
		System.out.println();
		System.out.println("Enfrentamiento entre dos querubes: "+q2.enfrentamiento(q1, 1));
		System.out.println("Enfrentamiento entre dos Diablos: "+d2.enfrentamiento(d1, 1));
		System.out.println("Enfrentamiento con 0 adeptos de intercambio: "+d2.enfrentamiento(q1, 0));
		System.out.println("Enfrentamiento con diablo de ganador: "+q2.enfrentamiento(d1, 1));
		System.out.println("Enfrentamiento y temrinamos de quitar los adeptos de LUCIFER: "+q1.enfrentamiento(d1, 3));
		System.out.println("Aura de diablo: "+d1.getAura());
		System.out.println("Aura de querube: "+q1.getAura());
		System.out.println("Adeptos de diablo: "+d1.getAdeptos().size());
		System.out.println("Adeptos de querube: "+q1.getAdeptos().size());
		System.out.println("Enfrentamiento con 0 adeptos en uno de los celestiales: "+q1.enfrentamiento(d1, 3));
		
	}
}
