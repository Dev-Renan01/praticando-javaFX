package primeirosPassos;

import javax.swing.*;
import java.awt.*;

public class PraticandoJFrame {
        public static void main(String[] args) {

            JFrame frame = new JFrame("Minha Janela"); // Cria uma nova janela com o título "Minha Janela"

            // Define o tamanho da janela para 400 pixels de largura e 300 pixels de altura
            frame.setSize(400, 300);

            // Define a operação padrão quando o usuário fechar a janela.
            // Neste caso, o programa será encerrado (EXIT_ON_CLOSE).
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Torna a janela visível na tela
            frame.setVisible(true);

        }
    }