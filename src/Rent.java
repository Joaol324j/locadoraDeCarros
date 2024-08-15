import java.time.LocalDate;
import java.time.LocalTime;

public class Rent {
    public LocalDate data;
    public double valor;
    public LocalTime hora;

    public Rent(LocalDate data, double valor, LocalTime hora) {
        this.data = data;
        this.valor = valor;
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "data=" + data +
                ", valor=" + valor +
                ", hora=" + hora +
                '}';
    }
}
