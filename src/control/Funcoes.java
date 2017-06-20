package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static view.TrabalhoM3.gerenciadorDeDados;

public class Funcoes {

    public static Integer getLastID(String tabela) {
        try {
            String sql;
            sql = "SELECT max(id) as maxId from " + tabela + ";";
            return gerenciadorDeDados.getLastID(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static DefaultTableModel getEmbarcacoes(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Nome", "Tamanho"};
        String[][] dados;

        sql = "SELECT id, "
                + "nome, "
                + "tamanho "                
                + "from "
                + "embarcacao ";

        if (!filtros.equals("")) {
            sql = sql + " WHERE " + filtros;
        }
        dados = gerenciadorDeDados.getDadosTabela(sql);
        DefaultTableModel model;
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    
    public static void excluirRegistro(String tabela, String id){
        gerenciadorDeDados.executarComando("delete from " + tabela + " where id = " + id);
    }
}
