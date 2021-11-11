/*
UCF COP3330 Fall 2021 Application Assignment 1 Solution
 Copyright 2021 Samuel Bauta
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//extends the application class
public class TodoListApplication extends Application {
    @Override
    //initiates application screen
    public void start(Stage primaryStage) throws Exception {
        Parent root =
                FXMLLoader.load((getClass().getResource("TodoListApplication.fxml")));

        Scene mainScene = new Scene(root); // attach scene graph to scene
        primaryStage.setTitle("TodoListApplication"); // displayed in window's title bar
        primaryStage.setScene(mainScene); // attach scene to stage
        primaryStage.show(); // display the stage
    }
    public static void main(String[] args) {
        launch(args);
    }
}
