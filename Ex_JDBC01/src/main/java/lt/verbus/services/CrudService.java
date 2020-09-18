package lt.verbus.services;

import java.sql.SQLException;
import java.util.List;

public interface CrudService<T> {

    List<T> findAll() throws SQLException;

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

}
