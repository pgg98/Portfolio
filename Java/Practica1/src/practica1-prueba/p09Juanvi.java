import java.util.ArrayList;
import java.util.Arrays;

public class p09Juanvi {
	public static void main(String[] args) {

		System.out.println("**ESTO ES UNA PRUEBA DE TIENDA DONDE SE COMPRUEBAN LOS METODOS: getExistencias, getObjetos,inventario"
				+ "almacena,desinventaria,elimina y busca.***");
		System.out.println();
		
		Tienda BazarChino = new Tienda(4,4,4);
		
		Objeto ch1 = new Objeto(Tipo.ALIMENTO,"Gusanitos",1);
		Objeto ch2 = new Objeto(Tipo.ACCESORIO,"Gorro de purpurina",1);
		Objeto ch4 = new Objeto(Tipo.COCHE,"Hot wings",1);
		Objeto ch7 = new Objeto(Tipo.RECUERDO,"Calendario chino",1);
		Objeto ch8 = new Objeto(Tipo.RELICARIO,"Pendientes de plastico",1);
		Objeto ch9 = new Objeto(Tipo.ROPA,"Calzoncillos kevin klain",1);
		Objeto ch10 = new Objeto(null,"tippex",1);
	
	System.out.println("Inventario sin cosas");
	System.out.println();
	
		System.out.println(Arrays.toString(BazarChino.inventario()));
		System.out.println();
		
	System.out.println("Prueba almacena dentro y fuera de rango");	
	System.out.println();
		
		System.out.println(BazarChino.almacena(ch1, 0, 0));
		System.out.println();
		System.out.println(BazarChino.almacena(ch2, 1, 3));
		System.out.println();
		System.out.println(BazarChino.almacena(ch4, -70, 20));
		System.out.println();
		System.out.println(BazarChino.almacena(ch7, 20, 20));
		System.out.println();
		System.out.println(BazarChino.almacena(ch8, 20, 20));
		System.out.println();
		System.out.println(BazarChino.almacena(ch9, 20, 20));
		System.out.println();
		System.out.println(BazarChino.almacena(ch10, 20, 20));
		System.out.println();
		
		Objeto ch11 = new Objeto(Tipo.ACCESORIO,"Mando Poly Station",1);
		System.out.println(BazarChino.almacena(ch11, 0, 0));
		System.out.println();
	
		System.out.println("Prueba almacena sin objeto");	
		System.out.println();	
		
		
		System.out.println(BazarChino.almacena(null, 20, 20));
		System.out.println();
		
		
		System.out.println("Probando getExistencias para ver si los objetos están almacenados");
		System.out.println();
		
		for(int i = 0; i<BazarChino.getExistencias().length;i++) {
			for(int j = 0; j<BazarChino.getExistencias()[0].length;j++) {
				if(BazarChino.getExistencias()[i][j]!=null) {
				System.out.println((BazarChino.getExistencias()[i][j]).getNombre());
				System.out.println(i+","+j);
			}}
			
		}
		
		System.out.println();
		System.out.println("Probando elimina");
		System.out.println();
		
		System.out.println((BazarChino.elimina(1, 3).getNombre()));
		if(BazarChino.getExistencias()[1][3] == null) {
			System.out.println("Eliminado");
		}
		System.out.println(BazarChino.elimina(6, 9));
		System.out.println(BazarChino.elimina(-6, -9));
		System.out.println(BazarChino.elimina(3, 3));
	
		
		
		System.out.println();
		
		System.out.println("Probando inventario con dos objetos");
		System.out.println(Arrays.toString(BazarChino.inventario()));
		
		System.out.println();
		
		System.out.println("Probando inventario con todos los objetos");
		
		BazarChino.almacena(new Objeto(Tipo.RELICARIO,"relicario",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.TARJETA,"tarjeta",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.COCHE,"cochecito",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.CASA,"casa",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.ROPA,"ropa",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.ALIMENTO,"comida",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.ACCESORIO,"tutu",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.RECUERDO,"recuerdo",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.DINERO,"1€",1),0, 0);
		BazarChino.almacena(new Objeto(Tipo.MASCOTA,"hamster",1),0, 0);
		
		System.out.println(Arrays.toString(BazarChino.inventario()));
		
		BazarChino.elimina(2, 3);
		BazarChino.elimina(1, 3);
		BazarChino.elimina(2, 2);
		BazarChino.elimina(3, 2);
		BazarChino.elimina(3, 1);
		
		System.out.println();
		
		System.out.println(Arrays.toString(BazarChino.inventario()));
		
		System.out.println();
		
		System.out.println("Comprobando getExistencias para ver que se hayan eliminado los objetos");
		System.out.println();
		
		for(int i = 0; i<BazarChino.getExistencias().length;i++) {
			for(int j = 0; j<BazarChino.getExistencias()[0].length;j++) {
				if(BazarChino.getExistencias()[i][j]!=null) {
				System.out.println((BazarChino.getExistencias()[i][j]).getNombre());
				System.out.println(i+","+j);
			}}
			
		}
		
		
		System.out.println();
		System.out.println("Probando busca con null, objeto de la tienda y cadena vacia");
		System.out.println();
		
		System.out.println(BazarChino.busca(null));
		System.out.println();
		
		//cuidado con el formato de la descripción
		System.out.println(BazarChino.busca(ch1.getDescripcion().toString()));
			
		System.out.println();
		
		System.out.println(BazarChino.busca(""));
		
		System.out.println();
	
		
		System.out.println("Probando getExistencias antes de hacer desinventaria");
		System.out.println();
		
		
		for(int i = 0; i<BazarChino.getExistencias().length;i++) {
			for(int j = 0; j<BazarChino.getExistencias()[0].length;j++) {
				if(BazarChino.getExistencias()[i][j]!=null) {
				System.out.println((BazarChino.getExistencias()[i][j]).getNombre());
			}}
			
		}

		System.out.println();
		
		System.out.println("Probando desinventaria null, tipo que no tiene y tipo que si");
		System.out.println();
		
		Objeto[] prueba = BazarChino.desinventaria(Tipo.ACCESORIO);
		
		System.out.println(prueba[0].getNombre());
		System.out.println(prueba[1].getNombre());
		
		Objeto[] vacio = BazarChino.desinventaria(Tipo.ACCESORIO);
		if(vacio == null) {
			System.out.println("Correcto");
		}
		
		System.out.println();
		
		System.out.println(Arrays.toString(BazarChino.inventario()));
		
		System.out.println();
		
		System.out.println(BazarChino.desinventaria(null));
		System.out.println();

		Objeto[] retdes = BazarChino.desinventaria(Tipo.RECUERDO);

		System.out.println("Impriendo el return de desinventaria");
		System.out.println();
		
		if(retdes == null) {
			System.out.println("Desinventaria null");
		}
		else {
			System.out.println(retdes[0].getNombre());
		}
		
	
		
		System.out.println();
		System.out.println("Comprobando que se hayan borrado los objetos con getExistencias");
		System.out.println();
		
		for(int i = 0; i<BazarChino.getExistencias().length;i++) {
			for(int j = 0; j<BazarChino.getExistencias()[0].length;j++) {
				if(BazarChino.getExistencias()[i][j]!=null) {
					System.out.println((BazarChino.getExistencias()[i][j]).getNombre());
	}}	
	
}
		System.out.println();
		System.out.println("Pruebas getObjeto con null objetos que tiene y que no");
		System.out.println();
		
		System.out.println(BazarChino.getObjetos(null));
		
		
		ArrayList<Objeto> pruebagobj = BazarChino.getObjetos(Tipo.TARJETA);
		
		if(pruebagobj!=null) {
			System.out.println("Hay objetos de este tipo");
		}
		ArrayList <Objeto> retobjs = BazarChino.getObjetos(Tipo.COCHE);
		
		if(retobjs == null) {
			System.out.println("No hay objetos de este tipo");
		}
		
		
		
		System.out.println();
		
		Objeto co1 = new Objeto(Tipo.COCHE,"coche",1);
	
		System.out.println(	BazarChino.almacena(co1, 0, 0));
		
		ArrayList<Objeto> ret = BazarChino.getObjetos(Tipo.COCHE);
		
		System.out.println(ret.get(0).getNombre());
}
	}
	

