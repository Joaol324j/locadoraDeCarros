package locadoraDeCarros;

import java.time.LocalDate;
import java.time.LocalTime;

public class Rent {
    private LocalDate data;
    private double valor;
    private LocalTime hora;

    public Rent(LocalDate data, double valor, LocalTime hora) {
        this.data = data;
        this.valor = valor;
        this.hora = hora;
    }

    // Getters e Setters
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    @Override
    public String toString() {
        return "Rent{" +
                "data=" + data +
                ", valor=" + valor +
                ", hora=" + hora +
                '}';
    }
}
