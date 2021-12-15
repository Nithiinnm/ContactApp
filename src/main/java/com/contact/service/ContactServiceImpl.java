package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.bindings.ContactFormBinding;
import com.contact.entites.Contact;
import com.contact.repository.ContactRespositary;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRespositary contactRepo;

	@Override
	public String save(ContactFormBinding contactForm) {
		
		//We are receiving the data in binding. But we need a Entity to save data in DB.
		//So we need to copy data from one obj to another.
		//Property Name should be Same in Entity and Binding class.
		
		Contact entity = new Contact();
		contactForm.setActiveSw("Y");
		BeanUtils.copyProperties(contactForm, entity);
		Contact contactObj = contactRepo.save(entity);
		System.out.println("contactObj :"+contactObj);
		if(contactObj.getContactId() != null) {
			
			return "Contact Saved Successfully";
		}
		
		return "Failure ";
	}

	@Override
	public List<ContactFormBinding> viewContacts() {
		
		List<ContactFormBinding> dataList = new ArrayList<>();
		
		List<Contact> contactList = contactRepo.findAll();
		
		for(Contact entity : contactList) {
			ContactFormBinding formObj = new ContactFormBinding();
			BeanUtils.copyProperties(entity, formObj);
			dataList.add(formObj);
			
		}
		return dataList;
		
	}

	@Override
	public ContactFormBinding editContact(Integer id) {
		
		System.out.println("Id :"+id);
		ContactFormBinding formObj = new ContactFormBinding();
		
		Optional<Contact> findById = contactRepo.findById(id);
		System.out.println("findById :"+findById);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			System.out.println("contact :"+contact);
			BeanUtils.copyProperties(contact, formObj);
			return formObj ;
		}
		
		return null;
	}

	@Override
	public List<ContactFormBinding> deleteContact(Integer id) {

		contactRepo.deleteById(id);
		return viewContacts();
	}

}
