package dao.implementations;

import dao.interfaces.IStaffDao;
import entities.Diagnosis;
import entities.Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements IStaffDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_ROLE = "role";
    private Statement statement;

    public StaffDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Staff getStaff(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        String role = resultSet.getString(COLUMN_ROLE);
        return new Staff(id, name, role);
    }

    @Override
    public List<Staff> findAll() {
        String query = "SELECT * FROM staff";
        List<Staff> staffList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Staff staff = getStaff(resultSet);
                staffList.add(staff);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }

    @Override
    public Staff findById(long id) {
        String query = "SELECT * FROM staff WHERE staff.id=" + id;

        Staff staff = new Staff();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            staff = getStaff(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return staff;
    }

    @Override
    public Staff save(Staff staff) {
        String query = "INSERT INTO staff (name, role) VALUES (";
        query +="'"+staff.getName()+"','"+staff.getRole()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return staff;
    }

    @Override
    public Staff update(long id, Staff staff) {
        String query = "UPDATE staff SET name = '"+staff.getName() +"',role = '"+staff.getRole()+"' WHERE id="+id;


        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(long id) {
        String query = "DELETE FROM staff WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

}
