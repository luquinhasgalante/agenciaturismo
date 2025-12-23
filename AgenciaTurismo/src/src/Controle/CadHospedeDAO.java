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
    
    private void criarTable() {
        try {
            String sql = "CREATE TABLE hospedes ("
                    + "id int primary key not null auto_increment,"
                    + "nome varchar(60),"
                    + "email varchar(60),"
                    + "estado varchar(60),"
                    + "senha varchar(60)"
                    + ");";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar tabela: " + e.getMessage());
        }
    }
    
    public void cadastrarHospede(CadHospede h) {
        
        try{
            criarTable();
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

