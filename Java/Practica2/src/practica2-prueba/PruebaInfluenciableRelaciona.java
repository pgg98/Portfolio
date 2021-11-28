
public class PruebaInfluenciableRelaciona {
	public  static void main(String [] args) {
		Influenciable Danny = new Influenciable (24, "Danny", false);
		Influenciable Caballero = new Influenciable (25, "Caballero", false);
		Influenciable Ennio = new Influenciable (25, "Ennio", false);
		Influenciable inf1 = new Influenciable (24, "Maria", true);
		Influenciable inf2 = new Influenciable (24, "Danny", false);
		Influenciable inf3 = new Influenciable (24, "Danny", true);
		Influenciable inf4 = new Influenciable (24, "Danny", false);
		Influenciable inf5 = new Influenciable (24, "Danny", true);
		Influenciable inf6 = new Influenciable (24, "Danny", false);
		Influenciable inf7 = new Influenciable (24, "Danny", true);
		Influenciable inf8 = new Influenciable (24, "Danny", false);
		Influenciable inf9 = new Influenciable (24, "Danny", false);
		Persona p1 = new Persona (3242, null, false);
		Persona p2 = new Persona (3242, null, false);
		Persona p3 = new Persona (3242, null, false);
		Persona p4 = new Persona (3242, null, false);
		Persona p5 = new Persona (3242, null, false);
		Persona p6 = new Persona (3242, null, false);
		Persona p7 = new Persona (3242, null, false);
		
		Diablo d1 = new Diablo("LUCIFER");
		Diablo d2 = new Diablo("");
		Diablo d3 = new Diablo(null);
		Diablo d4 = new Diablo("LUCIFER");
		Diablo d5 = new Diablo("LUCIFER");
		Querube q1 = new Querube("Angelito");
		Querube q2 = new Querube("");
		Querube q3 = new Querube(null);
		Querube q4 = new Querube("Angelito");
		Querube q5 = new Querube("Angelito");
		Danny.setDeidad(d1);
		Caballero.setDeidad(q1);
		Ennio.setDeidad(q5);
		inf7.setDeidad(q3);
		Ennio.empareja(inf7);
		System.out.println("COMPROBAMOS EMPAREJA: ");
		System.out.println("Pasando un influenciable sin deidad: " + Danny.empareja(inf1));
		inf1.setDeidad(d2);
		inf2.setDeidad(q2);
		inf3.setDeidad(q3);
		inf4.setDeidad(d3);
		inf5.setDeidad(q3);
		System.out.println("Pasando un influenciable con deidad distinta: " + Danny.empareja(inf3));
		System.out.println("Pasando un influenciable con la misma deidad: " + Danny.empareja(inf1));
		System.out.println(Danny.getEstado());
		System.out.println(inf1.getEstado());
		System.out.println("Pasando un influenciable con pareja: " + Caballero.empareja(inf1));
		System.out.println("Nueva pareja: "+ Caballero.empareja(inf2));
		System.out.println("Comprobamos que es su pareja: "+ Caballero.getPareja().getNombre());
		System.out.println("Comprobamos que es su pareja: "+ inf2.getPareja().getNombre());
		System.out.println("Probamos con null: " + Caballero.empareja(null));
		System.out.println();
		System.out.println("COMPROBAMOS RELACIONA CON DEIDAD DIABLO: ");
		System.out.println("Se le pasa por paremetro un null: "+Danny.relaciona(null));
		System.out.println("Se le pasa un influenciable-Diablo: "+ Danny.relaciona(inf4));
		System.out.println("Se le pasa un influenciable-Querube: "+ Danny.relaciona(inf2));
		System.out.println("Se le pasa un influenciable-sin deidad: "+ Danny.relaciona(inf9));
		System.out.println("Se le pasa una persona normal: "+ Danny.relaciona(p1));
		System.out.println("Se le pasa por paremetro su pareja: "+Danny.relaciona(inf1));
		System.out.println();
		System.out.println("Vamos a ver el nuevo miembro de la familia de Danny: "+ Danny.getFamilia().get(0).getNombre());
		System.out.println("Valor animico de DANNY: "+Danny.getEstado()+" Valor animico de MARIA: "+inf1.getEstado());
		System.out.println("Edad de Ennio: "+Danny.getEdad()+" Edad de DANNY: "+inf1.getEdad());
		System.out.println("Genes de DANNY: "+Danny.getGenes()+" Gene de MARIA: "+inf1.getGenes());
		System.out.println("Edad: "+Danny.getFamilia().get(0).getEdad());
		System.out.println("Genes: "+Danny.getFamilia().get(0).getGenes());
		System.out.println("Deidad: "+Danny.getFamilia().get(0).getDeidad().getNombre());
		System.out.println("Deidad de Danny: "+Danny.getDeidad().getNombre());
		System.out.println("Deidad de Maria: "+inf1.getDeidad().getNombre());
		System.out.println("Comprobamos que tmb esta en la familia de Maria: "+ inf1.getFamilia().get(0).getNombre());
		System.out.println();
		System.out.println("Comprobamos relaciona con un influenciable sin deidad y pasando por parametro un influenciable sin deidad: "+ inf8.relaciona(inf9));
		System.out.println("Comprobamos relaciona con un influenciable sin deidad y pasando por parametro un influenciable con deidad: "+ inf8.relaciona(Caballero));
		System.out.println(inf8.getRelaciones().size());
		System.out.println("Comprobamos relaciona con un influenciable sin deidad y pasando por parametro una persona: "+ inf8.relaciona(p5));
		System.out.println(inf8.getRelaciones().size());
		System.out.println("Comprobamos relaciona con un influenciable sin deidad y pasando por parametro una persona: "+ inf8.relaciona(p5));
		System.out.println(inf8.getRelaciones().size());
		System.out.println();
		
		
		
		
		
		
		
		
		System.out.println("COMPROBAMOS RELACIONA CON DEIDAD QUERUBE: ");
		System.out.println();
		System.out.println("Se le pasa por paremetro un null: "+Caballero.relaciona(null));
		System.out.println("Se le pasa un influenciable-Diablo: "+ Caballero.relaciona(inf4));
		System.out.println("Comprobamos que deja de tener diedad: "+inf4.getDeidad());
		System.out.println("Se le pasa un influenciable-Querube: "+ Caballero.relaciona(inf5));
		System.out.println();
		System.out.println("Estado del influenciable ANTES de hacer una relacion con un Querube: "+inf9.getEstado());
		System.out.println("Se le pasa un influenciable-sin deidad: "+ Caballero.relaciona(inf9));
		System.out.println("Estado del influenciable DESPUES de hacer una relacion con un Querube: "+inf9.getEstado());
		System.out.println();
		System.out.println("Se le pasa una persona normal: "+ Caballero.relaciona(p1));
		System.out.println();
		System.out.println("Se le pasa por paremetro su pareja siendo ambos Hombes: "+Caballero.relaciona(inf2));
		System.out.println("Se le pasa por paremetro la pareja de Ennio: "+Ennio.relaciona(inf7));
		System.out.println();
		System.out.println("Vamos a ver el nuevo miembro de la familia de ENNIO: "+ Ennio.getFamilia().get(0).getNombre());
		System.out.println("Valor animico de Ennio: "+Ennio.getEstado()+" Valor animico de DANNY: "+inf7.getEstado());
		System.out.println("Edad de Ennio: "+Ennio.getEdad()+" Edad de DANNY: "+inf7.getEdad());
		System.out.println("Genes de ENNIO: "+Ennio.getGenes()+" Gene de DANNY: "+inf7.getGenes());
		System.out.println("Edad: "+Ennio.getFamilia().get(0).getEdad());
		System.out.println("Genes: "+Ennio.getFamilia().get(0).getGenes());
		System.out.println("Deidad: "+Ennio.getFamilia().get(0).getDeidad().getNombre());
		System.out.println("Deidad de Ennio: "+Ennio.getDeidad().getNombre());
		System.out.println("Deidad de DANNY: "+inf7.getDeidad().getNombre());
		System.out.println("Comprobamos que tmb esta en la familia de DANNY: "+ inf7.getFamilia().get(0).getNombre());
		System.out.println();
		System.out.println("COMPROBAMOS RELACIONA CON UN QUERUBE QUE TIENE UN FAMILIAR Y PASANDOLE UN QUERUBE: "+Ennio.relaciona(inf5));
		System.out.println("COMPROBAMOS RELACIONA CON UN QUERUBE QUE TIENE UN FAMILIAR Y PASANDOLE UN FAMILIAR: "+Ennio.relaciona(Ennio.getFamilia().get(0)));
		System.out.println("Relaciones (tiene que dar dos pues tiene un familiar y una nueva relacion): "+Ennio.getRelaciones().size());
		System.out.println();
		System.out.println("POR ULTIMO COMPROBAMOS QUE SI UN INFLUENCIABLE SE HA RELACIONADO CON OTRO Y DEPSUES SE CONVIIERTE EN SU PAREJA SE ELIMINA DE RELACIONES:");
		inf6.setDeidad(d5);
		inf8.setDeidad(d4);
		System.out.println("Se relacionan dos Diablos: " + inf6.relaciona(inf8));
		System.out.println("Se relacionan dos Diablos: " + inf8.relaciona(inf6));
		System.out.println("Estado del querube con familia: "+Ennio.getEstado());
		System.out.println("Se relacionan un diablo con un querube con familia: " + inf8.relaciona(Ennio));
		System.out.println("Estado del querube con familia: "+Ennio.getEstado());
		
		System.out.println("Crobamos sus RELACIONES: "+inf6.getRelaciones().size());
		System.out.println("Crobamos sus RELACIONES: "+inf8.getRelaciones().size());
		System.out.println("Se emparejan ambos: "+ inf6.empareja(inf8));
		System.out.println("Crobamos sus RELACIONES: "+inf6.getRelaciones().size());
		System.out.println("Crobamos sus RELACIONES: "+inf8.getRelaciones().size());
		System.out.println(Ennio.getEstado());
		System.out.println("Comprobamos un querube con familia se relaciona con otro querube: " + Caballero.relaciona(Ennio));
		System.out.println(Ennio.getEstado());
		System.out.println();
		Influenciable comp = new Influenciable(321,null,false);
		System.out.println("COMPROBAMOS PASARLE POR PARAMETRO A SI MISMO: "+ comp.empareja(comp)+" "+comp.relaciona(comp));
		}
}
