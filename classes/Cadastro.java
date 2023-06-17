package classes;

import java.time.LocalDate;

public class Cadastro {
    public String nome;    
    public String cpf;
    public LocalDate dataNascimento;
    public Sexo sexo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String bairro;
    public String cidade;
    public String estado;
    public String email;
    public long telefone;
    public long celular;
    public boolean celularWhats;
    public String profissao;
    public String empresa;
    public double salario;
    public boolean empregoAtual;
    public double pretencaoMinima;
    public double pretencaoMaxima;
    public String habilidades;

    public Cadastro(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, String logradouro, int numero, String complemento, 
        String bairro, String cidade, String estado, String email, long telefone, long celular, boolean celularWhats, 
        String profissao, String empresa, double salario, Boolean empregoAtual, double pretensaoMinima, double pretensaoMaxima,
        String habilidades) {
            
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.celularWhats = celularWhats;
        this.profissao = profissao;
        this.empresa = empresa;
        this.salario = salario;
        this.empregoAtual = empregoAtual;
        this.pretencaoMinima = pretensaoMinima;
        this.pretencaoMaxima = pretensaoMaxima;
        this.habilidades = habilidades;
    }
}




