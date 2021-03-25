import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Ejercicio1Ventana {

	private JFrame frmCalculadorDeNota;
	private JTextField texNota1;
	private JTextField texNota2;
	private JTextField texNota3;
	private JTextField texNota4;
	private JTextField texNota5;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1Ventana window = new Ejercicio1Ventana();
					window.frmCalculadorDeNota.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio1Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadorDeNota = new JFrame();
		frmCalculadorDeNota.setTitle("Calculadora de nota");
		frmCalculadorDeNota.setBounds(100, 100, 613, 314);
		frmCalculadorDeNota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadorDeNota.getContentPane().setLayout(null);
		
		texNota1 = new JTextField();
		texNota1.setText("exa1 clásico");
		texNota1.setBounds(52, 105, 86, 20);
		frmCalculadorDeNota.getContentPane().add(texNota1);
		texNota1.setColumns(10);
		
		texNota2 = new JTextField();
		texNota2.setText("exa2 clásico");
		texNota2.setBounds(151, 105, 86, 20);
		frmCalculadorDeNota.getContentPane().add(texNota2);
		texNota2.setColumns(10);
		
		texNota3 = new JTextField();
		texNota3.setText("exa3 clásico");
		texNota3.setBounds(247, 105, 86, 20);
		frmCalculadorDeNota.getContentPane().add(texNota3);
		texNota3.setColumns(10);
		
		texNota4 = new JTextField();
		texNota4.setText("exa4 test");
		texNota4.setBounds(343, 105, 86, 20);
		frmCalculadorDeNota.getContentPane().add(texNota4);
		texNota4.setColumns(10);
		
		texNota5 = new JTextField();
		texNota5.setText("exa5 test");
		texNota5.setBounds(439, 105, 86, 20);
		frmCalculadorDeNota.getContentPane().add(texNota5);
		texNota5.setColumns(10);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(343, 166, 182, 14);
		frmCalculadorDeNota.getContentPane().add(lblNota);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfo.setBounds(52, 196, 473, 23);
		frmCalculadorDeNota.getContentPane().add(lblInfo);
		
		lblNewLabel = new JLabel("Escribe la nota del alumno:");
		lblNewLabel.setBounds(52, 80, 473, 14);
		frmCalculadorDeNota.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Borrar todo");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texNota1.setText("exa1 clásico");
				texNota2.setText("exa2 clásico");
				texNota3.setText("exa3 clásico");
				texNota4.setText("exa4 test");
				texNota5.setText("exa5 test");
				lblInfo.setText("");
			}
		});
		btnNewButton_1.setBounds(167, 162, 130, 23);
		frmCalculadorDeNota.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInfo.setText("");
				String[] notaTex = {texNota1.getText(),texNota2.getText(),texNota3.getText(),texNota4.getText(),texNota5.getText()};
				boolean val = true;
				for (String i:notaTex) {
					val = validez(i);
					if (val == false) break;
				}
				if (val == false ) {
					lblInfo.setText("La nota introducida no es valida, deben ser numero entero.");
				}
				else {
					int[] nota = new int[notaTex.length];
					for (int i=0; i<nota.length; i++) {
						nota[i] = Integer.parseInt(notaTex[i]);
					}
					boolean rango = true;
					for (int i=0;i<nota.length;i++) {
						if ( i < 3 ) {
							if ( !Rango(nota[i], "clasico")) {
								lblInfo.setText("la nota del examen " + (i+1) + " no es valido: " + nota[i] + " (Debe ser número entre 0 y 10)");
								rango = false;
							}
						}
						else {
							if ( !Rango(nota[i], "tipo test")) {
								lblInfo.setText("la nota del examen " + (i+1) + " no es valido: " + nota[i] + " (Debe ser número entre 0 y 30)");	
								rango = false;
							}
						}
					}
					if ( rango == true ) {
						double resultado = nota[0]*0.1+nota[1]*0.2+nota[2]*0.2+((nota[3]+nota[4])-(60-nota[3]-nota[4])/3)/6*0.5;
						resultado = (resultado < 0) ? 0 : resultado;
						lblNota.setText("Nota: " + resultado);
					}
				}
			}
		});
		btnNewButton.setBounds(52, 162, 89, 23);
		frmCalculadorDeNota.getContentPane().add(btnNewButton);
	}
	static boolean validez (String text) {
		for (int i=0; i<text.length(); i++) 
			if (!Character.isDigit(text.charAt(i))) 			
				return false;
		return true;
	}
	static boolean Rango (int num, String tipo) {
		boolean ran=true;
		if (num >= 0 ) {
			if (tipo.compareTo("clasico") == 0) {
				if (num > 10) {
					ran = false;
				}
			}
			if (tipo.compareTo("tipo test") == 0){
				if (num > 30) {
					ran = false;
				}
			} 
		}
		else {
			ran = false;
		}
		return ran;
		
	}
}
