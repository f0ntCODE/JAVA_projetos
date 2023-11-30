package Banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dados.Acesso;

public class AcessoBD
{

    Connection connection = null;

    public boolean verificaAcesso(Acesso Acesso)
    {
    	Acesso = new Acesso();
    	connection = ConexaoBD.getInstance().getConnection();
        System.out.println("Conectado e verificando acesso");
        Statement stmt = null;
        
        boolean status = true;
        
        try
        {
            stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM usuarios");
            
            while(res.next())
			{
			   if(Acesso.getdigitoNome().compareTo(res.getString("digitoNome"))==0 && Acesso.getdigitoNumero().compareTo(res.getString("digitoNumero"))==0)
			   {
				   status = true;
				   
			   }
			   else
			   {
				   status = false;
			   }
			   
			}
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            status = false;
        }
        finally
        {
          
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    	
        return status;
    }
    
}
