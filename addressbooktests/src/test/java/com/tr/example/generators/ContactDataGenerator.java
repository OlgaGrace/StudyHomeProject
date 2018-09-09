package com.tr.example.generators;

import com.tr.example.model.ContactData;
import com.tr.example.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count2 = Integer.parseInt(args[0]);
        File file = new File (args[1]);
        List<ContactData> contacts = GenerateContacts(count2);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData group: contacts){
            writer.write(String.format("%s;%s;%s\n", group.getFirstName(),group.getLastName(), group.getAddress()));
        }
        writer.close();
    }

    private static List<ContactData> GenerateContacts(int count2) {
        List <ContactData> contacts = new ArrayList<>();
        for (int i = 0;i < count2; i++){
            contacts.add(new ContactData().withFirstName(String.format("Name %s", i+1)).
                    withLastName(String.format("Last Name %s", i+1))
                    .withAddress(String.format("Address %s", i+1)));
        }
        return contacts;
    }

}


