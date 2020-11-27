package lt.verbus.repository;

import lt.verbus.model.BaseEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface CrudRepository<ID, T extends BaseEntity> {

    Map<ID, T> findAll() throws SQLException, IOException;

    T findById(ID id);

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t);

}
