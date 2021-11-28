/*RELICARIO(4.5),
	TARJETA(3.2),
	COCHE(9.0),
	CASA(10),
	ROPA(6.8),
	ALIMENTO(5.5),
	ACCESORIO(7),
	RECUERDO(8),
	DINERO(10),
	MASCOTA(5); */
public class pEmisor00 {
	public static void main(String [] args) {
		// constructor
		Emisor e1 = new Emisor(Tipo.ACCESORIO, "amuleto12", 3);
		Emisor e2 = new Emisor(null, null, -1);
		Emisor e3 = new Emisor(Tipo.ALIMENTO, "", 2);
		
		// cambiamos las ondas para que afecte al valor emocional.
		e2.cambiaOndas(2); 	//  3
		e3.cambiaOndas(-3); // -2
		
		imprimirObjeto(e1);
		imprimirObjeto(e2);
		imprimirObjeto(e3);
		
	
		// envilece y purifica
		e1.envilece();
		System.out.println("Ondas, envilecido: " + e1.getOndas());
		e1.envilece();
		System.out.println("Ondas, continua envilecido: " + e1.getOndas());
		e1.purifica();
		System.out.println("Ondas, purificado: " + e1.getOndas());
		e1.purifica();
		System.out.println("Ondas, continua purificado: " + e1.getOndas());
		
		// cambiaondas
		e1.cambiaOndas(2);
		System.out.println("Ondas (+2): " + e1.getOndas());
		e1.cambiaOndas(-3);
		System.out.println("Ondas (-3): " + e1.getOndas());
		e1.cambiaOndas(-4);
		System.out.println("Ondas (-4): " + e1.getOndas());
		e1.cambiaOndas(8);
		System.out.println("Ondas (+8): " + e1.getOndas());
	
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
