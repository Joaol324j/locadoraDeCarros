package locadoraDeCarros;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        SistemaDeAluguel sistema = new SistemaDeAluguel();

        Cars carro1 = new Cars("Fusca", "azul", "ABC-1234", "Volkswagen", 1970, 2, true);
        Cars carro2 = new Cars("Civic", "preto", "XYZ-5678", "Honda", 2022, 4, true);
        Cars carro3 = new Cars("Palio", "Prata", "WZA-8321", "Chevrolet", 2009, 4, true);
        Cars carro4 = new Cars("BMW", "Preto", "WXA-6721", "BMW", 2024, 4, true);
        Cars carro5 = new Cars("Gol", "Prata", "BRA-5500", "Volkswagen", 2014, 4, true);
        sistema.adicionarCarro(carro1);
        sistema.adicionarCarro(carro2);
        sistema.adicionarCarro(carro3);
        sistema.adicionarCarro(carro4);
        sistema.adicionarCarro(carro5);
        Client cliente1 = new Client("João Lucas", 19, 2005, 123456789);
        Client cliente2 = new Client("Ivan Magalhães", 19, 2005, 987654321);
        Client cliente3 = new Client("Gabrielzin", 19, 2005, 187454827);
        Client cliente4 = new Client("Kaike do Vale", 19, 2005, 256454825);
        Client cliente5 = new Client("Wesnei Paiva", 19, 2004, 656452841);
        

        try {
            if (sistema.alugarCarro(carro1, cliente1, LocalDate.now(), 100.0, LocalTime.now())) {
                System.out.println("Carro alugado com sucesso!");
            } else {
                System.out.println("Falha ao alugar o carro.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Carros disponíveis: " + sistema.listarCarrosDisponiveis());
        System.out.println("Carros alugados: " + sistema.listarCarrosAlugados());

        try {
            sistema.devolverCarro(carro1, LocalDate.now());
            System.out.println("Carro devolvido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Carros disponíveis após devolução: " + sistema.listarCarrosDisponiveis());
        System.out.println("Carros alugados após devolução: " + sistema.listarCarrosAlugados());
    }
}
