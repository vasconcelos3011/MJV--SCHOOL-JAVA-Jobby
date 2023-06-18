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
            new Celular(21976439034L, false)

        );

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
        System.out.println(novaString);

        cadastrar(novaString);
    }

    public static void cadastrar(StringBuilder item){
        String itemEnvio = item.toString() + System.lineSeparator();

        try{
            Path path = Paths.get("./arquivo/cadastro.csv");
                       
            Files.write(path, itemEnvio.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception exception){
            System.out.println();
        }        
    }
}