package primeirosPassos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PraticandoJButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JButton");

        JButton button = new JButton("Clique Aqui");// Cria um botão com texto


        // Adiciona um "ouvinte de eventos" (ActionListener) ao botão.
        // Esse ouvinte será chamado sempre que o botão for clicado.
        button.addActionListener(new ActionListener() {

            // Sobrescreve o método actionPerformed, que é executado quando o evento acontece.
            public void actionPerformed(ActionEvent e) {

                // Exibe uma caixa de diálogo simples com a mensagem "Botão foi clicado!"
                JOptionPane.showMessageDialog(frame,"Botão foi clicado!");
            }
        });


        frame.setLayout(new FlowLayout());
        frame.add(button);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
