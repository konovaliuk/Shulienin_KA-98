package dao.interfaces;

import entities.Patiens;

import java.util.List;

public interface IPatiensDao {
    List<Patiens> findAll();

    Patiens findById(long id);
    Patiens save(Patiens patiens);
    Patiens update(long id, Patiens patiens);
    void delete(long id);
}
