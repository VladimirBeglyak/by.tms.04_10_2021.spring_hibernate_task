package by.beglyak.dao;

import by.beglyak.entity.Cinema;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("cinemaDaoBean")
public class CinemaDaoImpl implements BaseDao<Long, Cinema> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Cinema cinema) {
        Session session = sessionFactory.openSession();
        session.save(cinema);
    }

    @Override
    @Transactional
    public void update(Cinema cinema) {
        Session session = sessionFactory.openSession();
        session.update(cinema);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Query<Cinema> query = session.createQuery("delete from Cinema where id=:cinemaId");
        query.setParameter("cinemaId",id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Cinema getById(Long id) {
        Session session = sessionFactory.openSession();
        Cinema cinema = session.get(Cinema.class, id);
        return cinema;
    }

    @Override
    @Transactional
    public List<Cinema> getAllCinemas() {
        Session session = sessionFactory.openSession();
        Query<Cinema> query = session.createQuery("select c from Cinema c", Cinema.class);
        List<Cinema> allCinemas = query.getResultList();
        return allCinemas;
    }
}
