

public class p10Juanvi {

	public static void main(String[] args) {
		
		Tienda Carrefour = new Tienda(10,10,20);
		Tienda Mercadona = new Tienda(7,8,15);
		Tienda BazarChino = new Tienda(6,6,4);
		
		Persona p1 = new Persona(21,"Juan",false);
		Persona p2 = new Persona(-35,"Mario",false);
		Persona p3 = new Persona(58,"",true);
		Persona p4 = new Persona(0,null,true);
		
		Objeto m1 = new Objeto(Tipo.ALIMENTO,"Donuts",1);
		Objeto m2 = new Objeto(Tipo.ALIMENTO,"Pizza",1);
		Objeto m3 = new Objeto(Tipo.ALIMENTO,"Gambas",5);
		Objeto m4 = new Objeto(Tipo.ALIMENTO,"Medio Pollo",3);
		Objeto m5 = new Objeto(Tipo.ALIMENTO,"Perejil",1);
		Objeto m6 = new Objeto(Tipo.ALIMENTO,"Pan",1);
		Objeto m7 = new Objeto(Tipo.ALIMENTO,"Papas Pimienta y Limón",3);
		Objeto m8 = new Objeto(Tipo.ALIMENTO,"Pipas",2);
		
		Objeto c1 = new Objeto(Tipo.ALIMENTO,"Larios",2);
		Objeto c2 = new Objeto(Tipo.ALIMENTO,"Sushi",2);
		Objeto c3 = new Objeto(Tipo.ALIMENTO,"Kikos",1);
		Objeto c4 = new Objeto(Tipo.ALIMENTO,"Aceite",3);
		Objeto c5 = new Objeto(Tipo.ACCESORIO,"PS4",6);
		Objeto c6 = new Objeto(Tipo.ACCESORIO,"Nevera",8);
		Objeto c7 = new Objeto(Tipo.ACCESORIO,"Tablet",5);
		Objeto c8 = new Objeto(Tipo.ACCESORIO,"Alargador",2);
		
		Objeto ch1 = new Objeto(Tipo.RECUERDO,"Calendario chino",1);
		Objeto ch2 = new Objeto(Tipo.RECUERDO,"Bola de cristal",1);
		Objeto ch3 = new Objeto(Tipo.RECUERDO,"Figurita china",1);
		Objeto ch4 = new Objeto(Tipo.ACCESORIO,"Cargador USB",1);
		Objeto ch5 = new Objeto(Tipo.ACCESORIO,"Mando fony",1);
		Objeto ch6 = new Objeto(Tipo.ACCESORIO,"Bola discoteca",2);
		
		System.out.println(p1.encuentra(m5));
		System.out.println(p1.encuentra(c1));
		
		System.out.println(p4.encuentra(ch1));
		System.out.println(p2.encuentra(c6));
		
		System.out.println(p1.encuentra(ch1));
		System.out.println(p3.encuentra(m1));
		
		System.out.println();
		
		if(Carrefour.getExistencias()[0][0] == null) {
			System.out.println("Carrefour vacio");
		}
		if(Mercadona.getExistencias()[0][0] == null) {
			System.out.println("Mercadona vacio");
		}
		if(BazarChino.getExistencias()[0][0] == null) {
			System.out.println("Chino vacio");
		}
		
		System.out.println();
		
		
		Carrefour.almacena(c1, 0, 0);
		Carrefour.almacena(c2, 2, 2);
		Carrefour.almacena(c3, 1, 3);
		Carrefour.almacena(c4, 1, 5);
		Carrefour.almacena(c5, 6, 2);
		Carrefour.almacena(c6, 0, 9);
		Carrefour.almacena(c7, 5, 4);
		Carrefour.almacena(c8, 1, 8);

		Mercadona.almacena(m1, 0, 0);
		Mercadona.almacena(m2, 1, 2);
		Mercadona.almacena(m3, 0, 5);
		Mercadona.almacena(m4, 3, 2);
		Mercadona.almacena(m5, 3, 5);
		Mercadona.almacena(m6, 2, 2);
		Mercadona.almacena(m7, 5, 2);
		Mercadona.almacena(m8, 1, 5);
		
		BazarChino.almacena(ch1, 0, 0);
		BazarChino.almacena(ch2, 0, 2);
		BazarChino.almacena(ch3, 1, 3);
		BazarChino.almacena(ch4, 2, 4);
		BazarChino.almacena(ch5, 3, 1);
		BazarChino.almacena(ch6, 0, 1);
		
		p1.adquiere(Carrefour, Tipo.ACCESORIO);
		p1.adquiere(Mercadona, Tipo.ALIMENTO);
		p1.adquiere(Mercadona, Tipo.ALIMENTO);
		p1.adquiere(Mercadona, Tipo.ACCESORIO);
		p1.adquiere(Mercadona, Tipo.ALIMENTO);
		p1.adquiere(Mercadona, Tipo.ALIMENTO);
		
		System.out.println();
		
		System.out.println(p1.getEstado());
		
		p2.adquiere(Mercadona, Tipo.ALIMENTO);
		p2.adquiere(Carrefour, Tipo.ALIMENTO);
		p2.adquiere(Carrefour, Tipo.ACCESORIO);
		p2.adquiere(Mercadona, Tipo.ALIMENTO);
		p2.adquiere(Mercadona, Tipo.ALIMENTO);
		p2.adquiere(Mercadona, Tipo.ACCESORIO);
		
		System.out.println();
		
		System.out.println(p2.getEstado());
		
		p3.adquiere(Mercadona, Tipo.ALIMENTO);
		p3.adquiere(Carrefour, Tipo.ALIMENTO);
		p3.adquiere(Mercadona, Tipo.ALIMENTO);
		p3.adquiere(Mercadona, Tipo.ALIMENTO);
		p3.adquiere(Carrefour, Tipo.ALIMENTO);
		p3.adquiere(Carrefour, Tipo.ACCESORIO);
		
		System.out.println();
		
		System.out.println(p3.getEstado());
		
		p4.adquiere(Mercadona, Tipo.ALIMENTO);
		p4.adquiere(Carrefour, Tipo.ACCESORIO);
		p4.adquiere(Carrefour, Tipo.ALIMENTO);
		p4.adquiere(Mercadona, Tipo.ALIMENTO);
		p4.adquiere(Carrefour, Tipo.ALIMENTO);
		p4.adquiere(Mercadona, Tipo.ALIMENTO);
	
		System.out.println();
		
		System.out.println(p4.getEstado());
		
		System.out.println();
		
		System.out.println(Mercadona.getGanancias());
		
		System.out.println();
		
		System.out.println(Carrefour.getGanancias());
		
		System.out.println();
		
		System.out.println(Carrefour.getGananciaTotal());
		
		System.out.println();
		
		System.out.println("Pertenencias:p1");
		System.out.println();
		
		System.out.println(p1.getPertenencias()[0].getNombre());
		System.out.println(p1.getPertenencias()[1].getNombre());
		System.out.println(p1.getPertenencias()[2].getNombre());
	
		System.out.println();
		
		System.out.println("Pertenencias:p2");
		
		System.out.println();
		
		System.out.println(p2.getPertenencias()[0].getNombre());
		System.out.println(p2.getPertenencias()[1].getNombre());
		System.out.println(p2.getPertenencias()[2].getNombre());
		System.out.println(p2.getPertenencias()[3].getNombre());
		System.out.println(p2.getPertenencias()[4].getNombre());

		System.out.println();
		
		System.out.println("Pertenencias:p3");
		
		System.out.println();
		
		System.out.println(p3.getPertenencias()[0].getNombre());
		System.out.println(p3.getPertenencias()[1].getNombre());
		System.out.println(p3.getPertenencias()[2].getNombre());
		System.out.println(p3.getPertenencias()[3].getNombre());
		System.out.println(p3.getPertenencias()[4].getNombre());
		System.out.println(p3.getPertenencias()[5].getNombre());
		System.out.println(p3.getPertenencias()[6].getNombre());
		
		System.out.println();
		
		System.out.println("Pertenencias:p4");
		
		System.out.println();
		
		System.out.println(p4.getPertenencias()[0].getNombre());

		System.out.println();
		
		System.out.println(p1.intercambio(p2, "Gambas", "Pizza"));
		System.out.println(p1.intercambio(p2, "Larios", "Nevera"));
		System.out.println(p2.intercambio(p3, "Pipas", "Donuts"));
		System.out.println(p2.intercambio(p3, "Kikos", "pan"));
		
		
		System.out.println();
		
		System.out.println("Pertenencias:p1");
		System.out.println();
		
		System.out.println(p1.getPertenencias()[0].getNombre());
		System.out.println(p1.getPertenencias()[1].getNombre());
		System.out.println(p1.getPertenencias()[2].getNombre());
	
		System.out.println();
		
		System.out.println("Pertenencias:p2");
		
		System.out.println();
		
		System.out.println(p2.getPertenencias()[0].getNombre());
		System.out.println(p2.getPertenencias()[1].getNombre());
		System.out.println(p2.getPertenencias()[2].getNombre());
		System.out.println(p2.getPertenencias()[3].getNombre());
		System.out.println(p2.getPertenencias()[4].getNombre());

		System.out.println();
		
		System.out.println();
		
		System.out.println("Pertenencias:p3");
		
		System.out.println();
		
		System.out.println(p3.getPertenencias()[0].getNombre());
		System.out.println(p3.getPertenencias()[1].getNombre());
		System.out.println(p3.getPertenencias()[2].getNombre());
		System.out.println(p3.getPertenencias()[3].getNombre());
		System.out.println(p3.getPertenencias()[4].getNombre());
		System.out.println(p3.getPertenencias()[5].getNombre());
		System.out.println(p3.getPertenencias()[6].getNombre());
		
		System.out.println();
		
		System.out.println("Estados");
		
		System.out.println();
		
		System.out.println(p1.getEstado());
		System.out.println(p2.getEstado());
		System.out.println(p3.getEstado());
		System.out.println(p4.getEstado());
		
		Objeto buscado = p3.busca("pan");
		
		if(buscado == null) {
			System.out.println("No encontrado");
		}
		
		System.out.println();
		
		buscado = p3.busca("Pan");
		
		if(buscado == null) {
			System.out.println("No encontrado");
		}
		
		
		
		System.out.println();
		
		System.out.println(p1.pierde(0));
		System.out.println(p1.pierde(1));
		System.out.println(p2.pierde(0));
		System.out.println(p2.pierde(3));
		System.out.println(p3.pierde(6));
		System.out.println(p3.pierde(0));
		System.out.println(p4.pierde(1));
		System.out.println(p4.pierde(3));
		System.out.println(p1.pierde(2));
		
		System.out.println();
		
		System.out.println("Estados");
		
		System.out.println();
		
		System.out.println(p1.getEstado());
		System.out.println(p2.getEstado());
		System.out.println(p3.getEstado());
		System.out.println(p4.getEstado());
		

}
}
