package by.beglyak.dao;

import by.beglyak.entity.Cinema;

import java.util.List;

public interface BaseDao <I,E>{
    void save(E e);
    void update(E e);
    void delete(I id);
    Cinema getById(I id);
    List<E> getAllCinemas();
}
