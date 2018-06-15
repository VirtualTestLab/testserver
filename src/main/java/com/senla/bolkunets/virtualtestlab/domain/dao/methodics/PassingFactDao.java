package com.senla.bolkunets.virtualtestlab.domain.dao.methodics;


import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;

import java.util.List;

public interface PassingFactDao extends GenericDao<Integer, PassingFact> {
     List<PassingFact> findByMethodicsIdWithValues(Integer methodicsId);
     List<PassingFact> findPassingMethodicsByUserId(Integer userId);

     PassingFact findPassingMethodicsForUser(Integer methodicsId, Integer userId);
}
