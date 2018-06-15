package com.senla.bolkunets.virtualtestlab.domain.dao.methodics;

import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;

public interface MethodicsDao extends GenericDao<Integer, Methodics> {

    Methodics getMethodicsByName(String name);

    Methodics getMethodicsWithQuastions(Integer id);

    void deleteById(Integer id);

    Methodics readFullMethodics(Integer id);
}
