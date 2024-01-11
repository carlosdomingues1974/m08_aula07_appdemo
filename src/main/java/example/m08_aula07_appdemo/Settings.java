package example.m08_aula07_appdemo;

import javafx.stage.Stage;

public class Settings {
    //region Stage
    /**
     * Stage da aplicação, guardada nesta classe de controlo, permite que
     *     // seja acedida por qualquer outra classe de trabalho, e com isso
     *     // Tem várias vantagens.
     *     // - Permitir manipular o tamanho da stage
     *     // - Permitir defini-la Parent de outras stages Modais, etc.
     */
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Settings.primaryStage = primaryStage;
    }
    //endregion
}
