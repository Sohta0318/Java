package dev.lpa;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if (findContact(contact) != -1) {
            return false;
        } else {
            return myContacts.add(contact);
        }
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        if(this.findContact(oldContact) >= 0){
            int index = this.myContacts.indexOf(oldContact);
            this.myContacts.set(index, newContact);
//            this.myContacts.add(index, newContact);
            return true;
        }else{
            return false;
        }
    }
    public boolean removeContact(Contact contact){
        if(this.findContact(contact) >= 0){
            this.myContacts.remove(contact);
            return true;
        }else{
            return false;
        }
    }
    private int findContact(Contact contact){
        return findContact(contact.getName());
    }
    private int findContact(String name){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        int index = findContact(name);
        if(index != -1){
            return this.myContacts.get(index);
        }else {
            return null;
        }
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < this.myContacts.size(); i++){
            System.out.println(i+1 + ". " + myContacts.get(i).getName() + " -> " +  myContacts.get(i).getPhoneNumber());
        }
    }

    public static void main(String[] args) {

    }
}

class Contact{
private String name;
private String phoneNumber;
public Contact(String name, String phoneNumber){
    this.name = name;
    this.phoneNumber = phoneNumber;
}
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contact createContact(String name, String phoneNumber){
    return new Contact(name, phoneNumber);
    }
}
