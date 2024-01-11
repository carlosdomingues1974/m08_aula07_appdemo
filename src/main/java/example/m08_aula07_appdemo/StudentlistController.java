package example.m08_aula07_appdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentlistController implements Initializable {
    //region Dados locais e Controlos XML

    // Atributo (Control) da tableView
    // 1º criá-los pelo método automático do XML: 1º criar o id no SceneBuilder, 2º no XML clicar para criar o atributo)
    // 2º acrescentar a diretiva @FXML e mudar para private: restringe o seu uso ao Controller e à file FXML associada.
    // 3º Associar a Classe que vai tratar.
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn tableColumnNumber;
    @FXML
    private TableColumn tableColumnName;
    @FXML
    private TableColumn tableColumnAge;
    @FXML
    private TableColumn tableColumnGender;
    //endregion

    /** LOADER
     * INITIALIZE() - é executado assim que o construtor acaba de ativar todos os elementos da scene
     * Neste caso, vai efetivar a associação das colunas da tableView aos atributos da classe.
     * Ou seja, estamos a dizer aos atributos da TableView onde devem is buscar os dados.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Associação das colunas aos atributos da classe
        tableColumnNumber.setCellValueFactory(new PropertyValueFactory<Aluno, Integer>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
        tableColumnAge.setCellValueFactory(new PropertyValueFactory<Aluno, LocalDate>("dataNascimento"));
        tableColumnGender.setCellValueFactory(new PropertyValueFactory<Aluno, Boolean>("genero"));

        // Associação da ObservableList à TableView. A partir daqui, tudo se faz na ObservableList.
        tableView.setItems(Settings.getListaAlunos());
    }
    public void buttonEdit(ActionEvent actionEvent) {
    }

    public void buttonDelete(ActionEvent actionEvent) {
    }

    public void buttonClose(ActionEvent actionEvent) {
    }

}
