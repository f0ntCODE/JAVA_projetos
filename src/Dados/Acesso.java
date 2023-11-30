package Dados;

public class Acesso
{
    private String digitoNome;
    private String digitoNumero;
   

    public Acesso() 
    {
        this.digitoNome=null;
        this.digitoNumero=null;
          
    }

    public Acesso(String digitoNome, String digitoNumero)
    {
        this.digitoNome = digitoNome;
        this.digitoNumero = digitoNumero;
         
    }

    public String getdigitoNome()
    {
        return digitoNome;
    }

    public void setdigitoNome(String digitoNome)
    {
        this.digitoNome = digitoNome;
    }

    public String getdigitoNumero()
    {
        return digitoNumero;
    }
    
    public void setdigitoNumero(String digitoNumero)
    {
        this.digitoNumero = digitoNumero;
    }
    
}

