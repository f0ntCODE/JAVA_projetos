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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Banco.ControladorVariáveis;
import Banco.DAO;

public class Resumo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DAO dao = new DAO();	
	private PreparedStatement pst;
	private Connection conec;
	private ResultSet rs = null;
	
	ControladorVariáveis control = new ControladorVariáveis();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resumo frame = new Resumo();
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
	public Resumo() {
		ControladorVariáveis control = new ControladorVariáveis();
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);
		Date data = (Date) control.getData();
		DateFormat formatar = new SimpleDateFormat("dd/MM/yy");
		String formatado = formatar.format(data);
		String textoAdicional = "                           ";
		String textoCompleto = formatado + textoAdicional + control.getHora();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				getData();
				getHora();
				status();
				enviaValor();
				

			}
		});

		int alt = 600;// altura e largura da JFrame
		int larg = 800;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, larg, alt);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// ____________________________________________________________________________________

		// ____________________________________________________________________________________
		JLabel servicoEscolhido = new JLabel(control.getServico());
		servicoEscolhido.setForeground(new Color(67, 136, 145));
		servicoEscolhido.setHorizontalAlignment(SwingConstants.CENTER);
		servicoEscolhido.setFont(new Font("Inknut Antiqua", Font.PLAIN, 32));
		servicoEscolhido.setBounds(153, 147, 488, 44);
		contentPane.add(servicoEscolhido);

		JLabel profissionalEscolhido = new JLabel(control.getBarbeiro());
		profissionalEscolhido.setForeground(new Color(67, 136, 145));
		profissionalEscolhido.setHorizontalAlignment(SwingConstants.CENTER);
		profissionalEscolhido.setFont(new Font("Inknut Antiqua", Font.PLAIN, 32));
		profissionalEscolhido.setBounds(153, 268, 488, 37);
		contentPane.add(profissionalEscolhido);
		// ____________________________________________________________________________________

		JLabel dataEscolhida = new JLabel(textoCompleto);
		dataEscolhida.setForeground(new Color(67, 136, 145));
		dataEscolhida.setHorizontalAlignment(SwingConstants.CENTER);
		dataEscolhida.setFont(new Font("Inknut Antiqua", Font.PLAIN, 32));
		dataEscolhida.setBounds(153, 379, 488, 37);
		contentPane.add(dataEscolhida);

		// ____________________________________________________________________________________agendar
		JLabel DataDeAgendamento = new JLabel("<HTML><u>Agendamento:</u><HTML>");
		DataDeAgendamento.setForeground(new Color(154, 112, 14));
		DataDeAgendamento.setFont(new Font("Inknut Antiqua", Font.PLAIN, 32));
		DataDeAgendamento.setBounds(153, 341, 478, 44);
		contentPane.add(DataDeAgendamento);

		JLabel barbaCabeloIcon = new JLabel("");
		barbaCabeloIcon.setHorizontalAlignment(SwingConstants.CENTER);
		barbaCabeloIcon.setIcon(new ImageIcon(Resumo.class.getResource("/Icones/Calendario_vetor.png")));
		barbaCabeloIcon.setBounds(81, 348, 60, 68);
		contentPane.add(barbaCabeloIcon);
		// ____________________________________________________________________________________

		// ____________________________________________________________________________________servico
		JLabel Servico = new JLabel("<HTML><u>Serviço:</u><HTML>");
		Servico.setForeground(new Color(154, 112, 14));
		Servico.setBounds(153, 111, 500, 44);
		Servico.setFont(new Font("Inknut Antiqua", Font.PLAIN, 32));
		contentPane.add(Servico);

		JLabel calenda = new JLabel("");
		calenda.setIcon(new ImageIcon(Resumo.class.getResource("/Icones/barbaIcon.png")));
		calenda.setHorizontalAlignment(SwingConstants.CENTER);
		calenda.setBounds(83, 123, 60, 79);
		contentPane.add(calenda);

		// ____________________________________________________________________________________

		// ____________________________________________________________________________________
		// botao finalizar

		JLabel Finalizar = new JLabel("Finalizar");
		Finalizar.setHorizontalAlignment(SwingConstants.CENTER);
		Finalizar.setForeground(Color.WHITE);
		Finalizar.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		Finalizar.setBounds(662, 518, 90, 19);
		contentPane.add(Finalizar);

		Finalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int opcao = JOptionPane.showConfirmDialog(contentPane, "Deseja finalizar o agendamento?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(contentPane, "Agendamento realizado com sucesso!");

					dispose();
					Login log = new Login();
					log.setLocationRelativeTo(null);
					log.setResizable(false);
					log.setVisible(true);
				}

				else {
					e.consume();
				}

			}
		});

		Finalizar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Finalizar.setCursor(mao);
			}
		});
		// ____________________________________________________________________________________

		JLabel FundoBotaoFinalizar = new JLabel("");
		FundoBotaoFinalizar.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/voltar_botao.png")));
		FundoBotaoFinalizar.setBounds(662, 513, 90, 37);
		contentPane.add(FundoBotaoFinalizar);

		// ____________________________________________________________________________________

		// ____________________________________________________________________________________botao
		// voltar
		JLabel Voltar = new JLabel("Voltar");
		Voltar.setForeground(new Color(255, 255, 255));
		Voltar.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		Voltar.setHorizontalAlignment(SwingConstants.CENTER);
		Voltar.setBounds(42, 518, 90, 19);
		contentPane.add(Voltar);

		Voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dispose();
				Agendar agen = new Agendar();
				agen.setLocationRelativeTo(null);
				agen.setVisible(true);
			}
		});

		Voltar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Voltar.setCursor(mao);
			}
		});

		JLabel FundoBotaoVoltar = new JLabel("");
		FundoBotaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Agendar().setLocationRelativeTo(null);
				new Agendar().setVisible(true);
			}
		});

		FundoBotaoVoltar.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/voltar_botao.png")));
		FundoBotaoVoltar.setBounds(42, 513, 90, 37);
		contentPane.add(FundoBotaoVoltar);
		// ____________________________________________________________________________________

		// ____________________________________________________________________________________profissional

		JLabel textoCabelo = new JLabel("<HTML><u>Profissional</u><HTML>");
		textoCabelo.setForeground(new Color(154, 112, 14));
		textoCabelo.setFont(new Font("Inknut Antiqua", Font.PLAIN, 32));
		textoCabelo.setBounds(153, 237, 500, 37);
		contentPane.add(textoCabelo);

		JLabel cabeloIcon = new JLabel("");
		cabeloIcon.setIcon(new ImageIcon(Resumo.class.getResource("/Icones/Vector.png")));
		cabeloIcon.setBounds(83, 237, 70, 68);
		contentPane.add(cabeloIcon);

		JLabel campoDoAgendamento = new JLabel("");
		campoDoAgendamento.setFont(new Font("Inknut Antiqua", Font.PLAIN, 11));
		campoDoAgendamento.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/Barba_botao.png")));
		campoDoAgendamento.setHorizontalAlignment(SwingConstants.CENTER);
		campoDoAgendamento.setBounds(42, 324, 699, 130);
		contentPane.add(campoDoAgendamento);

		JLabel campoDoProfissional = new JLabel("");
		campoDoProfissional.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/Barba_botao.png")));
		campoDoProfissional.setHorizontalAlignment(SwingConstants.CENTER);
		campoDoProfissional.setBounds(42, 211, 699, 130);
		contentPane.add(campoDoProfissional);

		JLabel campoDoServico = new JLabel("");
		campoDoServico.setHorizontalAlignment(SwingConstants.CENTER);
		campoDoServico.setIcon(new ImageIcon(Servicos.class.getResource("/Imagens/Barba_botao.png")));
		campoDoServico.setBounds(42, 94, 699, 130);
		contentPane.add(campoDoServico);

		// ____________________________________________________________________________________

		// ____________________________________________________________________________________resumo

		JLabel agen = new JLabel("<HTML><u>Resumo<u/><HTML>");
		agen.setFont(new Font("Inknut Antiqua", Font.PLAIN, 48));
		agen.setHorizontalAlignment(SwingConstants.CENTER);
		agen.setForeground(new Color(255, 255, 255));
		agen.setBounds(151, 10, 480, 111);
		contentPane.add(agen);
		contentPane.setLayout(null);

		// ____________________________________________________________________________________

		// ____________________________________________________________________________________fundo

		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/Fundo.jpg")));
		contentPane.add(fundo);
		fundo.setBounds(-42, 10, 869, 588);
	}
	// ____________________________________________________________________________________

	// validador de conexão
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
	
	public String getHora() {
		int idObtido = control.getID();
		String hora = "";
		
		String readTabela = "select * from dados_barbearia where ID = ?";
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(readTabela);
				pst.setInt(1, idObtido);
				rs = pst.executeQuery();
				if (rs.next()) {
					 hora = rs.getString(8);
					
					
				} else {
					System.out.println("Erro ao ler a tabela do BD");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return hora;
		}
	
	public Date getData() {
		int idObtido = control.getID();
		Date data = null;
		
		String readTabela = "select * from dados_barbearia where ID = ?";
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(readTabela);
				pst.setInt(1, idObtido);
				rs = pst.executeQuery();
				if (rs.next()) {
					 data = rs.getDate(7);
				
					
					
				} else {
					System.out.println("Erro ao ler a tabela do BD");
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return data;
		}
	

	private void enviaValor() {

		int idObtido = control.getID();
		
		if (control.getBarbeiro() == "Leonardo") {
			String update = "update barbeiro_leonardo set DIA = ?, HORÁRIO = ? where ID = ? ";
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(update);
				pst.setDate(1, getData());
				pst.setString(2, getHora());
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

		else if (control.getBarbeiro() == "Bruno") {
			String update = "update barbeiro_bruno set DIA = ?, HORÁRIO = ? where ID = ? ";
			try {
				conec = dao.conectar();
				pst = conec.prepareStatement(update);
				pst.setDate(1, getData());
				pst.setString(2, getHora());
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

	}

}
