package control;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON        

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader("servidor.json"));

            //Salva nas variaveis os dados retirados do arquivo
            this.SERVIDOR = (String) jsonObject.get("servidor");
            this.PORTA = (String) jsonObject.get("porta");
            this.USUARIO = (String) jsonObject.get("usuario");
            this.SENHA = (String) jsonObject.get("senha");
            this.DATABASE = (String) jsonObject.get("database");
            
        }
        catch (Exception e) {
            //
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
