package view;

import control.GerenciadorDeDados;
import control.ParametrosConexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Especie;
import model.Fotografia;

public class TrabalhoM3 {

    public static GerenciadorDeDados gerenciadorDeDados;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ParametrosConexao parametros = new ParametrosConexao();
        parametros.lerArquivoConfiguracao();
        gerenciadorDeDados = new GerenciadorDeDados(parametros);
        
        Principal principal = new Principal();
        principal.show();
    }

}
