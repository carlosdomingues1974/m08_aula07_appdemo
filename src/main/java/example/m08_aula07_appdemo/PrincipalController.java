package example.m08_aula07_appdemo;

import example.m08_aula07_appdemo.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class PrincipalController {
    @FXML
    private BorderPane borderPane;

    /**
     * Fecha a aplicação, caso o botão clicado seja o Sim
     * @param actionEvent evento disparado
     */
    public void menuExitApplication(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sair da aplicação");
        alert.setHeaderText("Deseja mesmo sair da apliação?");
        // Adiciona botões personalizados em português
        ButtonType botaoSim = new ButtonType("Sim");
        ButtonType botaoNao = new ButtonType("Não");
        alert.getButtonTypes().setAll(botaoSim, botaoNao);

        /*Optional<ButtonType> choose = alert.showAndWait();
        if (choose.get() == botaoSim) {
            Settings.getPrimaryStage().close();
        }*/
        //Outra maneira
        alert.showAndWait().ifPresent(response ->{
            if(response == botaoSim){
                Settings.getPrimaryStage().close();
            }
        });
    }

    public void menuAbout(ActionEvent actionEvent) throws Exception {
        // Aquisição do controlo da cena (Scene) about FXML
        Parent scene = FXMLLoader.load(getClass().getResource("about.fxml"));

        //Nova janela (Stage)
        Stage about = new Stage();
        //Definições da Stage
        about.setTitle("Acerca de");
        about.setResizable(false);

        // Associação da Scene à Stage
        about.setScene(new Scene(scene));

        // Abertura da janela About em modo MODAL, em relação à primaryStage
        about.initOwner(Settings.getPrimaryStage());
        about.initModality(Modality.WINDOW_MODAL);

        //Abertura da janela About
        about.show();
    }

    public void menuStudentList(ActionEvent actionEvent) throws Exception{
        // Aquisição do controlo da cena da ListViewXml FXML (listviewxml.fxml) e
        // associar à zona central da BorderPane.
        // Aquisição do controlo do Scene pretendida
        Parent scene = FXMLLoader.load(getClass().getResource("studentlist.fxml"));

        // Atribuição da Scene à zona central da cena Principal, que é um BorderPane
        borderPane.setCenter(scene);
    }
}
