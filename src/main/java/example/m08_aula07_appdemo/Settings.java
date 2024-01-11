package example.m08_aula07_appdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Settings {
    //region Stage
    /**
     * Stage da aplicação, guardada nesta classe de controlo, permite que
     * seja acedida por qualquer outra classe de trabalho, e com isso
     * tem várias vantagens.
     *  - Permitir manipular o tamanho da stage
     *  - Permitir defini-la Parent de outras stages Modais, etc.
     */
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Settings.primaryStage = primaryStage;
    }
    //endregion

    //region Lista de Alunos

    /**
     * ObservableList de Alunos
     */
    private static ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

    public static ObservableList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static void setListaAlunos(ObservableList<Aluno> listaAlunos) {
        Settings.listaAlunos = listaAlunos;
    }

    /**
     * Carrega os alunos da turma na LIST
     */
    public static void loadStudentList(){
        listaAlunos.add(new Aluno(1, "André Rodrigues Campos", LocalDate.of(2001,7,12), true));
        listaAlunos.add(new Aluno(2, "Arízio Costa Badjana", LocalDate.of(2001,10,10), true));
        listaAlunos.add(new Aluno(3, "Arydson Pires Soares", LocalDate.of(2003,4,17), true));
        listaAlunos.add(new Aluno(4, "Bucari Baldé", LocalDate.of(2005,1,1), true));
        listaAlunos.add(new Aluno(5, "Daniel Figueira e Pina de Sá Sampaio", LocalDate.of(2003,7,29), true));
        listaAlunos.add(new Aluno(6, "Diogo Miguel Rodrigues Pereira", LocalDate.of(2002,6,13), true));
        listaAlunos.add(new Aluno(7, "Francisco Tavares Chamorrinha", LocalDate.of(2001,9,11), true));
        listaAlunos.add(new Aluno(8, "Guilherme Balelo Rodrigues", LocalDate.of(2003,8,15), true));
        listaAlunos.add(new Aluno(9, "Hendrik  Vinicius da Silva Lelis", LocalDate.of(2001,12,18), true));
        listaAlunos.add(new Aluno(10, "Isaac Elias Macieira ", LocalDate.of(2003,5,14), true));
        listaAlunos.add(new Aluno(11, "João Eduardo Pires Delgado", LocalDate.of(2003,4,17), true));
        listaAlunos.add(new Aluno(12, "João Miguel Vasconcelos Laires", LocalDate.of(2001,8,29), true));
        listaAlunos.add(new Aluno(13, "Ladirson Junior Sousa Monteiro", LocalDate.of(2002,8,27), true));
        listaAlunos.add(new Aluno(15, "Miguel Nogueira Boletas", LocalDate.of(2002,7,15), true));
        listaAlunos.add(new Aluno(16, "Nataniel Cristovão Massawe", LocalDate.of(2002,10,26), true));
        listaAlunos.add(new Aluno(17, "Raquel Maria Matos Pinto", LocalDate.of(2003,10,12), false));
        listaAlunos.add(new Aluno(19, "Rodrigo André Macedo Silva", LocalDate.of(2001,7,22), true));
        listaAlunos.add(new Aluno(20, "Rodrigo da Silveira Pereira", LocalDate.of(2003,3,6), true));
        listaAlunos.add(new Aluno(21, "Tiago Maria Neves", LocalDate.of(2003,6,8), true));
    }
    //endregion
}
