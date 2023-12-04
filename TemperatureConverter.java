import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureConverter extends JFrame implements ActionListener {
	private JTextField celsiusTextField;
	private JTextField fahrenheitTextField;
	TemperatureConverter(){
		setTitle("Temperature Converter");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create JPanel
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3,2));
		
		//create and add components
		JLabel celsiusLabel=new JLabel("Celsius");
		celsiusTextField=new JTextField();
		JLabel fahrenheitLabel=new JLabel("Fahrenheit");
		fahrenheitTextField=new JTextField();
		fahrenheitTextField.setEditable(false);
		JButton convertButton=new JButton("Convert");
		
		//Register the Button->actionListener
		convertButton.addActionListener(this);
		
		panel.add(celsiusLabel);
		panel.add(celsiusTextField);
		panel.add(fahrenheitLabel);
		panel.add(fahrenheitTextField);
		panel.add(new JLabel());
		panel.add(convertButton);
		
		add(panel);
	}
	public static void main(String[] args) {
		TemperatureConverter converter=new TemperatureConverter();
		converter.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double celsius=Double.parseDouble(celsiusTextField.getText());
		Double fahrenheit=(celsius*9/5)+32;
		fahrenheitTextField.setText(String.format("%.2f",fahrenheit));
		// TODO Auto-generated method stub
		
	}
}
