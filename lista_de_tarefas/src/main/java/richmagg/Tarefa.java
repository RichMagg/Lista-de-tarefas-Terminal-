package richmagg;

public class Tarefa {
    private String nome;
    private boolean concluido;

    public Tarefa(String nome) {
        this.nome = nome;
        this.concluido = false;
    }

    public Tarefa(String nome, boolean concluido) {
        this.nome = nome;
        this.concluido = concluido;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean getConcluido() {
        return this.concluido;
    }

    public void setConcluido(boolean valor) {
        this.concluido = valor;
    }

    public String getConcluidoAsString() {
        return (this.concluido) ? "Concluído" : "Pendente";
    }
}