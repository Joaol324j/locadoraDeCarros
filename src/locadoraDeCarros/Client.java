package locadoraDeCarros;

public class Client {
    private String nome;
    private int idade;
    private int nascimento;
    private int cpf;

    public Client(String nome, int idade, int nascimento, int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public int getNascimento() { return nascimento; }
    public void setNascimento(int nascimento) { this.nascimento = nascimento; }

    public int getCpf() { return cpf; }
    public void setCpf(int cpf) { this.cpf = cpf; }

    @Override
    public String toString() {
        return "Client{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nascimento=" + nascimento +
                ", cpf=" + cpf +
                '}';
    }
}
