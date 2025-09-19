package primeirosPassos;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PraticandoJCheckBox {
    public static void main(String[] args) {
        // Cria a janela principal (frame)
        JFrame frame = new JFrame("Preferências");

        // Cria um painel com layout vertical (componentes empilhados em coluna)
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Cria as checkboxes (opções de linguagens)
        JCheckBox cbJava = new JCheckBox("Java");
        JCheckBox cbPython = new JCheckBox("Python");
        JCheckBox cbCSharp = new JCheckBox("C#");

        // Cria um ItemListener para reagir quando as checkboxes forem (des)marcadas
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Pega a checkbox que disparou o evento
                JCheckBox source = (JCheckBox) e.getSource();

                // Verifica se foi marcada ou desmarcada
                boolean selected = (e.getStateChange() == ItemEvent.SELECTED);

                // Exibe no console o estado atual
                System.out.println(source.getText() +
                        ": " + (selected ? "marcado" : "desmarcado"));
            }
        };

        // Associa o mesmo listener às três checkboxes
        cbJava.addItemListener(listener);
        cbPython.addItemListener(listener);
        cbCSharp.addItemListener(listener);

        // Adiciona os componentes ao painel
        panel.add(new JLabel("Linguagens favoritas:"));
        panel.add(cbJava);
        panel.add(cbPython);
        panel.add(cbCSharp);

        // Adiciona o painel ao frame
        frame.add(panel);

        // Define o tamanho da janela
        frame.setSize(300, 150);

        // Define o comportamento ao fechar (encerra a aplicação)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Torna a janela visível
        frame.setVisible(true);
    }
}

