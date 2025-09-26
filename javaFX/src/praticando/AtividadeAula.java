package praticando;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtividadeAula extends JFrame {
            public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // Janela
                        JFrame janela = new JFrame("Product Registration");
                        janela.setSize(800, 500);
                        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        janela.setLayout(new BorderLayout());

                        // Painel principal
                        JPanel painelPrincipal = new JPanel();
                        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

                        // -------- Formulário --------
                        JPanel painelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
                        JTextField txtPreco = new JTextField();
                        JComboBox<String> cbCategory = new JComboBox<>(new String[]{"Eletrônico", "Roupa", "Alimento"});
                        JComboBox<String> cbImage = new JComboBox<>(new String[]{"Produto 1", "Produto 2", "Produto 3"});
                        JCheckBox chkAzul = new JCheckBox("Blue");
                        JCheckBox chkVerde = new JCheckBox("Green");

                        painelFormulario.add(new JLabel("Image:"));
                        painelFormulario.add(cbImage);
                        painelFormulario.add(new JLabel("Category:"));
                        painelFormulario.add(cbCategory);
                        painelFormulario.add(new JLabel("Supplier:"));
                        JPanel painelFornecedor = new JPanel();
                        painelFornecedor.add(chkAzul);
                        painelFornecedor.add(chkVerde);
                        painelFormulario.add(painelFornecedor);
                        painelFormulario.add(new JLabel("Price:"));
                        painelFormulario.add(txtPreco);

                        painelPrincipal.add(painelFormulario);

                        // -------- Botões --------
                        JPanel painelBotoes = new JPanel();
                        JButton btnSalvar = new JButton("Save");
                        JButton btnEditar = new JButton("Edit");
                        JButton btnExcluir = new JButton("Delete");
                        painelBotoes.add(btnSalvar);
                        painelBotoes.add(btnEditar);
                        painelBotoes.add(btnExcluir);
                        painelPrincipal.add(painelBotoes);

                        // -------- Busca --------
                        JPanel painelBusca = new JPanel();
                        JTextField txtBusca = new JTextField(20);
                        JButton btnBuscar = new JButton("Search");
                        painelBusca.add(new JLabel("Search:"));
                        painelBusca.add(txtBusca);
                        painelBusca.add(btnBuscar);
                        painelPrincipal.add(painelBusca);

                        // -------- Painel da tabela + label de imagem --------
                        JPanel painelTabelaImagem = new JPanel(new BorderLayout());

                        // Tabela
                        String[] colunas = {"ID", "Name", "Category", "Supplier", "Price"};
                        DefaultTableModel modelo = new DefaultTableModel(colunas, 4);
                        JTable tabela = new JTable(modelo);
                        JScrollPane scroll = new JScrollPane(tabela);
                        painelTabelaImagem.add(scroll, BorderLayout.CENTER);

                        // Label lateral "Image"
                        JLabel lblImagem = new JLabel("Image", JLabel.CENTER);
                        lblImagem.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        lblImagem.setPreferredSize(new Dimension(200, 0));
                        painelTabelaImagem.add(lblImagem, BorderLayout.WEST);

                        painelPrincipal.add(painelTabelaImagem);

                        // Adicionar painel principal
                        janela.add(painelPrincipal, BorderLayout.CENTER);

                        // ----- Ações -----
                        btnSalvar.addActionListener(new ActionListener() {
                            private int contadorId = 1;

                            public void actionPerformed(ActionEvent e) {
                                String fornecedor = (chkAzul.isSelected() ? "Blue " : "") + (chkVerde.isSelected() ? "Green" : "");
                                modelo.addRow(new Object[]{
                                        contadorId++,
                                        cbImage.getSelectedItem(),
                                        cbCategory.getSelectedItem(),
                                        fornecedor,
                                        txtPreco.getText()
                                });
                                cbImage.setSelectedIndex(0);
                                cbCategory.setSelectedIndex(0);
                                txtPreco.setText("");
                                chkAzul.setSelected(false);
                                chkVerde.setSelected(false);
                            }
                        });

                        btnEditar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int linha = tabela.getSelectedRow();
                                if (linha != -1) {
                                    modelo.setValueAt(cbImage.getSelectedItem(), linha, 1);
                                    modelo.setValueAt(cbCategory.getSelectedItem(), linha, 2);
                                    String fornecedor = (chkAzul.isSelected() ? "Blue " : "") + (chkVerde.isSelected() ? "Green" : "");
                                    modelo.setValueAt(fornecedor, linha, 3);
                                    modelo.setValueAt(txtPreco.getText(), linha, 4);
                                }
                            }
                        });

                        btnExcluir.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int linha = tabela.getSelectedRow();
                                if (linha != -1) modelo.removeRow(linha);
                            }
                        });

                        btnBuscar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String busca = txtBusca.getText().toLowerCase();
                                for (int i = 0; i < modelo.getRowCount(); i++) {
                                    String nome = modelo.getValueAt(i, 1).toString().toLowerCase();
                                    if (nome.contains(busca)) {
                                        tabela.setRowSelectionInterval(i, i);
                                        return;
                                    }
                                }
                                JOptionPane.showMessageDialog(janela, "Produto não encontrado!");
                            }
                        });

                        // Mostrar janela
                        janela.setVisible(true);
                    }
                });
            }
}