package dao.interfaces;


import entities.Surgeries;

import java.util.List;

public interface ISurgeriesDao {
    List<Surgeries> findAll();

    Surgeries findById(long id);
    Surgeries save(Surgeries surgeries);
    Surgeries update(long id, Surgeries surgeries);
    void delete(long id);
}
