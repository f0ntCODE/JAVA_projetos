package Dados;

public class Cliente
{
    private String Servico;
    private String Barbeiro;
    private String Data;
    private String digitoNome;
    private String digitoNumero;
   
    
    
    public Cliente()
    {
        
    }
    public String getdigitoNome() {
		return digitoNome;
	}


	public void setdigitoNome(String digitoNome) {
		this.digitoNome = digitoNome;
	}
    
	public String getdigitoNumero() {
		return digitoNumero;
	}


	public void setdigitoNumero (String digitoNumero) {
		this.digitoNumero = digitoNumero;
	}
	
    public String getServico() {
		return Servico;
	}


	public void setServico(String Servico) {
		this.Servico = Servico;
	}


	public String getBarbeiro() {
		return Barbeiro;
	}


	public void setBarbeiro(String Barbeiro) {
		this.Barbeiro = Barbeiro;
	}


	public String getData() {
		return Data;
	}


	public void setData(String Data) {
		this.Data = Data;
	}

	
}
