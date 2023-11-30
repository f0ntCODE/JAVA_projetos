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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Banco.ControladorVariáveis;
import Banco.DAO;

public class Funcionarios extends JFrame {

	DAO dao = new DAO();
	Servicos id = new Servicos();
	ControladorVariáveis control = new ControladorVariáveis();
	
	Login nomeCliente;
	
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String Barbeiro = "";
	
	private Connection conec;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios frame = new Funcionarios();
					frame.setResizable(false);// impede maximizar tela
					frame.setLocationRelativeTo(null); //tela permanece no centro da tela
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
	public Funcionarios() {
		
		
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ativação da janela conecta o banco
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowActivated(WindowEvent e) {
						status();
					}
				});
		
		//____________________________________________________________________________________
		//título
		JLabel prof = new JLabel("<HTML><u>Profissionais<u/><HTML>");
		prof.setFont(new Font("Inknut Antiqua", Font.PLAIN, 48));
		prof.setHorizontalAlignment(SwingConstants.CENTER);
		prof.setForeground(new Color(255, 255, 255));
		prof.setBounds(151, 10, 480, 111);
		contentPane.add(prof);
		
		//____________________________________________________________________________________
		//Texto "olá"
		JLabel Ola = new JLabel("Olá!");
		Ola.setHorizontalAlignment(SwingConstants.CENTER);
		Ola.setForeground(Color.WHITE);
		Ola.setFont(new Font("Tahoma", Font.PLAIN, 48));
		Ola.setBounds(10, 10, 134, 59);
		contentPane.add(Ola);
		
		//____________________________________________________________________________________
		//Linha abaixo do "olá"
		JLabel linha = new JLabel("");
		linha.setIcon(new ImageIcon(Servicos.class.getResource("/Icones/Line 4.png")));
		linha.setBounds(20, 69, 134, 14);
		contentPane.add(linha);
		
		//____________________________________________________________________________________
		//Botão funcinario 1
		JLabel funci = new JLabel("");
		funci.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/BotaoFunci1Modelo.png")));
		funci.setHorizontalAlignment(SwingConstants.CENTER);
		funci.setBounds(43, 132, 699, 130);
		contentPane.add(funci);
		
		//____________________________________________________________________________________
		//Botão funcionario 2
		JLabel funci2 = new JLabel("");
		funci2.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/BotaoFunci2Modelo.png")));
		funci2.setHorizontalAlignment(SwingConstants.CENTER);
		funci2.setBounds(43, 274, 699, 130);
		contentPane.add(funci2);
		
		//____________________________________________________________________________________
		//funcoes dos botões de escolha
		
		funci.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				funci.setCursor(mao);
			}
			
		});
		
		funci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Barbeiro = "Leonardo";
				funci2.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/BotaoFunci2Modelo.png")));
				funci.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/BotaoFunci1ModeloPressionado.png")));
				
			}
		});
		
		funci2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				funci2.setCursor(mao);
			}
		});
		funci2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Barbeiro = "Bruno";
				funci2.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/BotaoFunci2Pressionado.png")));
				funci.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/BotaoFunci1Modelo.png")));
			}
		});
		
		
		//____________________________________________________________________________________
		//Botão voltar
		JLabel volt = new JLabel("Voltar");
		volt.setForeground(new Color(255, 255, 255));
		volt.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		volt.setHorizontalAlignment(SwingConstants.CENTER);
		volt.setBounds(42, 518, 90, 19);
		contentPane.add(volt);
		
		JLabel botaoVolt = new JLabel("");
		botaoVolt.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/voltar_botao.png")));
		botaoVolt.setBounds(42, 513, 90, 37);
		contentPane.add(botaoVolt);
		

		
		//____________________________________________________________________________________
		//botão próximo
		JLabel prox = new JLabel("Próximo");
		prox.setHorizontalAlignment(SwingConstants.CENTER);
		prox.setForeground(Color.WHITE);
		prox.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		prox.setBounds(662, 518, 90, 19);
		contentPane.add(prox);
		
		JLabel botaoProx = new JLabel("");
		botaoProx.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/voltar_botao.png")));
		botaoProx.setBounds(662, 513, 90, 37);
		contentPane.add(botaoProx);
		
		//____________________________________________________________________________________
		//funcoes dos botões voltar/proximo
		
		volt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dispose();
				Servicos serv = new Servicos();
				serv.setResizable(false);
				serv.setLocationRelativeTo(null);
				serv.setVisible(true);
			}
		});
		
		volt.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				volt.setCursor(mao);
			}
		});
		
		prox.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(Barbeiro == "") {
					JOptionPane.showMessageDialog(contentPane, "Escolha uma opção", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
				buscaDados();
				enviaProfissional();
				dispose();
				Agendar agen = new Agendar();
				agen.setResizable(false);
				agen.setLocationRelativeTo(null);
				agen.setVisible(true);
				}
			}
		});
		
		prox.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				prox.setCursor(mao);
			}
		});
		
		
		//____________________________________________________________________________________
		JLabel fundo= new JLabel("");
		fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/Fundo.jpg")));
		contentPane.add(fundo);
		fundo.setBounds(-42, 10, 869, 588);
	
	}
	private void status() {
		try {
			conec = dao.conectar();
			if (conec == null) {
				System.out.println("Erro de conexão");

			} else {
				System.out.println("Banco conectado com sucesso");
			}
			conec.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void buscaDados() {
		int idObtido = control.getID();
		String cliente = "";
		String servico = "";
		Date dia = null;
		
		String readTabela = "select * from dados_barbearia where ID = ?";
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(readTabela);
				pst.setInt(1, idObtido);
				rs = pst.executeQuery();
				if (rs.next()) {
					cliente = rs.getString(2);
					servico = rs.getString(4);
					dia = rs.getDate(7);
					
				} else {
					System.out.println("Erro ao ler a tabela do BD");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		
		if (Barbeiro.isEmpty()) {
			System.out.println("Nada escolhido");
			
		} 
		else if(Barbeiro == "Leonardo"){
			String insert = "insert into barbeiro_leonardo (CLIENTE, TELEFONE, SERVICO, DIA, HORÁRIO) values (?, ?, ?, ?, ?)";	
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(insert);
				pst.setString(1, cliente);
				pst.setString(2, control.getNumero());
				pst.setString(3, servico);
				pst.setDate(4, dia);
				pst.setString(5, control.getHora());
				 				
				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					System.out.println("Sucesso ao enviar dado");

				} else {

					System.out.println("Falha ao enviar dado");
				}
				conec.close();

			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		else if(Barbeiro == "Bruno") {
			String insert = "insert into barbeiro_bruno (CLIENTE, TELEFONE, SERVICO, DIA, HORÁRIO) values (?, ?, ?, ?, ?)";	
			
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(insert);
				pst.setString(1, cliente);
				pst.setString(2, control.getNumero());
				pst.setString(3, servico);
				pst.setDate(4, dia);
				pst.setString(5, control.getHora());
				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					
					System.out.println("Sucesso ao enviar dado" );

				} else {

					System.out.println("Falha ao enviar dado");
				}
				conec.close();

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
		}
		
	}
	
private void enviaProfissional() {
		
		int idObtido = control.getID();
		
		String update = "update dados_barbearia set BARBEIRO = ? where ID = ? ";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(update);
			pst.setString(1, Barbeiro);
			pst.setInt(2, idObtido);
			int confirma = pst.executeUpdate();

			if (confirma == 1) {
				System.out.println("Sucesso ao enviar dado");

			} else {

				System.out.println("Falha ao enviar dado");
			}
			conec.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}	
}
