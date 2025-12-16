/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.CadHospede;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class CadHospedeDAO {
    Connection conexao;
    
    public CadHospedeDAO() {
        conexao = new ConexaoDAO().conectaBancoDados();
    }
    
    public void cadastrarHospede(CadHospede h) {
        
        try{
            String sql = "INSERT INTO hospedes (nome, email, estado, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getEmail());
            stmt.setString(3, h.getEstado());
            stmt.setString(4, h.getSenha());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Hóspede cadastrado com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar hóspede: " + e.getMessage());
        }
    }
    
    
}
