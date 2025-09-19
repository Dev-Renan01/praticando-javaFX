package primeirosPassos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PraticandoJPasswordField {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // Cria um painel com GridLayout de 3 linhas e 2 colunas, com espaçamento de 5px entre os componentes
        Panel panel = new Panel(new GridLayout(3, 2, 5, 5));

        // Cria um rótulo para o campo de usuário
        JLabel userLabel = new JLabel("Usuário:");

        // Cria um campo de texto para entrada do nome de usuário
        JTextField userField = new JTextField(15);

        // Cria um rótulo para o campo de senha
        JLabel passLabel = new JLabel("Senha:");

        // Cria um campo de senha com tamanho de 15 colunas
        JPasswordField passField = new JPasswordField(15);

        // Define o caractere que será exibido no lugar da senha digitada
        passField.setEchoChar('*');

        // Cria um botão de login
        JButton loginButton = new JButton("Entrar");

        // Adiciona um ouvinte de ação ao botão
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtém a senha digitada como um array de caracteres
                char[] password = passField.getPassword();
            }
        });

// Adiciona os componentes ao painel na ordem do GridLayout
        panel.add(userLabel);    // primeira célula
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel("")); // célula vazia para alinhamento
        panel.add(loginButton);  // botão ocupa a última célula

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
