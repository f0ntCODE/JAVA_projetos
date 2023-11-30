 package Telas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseMotionAdapter;

public class PrincipalAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdmin frame = new PrincipalAdmin();
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
	public PrincipalAdmin() {
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
			
			// ____________________________________________________________________________________
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja Realizar o Logout?", "Logout", JOptionPane.YES_NO_OPTION);
				if(opcao == JOptionPane.YES_OPTION) {
					dispose();
				LoginAdmin adminLog = new LoginAdmin();
				adminLog.setLocationRelativeTo(null);
				adminLog.setResizable(false);
				adminLog.setVisible(true);
				}
				
				else if(opcao == JOptionPane.NO_OPTION) {
					e.consume();
				}
				
				
			}
		});
		// ____________________________________________________________________________________
		
		JLabel relatório = new JLabel("Relatório");
		relatório.setForeground(new Color(255, 255, 255));
		relatório.setHorizontalAlignment(SwingConstants.CENTER);
		relatório.setFont(new Font("Inknut Antiqua", Font.BOLD, 20));
		relatório.setBounds(497, 334, 189, 110);
		contentPane.add(relatório);
		
		// ____________________________________________________________________________________
		
		relatório.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Relat relatorio = new Relat();
				relatorio.setLocationRelativeTo(null);
				relatorio.setResizable(false);
				relatorio.setVisible(true);
			}
		});
		
		relatório.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				relatório.setCursor(mao);
			}
		});
		// ____________________________________________________________________________________
		JLabel textFunci = new JLabel("");
		textFunci.setForeground(new Color(255, 255, 255));
		//textFunci.setLineWrap(true);
		textFunci.setText("<HTML>Gerenciar <br> Funcionários<HTML>");
		textFunci.setFont(new Font("Inknut Antiqua", Font.BOLD, 20));
		textFunci.setHorizontalAlignment(SwingConstants.CENTER);
		textFunci.setBounds(91, 334, 233, 110);
		contentPane.add(textFunci);
		
		textFunci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaFuncio funcionario= new TelaFuncio();//aparecer tela de funcionario centralizada
				funcionario.setLocationRelativeTo(null);
				funcionario.setResizable(false);
				funcionario.setVisible(true);
			}
		});
		
		textFunci.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				textFunci.setCursor(mao);
			}
		});
		// ____________________________________________________________________________________
		
		JLabel bemvindo = new JLabel("<HTML><u>Bem vindo, Celso</u><HTML>");
		bemvindo.setForeground(new Color(255, 255, 255));
		bemvindo.setFont(new Font("Inknut Antiqua", Font.PLAIN, 30));
		bemvindo.setHorizontalAlignment(SwingConstants.CENTER);
		bemvindo.setBounds(91, 230, 619, 40);
		contentPane.add(bemvindo);
		// ____________________________________________________________________________________
		
		JLabel funcioBot_1 = new JLabel("");
		funcioBot_1.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/Imagens/Rectangle 8.png")));
		funcioBot_1.setHorizontalAlignment(SwingConstants.CENTER);
		funcioBot_1.setBounds(477, 334, 233, 110);
		contentPane.add(funcioBot_1);
		// ____________________________________________________________________________________
		
		JLabel funcioBot = new JLabel("");
		funcioBot.setFont(new Font("Inknut Antiqua Black", Font.PLAIN, 11));
		textFunci.setLabelFor(funcioBot);
		funcioBot.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/Imagens/Rectangle 8.png")));
		funcioBot.setHorizontalAlignment(SwingConstants.CENTER);
		funcioBot.setBounds(91, 334, 233, 110);
		contentPane.add(funcioBot);
		
		JLabel sino = new JLabel("\r\n");
		sino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(sino, "Recurso disponível em breve...");
			}
		});
		sino.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/Icones/sino.png")));
		sino.setHorizontalAlignment(SwingConstants.CENTER);
		sino.setBounds(20, 43, 46, 40);
		contentPane.add(sino);
		voltar.setForeground(new Color(255, 255, 255));
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setBounds(660, 43, 112, 40);
		voltar.setText("<HTML><u>Logout</u><HTML>");
		voltar.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		contentPane.add(voltar);
		
		//____________________________________________________________________________________Logo
		JLabel logotipo = new JLabel("");
		logotipo.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/Icones/foto admin.png")));
		logotipo.setHorizontalAlignment(SwingConstants.CENTER);
		logotipo.setBounds(200, -50, 403, 387);
		contentPane.add(logotipo);
		
		
		//____________________________________________________________________________________fundo
		JLabel fundo= new JLabel("");
		fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/Fundo.jpg")));
		contentPane.add(fundo);
		fundo.setBounds(-42, 10, 869, 588);
		
		//____________________________________________________________________________________
	}
}
