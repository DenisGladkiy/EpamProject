package mvc.model.dao;

import java.util.List;

/**
 * Created by Denis on 27.04.2018.
 */
public interface AbstractDao<T> {

    List<T> getAll();

    T getById(int id);

    boolean insert(T t);

    boolean update(T t);

    boolean delete(T t);

    boolean isExist(T t);
}
