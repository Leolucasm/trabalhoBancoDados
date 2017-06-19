package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
