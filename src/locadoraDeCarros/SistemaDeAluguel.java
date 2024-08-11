package locadoraDeCarros;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SistemaDeAluguel {
    private List<Cars> carros = new ArrayList<>();
    private List<Rent> alugueis = new ArrayList<>();

    public void adicionarCarro(Cars carro) {
        carros.add(carro);
    }

    public boolean alugarCarro(Cars carro, Client cliente, LocalDate data, double valor, LocalTime hora) {
        if (carro.isDisponivel()) {
            carro.alugar(); // Marcar o carro como alugado
            Rent aluguel = new Rent(data, valor, hora);
            alugueis.add(aluguel);
            return true;
        }
        return false;
    }

    public void devolverCarro(Cars carro, LocalDate data) {
        Optional<Rent> aluguelOpt = alugueis.stream()
            .filter(aluguel -> !carro.isDisponivel() && aluguel.getData().equals(data))
            .findFirst();
        
        if (aluguelOpt.isPresent()) {
            carro.devolver(); // Marcar o carro como disponível
            alugueis.remove(aluguelOpt.get());
        } else {
            throw new IllegalArgumentException("Este carro não está alugado ou data incorreta.");
        }
    }

    public List<Cars> listarCarrosDisponiveis() {
        return carros.stream()
                     .filter(Cars::isDisponivel)
                     .collect(Collectors.toList());
    }

    public List<Cars> listarCarrosAlugados() {
        return carros.stream()
                     .filter(carro -> !carro.isDisponivel())
                     .collect(Collectors.toList());
    }
}
