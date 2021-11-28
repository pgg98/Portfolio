
public class P08Juanvi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***EN ESTA PRUEBA SE COMPRUEBAN LOS METODOS getGenes, getPertenencias, encuentra, busca, intercambio"
				+ "pierde de PERSONA y getPoseedor,valorEmocional y cambiaInfluencia de OBJETO***");
		System.out.println();
		
		Persona p1 = new Persona(21,"Juan",false);
		Persona p2 = new Persona(-35,"Mario",false);
		Persona p3 = new Persona(58,"",true);
		Persona p4 = new Persona(0,null,true);
		
		Objeto o1 = new Objeto (null,"Hoja de papel",10);
		Objeto o2 = new Objeto (Tipo.ALIMENTO,"",2);
		Objeto o3 = new Objeto(null,null,3);
		Objeto o4 = new Objeto (Tipo.DINERO,"Billete de 5$",1);
		
		System.out.println();
		
		System.out.println("**PRUEBA METODO CALCULAR VALOR EMOCIONAL**");
		
		System.out.println();
		
		System.out.print("("+o4.calculaValorEmocional());
		System.out.print(","+o1.calculaValorEmocional());
		System.out.print(","+o2.calculaValorEmocional());
		System.out.print(","+o3.calculaValorEmocional()+")");
		
		System.out.println();
		
		System.out.println("**PRUEBA METODO CAMBIA INFLUENCIA**");
		
		System.out.println();
		
		System.out.println(o4.getInfluencia());
		System.out.println(o4.cambiaInfluencia(5));
		System.out.println(o4.getInfluencia());
		
		System.out.println();
		
		System.out.println(o1.getInfluencia());
		System.out.println(o1.cambiaInfluencia(0));
		System.out.println(o1.getInfluencia());
		
		System.out.println();
		
		System.out.println(o2.getInfluencia());
		System.out.println(o2.cambiaInfluencia(-5));
		System.out.println(o2.getInfluencia());
		
		System.out.println();
		
		p2.encuentra(o4);
		
		System.out.println("**PROBANDO GETGENES**");
		System.out.println();
		
		System.out.println(p1.getGenes());
		System.out.println(p2.getGenes());
		System.out.println(p3.getGenes());
		System.out.println(p4.getGenes());
		
		System.out.println();
		
		System.out.println("**PROBANDO GETPERTENENCIAS NULL**");
		
		System.out.println();
		
		System.out.println(p1.getPertenencias());
		System.out.println(p3.getPertenencias());
		System.out.println(p4.getPertenencias());
		
		System.out.println();
		
		System.out.println("**PROBANDO ENCUENTRA CON POSEEDOR NULL**");
		
		System.out.println();
		
		System.out.println(p1.getEstado());
		System.out.println(p1.encuentra(o1));
		System.out.println(p1.getEstado());
		
		System.out.println();
		
		for(int i = 0; i<p1.getPertenencias().length;i++)
		System.out.println(p1.getPertenencias()[i].getNombre());
		
		System.out.println();
		
		System.out.println(p2.getEstado());
		System.out.println(p2.encuentra(o2));
		System.out.println(p2.getEstado());
		
		System.out.println();
		
		for(int i = 0; i<p2.getPertenencias().length;i++)
		System.out.println(p2.getPertenencias()[i].getNombre());
		
		System.out.println();
		System.out.println("**PROBANDO ENCUENTRA CON UN POSEEDOR**");
		System.out.println();
		System.out.println(p1.encuentra(o2));
		
		System.out.println();
		
		System.out.println("**PROBANDO ENCUENTRA CON UN OBJETO QUE YA TIENE Y CON NULL**");
		System.out.println();
		System.out.println(p1.encuentra(o1));
		System.out.println();
		System.out.println(p1.encuentra(null));
		
		System.out.println();
		
		System.out.println("**PROBANDO BUSCA**");
		System.out.println();
		System.out.println(p1.busca(null));
		System.out.println(p1.busca(""));
		System.out.println(p1.busca("Hoja de papel").getNombre());
		System.out.println(p1.busca("Papel"));
		System.out.println(p3.busca("Objeto"));
		
		System.out.println();
		
		System.out.println("**PROBANDO INTERCAMBIO**");
		
		System.out.println();
		
		System.out.println(p1.intercambio(null, "Hoja de papel", "Billete de 5$"));
		System.out.println(p1.intercambio(p2,null, "Billete de 5$"));
		System.out.println(p1.intercambio(p2, "Hoja de papel", null));
		System.out.println(p1.intercambio(p2,"", "Billete de 5$"));
		System.out.println(p1.intercambio(p1, "Hoja de papel", ""));
		System.out.println(p1.intercambio(p2,"asgasg", "Billete de 5$"));
		System.out.println(p1.intercambio(p2,"asgasg", "fjdshf"));
		
		System.out.println();
		
		System.out.println(p1.intercambio(p2,"Hoja de papel", "Billete de 5$"));
		
		System.out.println();
		
		System.out.println(o1.getPoseedor());
		System.out.println(o4.getPoseedor());
		
		System.out.println();
		
		for(int i = 0; i<p1.getPertenencias().length;i++)
			System.out.println(p1.getPertenencias()[i].getNombre());
		
		System.out.println();
		
		
		for(int i = 0; i<p2.getPertenencias().length;i++)
			System.out.println(p2.getPertenencias()[i].getNombre());
	
		System.out.println();
	
		System.out.println("**PROBANDO PIERDE**");
		
		System.out.println();
		
		System.out.println(o1.calculaValorEmocional());
		System.out.println(p2.pierde(0));
		System.out.println(o1.getPoseedor());
		System.out.println(p2.pierde(-5));
		System.out.println(p2.pierde(100));
		
		System.out.println();
		
		for(int i = 0; i<p2.getPertenencias().length;i++)
			System.out.println(p2.getPertenencias()[i].getNombre());
	

}}
