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
public class pQuerube01 {
	public static void main(String [] args) {
		// INFLUYE SOBRE PERSONA NORMAL :)
		Persona p = new Persona(26, "jose", false);
		Objeto [] objetos = {
			new Objeto(Tipo.ACCESORIO, "accesorio1", 8), // 10
			new Objeto(Tipo.ACCESORIO, "accesorio2", 10), // 12 
			new Emisor(Tipo.RECUERDO, "trapo viejo", 8), // 10 ondas a 2
			new Objeto(Tipo.DINERO, "doblones", -10) // 10
		};
		for(Objeto e : objetos) {
			p.encuentra(e);
		}
		System.out.println("---- antes de influir sobre una persona ----");
		listarPertenencias(p);
		
		Querube q = new Querube("josesion");
		System.out.println("querube sobre persona: " + q.influye(p));
		
		System.out.println("---- despues de influir ----");
		listarPertenencias(p);
		
		
		// Influye sobre influenciable sin deidad.
		Influenciable influ = new Influenciable(12, "undescript", true);
		System.out.println(q.influye(influ));
		System.out.println("deidad: " + (q == influ.getDeidad()));
		System.out.print("adeptos de " + q.getNombre() + ": ");
		for(int i = 0; i < q.getAdeptos().size(); i++) {
			System.out.println(q.getAdeptos().get(i).getNombre());
		}		
	
	
		// Influenciable con deidad.
		System.out.println("mi aura antes de la siguiente influencia: " + q.getAura());
		System.out.println("influyendo sobre deidad: " + q.influye(influ));
		System.out.println("el aura despues de influir: " + q.getAura());
		
	}
	public static void listarPertenencias(Persona p) {
		double totalEmocional = 0;
		for(int i = 0; i < p.getPertenencias().length; i++) {
			imprimirObjeto(p.getPertenencias()[i]);
			totalEmocional += p.getPertenencias()[i].calculaValorEmocional();
		}
		System.out.println("--total emocional de las pertencias--: " + totalEmocional);
		
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
