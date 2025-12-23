
package Controle;

import Modelo.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Coordenação
 */
public class LoginDAO {
    Connection conexao;
    
    public ResultSet autenticacaoUsuario(Login objusuariomodelo) {
        conexao = new ConexaoDAO ().conectaBancoDados();
    try{
        String sql = "select * from hospedes where email = ? and senha = ?";
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1,objusuariomodelo.getUsuario());
        pstm.setString(2,objusuariomodelo.getSenha());
        
        ResultSet rs = pstm.executeQuery();
        return rs;
    } catch (SQLException erro){
        JOptionPane.showMessageDialog(null, "UsuarioDAO: "+ erro);
        return null;
    }    
    }
}
