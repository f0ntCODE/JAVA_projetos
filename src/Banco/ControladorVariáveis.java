package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class ControladorVariáveis {
	DAO dao = new DAO();
	
	private int id;
	private PreparedStatement pst;
	private ResultSet rs = null;
	private Connection conec;

	
	
	
	public int getID() {
		
		int idAtual = -1;

		String lerId = "select max(ID) from dados_barbearia";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(lerId);
			rs = pst.executeQuery();

			if (rs.next()) {
				idAtual = rs.getInt(1);

			} else {
				System.out.println("Não encontrado");

			}
			conec.close();

		} catch (Exception e) {
			System.out.println("Problema ao obter o ID");
		}
		
		id = idAtual;
		return id;
	}
		
	public String getServico() {
	int idObtido = getID();
	String servico = "";

	String readTabela = "select * from dados_barbearia where ID = ?";
	try {
		conec = dao.conectar();
		pst = conec.prepareStatement(readTabela);
		pst.setInt(1, idObtido);
		rs = pst.executeQuery();

		if (rs.next()) {
			servico = rs.getString(4);

		} else {
			System.out.println("Erro ao ler a tabela do BD");
		}

	} catch (Exception e) {
		System.out.println(e);
	} finally {

		try {
			if (conec != null) {
				conec.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	return servico;
	

}
	
	public String getNumero() {
		int idObtido = getID();
		String numero = "";

		String readTabela = "select * from dados_barbearia where ID = ?";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(readTabela);
			pst.setInt(1, idObtido);
			rs = pst.executeQuery();

			if (rs.next()) {
				numero = rs.getString(3);

			} else {
				System.out.println("Erro ao ler a tabela do BD");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				if (conec != null) {
					conec.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

		}
		return numero;
		

	}
	
	public String getBarbeiro() {
		int idObtido = getID();
		String barbeiro = "";

		String readTabela = "select * from dados_barbearia where ID = ?";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(readTabela);
			pst.setInt(1, idObtido);
			rs = pst.executeQuery();

			if (rs.next()) {
				barbeiro = rs.getString(6);

			} else {
				System.out.println("Erro ao ler a tabela do BD");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				if (conec != null) {
					conec.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

		}
		return barbeiro;
		

	}
	
	public  int getSoma(){
		int somando = 0;
	String readTabela = "select SUM(VALOR) from dados_barbearia";
		
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(readTabela);
			//pst.setInt(1, idObtido);
			rs = pst.executeQuery();

			if (rs.next()) {
				somando = rs.getInt(1);//somando o valor das variáveis no banco
				System.out.println(somando);

			} else {
				System.out.println("Erro ao ler a tabela do BD");
			}

		} catch (Exception e) {
			System.out.println(e);
			} 
				finally {

			try {
				if (conec != null) {
					conec.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

		}
		
		return somando;
	}
	
	
	public  int getQTDLeonardo(){
		int idAtual = -1;

		String lerId = "select max(ID) from barbeiro_leonardo";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(lerId);
			rs = pst.executeQuery();

			if (rs.next()) {
				idAtual = rs.getInt(1);

			} else {
				System.out.println("Não encontrado");

			}
			conec.close();

		} catch (Exception e) {
			System.out.println("Problema ao obter o ID");
		}
		
		id = idAtual;
		
		return id;
	}
	
	
	public  int getQTDBruno(){
		int idAtual = -1;

		String lerId = "select max(ID) from barbeiro_bruno";
		try {
			conec = dao.conectar();
			pst = conec.prepareStatement(lerId);
			rs = pst.executeQuery();

			if (rs.next()) {
				idAtual = rs.getInt(1);

			} else {
				System.out.println("Não encontrado");

			}
			conec.close();

		} catch (Exception e) {
			System.out.println("Problema ao obter o ID");
		}
		
		id = idAtual;
		
		return id;
	}
	
	public String getHora() {
	int idObtido = getID();
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
		int idObtido = getID();
		Date data = new Date();
		
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
	
	

	
	/*public static void main(String[] args) {//para teste
		ControladorVariáveis contro = new ControladorVariáveis();
		contro.getData();
	}*/
}
	
	
