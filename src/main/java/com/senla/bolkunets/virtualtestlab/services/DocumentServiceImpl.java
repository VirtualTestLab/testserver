package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.info.DocumentDao;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Document;
import com.senla.bolkunets.virtualtestlab.domain.services.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	private DocumentDao documentDao;

	public DocumentServiceImpl(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@Override
	public Document createDocument(Document methodics) {
		return documentDao.create(methodics);
	}

	@Override
	public Document updateDocument(Document methodics) {
		return documentDao.update(methodics);
	}

	@Override
	public void deleteDocument(Document methodics) {
		documentDao.delete(methodics);
	}

	@Override
	public List<Document> getAllDocument() {
		return documentDao.readAll();
	}

	@Override
	public Document findById(Integer id) {
		return documentDao.read(id);
	}

}
