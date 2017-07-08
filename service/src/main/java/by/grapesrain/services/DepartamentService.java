package by.grapesrain.services;

import by.grapesrain.entitys.Departament;

import java.util.List;

/**
 * Created by PloSkiY on 07.07.2017.
 */
public interface DepartamentService {

    List<Departament> allDepartaments();

    Departament findById(long id);
}
