package com.tr.example.model;

import java.io.File;

public class ContactData {
    private  String firstName;
    private  String lastName;
    private  String address;
    //private File photo;
   // private String group;

  //  public String getGroup() {
 //       return group;
 //   }

  //  public ContactData withGroup(String group) {
  //      this.group = group;
  //      return this;

 //   }

 //   public File getPhoto() {
    //    return photo;
   // }

 //   public ContactData withPhoto(File photo) {
  //      this.photo = photo;
  //      return this;
   // }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
