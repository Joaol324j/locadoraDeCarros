public class Cars {

    public String nome;
    public String cor;
    public String placa;
    public String marca;
    public int ano;
    public int portas;
    public boolean disponivel;
    public Rent rent;

    public Cars(String nome, String cor, String placa, String marca, int ano, int portas, boolean disponivel) {
        this.nome = nome;
        this.cor = cor;
        this.placa = placa;
        this.marca = marca;
        this.ano = ano;
        this.portas = portas;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", portas=" + portas +
                ", disponivel=" + (disponivel ? "Sim" : "Não") +
                '}';
    }
}
