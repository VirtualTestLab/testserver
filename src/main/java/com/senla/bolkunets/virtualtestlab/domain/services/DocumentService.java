package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.info.Document;

import java.util.List;

public interface DocumentService {

	Document createDocument(Document methodics);

	Document updateDocument(Document methodics);

	void deleteDocument(Document methodics);

	List<Document> getAllDocument();

	Document findById(Integer id);

}
