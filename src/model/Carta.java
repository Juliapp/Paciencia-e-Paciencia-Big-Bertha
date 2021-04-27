package model;


/**
 *
 * @author Adlla Katarine e Daniel Alves
 */
public class Carta {
    
    private String naipe, valor, cor;
    private int peso;
    private boolean visivel;

    /**
     * Construtor da classe
     *
     * @param naipe naipe da carta
     * @param valor número da carta
     * @param cor cor da carta
     * 
     */
    public Carta(String naipe, String valor, int peso) {
        this.naipe = naipe;
        this.valor = valor;
        this.peso = peso;
        this.visivel = false;
        setCor();
    }


    private void setCor(){
        if(this.naipe.equals("♣") || this.naipe.equals("♠"))
            this.cor = "PRETO";
        else
            this.cor = "VERMELHO";
    }
    /**
     *
     * @return naipe da carta
     * 
     */
    public String getNaipe() {
        return naipe;
    }

    /**
     *
     * @return valor da carta
     * 
     */
    public String getValor() {
        return valor;
    }

    /**
     *
     * @param cor
     * 
     */
    public String getCor() {
        return cor;
    }

    /**
     *
     * @param peso
     * 
     */
    public int getPeso() {
        return peso;
    }

    /**
     *
     * @return se ela está virada ou não
     * 
     */
    public boolean isVisivel() {
        return visivel;
    }

    /**
     *
     * @param face
     * 
     */
    public void setVisivel(boolean face) {
        this.visivel = face;
    }


    @Override
    public String toString() {
        return "Carta [cor=" + cor + ", naipe=" + naipe + ", valor=" + valor + ", peso=" +peso+"]";
    }
}
