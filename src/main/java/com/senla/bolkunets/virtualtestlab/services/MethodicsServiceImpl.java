package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.PassingFactDao;
import com.senla.bolkunets.virtualtestlab.domain.dao.user.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MethodicsServiceImpl implements MethodicsService {


    private MethodicsDao methodicsDao;

    private UserProfileDao userProfileDao;

    private PassingFactDao passingFactDao;

    public MethodicsServiceImpl(PassingFactDao passingFactDao, MethodicsDao methodicsDao, UserProfileDao userProfileDao) {
        this.methodicsDao = methodicsDao;
        this.userProfileDao = userProfileDao;
        this.passingFactDao = passingFactDao;
    }

    public Methodics createMethodics(Methodics methodics) {
       return methodicsDao.create(methodics);
    }

    @Override
    public Methodics updateMethodics(Methodics methodics) {
        return methodicsDao.update(methodics);
    }

    public void deleteMethodics(Methodics methodics) {
        methodicsDao.delete(methodics);
    }

    public List<Methodics> getAllMethodics() {
        return methodicsDao.readAll();
    }

    public Methodics findById(Integer id) {
        return methodicsDao.read(id);
    }

    public List<Methodics> getAssignedMethodicsByUserProfile(Integer userProfileId) {
        UserProfile userProfile = userProfileDao.read(userProfileId);
        if(userProfile!=null){
            List<Methodics> methodicsList = userProfile.getOpenMethodicsForUser();
            methodicsList.size();
            return methodicsList;
        }
        return null;
    }

    public List<Methodics> getPassedMethodicsByUserProfile(Integer userProfileId) {
        UserProfile userProfile = userProfileDao.read(userProfileId);
        if(userProfile!=null){
            List<Integer> methodicsPassingIds = passingFactDao.findPassingMethodicsByUserId(userProfileId).stream().map(x -> x.getMethodicsId()).collect(Collectors.toList());
            List<Methodics> methodicsList = userProfile.getOpenMethodicsForUser();
            methodicsList.size();
            return methodicsList.stream().filter(
                    methodics -> methodicsPassingIds.contains(methodics.getId())
            ).collect(Collectors.toList());
        }
        return null;
    }

    public List<Methodics> getNoPassedMethodicsByUserProfile(Integer userProfileId) {
        UserProfile userProfile = userProfileDao.read(userProfileId);
        if(userProfile!=null){
            List<Integer> methodicsPassingIds = passingFactDao.findPassingMethodicsByUserId(userProfileId).stream().map(x -> x.getMethodicsId()).collect(Collectors.toList());
            List<Methodics> methodicsList = userProfile.getOpenMethodicsForUser();
            methodicsList.size();
            return methodicsList.stream().filter(
                    methodics -> !methodicsPassingIds.contains(methodics.getId())
            ).collect(Collectors.toList());
        }
        return null;
    }

    public void deleteMethodicsById(Integer id) {
        methodicsDao.deleteById(id);
    }

    public Methodics getMethodicsWithQuestions(Integer id) {
        return methodicsDao.getMethodicsWithQuastions(id);
    }

    public Methodics getFullMethodics(Integer id){
        return methodicsDao.readFullMethodics(id);
    }


}
