package example.m08_aula07_appdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
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

        /**
         * Conversão dos dados da coluna Género. O método setCellFactory permite faze-lo.
         * Neste caso, queremos substituir o boolean do atributo genero por uma
         * string (true = Masculino; false = Femenino).
         * Passamos por parâmetro a classe do objeto da Lista (Aluno) e o tipo de dados (Boolean)
         * a tratar antes de chegar à coluna.
         * As instruções de substituição fazem-se no método updateItem.
         */
        tableColumnGender.setCellFactory(evt -> new TableCell<Aluno, Boolean>(){
            /**
             *  Método que permite especificar a conversão do valor a surgir na coluna
             * @param item recebe os dados que queremos tratar. Só temos que alterar o tipo de dados do parâmetro: Boolean
             * @param empty é um boolean que informa se o objeto da lista (Aluno) é null. Este parâmetro nunca se modifica.
             */
            @Override
            protected void updateItem(Boolean item, boolean empty){
                super.updateItem(item, empty);
                // Caso o Aluno venha null não faz nada. Caso contrário, testa o item (Género -> Boolean)
                setText(empty ? null : item ? "Masculino" : "Femenino");
            }
        });

        /**
         * Conversão dos dados da coluna Idade. O método setCellFactory permite faze-lo.
         * Neste caso, queremos substituir a data de nascimento (LocalDate), pela idade (Integer).
         * Passamos por parâmetro a classe do objeto da Lista (Aluno) e o tipo de dados (LocalDate)
         * a tratar antes de chegar à coluna.
         * As instruções de substituição fazem-se no método upDateItem.
         */
        tableColumnAge.setCellFactory(evt -> new TableCell<Aluno, LocalDate>(){
            /**
             * Método que permite especificar a conversão do valor a surgir na coluna
             * @param item recebe os dados que queremos tratar. Só temos que alterar o tipo de dados do parâmetro: LocalDate
             * @param empty é um boolean que informa se o objeto da lista (Aluno) é null. Este parâmetro nunca se modifica.
             */
            @Override
            protected void updateItem(LocalDate item, boolean empty){
                super.updateItem(item, empty);
                // Caso o empty (Aluno) esteja a null, não preenche nada. Caso contrário calcula a idade do aluno
                if(!empty){
                    Period age = Period.between(item, LocalDate.now());
                    setText(String.valueOf(age.getYears()));
                }
            }
        });

        // Associação da ObservableList à TableView. A partir daqui, tudo se faz na ObservableList.
        tableView.setItems(Settings.getListaAlunos());
    }

    /**
     * Editar/ Atualizar o item selecionado
     * 1º Verifica se há algum item selecionado
     * 2º Extrai o Objeto
     * 3º Atualiza Settings com a FLAG Action a 2 e o Objeto Entidade
     * @param actionEvent executa o evento
     * @throws Exception serve para ignorar todos o warnings de exceções. Caso contrário temos qe usar o try...catch
     */
    public void buttonEdit(ActionEvent actionEvent) throws Exception {
        // Caso não haja um item selecionado notifica o Utilizador e termina.
        if(tableView.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Item não selecionado");
            alert.setHeaderText("Selecione um item, por favor!");
            alert.show();
            return;
        }
        // Se chegou aqui é porque há um item selecionado => Extrai-o
        // O método devolve um Object porque nunca sabe o que lá vem. => Cast para Aluno.
        Aluno selectedItem = (Aluno) tableView.getSelectionModel().getSelectedItem();

        // Definição da Flag Ation e do objeto de Entidade de settings com Insert
        Settings.ACTION = Settings.ACTION_UPDATE;
        Settings.setStudentEdit(selectedItem);

        // Abre a Scene numa nova Stage em modo Modal
        // Aquisição do controlo da Scene pretendida
        Parent scene = FXMLLoader.load(getClass().getResource("student.fxml"));

        // Nova janela
        Stage studentEdit = new Stage();
        studentEdit.setTitle("Aplicação de Demonstração - Atualizar Aluno");

        // Associação da Scene à Stage
        studentEdit.setScene(new Scene(scene));

        // Abertura da janela edit Student em modo MODAL, em relação à primaryStage
        studentEdit.initOwner(Settings.getPrimaryStage());
        studentEdit.initModality(Modality.WINDOW_MODAL);

        // Abertura da Window
        studentEdit.show();

    }

    /**
     * Eliminar o Item Selecionado
     * 1º Verifica se há algum item selecionado
     * 2º Extrai o Objeto
     * 3º Atualiza Settings com a FLAG Action a 3 e o Objeto Entidade
     * @param actionEvent executa o evento
     * @throws Exception serve para ignorar todos o warnings de exceções. Caso contrário temos qe usar o try...catch
     */
    public void buttonDelete(ActionEvent actionEvent) throws Exception{
        // Caso não haja um item selecionado notifica o Utilizador e termina.
        if(tableView.getSelectionModel().getSelectedItem() == null){

            // Notifica o utilizdor e termina
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Item não selecionado");
            alert.setHeaderText("Selecione um item, por favor!");
            alert.show();
            return;
        }
        // Se chegou aqui é porque há um item selecionado => Extrai-o
        // O método devolve um Object porque nunca sabe o que lá vem. => Cast para Aluno.
        Aluno selectedItem = (Aluno) tableView.getSelectionModel().getSelectedItem();

        // Definição da Flag Ation e do objeto de Entidade de settings com Insert
        Settings.ACTION = Settings.ACTION_DELETE;
        Settings.setStudentEdit(selectedItem);

        // Abre a Scene numa nova Stage em modo Modal
        // Aquisição do controlo da Scene pretendida
        Parent scene = FXMLLoader.load(getClass().getResource("student.fxml"));

        // Nova janela
        Stage studentDelete = new Stage();
        studentDelete.setTitle("Aplicação de Demonstração - Eliminar Aluno");

        // Associação da Scene à Stage
        studentDelete.setScene(new Scene(scene));

        // Abertura da janela edit Student em modo MODAL, em relação à primaryStage
        studentDelete.initOwner(Settings.getPrimaryStage());
        studentDelete.initModality(Modality.WINDOW_MODAL);

        // Abertura da Window
        studentDelete.show();

    }

    /**
     * permite sair da cena atual. Repôe a cena Principal na Stage
     * @param actionEvent executa o evento
     * @throws Exception erve para ignorar todos o warnings de exceções. Caso contrário temos qe usar o try...catch
     */
    public void buttonClose(ActionEvent actionEvent) throws Exception {
        // Aquisição do controlo da Scene pretendida
        Parent scene = FXMLLoader.load(getClass().getResource("principal.fxml"));

        // Voltar à cena principal da Stage
        Settings.getPrimaryStage().setScene(new Scene(scene));
    }

}
