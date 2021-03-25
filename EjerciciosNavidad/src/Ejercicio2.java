import java.util.ArrayList;
public class Ejercicio2 {

	public static void main(String[] args) {
		persona pr1 = new persona();
		pr1.setNombre("Pepe");
		pr1.setAficiones("jardinería", "bricolaje", "deportes", "música", "fotografía", "yoga", "cocina");
		persona pr2 = new persona();
		pr2.setNombre("Juan");
		pr2.setAficiones("deportes", "jardinería", "fotografía");
		persona pr3 = new persona();
		pr3.setNombre("Maria");
		pr3.setAficiones("fotografía", "yoga", "cocina" , "deportes", "jardinería");
		persona pr4 = new persona();
		pr4.setNombre("Angelina");
		pr4.setAficiones("deportes", "bricolaje" , "fotografía");
		persona pr5 = new persona();
		pr5.setNombre("Bouchra");
		pr5.setAficiones("yoga", "cocina" , "deportes", "jardinería");
		persona pr6 = new persona();
		pr6.setNombre("Josefa");
		pr6.setAficiones("fotografía", "yoga", "cocina");
		persona pr7 = new persona();
		pr7.setNombre("Aida");
		pr7.setAficiones("deportes", "jardinería", "fotografía");
		persona pr8 = new persona();
		pr8.setNombre("Mar");
		pr8.setAficiones("fotografía", "deportes", "yoga");
		persona pr9 = new persona();
		pr9.setNombre("Marcela");
		pr9.setAficiones("deportes", "fotografía", "bricolaje");
		persona pr10 = new persona();
		pr10.setNombre("Carmen");
		pr10.setAficiones("yoga", "cocina" , "deportes", "fotografía");
		
		calcAfines(pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9,pr10);
		for (persona i:pr7.afines) System.out.println(i.nombre + " ");
	}
	
	static void calcAfines (persona ... personas) { //llamar methodo sonAfines a todas las personas
		for (int i=0; i<personas.length; i++) {
			for (int j=i+1; j<personas.length; j++) {
				personas[i].sonAfines(personas[j]);
			}
		}
	}
}

class persona {
	String nombre;
	String[] aficiones;
	persona[] afines = new persona [0];
	
	public void setNombre (String nom) {
		nombre = nom;
	}
	public void setAficiones (String ... a) {
		aficiones = a.clone();
	}
	public void sonAfines (persona a) { //para comparar aficiones y añadir afines a la lista
		ArrayList<persona> lista1 = new ArrayList<persona>();
		for (persona i:afines) lista1.add(i);
		if (!lista1.contains(a)) {
			ArrayList<String> lista2 = new ArrayList<String>();
			for (String i:a.aficiones) lista2.add(i);
			int cont=0;
			for (String j:this.aficiones) {
				if (lista2.contains(j)) {
					cont++;
				}
			}
			if (cont >= 3) {
				persona[] tmp1 = new persona [afines.length+1], tmp2 = new persona [a.afines.length+1];
				for (int i=0; i < this.afines.length; i++) tmp1[i] = this.afines[i];
				for (int i=0; i < a.afines.length; i++) tmp2[i] = a.afines[i];
				tmp1[tmp1.length-1] = a;
				tmp2[tmp2.length-1] = this;
				this.afines = tmp1.clone();
				a.afines = tmp2.clone();
			}
		}
	}
}
