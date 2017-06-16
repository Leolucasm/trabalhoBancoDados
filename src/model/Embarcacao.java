package model;

import trabalhom3.TrabalhoM3;

public class Embarcacao {

    private String nome;
    private double tamanho;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    private boolean valida() {
        return !((this.nome.equals("")) || (this.tamanho <= 0));
    }

    public boolean save() throws Exception {
        if (valida()) {
            TrabalhoM3.gerenciadorDeDados.executarComando("INSERT INTO embarcacao nome, tamanho values (" + this.nome + ", " + this.tamanho + ")");
            return true;
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }

}
