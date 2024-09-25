package logic.DAO;

import model.Chef;

import java.util.List;

public class DAOChefImpl implements DAOInterface<Chef>{
    private static final String SELECT_ALL_CHEF = "SELECT * FROM chef";
    private static final String SELECT_QUERY = "SELECT * FROM chef WHERE iduser=?";
    private static final String INSERT_QUERY = "INSERT INTO chef (iduser,restaurant,bestdish,city) VALUES (?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE chef SET iduser = ?, restaurant = ?,bestdish = ?, city = ? WHERE iduser=?";
    private static final String DELETE_QUERY = "DELETE FROM chef WHERE iduser=?";

    @Override
    public Chef get(long id) {
        return null;
    }

    @Override
    public List<Chef> getAll() {
        return List.of();
    }

    @Override
    public void save(Chef chef) {

    }

    @Override
    public void update(Chef chef) {

    }

    @Override
    public void delete(Chef chef) {

    }
}
