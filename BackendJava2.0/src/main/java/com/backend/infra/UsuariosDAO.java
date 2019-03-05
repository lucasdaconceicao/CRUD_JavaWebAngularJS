
package com.backend.infra;

import com.backend.model.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
    
    public void inserir(Usuarios usuario) throws Exception{
        String sqlQuery="INSERT INTO usuarios(nome,email,cpf) VALUES(?,?,?);";
        try{
            PreparedStatement comando=ConexaoBD.getConexaoMySQL().prepareStatement(sqlQuery);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getCpf());
            
            comando.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            ConexaoBD.FecharConexao();
        }
    }
    public int alterar(Usuarios usuario) throws Exception{
        String sqlQuery="UPDATE usuarios SET nome=?,email=?,cpf=? WHERE id=?;";
        int linhasAfetadas=0;
        try{
            PreparedStatement comando = ConexaoBD.getConexaoMySQL().prepareStatement(sqlQuery);
            comando.setString(1,usuario.getNome());
            comando.setString(2,usuario.getEmail());
            comando.setString(3,usuario.getCpf());
            comando.setInt(4, (int) usuario.getId());
            
            linhasAfetadas= comando.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            ConexaoBD.FecharConexao();
        }
        return linhasAfetadas;
    }
    public int excluir(int id) throws Exception{
        int linhasAfetadas=0;
        String sqlQuery="DELETE FROM usuarios WHERE id=?;";
        try{
            PreparedStatement comando = ConexaoBD.getConexaoMySQL().prepareStatement(sqlQuery);
            comando.setInt(1,id);
            linhasAfetadas=comando.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
        finally{
            ConexaoBD.FecharConexao();
        }
        return linhasAfetadas;
    }
    public Usuarios selecionar(int id) throws Exception{
        String sqlQuery ="SELECT *FROM usuarios WHERE id=?;";
        try{
            PreparedStatement comando= ConexaoBD.getConexaoMySQL().prepareStatement(sqlQuery);
            comando.setInt(1,id);
            ResultSet resultado=comando.executeQuery();
            
            if(resultado.next()){
                return parserUsuarios(resultado);
            }
        }
        catch(Exception e){
            throw e;
        }
        finally{
            ConexaoBD.FecharConexao();
        }
        return null;
    }
    public List<Usuarios>listar() throws Exception{
        String sqlQuery = "SELECT * FROM usuarios ORDER BY id DESC;";
        try{
            PreparedStatement comando= ConexaoBD.getConexaoMySQL().prepareStatement(sqlQuery);
            ResultSet resultado= comando.executeQuery();
            
            List<Usuarios> usuario = new ArrayList<>();
            while(resultado.next()){
                usuario.add(parserUsuarios(resultado));
            }
            return usuario;
        }
        catch(Exception e){
            throw e;
        }
        finally{
            ConexaoBD.FecharConexao();
        }
    }
    
    private Usuarios parserUsuarios(ResultSet resultado) throws SQLException{
        Usuarios u = new Usuarios();
        u.setId(resultado.getInt("id"));
        u.setNome(resultado.getString("nome"));
        u.setEmail(resultado.getString("email"));
        u.setCpf(resultado.getString("cpf"));
        return u;
    }
}
