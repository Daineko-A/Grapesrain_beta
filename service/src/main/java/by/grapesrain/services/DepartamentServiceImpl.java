package by.grapesrain.services;

import by.grapesrain.dao.DepartamentDao;
import by.grapesrain.entitys.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PloSkiY on 07.07.2017.
 */
@Service
@Transactional
public class DepartamentServiceImpl implements DepartamentService {

    private final DepartamentDao departamentDao;

    @Autowired
    public DepartamentServiceImpl(DepartamentDao departamentDao) {
        this.departamentDao = departamentDao;
    }

    @Override
    public List<Departament> allDepartaments() {
        return departamentDao.findAll();
    }

    @Override
    public Departament findById(long id) {
        return departamentDao.findById(id);
    }
}
