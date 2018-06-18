package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.info.Contact;

import java.util.List;

public interface ContactService {

	Contact createContact(Contact methodics);

	Contact updateContact(Contact methodics);

	void deleteContact(Contact methodics);

	List<Contact> getAllContact();

	Contact findById(Integer id);

}
