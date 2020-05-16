package appBanco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsumidoraConta extends JFrame {
    private JButton btnConsultar;
    private JLabel lbNome;
    private JLabel lbSaldo;
    private JTextField txtValor;
    private JButton btnSaque;
    private JButton btnDepositar;
    private JTextField txtldConta;

    public ConsumidoraConta() {
        btnConsultar.addActionListener(actionEvent -> {
            try {
                /*
                ws.ServicoContaService servico = new ws.ServicoContaService();
                ws.ServicoConta webservice = servico.getServicoConta();
                 */

                //List<String> resultado = (List<String>) webservice.consultarDadosConta(Integer.parseInt(txtldConta.getText()));

                List<String> resultado = new ArrayList<>();

                //Se resultado não retornou vazio
                if (!resultado.get(0).equals("")) {
                    //Exibe resultado da busca
                    lbNome.setText(resultado.get(0));
                    lbSaldo.setText(resultado.get(1));

                    //Ativa a caixa de texto e botões para Saque e Depósito
                    txtValor.setEnabled(true);
                    btnSaque.setEnabled(true);
                    btnDepositar.setEnabled(true);
                }
                else {
                    //Alerta se resultado não encontrado
                    JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                }
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        });
    }
}
