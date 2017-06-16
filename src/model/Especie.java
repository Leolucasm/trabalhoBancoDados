package model;

import java.util.ArrayList;
import trabalhom3.TrabalhoM3;

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

    private boolean valida() {
        //Validar todas as informações do cadastro.
        return true;
    }

    public boolean save() throws Exception {
        if (valida()) {
            TrabalhoM3.gerenciadorDeDados.executarComando("BEGIN");
            TrabalhoM3.gerenciadorDeDados.executarComando("INSERT INTO especies");
            return true;
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }

}
