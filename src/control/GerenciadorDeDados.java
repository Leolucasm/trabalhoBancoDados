package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GerenciadorDeDados {

    private final String URL;
    private final String USUARIO;
    private final String SENHA;
    private Connection conexao;

    /**
     * @param parametros parâmetros de conexão com o banco de dados.
     */
    public GerenciadorDeDados(ParametrosConexao parametros) {
        this.USUARIO = parametros.getUSUARIO();
        this.SENHA = parametros.getSENHA();
        this.URL = "jdbc:postgresql://" + parametros.getSERVIDOR() + ":" + parametros.getPORTA() + "/" + parametros.getDATABASE();
    }

    /**
     * @param comando SQL contendo o comando para ser executado.
     */
    public void executarComando(String comando) {
        conecta();
        executar(comando);
        desconecta();
    }

    /**
     * @param comando SQL contendo o comando para ser executado.     
     */
    public void executar(String comando) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(comando);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao executar o comando! \n Mensagem: " + ex.getMessage());
        }
    }
    
    public int getLastID(String comando) throws SQLException {        
        Statement st = conexao.createStatement();        
        ResultSet rs = st.executeQuery(comando);
        rs.next();        
        return rs.getInt("maxId"); 
    }    

    public void conecta() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n Mensagem: " + ex.getMessage());
        }

    }

    public void desconecta() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar!");
        }
    }
}
