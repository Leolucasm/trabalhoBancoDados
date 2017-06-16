package trabalhom3;

import control.GerenciadorDeDados;
import control.ParametrosConexao;

public class TrabalhoM3 {

    public static GerenciadorDeDados gerenciadorDeDados;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ParametrosConexao parametros = new ParametrosConexao();
        parametros.lerArquivoConfiguracao();
        gerenciadorDeDados = new GerenciadorDeDados(parametros);
        gerenciadorDeDados.conecta();
    }

}
