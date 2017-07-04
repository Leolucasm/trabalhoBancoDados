package control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
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

    public String[][] getDadosTabela(String consulta) throws SQLException {
        conecta();
        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = st.executeQuery(consulta);
        resultSet.last();
        int linha = resultSet.getRow();
        resultSet.beforeFirst();

        int colunas = resultSet.getMetaData().getColumnCount();

        String[][] dadosTabela;

        if (linha > 0) {
            dadosTabela = new String[linha][colunas];
        } else {
            dadosTabela = new String[1][colunas];
        }

        int i = 0;

        while (resultSet.next()) {
            for (int colun = 1; colun <= colunas; colun++) {
                if (resultSet.getObject(colun) != null) {
                    String valor = resultSet.getObject(colun).toString();
                    dadosTabela[i][colun - 1] = valor;
                } else {
                    dadosTabela[i][colun - 1] = " ";
                }
            }
            i++;
        }

        if (i == 0) {
            for (int colun = 1; colun <= colunas; colun++) {
                dadosTabela[i][colun - 1] = " ";
            }
        }

        desconecta();
        return dadosTabela;
    }

    public void insereFotografia(int id_especie, String caminho_fotografia) throws SQLException, Exception {        
        PreparedStatement st = conexao.prepareStatement("insert into fotografia (foto, especie_id) values (?, ?)");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage imagem = ImageIO.read(new File(caminho_fotografia));
        ImageIO.write((BufferedImage) imagem, "png", baos);
        baos.flush();
        byte[] byteArray = baos.toByteArray();
        baos.close();
        st.setBytes(1, byteArray);
        st.setInt(2, id_especie);
        st.executeUpdate();
        st.close();        
    }

    /**
     * @param comando SQL contendo o comando para ser executado.
     */
    public void executarComando(String comando) throws SQLException {
        conecta();
        executar(comando);
        desconecta();
    }

    /**
     * @param comando SQL contendo o comando para ser executado.
     */
    public void executar(String comando) throws SQLException {        
            Statement st = conexao.createStatement();
            st.executeUpdate(comando);        
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
