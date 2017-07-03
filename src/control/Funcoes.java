package control;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerDateModel;
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
        
        sql = sql + " order by id";
        dados = gerenciadorDeDados.getDadosTabela(sql);
        DefaultTableModel model;
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }        

    public static DefaultTableModel getEspecies(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Nome", "Profundidade Mínima", "Profundidade Máxima"};
        String[][] dados;

        sql = "SELECT id, "
                + "nome, "
                + "profundidade_minima, "
                + "profundidade_maxima "
                + "from "
                + "especie ";

        if (!filtros.equals("")) {
            sql = sql + " WHERE " + filtros;
        }
        
        sql = sql + " order by id";
        dados = gerenciadorDeDados.getDadosTabela(sql);
        DefaultTableModel model;
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel getPortos(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Nome", "Administração"};
        String[][] dados;

        sql = "SELECT id, "
                + "nome, "
                + "administracao "
                + "from "
                + "porto ";

        if (!filtros.equals("")) {
            sql = sql + " WHERE " + filtros;
        }
        
        sql = sql + " order by id";
        dados = gerenciadorDeDados.getDadosTabela(sql);

        for (int i = 0; i < dados.length; i++) {
            if (dados[i][2].equals("PUB")) {
                dados[i][2] = "Pública";
            } else if (dados[i][2].equals("PRI")){
                dados[i][2] = "Privada";
            }
        }
        DefaultTableModel model;
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    
    public static DefaultTableModel getViagens(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Data de Saída", "Data de Chegada", "Embarcacao", "Porto de Saída", "Porto de Chegada"};
        String[][] dados;

        sql = "SELECT v.id, "
                + "TO_CHAR(data_saida, 'DD/MM/YYYY'), "                
                + "TO_CHAR(data_chegada, 'DD/MM/YYYY'), "
                + "e.nome as nome_embarcacao, "
                + "s.nome as nome_porto_saida, "
                + "c.nome as nome_porto_chegada "
                + "from "
                + "viagem v "
                + "left join embarcacao e on (v.embarcacao_id = e.id) "
                + "left join porto s on (v.id_porto_saida = s.id) "
                + "left join porto c on (v.id_porto_chegada = c.id) ";

        if (!filtros.equals("")) {
            sql = sql + " WHERE " + filtros;
        }              
        
        sql = sql + " order by v.id";        
        dados = gerenciadorDeDados.getDadosTabela(sql);
       
        DefaultTableModel model;
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static void excluirRegistro(String tabela, String id) throws SQLException {
        
        gerenciadorDeDados.conecta();
        gerenciadorDeDados.executar("BEGIN");
        
        if (tabela.equals("viagem")){            
            gerenciadorDeDados.executar("DELETE from captura using lance WHERE  lance.viagem_id = " + id + " AND captura.lance_id = lance.id");
            gerenciadorDeDados.executar("DELETE from lance WHERE lance.viagem_id = " + id);
        }         
        gerenciadorDeDados.executar("delete from " + tabela + " where id = " + id);
        
        gerenciadorDeDados.executar("COMMIT");
        gerenciadorDeDados.desconecta();
    }

    public static String formatarDouble(String valor) {
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");
        return valor;
    }
    
    public static boolean registroExiste(String tabela, String campo, String valor_campo) throws SQLException{
        String sql;        
        String[][] dados;

        sql = "SELECT id from " + tabela + " where upper(" + campo + ") = upper('" + valor_campo + "')";                
        dados = gerenciadorDeDados.getDadosTabela(sql);
        
        return !(dados[0][0].equals(" "));
    }
    
    public static String dataSQL(SpinnerDateModel model){        
        DateFormat formato_dia = new SimpleDateFormat("dd");
        DateFormat formato_mes = new SimpleDateFormat("M");
        DateFormat formato_ano = new SimpleDateFormat("yyyy");
        java.util.Date data = model.getDate();
                      
        String dia = formato_dia.format(data);
        String mes = formato_mes.format(data);
        String ano = formato_ano.format(data);
                        
        return dia + "/" + mes + "/" + ano;
    }
    
    public static String horaSQL(SpinnerDateModel model){        
        DateFormat formato_hora = new SimpleDateFormat("HH");
        DateFormat formato_minuto = new SimpleDateFormat("mm");        
        java.util.Date data = model.getDate();
                      
        String hora = formato_hora.format(data);
        String minuto = formato_minuto.format(data);        
                        
        return hora + ":" + minuto;
    }
    
    public static String formataData(Date data_sql){                
        DateFormat formato_dia = new SimpleDateFormat("dd");
        DateFormat formato_mes = new SimpleDateFormat("M");
        DateFormat formato_ano = new SimpleDateFormat("yyyy");        
                      
        String dia = formato_dia.format(data_sql);
        String mes = formato_mes.format(data_sql);
        String ano = formato_ano.format(data_sql);
                        
        return dia + "/" + mes + "/" + ano;
    }
}
