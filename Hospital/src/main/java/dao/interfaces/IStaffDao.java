package dao.interfaces;


import entities.Staff;

import java.util.List;

public interface IStaffDao {
    List<Staff> findAll();

    Staff findById(long id);
    Staff save(Staff staff);
    Staff update(long id, Staff staff);
    void delete(long id);
}
