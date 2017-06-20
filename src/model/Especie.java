package model;

import java.util.ArrayList;
import view.TrabalhoM3;
import control.Funcoes;

public class Especie {

    private String nome;
    private double profundidade_minima;
    private double profundidade_maxima;
    private ArrayList<Fotografia> fotografias = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public double getProfundidade_minima() {
        return profundidade_minima;
    }

    public double getProfundidade_maxima() {
        return profundidade_maxima;
    }

    public ArrayList<Fotografia> getFotografias() {
        return fotografias;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfundidade_minima(double profundidade_minima) {
        this.profundidade_minima = profundidade_minima;
    }

    public void setProfundidade_maxima(double profundidade_maxima) {
        this.profundidade_maxima = profundidade_maxima;
    }

    public void inserirFotografia(Fotografia fotografia) {
        fotografias.add(fotografia);
    }
    
    private String getSQLFotografias(){        
        String sql;
        int especie_id = Funcoes.getLastID("especie");
        
        sql = "INSERT INTO fotografia (nome_arquivo, especie_id) values ";
        for (Fotografia fotografia : fotografias) {
            sql = sql + "('" +fotografia.getNome_arquivo() + "', " + especie_id + "), ";
        }                
        
        sql = sql.substring(0, sql.length()-2) + ";";
        return sql;
    }

    private boolean valida() {
        //Validar todas as informações do cadastro.
        return true;
    }

    public boolean save() throws Exception {
        if (valida()) {
            TrabalhoM3.gerenciadorDeDados.conecta();
            TrabalhoM3.gerenciadorDeDados.executar("BEGIN");
            TrabalhoM3.gerenciadorDeDados.executar("INSERT INTO especie (nome, profundidade_minima, profundidade_maxima) "
                    + "values ('" + this.nome + "', " + this.profundidade_minima + ", " + this.profundidade_maxima + ") ");  
            TrabalhoM3.gerenciadorDeDados.executar(getSQLFotografias());
            TrabalhoM3.gerenciadorDeDados.executar("COMMIT");
            TrabalhoM3.gerenciadorDeDados.desconecta();
            return true;
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }

}
