/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Samuel Bauta
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
All this class will do is run the program and launch the GUI application

For this assignment, I completely redid my class structure, FXML, and program from the ground up

 */

public class TodoListApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =
                FXMLLoader.load((getClass().getResource("TodoListApplication.fxml")));

        Scene mainScene = new Scene(root); // attach scene graph to scene
        primaryStage.setTitle("TodoListApplication"); // displayed in window's title bar
        primaryStage.setScene(mainScene); // attach scene to stage
        primaryStage.show(); // display the stage
    }

    //date picker instead of date text box

    public static void main(String[] args) {

        launch(args);
    }

}

        /*

        open new fxml- scene manager bs: (call new controller to type new input)
                        have user input data
                        retrieve data from user
        update list with new data (update observable list) *hint*

        test:
        1) test if data is correct - new controller - make sure length valid and valid date format
        2) test if data is inserted correctly - current controller - global list is appended correctly

         */