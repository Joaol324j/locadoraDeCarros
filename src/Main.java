import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main extends JFrame {
    private JPanel SytemPanel;
    private JButton adicionarCarroButton;
    private JButton removerCarroButton;
    private JList<String> carrosList;
    private JButton adicionarClienteButton;
    private JButton removerClienteButton;
    private JList<String> clienteList;
    private JButton alugarButton;
    private JButton devolverButton;
    private JButton detalhesButton;
    private DefaultListModel<String> carrosListModel;
    private DefaultListModel<String> clienteListModel;
    private ArrayList<Cars> listaCarros;
    private ArrayList<Client> listaClientes;

    public Main() {
        carrosListModel = new DefaultListModel<>();
        clienteListModel = new DefaultListModel<>();
        listaCarros = new ArrayList<>();
        listaClientes = new ArrayList<>();
        carrosList.setModel(carrosListModel);
        clienteList.setModel(clienteListModel);

        setContentPane(SytemPanel);
        setTitle("Locadora de Carros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        adicionarCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Carro:");
                String cor = JOptionPane.showInputDialog("Cor do Carro:");
                String placa = JOptionPane.showInputDialog("Placa do Carro:");
                String marca = JOptionPane.showInputDialog("Marca do Carro:");
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do Carro:"));
                int portas = Integer.parseInt(JOptionPane.showInputDialog("Número de Portas:"));

                Cars novoCarro = new Cars(nome, cor, placa, marca, ano, portas, true);
                listaCarros.add(novoCarro);
                String carroInfo = String.format("%s | %s | %s | %s | %d | %d portas",
                        nome, cor, placa, marca, ano, portas);
                carrosListModel.addElement(carroInfo);
            }
        });

        removerCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carroSelecionado = carrosList.getSelectedIndex();
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Veículo?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (carroSelecionado >= 0) {
                        listaCarros.remove(carroSelecionado);
                        carrosListModel.remove(carroSelecionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um carro para remover.");
                    }
                }
            }
        });

        adicionarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Cliente:");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Cliente:"));
                int nascimento = Integer.parseInt(JOptionPane.showInputDialog("Ano de Nascimento do Cliente:"));
                String cpf = JOptionPane.showInputDialog("CPF do Cliente:");

                Client novoCliente = new Client(nome, idade, nascimento, cpf);
                listaClientes.add(novoCliente);
                String clientInfo = String.format("%s | %d | %d | %s |",
                        nome, idade, nascimento, cpf);
                clienteListModel.addElement(clientInfo);
            }
        });

        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int clienteSelecionado = clienteList.getSelectedIndex();
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Cliente?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (clienteSelecionado >= 0) {
                        listaClientes.remove(clienteSelecionado);
                        clienteListModel.remove(clienteSelecionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um cliente para remover.");
                    }
                }
            }
        });

        alugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carroSelecionado = carrosList.getSelectedIndex();
                int clienteSelecionado = clienteList.getSelectedIndex();

                if (carroSelecionado >= 0 && clienteSelecionado >= 0) {
                    Cars carro = listaCarros.get(carroSelecionado);

                    if (carro.isDisponivel()) {
                        carro.setDisponivel(false);
                        int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor para Alugar o Carro"));
                        Rent rent = new Rent(valor, LocalDate.now(), LocalTime.now());
                        carro.setRent(rent);
                        JOptionPane.showMessageDialog(null, "Carro alugado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este carro já está alugado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um carro e um cliente.");
                }
            }
        });


        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carroSelecionado = carrosList.getSelectedIndex();

                if (carroSelecionado >= 0) {
                    Cars carro = listaCarros.get(carroSelecionado);

                    if (!carro.isDisponivel()) {
                        carro.setDisponivel(true);
                        JOptionPane.showMessageDialog(null, "Carro devolvido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este carro não está alugado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um carro para devolver.");
                }
            }
        });

        detalhesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carroSelecionado = carrosList.getSelectedIndex();

                if (carroSelecionado >= 0) {
                    Cars carro = listaCarros.get(carroSelecionado);
                    Rent rent = carro.getRent();

                    if (rent != null) {
                        JOptionPane.showMessageDialog(null,
                                String.format("Detalhes do Aluguel:\nValor: %.2f\nData: %s\nHora: %s",
                                        rent.valor, rent.data.toString(), rent.hora.toString()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Este carro não está alugado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um carro para ver os detalhes.");
                }
            }
        });

    }

    public static void main(String[] args) {
        new Main();
    }
}
