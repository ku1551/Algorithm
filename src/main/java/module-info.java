module com.example.beakjun {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.beakjun to javafx.fxml;
    exports com.example.beakjun;
}