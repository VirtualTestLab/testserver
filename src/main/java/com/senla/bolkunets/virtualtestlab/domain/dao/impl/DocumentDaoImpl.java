package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.info.DocumentDao;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Document;

public class DocumentDaoImpl extends AbstractDao<Integer, Document> implements DocumentDao {
	public DocumentDaoImpl(Class<Document> type) {
		super(type);
	}
}
