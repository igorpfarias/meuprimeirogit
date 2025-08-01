package api2025;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class CadastroApp extends JFrame{
	private JTextField idField, nomeField, telefoneField;
    private DefaultTableModel tableModel;
    private JTable table;

    public CadastroApp() {
        setTitle("Sistema de Cadastro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Cadastro"));

        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        formPanel.add(telefoneField);

        JButton cadastrarButton = new JButton("Cadastrar");
        formPanel.add(cadastrarButton);

        // Espaço vazio
        formPanel.add(new JLabel());

        // Tabela
        tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "Telefone"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona ação ao botão
        cadastrarButton.addActionListener(e -> adicionarCadastro());

        // Layout principal
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void adicionarCadastro() {
        String id = idField.getText().trim();
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();
        
            if (id.isEmpty() || nome.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Adiciona na tabela
        tableModel.addRow(new Object[]{id, nome, telefone});

        // Limpa os campos
        idField.setText("");
        nomeField.setText("");
        telefoneField.setText("");
    }

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> {
	            CadastroApp app = new CadastroApp();
	            app.setVisible(true);
		 });

	}
}

