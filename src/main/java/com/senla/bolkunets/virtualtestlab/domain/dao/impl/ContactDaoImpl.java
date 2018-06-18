package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.info.ContactDao;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl extends AbstractDao<Integer, Contact> implements ContactDao {
	public ContactDaoImpl() {
		super(Contact.class);
	}
}
