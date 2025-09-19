package primeirosPassos;

import javax.swing.*;
import java.awt.*;

public class PraticandoJLabel {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Minha Janela");

        JLabel label1 = new JLabel("Olá, Mundo!"); // Cria um JLabel com o texto "Olá, Mundo!"
        ImageIcon icon = new ImageIcon("icon.png"); // Cria um ícone a partir de um arquivo de imagem chamado "icon.png"
        JLabel label2 = new JLabel("Com ícone", icon, JLabel.CENTER);// Cria um JLabel que exibe texto e ícone ao mesmo tempo.

        frame.setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout, componentes um ao lado do outro

        frame.add(label1);// Adiciona o JLabel
        frame.add(label2);

        frame.setSize(400, 300);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
