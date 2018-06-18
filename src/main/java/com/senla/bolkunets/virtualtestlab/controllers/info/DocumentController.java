package com.senla.bolkunets.virtualtestlab.controllers.info;

import com.senla.bolkunets.virtualtestlab.controllers.dto.info.DocumentDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.UserProfileDto;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Document;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.DocumentService;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/documents")
public class DocumentController {
	private DocumentService documentService;

	private DozerBeanMapper dozerBeanMapper;

	public DocumentController(DocumentService documentService, DozerBeanMapper dozerBeanMapper) {
		this.documentService = documentService;
		this.dozerBeanMapper = dozerBeanMapper;
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public DocumentDto createDocument(@RequestBody DocumentDto documentDto){
		Document document = dozerBeanMapper.map(documentDto, Document.class);
		Document persistenceDoc = documentService.createDocument(document);
		return dozerBeanMapper.map(persistenceDoc, DocumentDto.class);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseMessageDto deleteDocument(@PathVariable(value = "id") Integer id){
		Document persistenceDoc = documentService.findById(id);
		documentService.deleteDocument(persistenceDoc);
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setMessage(String.format("document with id=%s was deleted.", id));
		return responseMessageDto;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public DocumentDto updateDocument(@RequestBody DocumentDto documentDto){
		Document document = dozerBeanMapper.map(documentDto, Document.class);
		Document persistenceDoc = documentService.updateDocument(document);
		return dozerBeanMapper.map(persistenceDoc, DocumentDto.class);
	}


	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<DocumentDto> getAllUsers(){
		List<DocumentDto> response = new ArrayList<>();
		List<Document> allDocument = documentService.getAllDocument();
		allDocument.forEach(x-> response.add(dozerBeanMapper.map(x, DocumentDto.class)));
		return response;
	}
}
