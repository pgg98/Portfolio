
public class p06Juanvi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***ESTA PRUEBA COMPRUEBA LOS CONSTRUCTORES DE OBJETO, PERSONA Y TIENDA");
		System.out.println();
		
		System.out.println("***PRUEBA CONSTRUCTOR OBJETO***");
		System.out.println("Creamos un objeto siguiendo las pautas del constructor");
		Objeto o4 = new Objeto (Tipo.DINERO,"Billete de 5$",1);
		System.out.println("Obtenemos su descripci�n para comprobar que este bien");
		System.out.println(o4.getDescripcion());
		System.out.println();
		
		System.out.println("Creamos un objeto pas�ndole un tipo Null");
		Objeto o1 = new Objeto (null,"Hola de papel",10);
		System.out.println("Obtenemos su descripci�n para comprobar que este bien");
		System.out.println(o1.getDescripcion());
		System.out.println();
		
		System.out.println("Creamos un objeto pas�ndole cadena vac�a");
		Objeto o2 = new Objeto (Tipo.ALIMENTO,"",2);
		System.out.println("Obtenemos su descripci�n para comprobar que este bien");
		System.out.println(o2.getDescripcion());
		System.out.println();
		
		System.out.println("Creamos un objeto pas�ndole cadena null y tipo null");
		Objeto o3 = new Objeto(null,null,3);
		System.out.println("Obtenemos su descripci�n para comprobar que este bien");
		System.out.println(o3.getDescripcion());
		System.out.println();
		
		System.out.println("***PRUEBA CONSTRUCTOR PERSONA***");
		System.out.println("Creamos una persona siguiendo las pautas");
		Persona p1 = new Persona(21,"Juan",false);
		System.out.println(p1.getNombre());
		System.out.println(p1.getEdad());
		System.out.println(p1.getGenes());
		System.out.println();
		
		System.out.println("Creamos una persona con un double menor que 0");
		Persona p2 = new Persona(-35,"Mario",false);
		System.out.println(p2.getNombre());
		System.out.println(p2.getEdad());
		System.out.println(p2.getGenes());
		System.out.println();
		
		System.out.println("Creamos una persona con cadena vac�a");
		Persona p3 = new Persona(58,"",true);
		System.out.println(p3.getNombre());
		System.out.println(p3.getEdad());
		System.out.println(p3.getGenes());
		System.out.println();
		
		System.out.println("Creamos una persona con edad 0 y cadena null");
		Persona p4 = new Persona(0,null,true);
		System.out.println(p4.getNombre());
		System.out.println(p4.getEdad());
		System.out.println(p4.getGenes());
		System.out.println();
		
		System.out.println("***PRUEBA CONSTRUCTOR TIENDA***");
		System.out.println("Creamos una tienda siguiendo las pautas del constructor");
		Tienda t = new Tienda(4,6,9);
		System.out.println(t.getExistencias().length+","+t.getExistencias()[0].length+","+t.getGanancias());
		System.out.println();
		
		System.out.println("Creamos una tienda con i1 < 0 , i2 < 0 y ganancias < 0 ");
		Tienda t1 = new Tienda(-1,-5,-7);
		System.out.println(t1.getExistencias().length+","+t1.getExistencias()[0].length+","+t1.getGanancias());
		
		
		
	

}}
