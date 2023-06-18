package classes;

import java.time.LocalDate;

public class CadastroExperiencia {
    public int id;
    public double salario;
    public boolean empregoAtual;
    public LocalDate dataContratacao;
    public LocalDate dataDesligamento;

    public CadastroExperiencia(int id, double salario, boolean empregoAtual, LocalDate dataContratacao, LocalDate dataDesligamento) {
        this.id = id;
        this.salario = salario;
        this.empregoAtual = empregoAtual;
        this.dataContratacao = dataContratacao;
        this.dataDesligamento = dataDesligamento;
    }

    public int getId() {
        return id;
    }
     
    public void setId( int id){
        this.id = id;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario( double salario){
        this.salario = salario;
    }

    public boolean getEmpregoAtual() {
        return empregoAtual;
    }

    public void setEmpregoAtual( boolean empregoAtual) {
         this.empregoAtual = empregoAtual;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao( LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento( LocalDate dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }
    
}
