package dao.interfaces;

import entities.Drugs;

import java.util.List;

public interface IDrugsDao {
    List<Drugs> findAll();

    Drugs findById(long id);
    Drugs save(Drugs drugs);
    Drugs update(long id, Drugs drugs);
    void delete(long id);
}
