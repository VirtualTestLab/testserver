package com.senla.bolkunets.virtualtestlab.controllers.userprofile;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.UserProfileDto;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    private UserProfileService userProfileService;

    private DozerBeanMapper dozerBeanMapper;

    public UserProfileController(UserProfileService userProfileService, DozerBeanMapper dozerBeanMapper) {
        this.userProfileService = userProfileService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public UserProfileDto createUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfile userProfile = dozerBeanMapper.map(userProfileDto, UserProfile.class);
        UserProfile persistUserProfile = userProfileService.createUserProfile(userProfile);
        UserProfileDto responseUserProfile = dozerBeanMapper.map(persistUserProfile, UserProfileDto.class);
        return responseUserProfile;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseMessageDto deleteUserProfile(@PathVariable(value = "id") Integer id){
        userProfileService.deleteUserProfileById(id);
        ResponseMessageDto responseMessageDto = new ResponseMessageDto();
        responseMessageDto.setMessage(String.format("user with id=%s was deleted.", id));
        return responseMessageDto;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UserProfileDto updateUser(@RequestBody UserProfileDto userProfileDto){
        UserProfile userProfile = dozerBeanMapper.map(userProfileDto, UserProfile.class);
        UserProfile updatedProfile = userProfileService.updateUserProfile(userProfile);
        return dozerBeanMapper.map(updatedProfile, UserProfileDto.class);
    }


    @RequestMapping(value = "get/{login}", method = RequestMethod.GET)
    public UserProfileDto getUsersByLogin(@PathVariable String login){
        UserProfile userProfile = userProfileService.findUserProfileByLogin(login);
        UserProfileDto userProfileDto = dozerBeanMapper.map(userProfile, UserProfileDto.class);
        return userProfileDto;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<UserProfileDto> getAllUsers(){
        List<UserProfileDto> response = new ArrayList<>();
        List<UserProfile> userProfile = userProfileService.getUsers();
        userProfile.forEach(x-> response.add(dozerBeanMapper.map(x, UserProfileDto.class)));
        return response;
    }

}
