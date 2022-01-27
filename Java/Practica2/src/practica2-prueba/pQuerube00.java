// Prueba influye(Objeto) de querube.

public class pQuerube00 {
	public static void main(String [] args) {
		Querube q = new Querube("pusition");
		
		Emisor emi1 = new Emisor(Tipo.ACCESORIO, "diadema", 10);
		emi1.cambiaOndas(-3);
		Emisor emi2 = new Emisor(Tipo.ACCESORIO, "tiara", 12);
		
		Objeto obj1 = new Objeto(Tipo.RELICARIO, "astilla de cruz", 100);
		
		Objeto obj2 = new Objeto(Tipo.RELICARIO, "diente de cerberos", -30);
		
		System.out.println("------------------------------------------------------");
		q.influye(emi1);
		imprimirObjeto(emi1);
		System.out.println("aura: " + q.getAura());
		
		System.out.println("------------------------------------------------------");
		q.influye(emi2);
		imprimirObjeto(emi2);
		System.out.println("aura: " + q.getAura());
		
		System.out.println("------------------------------------------------------");
		q.influye(obj1);
		imprimirObjeto(obj1);
		System.out.println("aura: " + q.getAura());
		

		System.out.println("------------------------------------------------------");
		q.influye(obj2);
		imprimirObjeto(obj2);
		System.out.println("aura: " + q.getAura());

		System.out.println("Influenciados: " + q.getInfluenciados());
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
