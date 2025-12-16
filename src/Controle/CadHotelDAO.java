/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.CadHotel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class CadHotelDAO {
    Connection conexao;
    
    public CadHotelDAO() {
        conexao = new ConexaoDAO().conectaBancoDados();
    }
    
    public void CadastrarHotel(CadHotel h) {
        try{
            String sql = "INSERT INTO hoteis (nome, cidade, preco, descricao, estado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getCidade());
            stmt.setDouble(3, h.getPreco());
            stmt.setString(4, h.getDescricao());
            stmt.setString(5, h.getEstado());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Hotel cadastrado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar hotel: " + e.getMessage());
        }
        
    }
    
    // READ (LISTAR)
    public List<CadHotel> listarHoteis() {
        List<CadHotel> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoteis";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CadHotel h = new CadHotel();
                h.setId(rs.getInt("id"));
                h.setNome(rs.getString("nome"));
                h.setCidade(rs.getString("cidade"));
                h.setPreco(rs.getDouble("preco"));
                h.setDescricao(rs.getString("descricao"));
                h.setEstado(rs.getString("estado"));
                lista.add(h);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + erro.getMessage());
        }
        return lista;
    }
}
