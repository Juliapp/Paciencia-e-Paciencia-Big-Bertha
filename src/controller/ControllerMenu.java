package controller;

import java.util.ArrayList;
import model.Baralho;
import model.Carta;
import util.Embaralhar;



/**
 *
 * @author Adlla Katarine e Daniel Alves
 */
public class ControllerMenu {
    ArrayList<Carta> baralho;

    public ControllerMenu(int quantidadeBaralho) {
        Baralho br = new Baralho(quantidadeBaralho);
        this.baralho = br.getBaralho();
        this.baralho = Embaralhar.embaralhar(this.baralho);
    }

    
    public ArrayList<Carta> getBaralhoEmbaralhado(){
        return this.baralho;
    }
}
