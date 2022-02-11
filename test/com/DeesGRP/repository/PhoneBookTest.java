package com.DeesGRP.repository;

import com.DeesGRP.model.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }



    @Test
    @DisplayName("Contact can be blocked")
    void accountCanBeBlocked(){
        //Given that
        PhoneBook phoneBook = new PhoneBook();
        Contact esther = new Contact("Esther", "90975674647");
        Contact adeola = new Contact("Adeola", "646464764746");
        List<Contact> contacts = new ArrayList<>(Arrays.asList(esther, adeola));
        phoneBook.setContacts(contacts);

        //When
        phoneBook.blockContact(esther.getId());

        //Assertion
        assertEquals(contacts.size(), 1);
        assertEquals(contacts.get(0).getFirstName(), adeola.getFirstName());
        assertEquals(contacts.get(0).getLastName(), adeola.getLastName());
        assertNotNull(contacts.get(0).getId());
        assertEquals(phoneBook.getBlockContact().size(), 1);
        assertTrue(phoneBook.getBlockContact().get(0).isBlock());
    }

    @Test
    @DisplayName("Contact can be added to the phonebook")
    public void contactCanBeAdded(){
        //Given that
            // I have a phonebook and a contact
        PhoneBook phoneBook = new PhoneBook();
        Contact mongoDB = new Contact("Abdullahi", "56891234091");

        //when i add contact to the phonebook
        phoneBook.addContact(mongoDB);

        //check that contact has been added
        //Todo add more test cases for better validation
        assertEquals(1, phoneBook.getContactCount());
    }

        @Test

    void testContactListCanBeGotten(){
        //given that we have a phonebook and contacts
        PhoneBook phoneBook = new PhoneBook();
        Contact lota = new Contact("lota","09056819817");
        Contact dee = new Contact("dee","09056819817");
        //when we have contacts in it
        phoneBook.addContact(lota);
        phoneBook.addContact(dee);
        //assert
        assertEquals(2, phoneBook.getAllContact().size());
        List<Contact> expected = new ArrayList<>(Arrays.asList(lota, dee));  //{lota, dee}.toArray() [lota,dee]
        assertArrayEquals(expected.toArray(), phoneBook.getAllContact().toArray());
    }



}