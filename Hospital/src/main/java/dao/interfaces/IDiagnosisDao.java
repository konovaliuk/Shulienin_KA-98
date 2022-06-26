package dao.interfaces;

import entities.Diagnosis;

import java.util.List;

public interface IDiagnosisDao {
    List<Diagnosis> findAll();

    Diagnosis findById(long id);
    Diagnosis save(Diagnosis diagnosis);
    Diagnosis update(long id, Diagnosis diagnosis);
    void delete(long id);
}
