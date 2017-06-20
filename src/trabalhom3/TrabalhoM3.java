package trabalhom3;

import control.GerenciadorDeDados;
import control.ParametrosConexao;

public class TrabalhoM3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ParametrosConexao parametros = new ParametrosConexao();                
        parametros.lerArquivoConfiguracao();        
        GerenciadorDeDados gerenciadorDeDados = new GerenciadorDeDados(parametros);
        gerenciadorDeDados.conecta();        
    }
    
}
