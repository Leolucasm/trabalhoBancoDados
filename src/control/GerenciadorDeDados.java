package control;

import java.sql.Connection;
import java.sql.DriverManager;
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
        this.URL = "jdbc:postgressql://" + parametros.getSERVIDOR() + ":" + parametros.getPORTA() + "/" + parametros.getDATABASE();
    }

    /**
     * @param comando SQL contendo o comando para ser executado.
     */
    public void executarComando(String comando) {
        try {
            executar(comando);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao executar o comando! \n Mensagem: " + ex.getMessage());            
        }
    }    

    /**
     * @param comando SQL contendo o comando para ser executado.
     */
    public void executar(String comando) throws SQLException {        
        conecta();
        Statement st = conexao.createStatement();
        st.executeUpdate(comando);
        desconecta();
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
