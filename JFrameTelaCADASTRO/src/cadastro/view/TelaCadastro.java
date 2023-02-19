package cadastro.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;

public class TelaCadastro extends JFrame implements ActionListener {

	private JLabel tituloLabel, nomeLabel, cpfLabel, foneLabel, emailLabel;
	private JLabel cofoneLabel, conomeLabel, cocpfLabel, coemailLabel;
	private JFormattedTextField cpfField, foneField;
	private JTextField nomeField, emailField;
	private JButton adicionarButton;
	private JRadioButton clienteButton, funcionarioButton;
	private JCheckBox propagandaBox;
	private MaskFormatter cpfFormatter, foneFormatter;
	private ButtonGroup radioGroup;
	
	public TelaCadastro() {
		setTitle("Cadastro");
		getContentPane().setLayout(null);
		setBounds(0, 0, 400, 280);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		Font fonte = new Font("SansSerif", Font.BOLD, 20);
		
		tituloLabel = new JLabel("Cadastrar");
		tituloLabel.setBounds(20, 13, 95, 20);
		tituloLabel.setFont(fonte);
		tituloLabel.setForeground(Color.DARK_GRAY);
		add(tituloLabel);
		
		nomeLabel = new JLabel("Nome: ");
		nomeLabel.setBounds(27, 50, 40, 20);
		conomeLabel = new JLabel("*");
		conomeLabel.setBounds(350, 58, 10, 10);
		conomeLabel.setVisible(false);
		add(nomeLabel);
		add(conomeLabel).setForeground(Color.red);
		
		cpfLabel = new JLabel("CPF: ");
		cpfLabel.setBounds(27, 85, 40, 20);
		cocpfLabel = new JLabel("*");
		cocpfLabel.setBounds(350, 93, 10, 10);
		cocpfLabel.setVisible(false);
		add(cpfLabel);
		add(cocpfLabel).setForeground(Color.red);
		
		foneLabel = new JLabel("Fone: ");
		foneLabel.setBounds(27, 120, 40, 20);
		cofoneLabel = new JLabel("*");
		cofoneLabel.setBounds(350, 128, 10, 10);
		cofoneLabel.setVisible(false);
		add(foneLabel);
		add(cofoneLabel).setForeground(Color.red);
		
		emailLabel = new JLabel("E-mail: ");
		emailLabel.setBounds(27, 155, 45, 20);
		coemailLabel = new JLabel("*");
		coemailLabel.setBounds(350, 163, 10, 10);
		coemailLabel.setVisible(false);
		add(emailLabel);
		add(coemailLabel).setForeground(Color.red);
		
		nomeField = new JTextField();
		nomeField.setBounds(70, 50, 270, 25);
		add(nomeField);
		
		try {
			cpfFormatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cpfField = new JFormattedTextField(cpfFormatter);
		cpfField.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
		cpfField.setBounds(70, 85, 270, 25);
		cpfField.setText("000.000.000-00");
		cpfField.setForeground(Color.gray);
		cpfField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				cpfField.setText(null);
				cpfField.setForeground(Color.black);
			}
		});
		add(cpfField);
		
		try {
			foneFormatter = new MaskFormatter("(##) #.####-####");
		} catch (ParseException e) {e.printStackTrace();}
		foneField = new JFormattedTextField(foneFormatter);
		foneField.setBounds(70, 120, 270, 25);
		add(foneField);
		foneField.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
		
		emailField = new JTextField();
		emailField.setBounds(70, 155, 270, 25);
		add(emailField);
		
		clienteButton = new JRadioButton("Cliente");
		clienteButton.setBounds(155, 15, 70, 20);
		add(clienteButton);
		
		funcionarioButton = new JRadioButton("Funcionário");
		funcionarioButton.setBounds(240, 15, 90, 20);
		add(funcionarioButton);
		
		propagandaBox = new JCheckBox("Aceito receber e-mails.");
		propagandaBox.setBounds(38, 192, 180, 25);
		add(propagandaBox);
		
		adicionarButton = new JButton("Adicionar");
		adicionarButton.setBounds(244, 190, 80, 30);
		adicionarButton.setEnabled(true);
		adicionarButton.addActionListener(this);
		add(adicionarButton);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(funcionarioButton);
		funcionarioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		radioGroup.add(clienteButton);
		clienteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==adicionarButton)
		
			conomeLabel.setVisible(nomeField.getText().equalsIgnoreCase(""));
			cocpfLabel.setVisible(cpfField.getValue() == null);
			cofoneLabel.setVisible(foneField.getValue() == null);
			coemailLabel.setVisible(emailField.getText().equalsIgnoreCase(""));
			
			nomeField.setText(null);
			cpfField.setValue(null);
			foneField.setValue(null);
			emailField.setText(null);
			
	}
}
