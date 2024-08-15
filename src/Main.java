import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private JLabel SystemLabel;
    private JPanel SytemPanel;
    private JButton adicionarCarroButton;
    private JButton removerCarroButton;
    private JLabel JLabel1;
    private JList<String> carrosList;
    private DefaultListModel<String> carrosListModel;
    private ArrayList<Cars> lista;

    public Main() {
        carrosListModel = new DefaultListModel<>();
        lista = new ArrayList<>();
        carrosList.setModel(carrosListModel);

        setContentPane(SytemPanel);
        setTitle("Locadora de Carros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        adicionarCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Carro");
                String cor = JOptionPane.showInputDialog("Cor do Carro:");
                String placa = JOptionPane.showInputDialog("Placa do Carro:");
                String marca = JOptionPane.showInputDialog("Marca do Carro:");
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do Carro:"));
                int portas = Integer.parseInt(JOptionPane.showInputDialog("Número de Portas:"));

                Cars novoCarro = new Cars(nome, cor, placa, marca, ano, portas, true);
                lista.add(novoCarro);
                carrosListModel.addElement(novoCarro.nome);
            }
        });

        removerCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carroSelecionado = carrosList.getSelectedIndex();
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Veiculo?");
                if(opcao == JOptionPane.YES_OPTION) {
                    if (carroSelecionado >= 0) {
                        lista.remove(carroSelecionado);
                        carrosListModel.remove(carroSelecionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um carro para remover.");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
