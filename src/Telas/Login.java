package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Banco.DAO;
import Main.Limitador;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();

	private JPanel Painel;
	private JTextField Nome;
	private JTextField Numero;
	
	private Connection conec;
	private PreparedStatement pst;
	
	public String tel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};

	/**
	 * Create the frame.
	 */
	public Login() {
		//ativação da janela conecta o banco
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		
		
		
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Icones/cabeloBarbaIcon.png")));
		setTitle("Tela de Login");// Titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);// limites
		setSize(800, 600);// proporção
		Painel = new JPanel();
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		Painel.setLayout(null);
		setContentPane(Painel);

		// ____________________________________________________________________________________Legendas
		// de cima dos campos

		JLabel indic_Tel = new JLabel("Telefone");
		indic_Tel.setForeground(Color.LIGHT_GRAY);
		indic_Tel.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		indic_Tel.setBounds(260, 422, 94, 27);
		Painel.add(indic_Tel);

		JLabel indic_Nome = new JLabel("Nome");
		indic_Nome.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		indic_Nome.setForeground(new Color(192, 192, 192));
		indic_Nome.setBounds(260, 349, 94, 27);
		Painel.add(indic_Nome);

		// ____________________________________________________________________________________botao
		// admin
		JLabel botaoAreaAdmin = new JLabel("   ADMIN");
		botaoAreaAdmin.setForeground(new Color(255, 255, 255));
		botaoAreaAdmin.setBounds(680, 530, 94, 17);
		Painel.add(botaoAreaAdmin);

		// função do botão admin
		botaoAreaAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginAdmin admlog = new LoginAdmin();
				admlog.setLocationRelativeTo(null);
				admlog.setResizable(false);
				admlog.setVisible(true);
			}
		});

		// ____________________________________________________________________________________botao
		// continuar

		JLabel continuar = new JLabel("Continuar");
		continuar.setForeground(new Color(255, 255, 255));
		continuar.setFont(new Font("Inknut Antiqua ExtraBold", Font.PLAIN, 16));
		continuar.setHorizontalAlignment(SwingConstants.CENTER);
		continuar.setBounds(336, 500, 180, 47);
		Painel.add(continuar);

		JLabel botaoContinua = new JLabel("");
		botaoContinua.setHorizontalAlignment(SwingConstants.CENTER);
		botaoContinua.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Imagens/Botao_confirma.png")));
		botaoContinua.setBounds(315, 491, 230, 70);
		Painel.add(botaoContinua);

		continuar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				continuar.setCursor(mao);
			}
		});
		
		// ____________________________________________________________________________________área
		// de dígito do nome

		Nome = new JTextField();
		Nome.setForeground(new Color(255, 255, 255));
		Nome.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		Nome.setBounds(260, 381, 287, 30);
		Nome.setOpaque(false);
		Nome.setBorder(null);
		Painel.add(Nome);
		Nome.setColumns(10);

		Nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String texto = Nome.getText();
				Nome.setText(texto);
				String carac = "1234567890";
				if (carac.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		// ____________________________________________________________________________________
		// campo de digitar numero

		Numero = new JTextField();
		Numero.setForeground(new Color(255, 255, 255));
		Numero.setOpaque(false);
		Numero.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		Numero.setColumns(10);
		Numero.setBorder(null);
		Numero.setBounds(258, 450, 287, 30);
		Numero.setDocument(new Limitador(11));
		Painel.add(Numero);

		Numero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String tel = Numero.getText();
				Numero.setText(tel);

				String carac = "1234567890";
				if (!carac.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

		});

		// ____________________________________________________________________________________
		JLabel logotipo = new JLabel("");
		logotipo.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Imagens/Logotipo.png")));
		logotipo.setHorizontalAlignment(SwingConstants.CENTER);
		logotipo.setBounds(201, 0, 403, 387);
		Painel.add(logotipo);

		// ____________________________________________________________________________________
		JLabel campoNome = new JLabel("");
		campoNome.setHorizontalAlignment(SwingConstants.CENTER);
		campoNome.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Icones/campo.png")));
		campoNome.setBounds(211, 371, 385, 47);
		Painel.add(campoNome);

		// ____________________________________________________________________________________
		JLabel campoNumero = new JLabel("");
		campoNumero.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Icones/campo.png")));
		campoNumero.setHorizontalAlignment(SwingConstants.CENTER);
		campoNumero.setBounds(201, 443, 403, 47);
		Painel.add(campoNumero);
		
		JLabel lblAlpha = new JLabel("ALPHA. VER.1.0");
		lblAlpha.setForeground(new Color(255, 255, 255));
		lblAlpha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlpha.setBounds(10, 533, 94, 14);
		Painel.add(lblAlpha);
		

		// ____________________________________________________________________________________
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Login.class.getResource("/Imagens/Fundo.jpg")));
		fundo.setBounds(0, 0, 784, 572);
		Painel.add(fundo);
		botaoAreaAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));

		// função do botao continuar
		continuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int qtd = 0;
				int qtdn = 0;
				String texto = Nome.getText();
				Nome.setText(texto);

				for (int cont = 0; cont < texto.length(); cont++) {
					if (Character.isLetter(texto.charAt(cont))) {
						qtd++;
					}
				}

				String num = Numero.getText();

				for (char c : num.toCharArray()) {
					if (Character.isDigit(c)) {
						qtdn++;
					}
				}

				if (Nome.getText().equals("") && Numero.getText().equals("")) {
					JOptionPane.showMessageDialog(Painel, "Você precisa preencher todos os campos",
							"Preencha todos os campos", JOptionPane.WARNING_MESSAGE);
				}
				
				else if(Nome.getText().equals("") || Numero.getText().equals("")) {
					JOptionPane.showMessageDialog(Painel, "Um dos campos está vazio. Preencha-o corretamente",
							"Preencher campos", JOptionPane.WARNING_MESSAGE);
				}

				else if (qtd <= 3) {
					JOptionPane.showMessageDialog(Painel, "Poucos caracteres digitados. Tente novamente",
							"Nome muito pequeno", JOptionPane.WARNING_MESSAGE);

				}

				else if (qtdn < 11) {
					JOptionPane.showMessageDialog(Painel, "Digite corretamente o numero de telefone",
							"Numero de telefone inválido", JOptionPane.WARNING_MESSAGE);
				}

				else {
					dispose();
					Servicos serv = new Servicos();
					serv.setLocationRelativeTo(null);
					serv.setResizable(false);
					serv.setVisible(true);
					credencial();
					
				}
			}
		});
	}
	//fim do construtor
	
	private void status() {
		try {
			conec = dao.conectar();
			if (conec == null) {
				System.out.println("Erro de conexão");
				
			} else {
				System.out.println("Banco conectado com sucesso");
			}
			//conec.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void credencial() {
		String texto = Nome.getText();
		tel = Numero.getText();
		String insert = "insert into dados_barbearia (NOME, NUMERO) values(?, ?)";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(insert);
			pst.setString(1, texto);
			pst.setString(2, tel);
			int confirma = pst.executeUpdate();
			
			
			if (confirma == 1) {
				System.out.println("Sucesso ao enviar dado");
				
			} else {

				System.out.println("Falha ao enviar dado");
			}
			conec.close();
			
			
		} catch (Exception e) {
System.out.println(e);		}
	}
}
