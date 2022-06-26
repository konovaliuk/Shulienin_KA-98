package dao.implementations;

import dao.interfaces.IDrugsDao;
import entities.Drugs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrugsDaoImpl implements IDrugsDao {

    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";
    private Statement statement;

    public DrugsDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Drugs getDrugs(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String name = resultSet.getString(COLUMN_NAME);
        return new Drugs(id, name);
    }

    @Override
    public List<Drugs> findAll() {
        String query = "SELECT * FROM drugs";
        List<Drugs> drugsList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Drugs drugs = getDrugs(resultSet);
                drugsList.add(drugs);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return drugsList;
    }

    @Override
    public Drugs findById(long id) {
        String query = "SELECT * FROM drugs WHERE drugs.id=" + id;

        Drugs drugs = new Drugs();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            drugs = getDrugs(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }

    @Override
    public Drugs save(Drugs drugs) {
        String query = "INSERT INTO drugs (name) VALUES (";
        query +="'"+drugs.getName()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return drugs;
    }

    @Override
    public Drugs update(long id, Drugs drugs) {
        String query = "UPDATE drugs SET name = '"+drugs.getName() +"' WHERE id="+id;


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
        String query = "DELETE FROM drugs WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }
}
