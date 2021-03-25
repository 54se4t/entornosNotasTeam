import java.util.Scanner;
public class Ejercico1 {
	public static Scanner tec = new Scanner (System.in);
	public static void main(String[] args) {
		
		boolean programa = true;
		while ( programa == true ) {
			double notaClasicos=0,notaTipoTest=0;
			boolean calculo = false;
			while ( calculo == false) {
				System.out.println("Escrible las notas de los examenes clásicos:");
				notaClasicos = Clasicos(tec.nextDouble(),tec.nextDouble(),tec.nextDouble());
				if (notaClasicos != -1) {
					calculo = true;
					}
				else {
					System.out.println("Intenta otra vez profavor.");
					}
			}
			calculo = false;
			while ( calculo == false) {
				System.out.println("Escrible las notas de los examenes de tipo test:");
				notaTipoTest = TipoTest(tec.nextInt(), tec.nextInt());
				if ( notaTipoTest != -1) {
					calculo = true;
					System.out.println("La nota es: " + (notaClasicos+notaTipoTest));
					}
				else {
					System.out.println("Intenta otra vez profavor.");
					}
			}
			tec.nextLine();
			for (boolean bucle = true; bucle == true;){
				System.out.println("Quieres calcular la nota de otra persona? si/no");
				String text = tec.nextLine();
				if (text.compareToIgnoreCase("no") == 0) {
					programa = false;
					System.out.println("Calculo terminado");
					bucle = false;
				}
				else if (text.compareToIgnoreCase("si") == 0) {
					programa = true;
					bucle = false;
				}
				else {
					System.out.println("Escribe otra vez:");
				}
			}
		}
		
		
	}
	static double Clasicos (double n1, double n2, double n3){
		if (n1 > 10 || n1 < 0) {
			System.out.println("Error: esta nota no es valida: " + n1);
			return -1;
		}
		if (n2 > 10 || n2 < 0) {
			System.out.println("Error: esta nota no es valida: " + n2);
			return -1;
		}
		if (n3 > 10 || n3 < 0) {
			System.out.println("Error: esta nota no es valida: " + n3);
			return -1;
		}
		double total=n1*0.1+n2*0.2+n3*0.2;
		return total;
	}
	static double TipoTest (int n4, int n5) {
		if (n4 > 30 || n4 < 0) {
			System.out.println("Error: esta nota no es valida: " + n4);
			return -1;
		}
		if (n5 > 30 || n5 < 0) {
			System.out.println("Error: esta nota no es valida: " + n5);
			return -1;
		}
		double total=n4+n5;
		total= total-(60-total)/3;
		return total/60*5;
	}
}

