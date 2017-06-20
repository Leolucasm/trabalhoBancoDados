package model;

import view.TrabalhoM3;

public class Captura {
  private double peso;
  private int lance_id;
  private int especie_id;

    public void setEspecie_id(int especie_id) {
        this.especie_id = especie_id;
    }

    public void setLance_id(int lance_id) {
        this.lance_id = lance_id;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public int getEspecie_id() {
        return especie_id;
    }

    public int getLance_id() {
        return lance_id;
    }

    public double getPeso() {
        return peso;
    }    
    
    private boolean valida(){
        return !((peso <= 0) || (especie_id <= 0) || (lance_id <=0));
    }
    
    public void save(int lance) throws Exception{
        setLance_id(lance);
        if (valida()) {                        
            TrabalhoM3.gerenciadorDeDados.executar("INSERT INTO captura (peso, especie_id, lance_id) "
                    + "values (" + this.peso + ", " + this.especie_id + ", " + this.lance_id + ")");                          
        } else {
            throw new Exception("Pelo menos um dos campos obrigatórios não está preenchido, por favor verifique!");
        }
    }
}
