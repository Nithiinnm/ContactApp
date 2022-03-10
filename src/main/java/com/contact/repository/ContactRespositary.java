
package com.contact.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.entites.Contact;

public interface ContactRespositary extends JpaRepository<Contact, Serializable> {
	
	
	//We can mention Serializable(or Integer) for all the datatypes(genrics). 

}
