package dao;

import dao.entity.Entity;

import java.util.List;

/**
 * Created by Denis on 23.04.2018.
 */
public interface AbstractDao<T extends Entity> {
    List<T> getAll();

    List<T> getByForeignKey(int key);

    T getById(int primaryKey);

    void addByForeignKey(T t);

    void removeById(int primaryKey);
}
