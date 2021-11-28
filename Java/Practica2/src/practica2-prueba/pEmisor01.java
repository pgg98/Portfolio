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

public class pEmisor01 {
	public static void main(String [] args) {
		int emanados;
		Tienda t;
		Emisor emi;
		
		t = crearTienda();
		imprimirTienda(t);
		
		emi = new Emisor(Tipo.ALIMENTO, "GIN22", 2);
		emanados = emi.emana();
		System.out.println("Emanando sin tienda: " + emanados);
		
		System.out.println("Colocando emisor: " + t.almacena(emi, 2, 0));
		imprimirTienda(t);
		
		imprimirObjeto(emi);
		// probando emana con ondas 1
		emanados = emi.emana();
		System.out.println("Emanados con ondas a +1: " + emanados);
		imprimirTienda(t);
		
		// probando emana con ondas -1.
		emi.cambiaOndas(-2); 
		emanados = emi.emana();
		System.out.println("Emanados con ondas a -1: " + emanados);
		imprimirTienda(t);
		
		// probando emana con ondas 2 y con ondas -2.
		
		emi.cambiaOndas(-2);
		emanados = emi.emana();
		System.out.println("Emanados con ondas a -3: " + emanados);
		imprimirTienda(t);
		
	}
	
	public static void imprimirTienda(Tienda t) {
		int i, j;
		
		Objeto [][] existencias = t.getExistencias();
		for(i = 0; i < existencias.length; i++) {
			for(j = 0; j < existencias[i].length; j++) {
				if(existencias[i][j] != null) {
					System.out.print("\t" + existencias[i][j].getNombre() + " (" + existencias[i][j].getInfluencia() + ")");
				}
				else {
					System.out.print("\t----------");
				}
			}
			System.out.println();
		}
		
	}
	public static Tienda crearTienda() {
		Tienda t = new Tienda(5, 4, 0);
		int i, j;
		
		Objeto objetos [][] = {
				{new Objeto(Tipo.ACCESORIO, "OBJ00", 10), null, new Objeto(Tipo.ACCESORIO, "OJB01", 10), null},
				{new Objeto(Tipo.ALIMENTO, "OBJ10", 5), new Objeto(Tipo.ALIMENTO, "OBJ11", -2), new Objeto(Tipo.ALIMENTO, "OBJ12", 2), null},
				{new Emisor(Tipo.ALIMENTO, "EMI20", 10), new Objeto(Tipo.ALIMENTO, "OBJ21", 4), null, new Objeto(Tipo.ALIMENTO, "OBJ22", -3)},
				{new Objeto(Tipo.CASA, "OBJ30", 2), new Objeto(Tipo.CASA, "OBJ31", 5), new Objeto(Tipo.CASA, "OBJ32", 1), new Objeto(Tipo.CASA, "OBJ33", 4)},
				{new Objeto(Tipo.ALIMENTO, "OBJ40", 4), new Objeto(Tipo.ALIMENTO, "OBJ41", 1), null, new Objeto(Tipo.ALIMENTO, "OBJ43", 2)}
		};
		
		
		for(i = 0; i < objetos.length; i++) {
			for(j = 0; j < objetos[i].length; j++) {
				if(objetos[i][j] != null) {
					t.almacena(objetos[i][j], i, j);
				}
			}
		}
		return t;
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
