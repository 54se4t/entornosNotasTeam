
public class Ejercicio1 {
	public static void main(String[] args) {
		double notaAlumno1 = Calculador (10,10,10,30,0,30,0,0,0,0);
		double notaAlumno2 = Calculador (0,0,0,0,30,0,30,5,5,5);
		double notaAlumno3 = Calculador (5,5,5,15,0,15,0,0,0,0);
		double notaAlumno4 = Calculador (6,5,3,17,4,24,5,0,3,4);
		double notaAlumno5 = Calculador (3,3,4,4,14,3,15,0,5,1);
		double notaAlumno6 = Calculador (6,7,3,16,2,25,1,0,0,0);
		double notaAlumno7 = Calculador (8,7,7,19,0,28,2,0,0,0);
		double notaAlumno8 = Calculador (7,7,7,27,3,27,0,9,0,0);
		double notaAlumno9 = Calculador (7,7,7,27,3,27,0,0,2,0);
		double notaAlumno10 = Calculador (10,10,10,30,0,30,0,1,0,0);
		System.out.println(notaAlumno1);
		System.out.println(notaAlumno2);
		System.out.println(notaAlumno3);
		System.out.println(notaAlumno4);
		System.out.println(notaAlumno5);	
	}
	
	static double Calculador (
			int c1, int c2, int c3, 
			int t1Correctas, int t1Falladas, int t2Correctas, int t2Falladas, 
			int retrasado1, int retrasado2, int retrasado3) {
		if (retrasado1 > 5 || retrasado2 > 5 || retrasado3 > 5) return 3; 
		double resultado=(c1*0.1+c2*0.2+c3*0.2+ (t1Correctas-(t1Falladas/3))/3*0.25 + (t2Correctas-(t2Falladas/3))/3*0.25)
				*(1-(double)retrasado1/10-(double)retrasado2/10-(double)retrasado3/10);
		if (resultado < 0) resultado = 0;
		return resultado;
	}
}

