package primeirosPassos;

import javax.swing.*;
import java.awt.*;

public class PraticandoJPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha janela");

        JPanel panel = new JPanel();// Cria um painel com layout

        panel.setLayout(new FlowLayout()); // organiza os componentes um ao lado do outro

        panel.add(new JButton("Botão 1"));// Adiciona um botão
        panel.add(new JButton("Botão 2"));

        frame.add(panel);// Adiciona o painel que contém os botões à janela (frame)

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}