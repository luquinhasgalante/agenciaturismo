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
    
    private int ordem = 0;
    
    private String[] ordens =  {
        " ORDER BY id",
        " ORDER BY id DESC",
        " ORDER BY preco DESC",
        " ORDER BY preco"
    };
    
    private String estadoFiltro = "";
    private double precoMin = 0;
    private double precoMax = 0;
    
    public CadHotelDAO() {
        conexao = new ConexaoDAO().conectaBancoDados();
    }
    
    private String filtroEstado() {
        if(!estadoFiltro.isEmpty()) {
            return "WHERE estado = '" + getEstadoFiltro() + "' ";
        }
        return "";
    }
    
    private String filtroPreco() {
        if(getPrecoMax() > 0 && filtroEstado().isEmpty()) {
            return "WHERE preco BETWEEN " + getPrecoMin() + " AND " + getPrecoMax() + " ";
        }
        else if(getPrecoMax() > 0 && !filtroEstado().isEmpty()) {
            return "AND preco BETWEEN " + getPrecoMin() + " AND " + getPrecoMax() + " ";
        }
        
        return "";
    }
    
    private void criarTable() {
        try{
        String sql = "CREATE TABLE IF NOT EXISTS hoteis ( "
                + "id int primary key not null auto_increment,"
                + "nome varchar(60),"
                + "cidade varchar(60),"
                + "preco double,"
                + "descricao varchar(250),"
                + "estado varchar(60),"
                + "imagem varchar(255)"
                + ");";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar tabela: " + e.getMessage());
        }
    }
    
    public void CadastrarHotel(CadHotel h) {
        try{
            criarTable();
            
            String sql = "INSERT INTO hoteis (nome, cidade, preco, descricao, estado, imagem) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getCidade());
            stmt.setDouble(3, h.getPreco());
            stmt.setString(4, h.getDescricao());
            stmt.setString(5, h.getEstado());
            stmt.setString(6, h.getCaminhoImagem());
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
            String sql = "SELECT * FROM hoteis " + filtroEstado() + filtroPreco() + getOrdens()[getOrdem()];
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
                h.setCaminhoImagem(rs.getString("imagem"));
                lista.add(h);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar hotéis: " + erro.getMessage() + "SELECT * FROM hoteis " + filtroEstado() + filtroPreco() + getOrdens()[getOrdem()]);
        }
        return lista;
    }

    /**
     * @return the ordem
     */
    public int getOrdem() {
        return ordem;
    }

    /**
     * @param ordem the ordem to set
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    /**
     * @return the ordens
     */
    public String[] getOrdens() {
        return ordens;
    }

    /**
     * @param ordens the ordens to set
     */
    public void setOrdens(String[] ordens) {
        this.ordens = ordens;
    }

    /**
     * @return the estadoFiltro
     */
    public String getEstadoFiltro() {
        return estadoFiltro;
    }

    /**
     * @param estadoFiltro the estadoFiltro to set
     */
    public void setEstadoFiltro(String estadoFiltro) {
        this.estadoFiltro = estadoFiltro;
    }

    /**
     * @return the precoMin
     */
    public double getPrecoMin() {
        return precoMin;
    }

    /**
     * @param precoMin the precoMin to set
     */
    public void setPrecoMin(double precoMin) {
        this.precoMin = precoMin;
    }

    /**
     * @return the precoMax
     */
    public double getPrecoMax() {
        return precoMax;
    }

    /**
     * @param precoMax the precoMax to set
     */
    public void setPrecoMax(double precoMax) {
        this.precoMax = precoMax;
    }
}
