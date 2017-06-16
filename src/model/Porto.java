package model;

public class Porto {

    public enum tipo_administracao {
        publico, privativo
    }

    private String nome;
    private int ano_fundacao;
    private tipo_administracao administracao;

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
        return true;
    }

    public boolean save() throws Exception {
        if (valida()) {
            return true;
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }

}
