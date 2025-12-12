package Visao;

import Controle.CadUsuarioDAO;
import Modelo.CadUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Tadeu
 */

public class FormCadUsuario extends javax.swing.JFrame {

    CadUsuarioDAO usuarioDAO = new CadUsuarioDAO();

    public FormCadUsuario() {
        initComponents();
        listarUsuarios();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        jLabel1.setText("ID:");

        txtId.setEditable(false);

        jLabel2.setText("Usuário:");

        jLabel3.setText("Senha:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(evt -> cadastrar());

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(evt -> atualizar());

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(evt -> excluir());

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(evt -> limparCampos());

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Usuário", "Senha" }
        ));
        tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carregarCampos();
            }
        });
        jScrollPane1.setViewportView(tabelaUsuarios);

        btnListar.setText("Listar");
        btnListar.addActionListener(evt -> listarUsuarios());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar))
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private boolean camposPreenchidos() {
        return txtUsuario.getText().isBlank() || txtSenha.getText().isBlank();
    }
    
    private void cadastrar() {
        if(!camposPreenchidos()) {
            CadUsuario u = new CadUsuario();
            u.setUsuario(txtUsuario.getText());
            u.setSenha(txtSenha.getText());

            usuarioDAO.cadastrarUsuario(u);
            listarUsuarios();
            limparCampos();
            this.dispose();
            String[] args = {};
            FormLogin.main(args);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        }
    }

    private void atualizar() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário!");
            return;
        }

        CadUsuario u = new CadUsuario();
        u.setId(Integer.parseInt(txtId.getText()));
        u.setUsuario(txtUsuario.getText());
        u.setSenha(txtSenha.getText());

        usuarioDAO.atualizarUsuario(u);
        listarUsuarios();
        limparCampos();
    }

    private void excluir() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário!");
            return;
        }

        usuarioDAO.excluirUsuario(Integer.parseInt(txtId.getText()));
        listarUsuarios();
        limparCampos();
    }

    private void listarUsuarios() {
        List<CadUsuario> lista = usuarioDAO.listarUsuarios();
        DefaultTableModel modelo = (DefaultTableModel) tabelaUsuarios.getModel();
        modelo.setRowCount(0);

        lista.forEach(u -> {
            modelo.addRow(new Object[]{
                u.getId(),
                u.getUsuario(),
                u.getSenha()
            });
        });
    }

    private void carregarCampos() {
        int linha = tabelaUsuarios.getSelectedRow();
        txtId.setText(tabelaUsuarios.getValueAt(linha, 0).toString());
        txtUsuario.setText(tabelaUsuarios.getValueAt(linha, 1).toString());
        txtSenha.setText(tabelaUsuarios.getValueAt(linha, 2).toString());
    }

    private void limparCampos() {
        txtId.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new FormCadUsuario().setVisible(true));
    }

    // Declaração de variáveis
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtSenha;
}
