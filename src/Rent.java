import java.time.LocalDate;
import java.time.LocalTime;

public class Rent {
    public double valor;
    public LocalDate data;
    public LocalTime hora;

    public Rent(double valor, LocalDate data, LocalTime hora) {
        this.valor = valor;
        this.data = data;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "valor=" + valor +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}
