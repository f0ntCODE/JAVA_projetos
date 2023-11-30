package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Banco.ControladorVariáveis;
import Banco.DAO;
import javax.swing.JTextField;


public class Relat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private Connection conec;
	private PreparedStatement pst;
	private ResultSet rs = null;
	
	DAO dao = new DAO();
	
	private JTextField txtSoma;
	private JTextField textField;
	private JTextField qtdLeonardo;
	private JTextField qtdBruno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relat frame = new Relat();
					
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Relat() {
		int larg = 800;
		int alt = 600;
		
		ControladorVariáveis control = new ControladorVariáveis();
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, larg, alt);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);
		painel.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				System.out.println(control.getSoma());
			}
		});
		
		//____________________________________________________________________________________botao Voltar
		JLabel voltar = new JLabel("Voltar");
		voltar.setForeground(new Color(255, 255, 255));
		voltar.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setBounds(10, 11, 106, 39);
		painel.add(voltar);
		
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				PrincipalAdmin admp = new PrincipalAdmin();
				admp.setLocationRelativeTo(null);
				admp.setResizable(false);
				admp.setVisible(true);
			}
		});
		
		voltar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				voltar.setCursor(mao);
			}
		});
		
		
		JLabel voltBot = new JLabel("");
		voltBot.setHorizontalAlignment(SwingConstants.CENTER);
		voltBot.setIcon(new ImageIcon(TelaFuncio.class.getResource("/Imagens/voltar_botao.png")));
		voltBot.setBounds(10, 19, 118, 31);
		painel.add(voltBot);
		
		//____________________________________________________________________________________painel
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 74, 764, 434);
		painel.add(panel);
		panel.setLayout(null);
		
		JLabel lblRelat = new JLabel("<HTML><u>RELATÓRIO</u><HTML>");
		lblRelat.setForeground(new Color(67, 136, 145));
		lblRelat.setBounds(270, 5, 223, 79);
		lblRelat.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelat.setFont(new Font("Inknut Antiqua", Font.BOLD, 30));
		panel.add(lblRelat);
		
		txtSoma = new JTextField("R$ " + control.getSoma());
		txtSoma.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoma.setToolTipText("Somatória do dia");
		txtSoma.setOpaque(false);
		txtSoma.setBorder(null);
		txtSoma.setEditable(false);
		txtSoma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoma.setBounds(55, 156, 123, 20);
		panel.add(txtSoma);
		txtSoma.setColumns(10);
		
		textField = new JTextField("" + control.getID());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setToolTipText("Somatória do dia");
		textField.setOpaque(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(55, 269, 123, 20);
		panel.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(219, 131, 19, 253);
		panel.add(separator);
		
		JLabel lblSomaDia = new JLabel("SOMA TOTAL");
		lblSomaDia.setFont(new Font("Inknut Antiqua", Font.PLAIN, 14));
		lblSomaDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblSomaDia.setBounds(55, 131, 123, 14);
		panel.add(lblSomaDia);
		
		JLabel lblNmeroDeClientes = new JLabel("NÚMERO DE CLIENTES");
		lblNmeroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNmeroDeClientes.setFont(new Font("Inknut Antiqua", Font.PLAIN, 14));
		lblNmeroDeClientes.setBounds(10, 238, 214, 20);
		panel.add(lblNmeroDeClientes);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 209, 199, 32);
		panel.add(separator_1);
		
		JLabel txtleonardo = new JLabel("AGENDADOS COM LEONARDO");
		txtleonardo.setFont(new Font("Inknut Antiqua", Font.PLAIN, 14));
		txtleonardo.setBounds(248, 133, 386, 14);
		panel.add(txtleonardo);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(248, 209, 199, 32);
		panel.add(separator_1_1);
		
		JLabel txtBruno = new JLabel("AGENDADOS COM BRUNO");
		txtBruno.setFont(new Font("Inknut Antiqua", Font.PLAIN, 14));
		txtBruno.setBounds(248, 243, 386, 14);
		panel.add(txtBruno);
		
		qtdLeonardo = new JTextField("" + control.getQTDLeonardo());
		qtdLeonardo.setToolTipText("Somatória do dia");
		qtdLeonardo.setOpaque(false);
		qtdLeonardo.setHorizontalAlignment(SwingConstants.CENTER);
		qtdLeonardo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		qtdLeonardo.setEditable(false);
		qtdLeonardo.setColumns(10);
		qtdLeonardo.setBorder(null);
		qtdLeonardo.setBounds(248, 160, 123, 20);
		panel.add(qtdLeonardo);
		
		qtdBruno = new JTextField("" + control.getQTDBruno());
		qtdBruno.setToolTipText("Somatória do dia");
		qtdBruno.setOpaque(false);
		qtdBruno.setHorizontalAlignment(SwingConstants.CENTER);
		qtdBruno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		qtdBruno.setEditable(false);
		qtdBruno.setColumns(10);
		qtdBruno.setBorder(null);
		qtdBruno.setBounds(248, 273, 123, 20);
		panel.add(qtdBruno);
		
		//____________________________________________________________________________________fundo
		JLabel fundo= new JLabel("");
		fundo.setBounds(-54, 4, 869, 588);
		fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/Fundo.jpg")));
		painel.add(fundo);
		
		//____________________________________________________________________________________
	}
	
	private void status() {
		try {
			conec = dao.conectar();
			if (conec == null) {
				JOptionPane.showMessageDialog( null, "Erro de conexão", "Erro de conexão", JOptionPane.ERROR);

			} else {
				System.out.println("Banco conectado com sucesso");
			}
			conec.close();

		} catch (Exception e) {
			System.out.println(e);
			}
		}
	}
