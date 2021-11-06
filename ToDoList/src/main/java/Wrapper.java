/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Samuel Bauta
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/*
I am still trying to figure out how to do this wrapper class. I want to have this
class wrap around my controller class, but I'm still figuring this out.

So far I have sample data shoved into the observable list to simply populate the list but nothing more
 */
public class Wrapper {

    private ObservableList<Item> items;

    public Wrapper() {

        items = FXCollections.observableArrayList();
        items.add(new Item("January 1", "Willy"));
        items.add(new Item("January 2", "Willy"));
        items.add(new Item("January 3", "Willy"));

    }

    /*
    These are simply getters and setters to be used by other classes
     */
    public ObservableList<Item> getItems() {
        return items;
    }

    public void setItems(ObservableList<Item> items) {
        this.items = items;
    }

}
