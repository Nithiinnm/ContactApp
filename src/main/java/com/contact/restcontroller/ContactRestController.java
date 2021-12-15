package com.contact.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.bindings.ContactFormBinding;
import com.contact.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService contactService;
	
	
	@PostMapping(value = "/save")
	public String saveContacts(@RequestBody ContactFormBinding contactform) {
		System.out.println("contactform :"+contactform);
		String contactSave = contactService.save(contactform);
		return contactSave;
		
	}
	
	@GetMapping(value = "/getallcontacts")
	public List<ContactFormBinding> viewContacts(){
		List<ContactFormBinding> viewContacts = contactService.viewContacts();
		return viewContacts;
		
	}
	
	@GetMapping(value = "/getContact/{id}")
	public ContactFormBinding editById(@PathVariable("id") Integer id) {
		
		ContactFormBinding contactForm = contactService.editContact(id);
		return contactForm;
		
	}
	
	@DeleteMapping(value = "/deleteContact/{id}")
	public List<ContactFormBinding> deleteContact(@PathVariable("id") Integer id){
		
		List<ContactFormBinding> listofContacts = contactService.deleteContact(id);
		return listofContacts;
		
	}
}
