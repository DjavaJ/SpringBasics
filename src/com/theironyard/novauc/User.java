package com.theironyard.novauc;

import java.util.ArrayList;

/**
 * Created by dangelojoyce on 2/28/17.
 */
public class User {

    String name;
    ArrayList<String> messages = new ArrayList();
    //String password;


    public User(String name) {
        this.name = name;
    }

    public ArrayList getMessages() {
        return messages;
    }

    public void setMessages(ArrayList messages) {
        this.messages = messages;
    }

    public User (ArrayList messages){
        this.messages = messages;
    }

    public User(String name, ArrayList messages) {
        this.name = name;
        this.messages = messages;
        //this.password = password;
    }
}




