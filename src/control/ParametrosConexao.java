package control;

import java.io.FileReader;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametrosConexao {

    private String SERVIDOR;
    private String PORTA;
    private String USUARIO;
    private String SENHA;
    private String DATABASE;

    public ParametrosConexao() {
        this.SERVIDOR = null;
        this.PORTA = null;
        this.USUARIO = null;
        this.SENHA = null;
        this.DATABASE = null;
    }

    /**
     * @param servidor Servidor onde está hospedado o banco de dados.
     * @param porta Porta de conexão com o banco de dados.
     * @param usuario Usuário de acesso ao banco de dados.
     * @param senha Senha de acesso ao banco de dados.
     * @param database Nome do banco de dados onde está hospedado o sistema.
     */
    public void setParametrosConexao(String servidor, String porta, String usuario, String senha, String database) {
        this.SERVIDOR = servidor;
        this.PORTA = porta;
        this.USUARIO = usuario;
        this.SENHA = senha;
        this.DATABASE = database;
    }

    public void lerArquivoConfiguracao() {

        Reader reader;        
        try {
            reader = new FileReader(new File(this.getClass().getResource("/arquivos/servidor.json").getFile()));
            Gson gson = new Gson();
            ParametrosConexao parametrosConexao = gson.fromJson(reader, ParametrosConexao.class);
            setParametrosConexao(parametrosConexao.getSERVIDOR(), parametrosConexao.getPORTA(), parametrosConexao.getUSUARIO(), parametrosConexao.getSENHA(), parametrosConexao.getDATABASE());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParametrosConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSERVIDOR() {
        return SERVIDOR;
    }

    public String getPORTA() {
        return PORTA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public String getSENHA() {
        return SENHA;
    }

    public String getDATABASE() {
        return DATABASE;
    }

}
