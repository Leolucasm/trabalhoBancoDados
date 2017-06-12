package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametrosConexao {

    private final String SERVIDOR;
    private final String PORTA;
    private final String USUARIO;
    private final String SENHA;
    private final String DATABASE;

    /**
     * @param servidor Servidor onde está hospedado o banco de dados.
     * @param porta Porta de conexão com o banco de dados.
     * @param usuario Usuário de acesso ao banco de dados.
     * @param senha Senha de acesso ao banco de dados.
     * @param database Nome do banco de dados onde está hospedado o sistema.
     */
    public ParametrosConexao(String servidor, String porta, String usuario, String senha, String database) {
        this.SERVIDOR = servidor;
        this.PORTA = porta;
        this.USUARIO = usuario;
        this.SENHA = senha;
        this.DATABASE = database;
    }

    public ParametrosConexao() {
        this.SERVIDOR = null;
        this.PORTA = null;
        this.USUARIO = null;
        this.SENHA = null;
        this.DATABASE = null;
        
        try {
            lerArquivoConfiguracao();
        } catch (IOException ex) {
            Logger.getLogger(ParametrosConexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void lerArquivoConfiguracao() throws IOException {
        FileReader arq = new FileReader(System.getProperty("user.dir") + "\\src\\arquivos\\servidor.ini");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine(); // lê a primeira linha
        while (linha != null) {
            System.out.printf("%s\n", linha);

            linha = lerArq.readLine(); // lê da segunda até a última linha
        }

        arq.close();
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
