package example.m08_aula07_appdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
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

    // Controlo da Stage. Obtém-se a partir de qualquer Controlo dos elementos FXML.
    @FXML
    private Stage thisStage;
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
        // Se flag Action não está definida => notifica e termina
        if(Settings.ACTION == -1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sair da aplicação");
            alert.setHeaderText("A flag Action não está definida");
            alert.show();
        }
        //Preparação da cena
        switch (Settings.ACTION){
            case Settings.ACTION_INSERT:
                // Altera o texto do título e do botão Action
                // Os campos são apresentados abertos e vazios
                lblTitle.setText("Inserção do Aluno");
                btnAction.setText("Inserir");
                break;
            case Settings.ACTION_UPDATE:
                // Altera o texto do título e do botão Action
                lblTitle.setText("Alteração do Aluno");
                btnAction.setText("Alterar");
                break;
            case Settings.ACTION_DELETE:
                // Altera o texto do título e do botão Action
                lblTitle.setText("Eliminação do Aluno");
                btnAction.setText("Eliminar");
                break;
        }

    }
    //endregion

    //region Ações
    public void buttonAction(ActionEvent actionEvent) {
        switch (Settings.ACTION){
            case Settings.ACTION_INSERT:
                // Recolha dos dados existentes nos Controlos (objetos gráficos da janela)
                // para um novo objeto.
                int number = Integer.parseInt(txtNumber.getText());
                String name = txtName.getText();
                LocalDate birth = datePickerBirthDate.getValue();
                boolean gender = rbMale.isSelected();
                Aluno newStudent = new Aluno(number,name,birth,gender);

                //Adiciona o novo Aluno à TableView
                Settings.getListaAlunos().add(newStudent);

        }
        // Reposição da Flag e do Objeto Entidade da classe Settings e encerramento da Stage
        Settings.ACTION = -1;
        Settings.setStudentEdit(null);
        thisStage = (Stage) btnAction.getScene().getWindow();
        thisStage.close();
    }

    public void buttonCancel(ActionEvent actionEvent) {
    }
    //endregion

    public void TextFieldNameKeyPressed(KeyEvent keyEvent) {
    }
}
