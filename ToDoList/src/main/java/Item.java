/*
UCF COP3330 Fall 2021 Application Assignment 1 Solution
 Copyright 2021 Samuel Bauta
 */


import javafx.scene.control.CheckBox;

public class Item {

    //declaring variables of Item class
    private String description;
    private String date;
    private CheckBox status;

    public Item(String date, String description)
    {
        this.description = description;
        this.date = date;
        this.status = new CheckBox();
    }

    public Item(String description,String date, boolean selected)
    {
        this.description = description;
        this.date = date;
        this.status = new CheckBox();
        this.status.selectedProperty().setValue(selected);
    }

    public Item() {

    }

    //create setters and getters to be accessed elsewhere
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CheckBox getStatus() {
        return status;
    }

    public void setStatus(CheckBox status) {
        this.status = status;
    }
}