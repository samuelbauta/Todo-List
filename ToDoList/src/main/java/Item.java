/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Samuel Bauta
 */

/*
This is the item class, basically, this class contains the only inputs for data which are
description and date, I'm still looking into how to implement a mark as complete section

for right now in my FXML I simply have it as a button but embedding a checkbox into a third
column may be a possibility I explore. I'm kind of saving it for last, but depending on which
approach I take the Item class may be altered by the second commit
 */

import java.time.LocalDate;

public class Item {

    private String description = null;
    private String date = null;

    public Item(){

    }

    public Item(String description, String date){
        this.description = description;
        this.date = date;
    }

    public Item(String text, LocalDate value) {

    }

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

}
