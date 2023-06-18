package classes;

public class Endereco {
    public long cep;
    public String logradouro;
    public String numero;
    public String complemento;
    public String bairro;

    public Endereco(long cep, String logradouro, String numero, String complemento, String bairro){
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public long getCep(){
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getLogradouro(){
        return logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero( String numero){
        this.numero = numero;
    }

    public String getComplemento(){
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro(){
        return bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }
}
