package example.m08_aula07_appdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Este Controller é chamado pela
 *     - Opção do menu "Inserir";
 *     - Ou pelos Botões Alterar e Eliminar da studentlist e ainda do evento MouseClick da TableView
 *
 *     Cada uma destas opções regista na classe static Settings 2 valores:
 *     - Flag Action - permite à Interface ter 3 comportamentos destintos
 *     - Objeto da Entidade a tratar nesta Scene, apenas para os casos UPDATE e DELETE
 *
 *     O Loader desta Scene (método initializee, JavaFX) irá ler estes 2 valores e atuará em conformidade.
 *         1 - é um Insert => campos abertos e buttonAction ="Insert". O Objeto Entidade virá NULL.
 *         2 - é um Update => coloca os dados do Objeto da entidade na Interface.
 *         3 - é um Delete => igual ao anterior, mas com todos os campos DISABLE.
 *     O método click do buttonAction, executa a ação correspondente, em função da Flag Action
 *         1 - é um Insert => Insere os dados preenchidos num novo aluno e adiciona-o à List
 *         2 - é um Update => Substitui os Aluno na Lista, após recolher os dados da Interface
 *         3 - é um Delete => Elimina o aluno na Lista.
 *
 *     No Final de cada uma destas operações, A Flag Action volta a -1 e o Objeto Entidade a NULL.
 */
public class StudentController implements Initializable {
    //region dados locais e controlos dos elementos FXML
    //Controlos para os elementos FXML
    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtName;
    @FXML
    private DatePicker datePickerBirthDate;
    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private Button btnAction;
    //endregion
    //region Loader
    /**
     * Método LOADER
     * Este é o primeiro método a ser executado, após a construção da Scene
     * Neste caso vai preparar a Scene, em função da FLAG Action da classe
     * Settings. Esta FLAG é definida no momento em que a Scene é chamada:
     *  - Da opção de menu Inserir: passa o valor 1
     *  - Da opção alterar da Scene studentist: passa o valor 2
     *  - Da opção eliminar da Scene studentlist: passa o valor 3
     *  - -1 é o valor indefinido. caso chegue aqui, o utilizador é notificado.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    //endregion

    //region Ações
    public void buttonAction(ActionEvent actionEvent) {
    }

    public void buttonCancel(ActionEvent actionEvent) {
    }
    //endregion

    public void TextFieldNameKeyPressed(KeyEvent keyEvent) {
    }
}
