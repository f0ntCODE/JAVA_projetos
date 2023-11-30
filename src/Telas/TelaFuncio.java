package Telas;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Banco.DAO;

public class TelaFuncio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private Connection conec;
	private PreparedStatement pst;
	private ResultSet rs = null;

	DAO dao = new DAO();
	private JTable tbLeo;
	private JTable tbBruno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncio frame = new TelaFuncio();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public TelaFuncio() {
		Cursor mao = new Cursor(Cursor.HAND_CURSOR);

		int larg = 800;
		int alt = 600;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, larg, alt);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);

		painel.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				carregarTabela();
			}
		});
		// ____________________________________________________________________________________painel
		JTabbedPane painelSelecao = new JTabbedPane(JTabbedPane.TOP);
		painelSelecao.setBounds(10, 77, 764, 456);
		painel.add(painelSelecao);

		JPanel funcio = new JPanel();
		painelSelecao.addTab("      Funcio1", null, funcio, null);
		funcio.setLayout(null);

		JLabel icone = new JLabel("");
		icone.setBounds(10, 10, 84, 83);
		icone.setIcon(new ImageIcon(TelaFuncio.class.getResource("/Icones/ícone_telaTabbed.png")));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		funcio.add(icone);

		JLabel nome_funci1 = new JLabel("<HTML><u>LEONARDO FONTANIVE TONET</u><HTML>");
		nome_funci1.setBounds(100, 10, 649, 79);
		nome_funci1.setForeground(new Color(150, 93, 41));
		nome_funci1.setFont(new Font("Inknut Antiqua", Font.BOLD, 30));
		funcio.add(nome_funci1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(20, 104, 729, 300);
		funcio.add(scrollPane);

		tbLeo = new JTable();
		scrollPane.setViewportView(tbLeo);
		tbLeo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NOME", "TELEFONE", "SERVICO", "DATA", "HOR\u00C1RIO" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Object.class, String.class, String.class, Object.class, String.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		tbLeo.setAlignmentX(Component.LEFT_ALIGNMENT);
		tbLeo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tbLeo.setCellSelectionEnabled(true);
		tbLeo.setColumnSelectionAllowed(true);
		tbLeo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JPanel funcio_2 = new JPanel();
		painelSelecao.addTab("      Funcio2      ", null, funcio_2, null);
		funcio_2.setLayout(null);

		JLabel icone_1 = new JLabel("");
		icone_1.setBounds(10, 10, 84, 83);
		icone_1.setIcon(new ImageIcon(TelaFuncio.class.getResource("/Icones/ícone_telaTabbed.png")));
		icone_1.setHorizontalAlignment(SwingConstants.CENTER);
		funcio_2.add(icone_1);

		JLabel nome_funci1_1 = new JLabel("<HTML><u>BRUNO LIMA DOS SANTOS </u><HTML>");
		nome_funci1_1.setBounds(100, 10, 649, 79);
		nome_funci1_1.setForeground(new Color(150, 93, 41));
		nome_funci1_1.setFont(new Font("Inknut Antiqua", Font.BOLD, 30));
		funcio_2.add(nome_funci1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(20, 104, 729, 300);
		funcio_2.add(scrollPane_1);

		tbBruno = new JTable();
		tbBruno.setColumnSelectionAllowed(true);
		tbBruno.setCellSelectionEnabled(true);
		tbBruno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tbBruno.setAlignmentX(0.0f);
		scrollPane_1.setViewportView(tbBruno);
		tbBruno.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NOME", "TELEFONE", "SERVICO", "DATA", "HOR\u00C1RIO" }));

		JLabel voltar = new JLabel("Voltar");
		voltar.setForeground(new Color(255, 255, 255));
		voltar.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setBounds(10, 27, 106, 39);
		painel.add(voltar);

		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				PrincipalAdmin adm = new PrincipalAdmin();
				adm.setResizable(false);
				adm.setLocationRelativeTo(null);
				adm.setVisible(true);
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
		voltBot.setBounds(10, 35, 118, 31);
		painel.add(voltBot);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Inknut Antiqua", Font.PLAIN, 16));
		lblExcluir.setBounds(656, 27, 106, 39);
		painel.add(lblExcluir);
		
		JLabel voltBot_1 = new JLabel("");
		voltBot_1.setIcon(new ImageIcon(TelaFuncio.class.getResource("/Icones/excluir.png")));
		voltBot_1.setHorizontalAlignment(SwingConstants.CENTER);
		voltBot_1.setBounds(656, 35, 118, 31);
		painel.add(voltBot_1);
		
				// ____________________________________________________________________________________fundo
				JLabel fundo = new JLabel("");
				fundo.setBounds(-37, 0, 869, 603);
				fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/Fundo.jpg")));
				painel.add(fundo);

		// ____________________________________________________________________________________
				lblExcluir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						excluir();
					}
				});
	}

	private void status() {
		try {
			conec = dao.conectar();
			if (conec == null) {
				JOptionPane.showMessageDialog(null, "Erro de conexão", "Erro de conexão", JOptionPane.ERROR);

			} else {
				System.out.println("Banco conectado com sucesso");
			}
			conec.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void carregarTabela() {
		DefaultTableModel modelo = (DefaultTableModel) tbLeo.getModel();
		modelo.setNumRows(0);
		tbLeo.getColumnModel().getColumn(0).setPreferredWidth(5);
		tbLeo.getColumnModel().getColumn(1).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(2).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(3).setPreferredWidth(80);
		tbLeo.getColumnModel().getColumn(4).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(5).setPreferredWidth(20);

		try {
			conec = dao.conectar();

			pst = conec.prepareStatement("select * from barbeiro_leonardo");
			rs = pst.executeQuery();

			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)

				});

			}

			conec.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + e, "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		DefaultTableModel modeloB = (DefaultTableModel) tbBruno.getModel();
		modeloB.setNumRows(0);
		tbLeo.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(1).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(2).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(3).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(4).setPreferredWidth(20);
		tbLeo.getColumnModel().getColumn(5).setPreferredWidth(20);

		try {
			conec = dao.conectar();

			pst = conec.prepareStatement("select * from barbeiro_bruno");
			rs = pst.executeQuery();

			while (rs.next()) {
				modeloB.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6)

				});

			}

			conec.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + e, "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	//talvez uma implementação futura: excluir à partir da tabela. Eis o código
	
		private void excluir() {
			 String SelecionarID = JOptionPane.showInputDialog("Digite o respectivo ID");
			 	if(SelecionarID == null || SelecionarID.isEmpty()) {
			 		JOptionPane.showMessageDialog(null, "Nada digitado no campo","Digite o ID", JOptionPane.WARNING_MESSAGE);
			 	}
			 	
			 	else {
			 		
			 			if(ehNumerico(SelecionarID)) {
			 				int valorNumero = Integer.parseInt(SelecionarID);
			 				int confirmarExcluir = JOptionPane.showConfirmDialog(painel, "Deseja realmente excluir este cliente?", "Exclusão", JOptionPane.YES_NO_OPTION);
			 					if(confirmarExcluir == JOptionPane.YES_OPTION) {
			 						String delete = "delete from barbeiro_leonardo where ID = ?";
			 						try {
			 							conec = dao.conectar();
			 							pst = conec.prepareStatement(delete);
			 							pst.setString(1, SelecionarID);
			 							int confirma = pst.executeUpdate();
			 						
			 							if (confirma == 1) {
			 								System.out.println("Sucesso ao excluir dado");
			 								JOptionPane.showMessageDialog(null, "Exclusão concedida");
			 							} else {

			 								System.out.println("Falha ao excluir dado");
			 								JOptionPane.showMessageDialog(null, "Falha na exclusão", "Erro" ,JOptionPane.ERROR_MESSAGE);
			 							}
			 							conec.close();
			 							
			 							
			 						} catch (Exception e) {
			 				System.out.println(e);		
			 				}
			 					}
			 					}
			 			else {
			 				JOptionPane.showMessageDialog(null, "O ID é um valor numérico");
			 			}
			 			}
			 			
				 
		 }

		private static boolean ehNumerico(String str) {
			return str.matches("\\d+");
		}
	
}
