import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ventanaPrincipal extends JFrame implements ItemListener {
	
	JComboBox entrada, salida;
	JTextField txtEntrada, txtSalida;
	
	public ventanaPrincipal() {
		getContentPane().setLayout(null);
		setSize(255, 120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle("Conversor");
		
		// Componentes
		
		JLabel lbl1 = new JLabel("Convertir: ");
			lbl1.setBounds(10, 10, 150, 20);
			lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(lbl1);
		
		txtEntrada = new JTextField();
			txtEntrada.setBounds(80, 10, 50, 25);
		add(txtEntrada);
		
		entrada = new JComboBox();
			entrada.addItem("Centigrados.");
			entrada.addItem("Fahrenheit.");
			entrada.addItem("Kelvin.");
			entrada.setBounds(140, 12, 100, 20);
		add(entrada);
		
		
		JLabel lbl2 = new JLabel("A: ");
			lbl2.setBounds(10, 50, 150, 20);
			lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(lbl2);
		
		salida = new JComboBox();
			salida.addItem("Centigrados.");
			salida.addItem("Fahrenheit.");
			salida.addItem("Kelvin.");
			salida.setBounds(40, 52, 100, 20);
		add(salida);
		
		JLabel igual = new JLabel("=");
			igual.setBounds(150, 50, 150, 20);
			igual.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(igual);
		
		txtEntrada = new JTextField();
			txtEntrada.setBounds(170, 50, 50, 25);
		add(txtEntrada);
			
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource() == salida ) {
			JOptionPane.showMessageDialog((Component)e.getSource(), "Si sirve");
		}
		
	}
}






public class EventoTemperaturas {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ventanaPrincipal();
			}
		});
	}

}
