package com.senla.bolkunets.virtualtestlab.controllers.info;

import com.senla.bolkunets.virtualtestlab.controllers.dto.info.ContactDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.domain.model.info.Contact;
import com.senla.bolkunets.virtualtestlab.domain.services.ContactService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	private ContactService contactService;

	private DozerBeanMapper dozerBeanMapper;

	public ContactController(ContactService contactService, DozerBeanMapper dozerBeanMapper) {
		this.contactService = contactService;
		this.dozerBeanMapper = dozerBeanMapper;
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public ContactDto createContact(@RequestBody ContactDto documentDto){
		Contact contact = dozerBeanMapper.map(documentDto, Contact.class);
		Contact persistenceDoc = contactService.createContact(contact);
		return dozerBeanMapper.map(persistenceDoc, ContactDto.class);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseMessageDto deleteDocument(@PathVariable(value = "id") Integer id){
		Contact persistenceDoc = contactService.findById(id);
		contactService.deleteContact(persistenceDoc);
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setMessage(String.format("document with id=%s was deleted.", id));
		return responseMessageDto;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ContactDto updateDocument(@RequestBody ContactDto documentDto){
		Contact document = dozerBeanMapper.map(documentDto, Contact.class);
		Contact persistenceDoc = contactService.updateContact(document);
		return dozerBeanMapper.map(persistenceDoc, ContactDto.class);
	}


	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<ContactDto> getAllUsers(){
		List<ContactDto> response = new ArrayList<>();
		List<Contact> allDocument = contactService.getAllContact();
		allDocument.forEach(x-> response.add(dozerBeanMapper.map(x, ContactDto.class)));
		return response;
	}
}
