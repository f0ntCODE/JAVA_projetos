package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Banco.AcessoBD;
import Dados.Acesso;

public class LoginAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAdmin() {
		int larg = 800;
		int alt = 600;
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, larg, alt);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel voltar = new JLabel("<HTML><u>voltar</u><HTML>");
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log = new Login();
				log.setLocationRelativeTo(null);
				log.setResizable(false);
				log.setVisible(true);
			}
		});

		JLabel texto_admin = new JLabel("ÁREA DO ADMIN");
		texto_admin.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		texto_admin.setForeground(new Color(255, 255, 255));
		texto_admin.setHorizontalAlignment(SwingConstants.CENTER);
		texto_admin.setBounds(256, 343, 290, 34);
		contentPane.add(texto_admin);

		voltar.setForeground(new Color(255, 255, 255));
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setBounds(10, 41, 112, 40);
		voltar.setText("<HTML><u>voltar</u><HTML>");
		voltar.setFont(new Font("Inknut Antiqua", Font.PLAIN, 18));
		contentPane.add(voltar);
		// ____________________________________________________________________________________

		senha = new JPasswordField();
		senha.setForeground(new Color(255, 255, 255));
		senha.setFont(new Font("Inknut Antiqua", Font.PLAIN, 20));
		senha.setBounds(256, 443, 290, 40);
		contentPane.add(senha);
		senha.setBorder(null);
		senha.setOpaque(false);
		// ____________________________________________________________________________________

		email = new JTextField();
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setBounds(256, 372, 290, 47);
		contentPane.add(email);
		email.setColumns(10);
		email.setBorder(null);
		email.setOpaque(false);
		// ____________________________________________________________________________________

		JLabel continuar = new JLabel("Continuar");
		continuar.setForeground(new Color(255, 255, 255));
		continuar.setFont(new Font("Inknut Antiqua ExtraBold", Font.PLAIN, 16));
		continuar.setHorizontalAlignment(SwingConstants.CENTER);
		continuar.setBounds(205, 501, 391, 40);
		contentPane.add(continuar);

		// ____________________________________________________________________________________
		//validador de senha e email
		
		continuar.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) {

				if (email.getText().equals("barbercelso@gmail.com") && senha.getText().equals("barbearia123")) {
					dispose();
					PrincipalAdmin principal = new PrincipalAdmin();
					principal.setResizable(false);
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
				} else if (email.getText().equals("") && senha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preecha todos os campos", "Erro de credencial",
							JOptionPane.WARNING_MESSAGE);
				}

				else if (email.getText().equals("") || senha.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Um dos campos está vazio. Preencha-o corretamente",
							"Preencher campos", JOptionPane.WARNING_MESSAGE);
				}
					
				else {
						JOptionPane.showMessageDialog(null, "Email ou senha errados! Tente novamente", "Erro de credenciais", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// ____________________________________________________________________________________
		
		// ____________________________________________________________________________________botao
		// continuar

		JLabel conti = new JLabel("");
		conti.setBounds(211, 450, 391, 148);
		conti.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Imagens/Botao_confirma.png")));
		conti.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(conti);

		// ____________________________________________________________________________________campo
		// senha
		JLabel campoSenha = new JLabel("");
		campoSenha.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Icones/campo.png")));
		campoSenha.setHorizontalAlignment(SwingConstants.CENTER);
		campoSenha.setBounds(201, 441, 403, 47);
		contentPane.add(campoSenha);

		// ____________________________________________________________________________________campo
		// email
		JLabel campo = new JLabel("");
		campo.setHorizontalAlignment(SwingConstants.CENTER);
		campo.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Icones/campo.png")));
		campo.setBounds(201, 372, 403, 47);
		contentPane.add(campo);

		// ____________________________________________________________________________________Logo
		JLabel logotipo = new JLabel("");
		logotipo.setIcon(new ImageIcon(LoginAdmin.class.getResource("/Imagens/Logotipo.png")));
		logotipo.setHorizontalAlignment(SwingConstants.CENTER);
		logotipo.setBounds(201, 0, 403, 387);
		contentPane.add(logotipo);

		// ____________________________________________________________________________________fundo
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/Fundo.jpg")));
		contentPane.add(fundo);
		fundo.setBounds(-42, 10, 869, 588);

		// ____________________________________________________________________________________
		// funcao do botao continuar
		continuar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				continuar.setCursor(mao);
			}

		});

		// ____________________________________________________________________________________
		// validador

	}
}
