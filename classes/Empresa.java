package classes;

public class Empresa {
    public int id;
    public String nome;

    public Empresa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId( int id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
