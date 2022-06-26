package dao.interfaces;

import entities.DiagnosisInfo;

import java.util.List;

public interface IDiagnosisInfoDao {
    List<DiagnosisInfo> findAll();

    DiagnosisInfo findById(long id);
    DiagnosisInfo save(DiagnosisInfo diagnosisInfo);
    DiagnosisInfo update(long id, DiagnosisInfo diagnosisInfo);
    void delete(long id);
}
