package models;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public Contact getContact(int index) {
        return new ArrayList<Contact>().get(index);
    }

    public void setContact(Contact contacts, int index) {
        Contact contact = new ArrayList<Contact>().set(index, contacts);
    }

    public void addContact(Contact contact){
            contacts.add(contact);
    }
    public void removeContact(String contactName){
        if (contacts.isEmpty()){
            throw new IllegalStateException("There are no contacts in the list.");
        }
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(contactName));
    }

    public String toString(){
        String temp = "";
        for (Contact contact: contacts) {
            temp += contact.toString();
            temp += "\n\n";
        }

        return temp;
    }
}
