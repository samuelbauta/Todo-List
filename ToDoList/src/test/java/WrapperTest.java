/*
UCF COP3330 Fall 2021 Application Assignment 1 Solution
 Copyright 2021 Samuel Bauta
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WrapperTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void addItem() {
        Wrapper wrapper = new Wrapper();
        Item item = new Item("2001/01/01","testing",true);
        wrapper.getList().add(item);
        assertTrue(wrapper.list.contains(item));
    }

    @Test
    void editItem() {
    }

    @Test
    void itemStatus() {
    }

    @Test
    void removeItem() {
    }

    @Test
    void clearList() {
    }

    @Test
    void saveList() {
    }

    @Test
    void openList() {
    }

    @Test
    void loadList() {
    }
}