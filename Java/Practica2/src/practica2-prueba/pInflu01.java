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

// prueba adquiere => usa getEstado(), almacena

public class pInflu01 {
	public static void main(String [] args) {
		Influenciable infu1 = new Influenciable(31, "pepico", false);
		
		Objeto [] abs = {
			new Emisor(Tipo.ACCESORIO, "pendientes", 100),
			new Emisor(Tipo.RELICARIO, "medallon", 2),
			new Emisor(Tipo.CASA, "casa del terror", 4),
			new Emisor(Tipo.ROPA, "capa de lino", -15),
			new Emisor(Tipo.ROPA, "grebas de oro", 12),
			new Objeto(Tipo.ROPA, "yelmo de dragon", 2), // Su valor intrinseco es 11 pero no es un emisor
			new Emisor(Tipo.ROPA, "fajin de escamas de nurbial", 200)
		};
		System.out.println("objetos para meter en la tienda.");
		
		for(int i = 0; i < abs.length; i++) {
			if(abs[i] instanceof Emisor) {
				System.out.print("Emisor => ");
			}
			else {
				System.out.print("Objeto => ");
			}
			System.out.println(abs[i].getNombre() + " valor intrinseco: " + abs[i].getValorIntrinseco());
		}
		Tienda t = new Tienda(4, 5, 0);
		for(int i = 0; i < abs.length; i++) {
			System.out.println("almacenando " + abs[i].getNombre() + " => " + t.almacena(abs[i], 0, 2));
		}
		
		// casos nazis
		System.out.println(infu1.adquiere(null, Tipo.ACCESORIO));
		System.out.println(infu1.adquiere(t, null));
		
		// intentando adquirir algo que no este
		// Objeto obj = new Objeto(Tipo.ALIMENTO, "bollycao", 1);
		// infu1.encuentra(obj);
		System.out.println("estado depues de comer bollycao: " + infu1.getEstado()); // 5 + 5.5/100
		System.out.println("buscando recuerdos pero no los encuentro: " + infu1.adquiere(t, Tipo.RECUERDO));
		
		// intentando adquirir algo que este pero sin valor emocional suficiente
		System.out.println("buscando accesorio pero es muy caro: " + infu1.adquiere(t, Tipo.ACCESORIO));
		
		// intentando adquirir de arriba ROPA (grebas de oro 0.816)
		System.out.println("buscando ropa: " + infu1.adquiere(t, Tipo.ROPA));
		System.out.println("estado emocional despues de adquirir: " + infu1.getEstado());
		System.out.println("ganancias de la tienda: " + t.getGanancias());
		System.out.println("pertenencias de juan: ");
		listarPertenencias(infu1);
		imprimirTienda(t);
		
		// ROPA => capa de lino (1.02)
		System.out.println("buscando ropa: " + infu1.adquiere(t, Tipo.ROPA));
		// 5 - 1.02 = 3.98 - 1.02 + 0.816 = 3.776
		System.out.println("estado emocional despues de adquirir: " + infu1.getEstado());
		// 2.98 + 
		System.out.println("ganancias de la tienda: " + t.getGanancias());
		System.out.println("pertenencias de juan: ");
		listarPertenencias(infu1);
		imprimirTienda(t);
		
		// 3.776 < 13 (no puede coger la ropa que le falta)
		System.out.println("buscando ropa: " + infu1.adquiere(t, Tipo.ROPA));
	
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
}
