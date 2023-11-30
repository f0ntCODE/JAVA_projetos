package Banco;

import java.sql.Connection;
import java.sql.DriverManager;

//método que conecta o BD
public class DAO {
	//variáveis de conexão
	private Connection conec;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/barba";
	private String usuario = "root";
	private String senha = "";
	
	public Connection conectar() {
		try {
			Class.forName(driver);
			conec = DriverManager.getConnection(url, usuario, senha);
			return conec;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}
