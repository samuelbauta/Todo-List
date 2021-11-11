/*
UCF COP3330 Fall 2021 Application Assignment 1 Solution
 Copyright 2021 Samuel Bauta
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class Wrapper {

    //create observable list
    ObservableList<Item> list = FXCollections.observableArrayList();

    //returns the observable list
    public ObservableList<Item> getList() {
        return list;
    }

    //add item to the list
    public void addItem(Item newItem){
        getList().addAll(newItem);
    }

    //get status from Item class
    public void itemStatus(){
        Item item = new Item();
        item.getStatus();
    }

    //removes the item from list
    public void removeItem(Item index){
        getList().remove(index);
    }

    //clear the list
    public void clearList(){
        getList().clear();
    }

    public void saveList() {
        //method saves list to local storage
        //create new file chooser
        FileChooser fileChooser = new FileChooser();
        //create filter to only save text file
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(filter);
        //open a new window that shows a save dialogue
        File file = fileChooser.showSaveDialog(new Stage());
        String status = null;

        //write a text file with the values from the list
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(file));
            for (Item item : list) {
                status = item.getStatus().isSelected() == true ? "Complete, " : "Incomplete, ";
                wr.write(status + item.getDate() + ", " + item.getDescription());
                wr.newLine();
            }
            wr.close();
        }catch(Exception e) {
            System.out.println("null");
        }
    }
}
