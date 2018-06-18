package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.info.DocumentDao;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Document;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDaoImpl extends AbstractDao<Integer, Document> implements DocumentDao {
	public DocumentDaoImpl(Class<Document> type) {
		super(type);
	}
}
