package by.beglyak.dao;

import by.beglyak.entity.Cinema;
import by.beglyak.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("filmDaoBean")
public class FilmDaoImpl implements BaseDao<Long, Film>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Film film) {
        Session session = sessionFactory.openSession();
        session.save(film);
    }

    @Override
    public void update(Film film) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Cinema getById(Long id) {
        return null;
    }

    @Override
    public List<Film> getAllCinemas() {
        return null;
    }
}
