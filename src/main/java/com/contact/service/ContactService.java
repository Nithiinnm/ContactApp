package com.contact.service;

import java.util.List;

import com.contact.bindings.ContactFormBinding;

public interface ContactService {

	public String save(ContactFormBinding contactForm);
	
	public List<ContactFormBinding> viewContacts();
	
	public ContactFormBinding editContact(Integer id);
	
	public List<ContactFormBinding> deleteContact(Integer id);
	
}
