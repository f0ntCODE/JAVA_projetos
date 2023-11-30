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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Banco.DAO;

public class Servicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos frame = new Servicos();
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
	DAO dao = new DAO();
	Login log = new Login();
	
	private Connection conec;
	private PreparedStatement pst;
	private int preco = 0;
	public String serv = "";
	private ResultSet rs = null;
	
	
	
	public Servicos() {
		
		// ativação da janela conecta o banco
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});


		
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ____________________________________________________________________esta é a
		// linha abaixo do "olá"

		JLabel linha = new JLabel("");
		linha.setIcon(new ImageIcon(Servicos.class.getResource("/Icones/Line 4.png")));
		linha.setBounds(20, 69, 134, 14);
		contentPane.add(linha);

		// ____________________________________________________________________este é o
		// "olá"
		JLabel Ola = new JLabel("Olá!");
		Ola.setHorizontalAlignment(SwingConstants.CENTER);
		Ola.setForeground(Color.WHITE);
		Ola.setFont(new Font("Tahoma", Font.PLAIN, 48));
		Ola.setBounds(10, 10, 134, 59);
		contentPane.add(Ola);

		// ____________________________________________________________________este é o
		// título

		JLabel Servicos = new JLabel("<HTML><u>Serviços</u><HTML>");
		Servicos.setFont(new Font("Inknut Antiqua", Font.PLAIN, 48));
		Servicos.setHorizontalAlignment(SwingConstants.CENTER);
		Servicos.setForeground(new Color(255, 255, 255));
		Servicos.setBounds(151, 10, 480, 111);
		contentPane.add(Servicos);

		// ____________________________________________________________________botão
		// barba

		JLabel barba = new JLabel("");
		barba.setHorizontalAlignment(SwingConstants.CENTER);
		barba.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaBotaoModelo.png")));
		barba.setBounds(42, 94, 699, 130);
		contentPane.add(barba);

		// ____________________________________________________________________botão
		// cabelo

		JLabel cabelo = new JLabel("");
		cabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/cabeloBotaoModelo.png")));
		cabelo.setHorizontalAlignment(SwingConstants.CENTER);
		cabelo.setBounds(42, 211, 699, 130);
		contentPane.add(cabelo);
		// ____________________________________________________________________botão
		// barba+cabelo

		JLabel barbaCabelo = new JLabel("");
		barbaCabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaCabeloBotaoModelo.png")));
		barbaCabelo.setHorizontalAlignment(SwingConstants.CENTER);
		barbaCabelo.setBounds(42, 324, 699, 130);
		contentPane.add(barbaCabelo);

		// _______________________________________________________________________Lista
		// de funções dos botões

		// cursor mão
		barba.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				barba.setCursor(mao);
			}
		});

		// efeito de toque
		barba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preco = 15;
				serv = "Corte de Barba";
				barbaCabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaCabeloBotaoModelo.png")));
				cabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/cabeloBotaoModelo.png")));
				barba.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaBotaoPressionado.png")));
				
			}
		});

		// cursor mao
		cabelo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				cabelo.setCursor(mao);
			}
		});
		// _______________________________________________________________________
		// efeito de toque
		cabelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preco = 22;
				serv = "Corte de Cabelo";
				barba.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaBotaoModelo.png")));
				barbaCabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaCabeloBotaoModelo.png")));
				cabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/cabeloBotaoPressionado.png")));
			}
		});

		// efeito mão
		barbaCabelo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				barbaCabelo.setCursor(mao);
			}
		});

		// efeito de toque

		barbaCabelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preco= 35;
				serv = "Corte de Barba e cabelo";
				barba.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaBotaoModelo.png")));
				cabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/cabeloBotaoModelo.png")));
				barbaCabelo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/barbaCabeloBotaoPressionado.png")));
			}
		});

		// _______________________________________________________________________botao
		// proximo

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

		// _______________________________________________________________________funções
		// botão proximo
		// cursor mao

		prox.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				prox.setCursor(mao);
			}
		});

		// alterar tela
		prox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (preco == 0) {
					JOptionPane.showMessageDialog(contentPane, "Escolha uma opção", "", JOptionPane.WARNING_MESSAGE);
				} else {
					enviaValor();
					dispose();
					Funcionarios funci = new Funcionarios();
					funci.setResizable(false);
					funci.setLocationRelativeTo(null);
					funci.setVisible(true);
				}
			}
		});
		// _______________________________________________________________________botão
		// voltar

		JLabel textoVolt = new JLabel("Voltar");
		textoVolt.setForeground(new Color(255, 255, 255));
		textoVolt.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		textoVolt.setHorizontalAlignment(SwingConstants.CENTER);
		textoVolt.setBounds(42, 518, 90, 19);
		contentPane.add(textoVolt);

		JLabel botaoVolt = new JLabel("");
		botaoVolt.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/voltar_botao.png")));
		botaoVolt.setBounds(42, 513, 90, 37);
		contentPane.add(botaoVolt);
		// _______________________________________________________________________funções
		// botao voltar
		// cursor mão
		textoVolt.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				textoVolt.setCursor(mao);
			}
		});

		// voltar tela
		textoVolt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log = new Login();
				log.setLocationRelativeTo(null);
				log.setResizable(false);
				log.setVisible(true);

			}
		});
		// ____________________________________________________________________painel de
		// fundo

		JLabel fundo = new JLabel("");
		fundo.setBounds(-67, 10, 919, 588);
		fundo.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/Fundo.jpg")));
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(fundo);
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
	
	public int obterID() {
		 int idAtual = -1;
		
		String lerId = "select max(ID) from dados_barbearia";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(lerId);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				idAtual = rs.getInt(1);
				System.out.println(rs.getInt(1));
				
			} else {
				System.out.println("Não encontrado");

			}
			conec.close();
			
		} catch (Exception e) {
			System.out.println("Problema ao obter o ID");
		}
		return idAtual;
	}

	private void enviaValor() {
		
		int idObtido = obterID();
		String update = "update dados_barbearia set SERVICO = ?, VALOR = ? where ID = ? ";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(update);
			pst.setString(1, serv);
			pst.setInt(2, preco);
			pst.setInt(3, idObtido);
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
	
	public String setEnviaServico() {
		
		return serv;
	}
	
}

//"update dados_barbearia set SERVICO = ?, VALOR = ? where NUMERO = ? ";
