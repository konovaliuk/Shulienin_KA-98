package dao.interfaces;


import entities.Procedures;

import java.util.List;

public interface IProceduresDao {
    List<Procedures> findAll();

    Procedures findById(long id);
    Procedures save(Procedures procedures);
    Procedures update(long id, Procedures procedures);
    void delete(long id);
}
