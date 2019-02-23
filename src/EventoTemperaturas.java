import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class Conversiones {
	
	//----------------------------------------------------------
	public double CelsiusToFahrenheit(double celsius) {
		double fahrenheit = (celsius * 1.8) + 32;
		return fahrenheit;
	}
	
	public double CelsiusToKelvin(double celsius) {
		double kelvin = celsius + 273.15;
		return kelvin;
	}
	
	public double CelsiusToRankine(double celsius) {
		double rankine = (celsius * 1.8) + 491.67;
		return rankine;
	}
	
	//----------------------------------------------------------
	public double FahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32) / 1.8;
		return celsius;
	}
	
	public double FahrenheitToKelvin(double fahrenheit) {
		double kelvin = ( (fahrenheit - 32) / 1.8 ) + 273.15;
		return kelvin;
	}
	
	public double FahrenheitToRankine(double fahrenheit) {
		double rankine = fahrenheit + 459.67;
		return rankine;
	}
	
	//----------------------------------------------------------
	
	public double KelvinToCelsius(double kelvin) {
		double celsius = kelvin - 273.15;
		return celsius;
	}
	
	public double KelvinToFahrenheit(double kelvin) {
		double fahrenheit = ( (kelvin - 273.15) * 1.8 ) + 32;
		return fahrenheit;
	}
	
	public double KelvinToRankine(double kelvin) {
		double rankine = kelvin * 1.8;
		return rankine;
	}
	
	//----------------------------------------------------------
	
	public double RankineToCelsius(double rankine) {
		double celsius = (rankine - 491.67) / 1.8;
		return celsius;
	}
	
	public double RankineToFahrenheit(double rankine) {
		double fahrenheit = rankine - 459.67;
		return fahrenheit;
	}
	
	public double RankineTokelvin(double rankine) {
		double kelvin = rankine/ 1.8;
		return kelvin;
	}
	
}



class ventanaPrincipal extends JFrame implements ActionListener {
	
	JComboBox entrada, salida;
	JTextField txtEntrada, txtSalida;
	
	Conversiones conv = new Conversiones();
	
	public ventanaPrincipal() {
		getContentPane().setLayout(null);
		setSize(310, 120);
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
			txtEntrada.setBounds(80, 10, 100, 25);
			txtEntrada.addActionListener(this);
		add(txtEntrada);
		
		entrada = new JComboBox();
			entrada.addItem("--Selecciona--");
			entrada.addItem("Centigrados.");
			entrada.addItem("Fahrenheit.");
			entrada.addItem("Kelvin.");
			entrada.addItem("Rankine.");
			entrada.setBounds(190, 12, 110, 20);
			entrada.addActionListener(this);
			entrada.setEnabled(false);
		add(entrada);
		
		JLabel lbl2 = new JLabel("A: ");
			lbl2.setBounds(10, 50, 150, 20);
			lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(lbl2);
		
		salida = new JComboBox();
			salida.addItem("--Selecciona--");
			salida.addItem("Centigrados.");
			salida.addItem("Fahrenheit.");
			salida.addItem("Kelvin.");
			salida.addItem("Rankine.");
			salida.setBounds(40, 52, 110, 20);
			salida.addActionListener(this);
			salida.setEnabled(false);
		add(salida);
		
		JLabel igual = new JLabel("=");
			igual.setBounds(160, 50, 150, 20);
			igual.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(igual);
		
		txtSalida = new JTextField();
			txtSalida.setBounds(180, 50, 100, 25);
			txtSalida.addActionListener(this);
			txtSalida.setEnabled(false);
		add(txtSalida);
			
		txtEntrada.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if(Character.isLetter(c) || Character.isWhitespace(c)) {
					JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar números.");
				}
				if(!Character.isLetter(c) || !Character.isWhitespace(c)) {
					entrada.setEnabled(true);
					salida.setEnabled(true);
				} 
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
			
		});
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		double grados = Double.parseDouble(txtEntrada.getText());
		double res;
		
			if(entrada.getSelectedItem().equals("Centigrados.") && salida.getSelectedItem().equals("Fahrenheit.")) {
				res = conv.CelsiusToFahrenheit(grados);
				txtSalida.setText(res+"");
				if(salida.getSelectedItem().equals("Centigrados.")) {
					txtSalida.setText(grados+"");
				}
				salida.removeAllItems();
			} else if(entrada.getSelectedItem().equals("Centigrados.") && salida.getSelectedItem().equals("Kelvin.")) {
				res = conv.CelsiusToKelvin(grados);
				txtSalida.setText(res+"");
				if(salida.getSelectedItem().equals("Centigrados.")) {
					txtSalida.setText(grados+"");
				}
			} else if(entrada.getSelectedItem().equals("Centigrados.") && salida.getSelectedItem().equals("Rankine.")) {
				res = conv.CelsiusToRankine(grados);
				txtSalida.setText(res+"");
				if(salida.getSelectedItem().equals("Centigrados.")) {
					txtSalida.setText(grados+"");
				}
			} else if(entrada.getSelectedItem().equals("Fahrenheit.") && salida.getSelectedItem().equals("Rankine.")) {
				res = conv.CelsiusToRankine(grados);
				txtSalida.setText(res+"");
				if(salida.getSelectedItem().equals("Centigrados.")) {
					txtSalida.setText(grados+"");
				}
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
