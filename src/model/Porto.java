package model;

import view.TrabalhoM3;

public class Porto {

    public enum tipo_administracao {
        publico, privativo
    }

    private String nome;
    private int ano_fundacao;
    private tipo_administracao administracao = null;

    public tipo_administracao getAdministracao() {
        return administracao;
    }

    public int getAno_fundacao() {
        return ano_fundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setAdministracao(tipo_administracao administracao) {
        this.administracao = administracao;
    }

    public void setAno_fundacao(int ano_fundacao) {
        this.ano_fundacao = ano_fundacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private boolean valida() {
        if((nome.equals("")) || (ano_fundacao <= 0) || (administracao == null)){
            return false;
        }
        return true;
    }

    public boolean save() throws Exception {
        if (valida()) {
            String campo_administracao = null;
            if (administracao == tipo_administracao.publico){
                campo_administracao = "PUB";
            } else{
                campo_administracao = "PRI";
            }            
            TrabalhoM3.gerenciadorDeDados.executarComando("INSERT INTO porto (nome, administracao, ano_fundacao) values ('" + this.nome + "', '" + campo_administracao + "', " + this.ano_fundacao +")");
            return true;
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }

}
