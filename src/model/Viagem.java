package model;

import control.Funcoes;
import java.sql.Date;
import java.util.ArrayList;
import view.TrabalhoM3;

public class Viagem {

    private Date data_saida;
    private Date data_chegada;
    private int embarcacao_id;
    private int id_porto_saida;
    private int id_porto_chegada;
    private ArrayList<Lance> lances = new ArrayList<>();

    public void setData_chegada(Date data_chegada) {
        this.data_chegada = data_chegada;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public void setEmbarcacao_id(int embarcacao_id) {
        this.embarcacao_id = embarcacao_id;
    }

    public void setId_porto_chegada(int id_porto_chegada) {
        this.id_porto_chegada = id_porto_chegada;
    }

    public void setId_porto_saida(int id_porto_saida) {
        this.id_porto_saida = id_porto_saida;
    }

    public void inserirLances(Lance lance) {
        lances.add(lance);
    }
    
    public void removerLances(int lance){
        lances.remove(lance);
    }

    public Date getData_chegada() {
        return data_chegada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public int getEmbarcacao_id() {
        return embarcacao_id;
    }

    public int getId_porto_chegada() {
        return id_porto_chegada;
    }

    public int getId_porto_saida() {
        return id_porto_saida;
    }

    private boolean valida() {
        return true;
    }

    private void saveLances() throws Exception {
        int viagem_id = Funcoes.getLastID("viagem");
        
        for (Lance lance : lances) {
            lance.save(viagem_id);
        }
    }

    public boolean save() throws Exception {
        if (valida()) {
            TrabalhoM3.gerenciadorDeDados.conecta();
            TrabalhoM3.gerenciadorDeDados.executar("BEGIN");            
            TrabalhoM3.gerenciadorDeDados.executar("insert into viagem (data_saida, data_chegada, embarcacao_id, id_porto_saida, id_porto_chegada) "
                    + "values (" + data_saida + "," + data_chegada + "," + embarcacao_id + "," + id_porto_saida + "," + id_porto_chegada + ")"); //Insere a viagem
            saveLances();
            TrabalhoM3.gerenciadorDeDados.executar("COMMIT");
            TrabalhoM3.gerenciadorDeDados.desconecta();
            return true;
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }
}
