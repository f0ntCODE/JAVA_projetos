package Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import Banco.ControladorVariáveis;
import Banco.DAO;

public class Agendar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel linha;
	public Date dataSelecionada;
	private JTextField txtEscolherHora;
	private Connection conec;
	private PreparedStatement pst;

	public String hora = "";
	public Date data = new Date();

	ControladorVariáveis control = new ControladorVariáveis();
	DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agendar frame = new Agendar();
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
	public Agendar() {
		int alt = 600;
		int larg = 800;

		Cursor mao = new Cursor(Cursor.HAND_CURSOR);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, larg, alt);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		txtEscolherHora = new JTextField();
		txtEscolherHora.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEscolherHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEscolherHora.setText("Escolha um horário");
		txtEscolherHora.setEditable(false);
		txtEscolherHora.setBounds(545, 281, 134, 20);
		contentPane.add(txtEscolherHora);
		txtEscolherHora.setColumns(10);


		// calendario

		JPanel panel = new JPanel();
		panel.setBounds(20, 132, 480, 326);
		contentPane.add(panel);

		JCalendar calendar = new JCalendar();
		data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);// data formatada
		formatador.format(data);// a data atual

		Color corBorda = new Color(67, 136, 145);// azul petróleo

		calendar.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, corBorda));// borda personalizada
		panel.add(calendar);

		calendar.getDayChooser().addPropertyChangeListener("day", evt -> {
			dataSelecionada = calendar.getDate();
		});
		
		calendar.getMonthChooser().addPropertyChangeListener("month", evt -> {

		    calendar.getDayChooser().setEnabled(true);
		});

		calendar.getDayChooser().setEnabled(false);
		
//_______________________________________________________________________________________________________horário
		JComboBox<String> combo = new JComboBox<String>();
		combo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo.setBounds(545, 301, 134, 20);
		contentPane.add(combo);
		
		combo.addItem("13:30");// itens do combobox
		combo.addItem("14:20");
		combo.addItem("15:10");
		combo.addItem("16:00");
		
		combo.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = combo.getSelectedItem();
				if (obj instanceof String) {
					hora = (String) obj;
					System.out.println(dataSelecionada);
					enviaValor();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Problema ao obter o valor de tempo. Pedimos desculpas");
				}
			}
		});
		// Usando BorderLayout para organizar os componentes
		panel.setLayout(new BorderLayout());

		// Exibir uma data específica (por exemplo, 10 de novembro de 2023)
		Calendar specificDate = Calendar.getInstance();
		specificDate.set(2023, Calendar.NOVEMBER, 10);
		Date dateToDisplay = specificDate.getTime();
		calendar.setDate(dateToDisplay);

		panel.add(calendar, BorderLayout.CENTER);

		// ____________________________________________________________________________________
		// botão finalizar

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

		// funcoes do botao finalizar
		prox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (dataSelecionada.before(data)) {
					JOptionPane.showMessageDialog(null, "Escolha uma data mais atual", "Data muito antiga",
							JOptionPane.WARNING_MESSAGE);

				} else {
					dispose();
					Resumo res = new Resumo();
					res.setLocationRelativeTo(null);
					res.setVisible(true);
				}
			}
		});

		prox.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				prox.setCursor(mao);
			}
		});

		// ___________________________________________________________________________________
		// botão voltar

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

		// ____________________________________________________________________________________
		// funcoes do botao voltar

		textoVolt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Funcionarios func = new Funcionarios();
				func.setLocationRelativeTo(null);
				func.setResizable(false);
				func.setVisible(true);
			}
		});

		textoVolt.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				textoVolt.setCursor(mao);

			}
		});

		// ____________________________________________________________________________________

		// ____________________________________________________________________________________olá
		JLabel Ola = new JLabel("Olá!");
		Ola.setHorizontalAlignment(SwingConstants.CENTER);
		Ola.setForeground(Color.WHITE);
		Ola.setFont(new Font("Tahoma", Font.PLAIN, 48));
		Ola.setBounds(10, 10, 134, 59);
		contentPane.add(Ola);

		// ____________________________________________________________________________________linha
		// abaixo do olá
		linha = new JLabel("");
		linha.setIcon(new ImageIcon(Servicos.class.getResource("/Icones/Line 4.png")));
		linha.setBounds(20, 69, 134, 14);
		contentPane.add(linha);

		// ____________________________________________________________________________________título
		JLabel agen = new JLabel("<HTML><u>Agendamento<u/><HTML>");
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

	// ______________________________________________________________________________________

	private void enviaValor() {

		int idObtido = control.getID();

		java.sql.Date sqlDate = new java.sql.Date(dataSelecionada.getTime()); // conversão de data para valor compatível com o sql

		String update = "update dados_barbearia set AGENDADO = ?, HORARIO = ? where ID = ? ";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(update);
			pst.setDate(1, sqlDate);
			pst.setString(2, hora);
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
			e.printStackTrace();
		}

	}
}
