package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.info.ContactDao;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Contact;
import com.senla.bolkunets.virtualtestlab.domain.services.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao;

	public ContactServiceImpl(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public Contact createContact(Contact methodics) {
		return contactDao.create(methodics);
	}

	@Override
	public Contact updateContact(Contact methodics) {
		return contactDao.update(methodics);
	}

	@Override
	public void deleteContact(Contact methodics) {
		contactDao.delete(methodics);
	}

	@Override
	public List<Contact> getAllContact() {
		return contactDao.readAll();
	}

	@Override
	public Contact findById(Integer id) {
		return contactDao.read(id);
	}
}
