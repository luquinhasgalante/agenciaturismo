package Controle;

import Modelo.CadUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CadUsuarioDAO {

    Connection conexao;

    public CadUsuarioDAO() {
        conexao = new ConexaoDAO().conectaBancoDados();
    }

    // CREATE
    public void cadastrarUsuario(CadUsuario usuario) {
        try {
            String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + erro.getMessage());
        }
    }

    // READ (LISTAR)
    public List<CadUsuario> listarUsuarios() {
        List<CadUsuario> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CadUsuario u = new CadUsuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                lista.add(u);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + erro.getMessage());
        }
        return lista;
    }

    // UPDATE
    public void atualizarUsuario(CadUsuario usuario) {
        try {
            String sql = "UPDATE usuarios SET usuario = ?, senha = ? WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + erro.getMessage());
        }
    }

    // DELETE
    public void excluirUsuario(int id) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + erro.getMessage());
        }
    }
}