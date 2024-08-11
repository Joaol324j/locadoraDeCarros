package locadoraDeCarros;

public class Cars {
    private String nome;
    private String cor;
    private String placa;
    private String marca;
    private int ano;
    private int portas;
    private boolean disponivel;

    public Cars(String nome, String cor, String placa, String marca, int ano, int portas, boolean disponivel) {
        this.nome = nome;
        this.cor = cor;
        this.placa = placa;
        this.marca = marca;
        this.ano = ano;
        this.portas = portas;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getPortas() { return portas; }
    public void setPortas(int portas) { this.portas = portas; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public void alugar() {
        if (disponivel) {
            this.disponivel = false;
        } else {
            throw new IllegalStateException("Carro já está alugado");
        }
    }

    public void devolver() {
        if (!disponivel) {
            this.disponivel = true;
        } else {
            throw new IllegalStateException("Carro já está disponível");
        }
    }

    @Override
    public String toString() {
        return "Cars{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", portas=" + portas +
                ", disponivel=" + disponivel +
                '}';
    }
}
