package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import util.UIComponentsBigBerta;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
public class PainelBigBerthaController extends UIComponentsBigBerta{

    private ControllerBigBerta controller;

    @FXML
    void onFromSelected(ActionEvent event) {
        RadioButton target = (RadioButton) event.getTarget();
        String id = target.getId();
        System.out.println(id);

        if(id.equals("fromMonte")){
            fromWhich.setDisable(true);
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
    void initialize() {
        controller = new ControllerBigBerta();
        initializeFileiras();
        renderFileiras();
        initializeFromButtons();
    }



    public void renderFileiras(){
        for (int i = 0; i <15; i++){
            ListView<String> lv = UIListFileiras.get(i);
            lv.getItems().setAll(controller.getStringFileiraByIndex(i));
        }
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