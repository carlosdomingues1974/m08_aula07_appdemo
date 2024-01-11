module example.m08_aula07_appdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.m08_aula07_appdemo to javafx.fxml;
    exports example.m08_aula07_appdemo;

}