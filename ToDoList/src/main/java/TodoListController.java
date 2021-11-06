/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Samuel Bauta
 */

/*
This is the controller class, it houses all my buttons and events.

The events I've been struggling to figure out are the add and edit events
For now I have the program partially running so that it populates data into
my list, however, the data is hardcoded in.

I'm trying to understand how to load data from the interface into the GUI so
until then this is about as much of a skeleton as I can provide.

I haven't even approached test cases yet, hopefully I can figure this all out soon
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class TodoListController  {

    Wrapper wrapper = new Wrapper();

    @FXML
    private DatePicker DateButton;

    @FXML
    private Button AddItemButton;

    @FXML
    private Button CheckButton;

    @FXML
    private TableColumn<?, ?> CheckColumn;

    @FXML
    private Button ClearListButton;

    @FXML
    private MenuItem CompleteButton;

    @FXML
    private TableColumn<Item, String> DateColumn;

    @FXML
    private TableColumn<Item, String> DescriptionColumn;

    @FXML
    private TableView TableView;

    @FXML
    private TextArea DescriptionTextBox;

    @FXML
    private MenuItem EditDateButton;

    @FXML
    private MenuItem EditDescriptionButton;

    @FXML
    private Button OpenListFileButton;

    @FXML
    private Button RemoveButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button UserGuideButton;

    @FXML
    private MenuItem ViewAll;

    @FXML
    private MenuItem ViewIncomplete;

    @FXML
    private MenuButton ViewOptionsButton;

    @FXML
    void AddItemToList(ActionEvent event) {

        Item newItem = new Item(DescriptionTextBox.getText(),DateButton.getValue());
        TableView.getItems().add(newItem);

    }

    @FXML
    void EditDescriptionFromList(TableColumn.CellEditEvent cellEditEvent)
    {
        TableView.setEditable(true);

        TableView.setItems(wrapper.getItems());
        TableView.getColumns().addAll(DateColumn,DescriptionColumn);

    }

    @FXML
    void EditDateFromList(ActionEvent event){

    }

    @FXML
    void ClearList(ActionEvent event) {

    }

    @FXML
    void MarkComplete(ActionEvent event) {

    }

    @FXML
    void OpenListFile(ActionEvent event) {

    }

    @FXML
    void OpenUserGuide(ActionEvent event) {

    }

    @FXML
    void RemoveItemFromList(ActionEvent event) {

    }

    @FXML
    void SaveFile(ActionEvent event) {

    }

    @FXML
    void DatePicker(ActionEvent event){

    }

    @FXML
    public void initialize(){

        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("Description"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("Date"));
        TableView.setItems(wrapper.getItems());

    }

}
