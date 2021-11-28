/*	RELICARIO(4.5),
	TARJETA(3.2),
	COCHE(9.0),
	CASA(10),
	ROPA(6.8),
	ALIMENTO(5.5),
	ACCESORIO(7),
	RECUERDO(8),
	DINERO(10),
	MASCOTA(5); */

// Influenciable:
//		encuentra => necesario influye(Objeto) de querube y Diablo cuando el objeto es un emisor.
//		
public class pInflu00 {
	public static void main(String [] args) {
		Tienda t = new Tienda(1, 2, 0);
		
		Influenciable i1 = new Influenciable(14, "juan", false);
		Emisor e = new Emisor(Tipo.ACCESORIO, "collar", 10);
		
		// Sin deidad y emisor (sin tienda sin poseedor).
		System.out.println("Encontrando collar: " + i1.encuentra(e));
		imprimirObjeto(e);
		System.out.println("juan tiene ahora: " + i1.getPertenencias()[0].getNombre());
		System.out.println("Intentando añadirlo con poseedor: " + i1.encuentra(e));
		
		Emisor e2 = new Emisor(Tipo.ACCESORIO, "condon", 5);
		System.out.println("almacenando emisor en tienda: " + t.almacena(e2, 0, 0));
		
		System.out.println("Encontrado condon: " + i1.encuentra(e2)); // sin deiudad no comprueba que este en una tienda Problem xD?¿
		
		System.out.print("juan tiene ahora: ");
		impimirPertenencias(i1);
		
		// ahora vamos a probar con deidad
		Querube q = new Querube("persteneo");
		i1.setDeidad(q);
		
		// con deidad y poseedor
		System.out.println("encontrando emisor con poseedor: "  + i1.encuentra(e)); // emisor y deidad con poseedor tiene poseedor
		
		Emisor e3 = new Emisor(Tipo.DINERO, "monedas de judas", 10);
		System.out.println("las ondas de las monedas de judas: " + e3.cambiaOndas(-3));
		System.out.println("Almacenando " + e3.getNombre() + " en tienda " + t.almacena(e3, 0, 0));
		// con deidad, sin poseedor y en tienda
		System.out.println("Encontrado con querube un emisor EN tienda sin poseedor: " + i1.encuentra(e3));
		t.elimina(0, 1); // lo saco de la tienda
		System.out.println("Encontrado con querube un emisor sin tienda sin poseedor: " + i1.encuentra(e3));
		System.out.println("Las pertencias de juan ahora son: ");
		listarPertenencias(i1);
		
		Emisor e4 = new Emisor(Tipo.ALIMENTO, "alubias magicas", 5);
		System.out.println("Encontrado con querube un emisor sin tienda sin poseedor: " + i1.encuentra(e4));
		System.out.println("Las pertencias de juan ahora son: ");
		listarPertenencias(i1);
		
		System.out.println("Encontrado con querube un emisor sin tienda CON poseedor: " + i1.encuentra(e4));
		
		
		Diablo d = new Diablo("uniaua");
		i1.setDeidad(d);
		
		Emisor e5 = new Emisor(Tipo.MASCOTA, "perro pa pasear", 3);
		System.out.println("Encontrado con diablo un perro sin dueño sin tienda: " + i1.encuentra(e5));
		System.out.println("Las pertencias de juan ahora son: ");
		listarPertenencias(i1);
		
		
		
	}
	public static void impimirPertenencias(Persona p) {
		Objeto [] pertes;
		pertes = p.getPertenencias();
		for(int i = 0; i < pertes.length; i++) {
			System.out.print(pertes[i].getNombre() + " " );
		}
	}
	public static void listarPertenencias(Persona p) {
		for(int i = 0; i < p.getPertenencias().length; i++) {
			imprimirObjeto(p.getPertenencias()[i]);
		}
	}
	
	public static void imprimirObjeto(Objeto obj) {
		if(obj == null) {
			System.out.println("null");
		}
		else {
			System.out.println("Nombre: " + obj.getNombre() +  " <" + obj.getTipo() + ">");
			System.out.println("\t Influencia: " + obj.getInfluencia());
			System.out.println("\t Valor emocional: " + obj.calculaValorEmocional());
			System.out.println("\t Valor intrinseco: " + obj.getValorIntrinseco());
			System.out.print("\t Poseedor: ");
			if(obj.getPoseedor() == null) {
				System.out.println("sin poseedor");
			}
			else {
				System.out.println(obj.getPoseedor());
			}
			if(obj instanceof Emisor) {
				System.out.print("\t\tEn tienda: ");
				if(((Emisor) obj).getLugar() == null) {
					System.out.println("sin tienda");
				}
				else {
					System.out.println(((Emisor) obj).getLugar().getGanancias());
				}
				System.out.println("\t\tOndas: " + ((Emisor)obj).getOndas());
			}
		}
	}
}
