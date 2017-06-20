package model;

import control.Funcoes;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import view.TrabalhoM3;

public class Lance {
    private Date data;
    private Time hora_inicial;
    private Time hora_final;
    private double comprimmento_rede;
    private double altura_rede;
    private double tamanho_malha;
    private double profundidade;
    private double latitude_inicial;
    private double longitude_inicial;
    private ArrayList<Captura> capturas = new ArrayList<>();
    private int viagem_id;

    public void setAltura_rede(double altura_rede) {
        this.altura_rede = altura_rede;
    }

    public void setComprimmento_rede(double comprimmento_rede) {
        this.comprimmento_rede = comprimmento_rede;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHora_final(Time hora_final) {
        this.hora_final = hora_final;
    }

    public void setHora_inicial(Time hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public void setLatitude_inicial(double latitude_inicial) {
        this.latitude_inicial = latitude_inicial;
    }

    public void setLongitude_inicial(double longitude_inicial) {
        this.longitude_inicial = longitude_inicial;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public void setTamanho_malha(double tamanho_malha) {
        this.tamanho_malha = tamanho_malha;
    }

    public void setViagem_id(int viagem_id) {
        this.viagem_id = viagem_id;
    }        

    public double getAltura_rede() {
        return altura_rede;
    }

    public double getComprimmento_rede() {
        return comprimmento_rede;
    }

    public Date getData() {
        return data;
    }

    public Time getHora_final() {
        return hora_final;
    }

    public Time getHora_inicial() {
        return hora_inicial;
    }

    public double getLatitude_inicial() {
        return latitude_inicial;
    }

    public double getLongitude_inicial() {
        return longitude_inicial;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public double getTamanho_malha() {
        return tamanho_malha;
    }        

    public int getViagem_id() {
        return viagem_id;
    }
        
    public void inserirCaptura(Captura captura){
        this.capturas.add(captura);
    }
    
    private boolean valida(){
        //Definir quais campos devem ser obrigatórios
        return true;
    }
    
    private void saveCapturas() throws Exception{
        int lance_id = Funcoes.getLastID("lance");
        for (Captura captura : capturas) {
            captura.save(lance_id);
        }
    }
    
    public void save(int viagem) throws Exception{
        setViagem_id(viagem);        

        if (valida()) {                        
            TrabalhoM3.gerenciadorDeDados.executar("INSERT INTO viagem (data, hora_inicial, hora_final, comprimmento_rede, altura_rede, tamanho_malha, "
                    + "profundidade, latitude_inicial, longitude_inicial, viagem_id) "
                    + "values ("+ data + "," + hora_inicial + "," + hora_final + "," + comprimmento_rede + "," + altura_rede + "," + tamanho_malha + "," 
                    + profundidade + "," + latitude_inicial + "," + longitude_inicial + "," + viagem_id +")");        
            saveCapturas();
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }
}
