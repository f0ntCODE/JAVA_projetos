package Banco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dados.Cliente;

public class ClienteBD
{

    Connection connection = null;

    public boolean inserirCliente(Cliente cliente) 
    {
    	cliente = new Cliente();
    	boolean status = true;
    	
        System.out.println("Inserir Cliente");
        
        connection = ConexaoBD.getInstance().getConnection();
        System.out.println("Conectado e pronto para inserir");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO `clientes` (nome, numero, servico, barbeiro, data, hora) "
            		+ "VALUES(" + cliente.getServico() + "," + cliente.getBarbeiro() + "," + cliente.getdigitoNome() + "," + cliente.getdigitoNumero() +
            		"," + cliente.getData() + ");"; 
            stmt.executeUpdate(sql);
            
            status = true;
            
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
                status = false;
            }
        }
        
        return status;
    } 

    public boolean atualizarAluno(Cliente cliente) 
    {
        System.out.println("Atualizar Cliente");
        connection = ConexaoBD.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE `barba` SET Nome = '" + cliente.getdigitoNome() + "' WHERE `id` = " + cliente.getBarbeiro() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
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
    } 

    
    public void relatorioCliente(Cliente cliente, DefaultTableModel modelo)      
    {
       connection = ConexaoBD.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclus�o");
       Statement stmt = null;
         
  	        
  	   try
  	   {  		    
  		   stmt = connection.createStatement();
           ResultSet res = stmt.executeQuery("SELECT * FROM clientes ORDER BY codigo");
         
  		   while(res.next())
  		   {
  			   cliente.setServico(res.getString("Servico"));
  			   cliente.setBarbeiro(res.getString("Barbeiro"));	
  			   cliente.setData(res.getString("Data"));
  			   cliente.setdigitoNome(res.getString("Nome"));
  			   cliente.setdigitoNumero(res.getString("Numero"));
			   cliente.setData(res.getString("Hora"));
			   
  			   modelo.addRow(new Object[] {cliente.getServico(), cliente.getBarbeiro(),
  					   cliente.getData(), cliente.getdigitoNome(), cliente.getData(), cliente.getdigitoNumero()});		    
	   
  		   }
  	   }
  	   catch(SQLException ex)
  	   {
  		   System.out.println("Erro SQL: " + ex.getMessage());
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
  	
    	
    }
    
    
    
    
}
