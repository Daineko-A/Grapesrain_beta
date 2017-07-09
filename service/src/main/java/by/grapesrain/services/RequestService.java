package by.grapesrain.services;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;

import java.util.List;

/**
 * Created by PloSkiY on 06.07.2017.
 */
public interface RequestService {

    List<Request> allRequests();

    Request findById(long id);

    List<Request> findRequestsByDepartament(Departament departament);
}
