public class Client {

    public String nome;
    public int idade;
    public int nascimento;
    public String cpf;

    public Client(String nome, int idade, int nascimento, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getNascimento() {
        return nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nascimento=" + nascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}

