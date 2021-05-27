package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import util.UIComponentsBigBerta;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
public class PainelBigBerthaController extends UIComponentsBigBerta{

    private ControllerBigBerta controller;
    public String moveFromId;
    public String moveToId;

    @FXML
    void onFromSelected(ActionEvent event) {
        RadioButton target = (RadioButton) event.getTarget();
        String id = target.getId();
        moveFromId = id;

        if(id.equals("fromMonte")){
            fromWhich.setDisable(true);
            fromWhich.setText("");
        }else{
            fromWhich.setDisable(false);
        }

        for(RadioButton button: UIListFromRadioButtons){
            if(id != button.getId()){
                button.setSelected(false);
            }
        }
    }

    @FXML
    void onToSelected(ActionEvent event) {
        RadioButton target = (RadioButton) event.getTarget();
        String id = target.getId();
        moveToId = id;

        for(RadioButton button: UIListToRadioButtons){
            if(id != button.getId()){
                button.setSelected(false);
            }
        }
    }

    
    @FXML
    void onJogar(ActionEvent event) {
        if(!(moveFromId.equals("") && moveToId.equals(""))){
            String strIndex = fromWhich.getText();
            int index;
    
            try {
                index = Integer.parseInt(strIndex);
            } catch (NumberFormatException e) {
                index = -99;
            }
            
            controller.Jogar(moveFromId, moveToId, index);
        }
        clearSelections();
        renderTela();
    }

    private void clearSelections(){
        moveFromId = "";
        moveToId = "";
        fromWhich.setText("");

        for(RadioButton button: UIListFromRadioButtons){
            button.setSelected(false);
        }
        for(RadioButton button: UIListToRadioButtons){
            button.setSelected(false);
        }
    }


    @FXML
    void initialize() {
        controller = new ControllerBigBerta();
        initializeAllUIComponents();
        renderTela();
    }

    public void renderTela(){
        renderFileiras();
        renderMontes();
        renderFundacoes();
    }


    public void renderFileiras(){
        for (int i = 0; i <15; i++){
            ListView<String> lv = UIListFileiras.get(i);
            lv.getItems().setAll(controller.getStringFileiraByIndex(i));
        }
    }

    public void renderMontes(){
        qtdCartasRestantes.setText("(" + controller.getQtdRestanteMonte() + ")");
        monte.setText(controller.getCartaMonte());
        proxCartaAComprar.setText(controller.getProxCartaMonte());
    }

    public void renderFundacoes(){
        ArrayList<String> faces = controller.getUltimasFundacoes();
        for (int i = 0; i < 9; i++) {
            UIFundacoesLabel.get(i).setText(faces.get(i));
        }
        // UIFundacoesLabel.get(8).setText(faces.get(8));
        fundacaoK.setText(faces.get(8));
    }

}

// Image image3 = new Image("assets/Group 3.png");
// Image image4 = new Image("assets/Group 4.png");
// Image image5 = new Image("assets/Group 5.png");
// Image image6 = new Image("assets/Group 6.png");
// fileira14.getItems().add(new ImageView(image3));
// fileira14.getItems().add(new ImageView(image4));
// fileira14.getItems().add(new ImageView(image5));
// fileira14.getItems().add(new ImageView(image6));

// 0
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// 11
// 12
// 13
// 14