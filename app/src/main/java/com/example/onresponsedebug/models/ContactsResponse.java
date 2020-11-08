package com.example.onresponsedebug.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactsResponse {
    @SerializedName("contacts")
    private List<Contact> contacts;

    public ContactsResponse(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
