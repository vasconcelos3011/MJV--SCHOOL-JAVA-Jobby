import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;

import classes.*;

public class SistemaCadastro {
    public static void main (String[] args) {
        Cadastro cadastro = new Cadastro(
            "Alberto Siqueira",
            "002.453.891-85",
            LocalDate.parse("1971-03-31"),
            "Albertos71@email.com",
            2127722514L,
            new ArrayList<String>(){
                {
                    add(new String("Java"));
                    add(new String("c#"));
                    add(new String ("Python"));
                    add(new String("JavaScript"));
                    add(new String("Angular"));
                    add(new String("React"));
                    add(new String("WordPress"));                
                }
            },
            new ArrayList<Profissao>(){
                {
                    add(new Profissao(0,"Desenvolvedor Full Stack"));
                    add(new Profissao(1,"Administrador do Banco de Dados"));
                }
            },
            new PretencaoSalarial(10500.75, 20000.00),
            Sexo.Masculino,
            new Celular(21998754510L, true),
            new Celular(21976439034L, false),
            new Endereco(2505525L, "Rua do Bispo", "71", "Casa", "Rio Comprido", new Cidade(0, "Rio de Janeiro", "Rio de Janeiro", "RJ")),
            new CadastroExperiencia(0, 8300.25, true, LocalDate.parse("2019-07-01"), null, RegimeContratacao.CLT, new Empresa(0, "MJV"))
        );

        cadastro.getCadastroExperiencia().setProfissao(cadastro.getProfissao());

        gerarItem(cadastro);
    }

    public static void gerarItem(Cadastro item){
        StringBuilder novaString = new StringBuilder();

        novaString.append(item.getNome() + ";");
        novaString.append(item.getCpf() + ";");
        novaString.append(item.getDataNascimento() + ";");
        novaString.append(item.getEmail() + ";");
        novaString.append(item.getTelefone() + ";");
        for (int i = 0; i < item.getHabilidades().size(); i++){
            novaString.append(item.getHabilidades().get(i) + ",");
        }
        novaString.append(";");
        for (int i = 0; i < item.getProfissao().size(); i++){
            novaString.append(item.getProfissao().get(i).getNome() + ",");
        }  
        novaString.append(";");
        novaString.append(item.getPretencaoSalarial().getPretencaoMinima() + ";");
        novaString.append(item.getPretencaoSalarial().getPretencaoMaxima() + ";");
        novaString.append(item.getSexo() + ";");
        novaString.append(item.getCelularPessoal().getNumero() + ";");
        novaString.append(item.getCelularPessoal().getCelularWhats() + ";");
        novaString.append(item.getCelularProfissional().getNumero() + ";");
        novaString.append(item.getCelularProfissional().getCelularWhats() + ";");
        novaString.append(item.getEndereco().getLogradouro() + ";");
        novaString.append(item.getEndereco().getNumero() + ";");
        novaString.append(item.getEndereco().getBairro() + ";");
        novaString.append(item.getEndereco().getComplemento() + ";");
        novaString.append(item.getEndereco().getCidade().getNome() + ";");
        novaString.append(item.getEndereco().getCidade().getEstado() + ";");
        novaString.append(item.getCadastroExperiencia().getEmpresa().getNome() + ";");
        novaString.append(item.getCadastroExperiencia().getSalario() + ";");
        novaString.append(item.getCadastroExperiencia().getEmpregoAtual() + ";");


        System.out.println(novaString);

        cadastrar(novaString);
    }

    public static void cadastrar(StringBuilder item){
        String itemEnvio = item.toString() + System.lineSeparator();

        try{
            Path path = Paths.get("./arquivo/cadastro.csv");
            byte[] bytesArquivo =  Files.readAllBytes(path);
            String conteudo = new String(bytesArquivo);

            if(conteudo.length() == 0){
                StringBuilder cabecalho = new StringBuilder();
                
                cabecalho.append("Nome" + ";");
                cabecalho.append("Cpf" + ";");
                cabecalho.append("Data de Nascimento" + ";");
                cabecalho.append("Email" + ";");
                cabecalho.append("Telefone" + ";");
                cabecalho.append("Habilidades" + ";");
                cabecalho.append("Profissão" + ";");
                cabecalho.append("Pretenção Mínima" + ";");
                cabecalho.append("Pretenção Máxima" + ";");
                cabecalho.append("Sexo" + ";");
                cabecalho.append("Celular Pessoal" + ";");
                cabecalho.append("Celular Pessoal Whats?" + ";");
                cabecalho.append("Celular Profissional" + ";");
                cabecalho.append("Celular Profissional Whats?" + ";");
                cabecalho.append("Logradouro" + ";");
                cabecalho.append("Número" + ";");
                cabecalho.append("Bairro" + ";");
                cabecalho.append("Complemento" + ";");
                cabecalho.append("Cidade" + ";");
                cabecalho.append("Estado" + ";");
                cabecalho.append("Empresa" + ";");
                cabecalho.append("Salário" + ";");
                cabecalho.append("Emprego Atual?" + ";");
            
                String cabecalhoEnvio = cabecalho.toString() + System.lineSeparator();
                Files.write(path, cabecalhoEnvio.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
                    
            Files.write(path, itemEnvio.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception exception){
            System.out.println(exception);
        }        
    }
}