package com.senla.bolkunets.virtualtestlab.controllers.userprofile;

import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.PersonInformationDto;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.PersonService;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import com.senla.bolkunets.virtualtestlab.security.holder.CurrentUserHolder;
import com.senla.bolkunets.virtualtestlab.security.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    private UserProfileService userProfileService;

    private CurrentUserHolder userHolder;

    private DozerBeanMapper dozerBeanMapper;

    public PersonController(PersonService personService, UserProfileService userProfileService, CurrentUserHolder userHolder, DozerBeanMapper dozerBeanMapper) {
        this.personService = personService;
        this.userProfileService = userProfileService;
        this.userHolder = userHolder;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public PersonInformationDto createPerson(@RequestBody PersonInformationDto personInformationDto) {

        Person person = dozerBeanMapper.map(personInformationDto, Person.class);

        User currentUser = userHolder.getCurrentUser();
        UserProfile userProfile = currentUser.getUserProfile();

        userProfile.setPerson(person);

        UserProfile updatedUserProfile = userProfileService.updateUserProfile(userProfile);

        Person savedPerson = updatedUserProfile.getPerson();

        return dozerBeanMapper.map(savedPerson, PersonInformationDto.class);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public PersonInformationDto deletePersonInformation() {

        User currentUser = userHolder.getCurrentUser();
        UserProfile userProfile = currentUser.getUserProfile();

        Person deletedPerson = userProfile.getPerson();

        userProfile.setPerson(null);

        userProfileService.updateUserProfile(userProfile);

        return dozerBeanMapper.map(deletedPerson, PersonInformationDto.class);

    }
	
	 @RequestMapping(value = "/get", method = RequestMethod.GET)
    public PersonInformationDto getPersonInformation() {

        User currentUser = userHolder.getCurrentUser();
        UserProfile userProfile = currentUser.getUserProfile();

        Person currenProfileUser = userProfile.getPerson();
		
		if(currenProfileUser!=null) {
			return dozerBeanMapper.map(currenProfileUser, PersonInformationDto.class);
		}
		
		return null;
       
    }
}
