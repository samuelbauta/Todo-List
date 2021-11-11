/*
UCF COP3330 Fall 2021 Application Assignment 1 Solution
 Copyright 2021 Samuel Bauta
 */
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TodoListController implements Initializable {
    Wrapper wrapperList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //create instance of wrapper class
        wrapperList = new Wrapper();

        //points to the Item class and sets the cell factory to string of type Item
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("status"));

        //setting date to proper format
        String pattern = "yyyy-MM-dd";
        DateBox.setPromptText(pattern.toLowerCase());
        DateBox.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

        //setting table to editable in order to edit items
        tableView.setEditable(true);

        //creates text field inside each row when item is made to edit
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Item, String> event) {
                Item item = event.getRowValue();
                item.setDescription(event.getNewValue());
            }
        });

    }

    @FXML
    void AddItemToList(ActionEvent event) {

        if (!DescriptionTextBox.getText().equals("") && !DescriptionTextBox.getText().equals(" ")) {
            Item item;

            if (DescriptionTextBox.getText().length() <= 256) {
                //get the values of description and date
                //allow user to enter item without date
                if (DateBox.getValue() == null) {
                    item = new Item(" ", DescriptionTextBox.getText());
                    wrapperList.addItem(item);
                    tableView.setItems(wrapperList.getList());

                }
                    item = new Item(DateBox.getValue().toString(), DescriptionTextBox.getText());
                    //add item to the list
                    wrapperList.addItem(item);
                    tableView.setItems(wrapperList.getList());

            } else {
                //allow user to enter item without date
                if (DateBox.getValue() == null) {
                    item = new Item(" ", DescriptionTextBox.getText().substring(1,256));
                    wrapperList.addItem(item);
                    tableView.setItems(wrapperList.getList());

                }
                item = new Item(DateBox.getValue().toString(), DescriptionTextBox.getText());
                //add item to the list
                wrapperList.addItem(item);
                tableView.setItems(wrapperList.getList());

            }
            //have the table view reflect the list
            //clear description box
            DescriptionTextBox.clear();
            DateBox.setValue(null);
        }

    }

    @FXML
    void RemoveItemFromList(ActionEvent event) {

        //creates object and set it to value of the selected item
        Object item = tableView.getSelectionModel().getSelectedItem();

        //remove it from the list
        wrapperList.removeItem((Item)item);
    }

    @FXML
    void viewComplete(ActionEvent event){

        //create a filtered list and wrap around the observable list
        FilteredList<Item> filteredData = new FilteredList<>(wrapperList.list, b -> true);

        //set the condition to only checked boxes
        filteredData.setPredicate(item ->
        {
            return item.getStatus().isSelected();
        });
        SortedList<Item> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
    @FXML
    void viewIncomplete(ActionEvent event){
        FilteredList<Item> filteredData = new FilteredList<>(wrapperList.list, b -> true);

        //set condition to only uncheck boxes
        filteredData.setPredicate(item ->
        {
            return !item.getStatus().isSelected();
        });
        SortedList<Item> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
    @FXML
    //just display all the items in the list
    void viewAll(ActionEvent event){
        tableView.setItems(wrapperList.getList());
    }

      @FXML
      //clear the list of all items
    void ClearList(ActionEvent event) {
        wrapperList.clearList();
        DescriptionTextBox.clear();
    }

    @FXML
    //open already existing list and load it into list app
    void OpenListFile(ActionEvent event) throws IOException {

        //filter file type to text files only
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filter);
        //opens load catalogue
        File file = fileChooser.showOpenDialog(null);

        try{
            //scan the file
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                //read into string array
                String[] line = reader.nextLine().split(", ");
                String status = line[0];
                String description = line[1];
                String date = line[2];
                //set boolean variable to match string so check box is set correctly
                boolean newStat;

                if(status.equals("Complete")){
                    newStat = true;
                }else
                    newStat = false;


                wrapperList.addItem(new Item(description,date,newStat));
                tableView.setItems(wrapperList.list);
            }
        }catch(Exception e){
            System.out.println("null");
        }
    }
    @FXML
    void OpenUserGuide(ActionEvent event) {


    }

    @FXML
    //save list to local storage.
    void SaveFile(ActionEvent event) {
        wrapperList.saveList();
    }

    @FXML
    private DatePicker DateBox;
    @FXML
    private Button AddItemButton;
    @FXML
    private TableColumn<Item, String> statusColumn;
    @FXML
    private Button ClearListButton;
    @FXML
    private MenuItem ViewComplete;
    @FXML
    private TableColumn<Item, String> dateColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableView tableView;
    @FXML
    private TextArea DescriptionTextBox;
    @FXML
    private Button EditButton;
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

    public void AddDate(ActionEvent event) {
    }


    //--------------------------------------
}
