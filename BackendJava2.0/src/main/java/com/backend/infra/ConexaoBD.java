
package com.backend.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static String status = "Não conectou...";

    public ConexaoBD() {
    
    }
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null; 
        try{
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);
            
            String serverName = "localhost";    
            String mydatabase ="base_usuario";       
            String url = "jdbc:mysql://"+serverName+"/"+mydatabase;
            String username = "root";              
            String password = "root";    
 
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        }
        catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } 
        catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
    //Método que retorna o status da conexão//
    public static String statusConection(){
        return status;
    }
    //Método que fecha conexão//
    public static boolean FecharConexao() {
        try {
            ConexaoBD.getConexaoMySQL().close();
            return true;
        } 
        catch (SQLException e) {
            return false;
        }
    }
    //Método que reinicia conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoBD.getConexaoMySQL();
    }
}
            
        


