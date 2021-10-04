package by.beglyak.service;

import by.beglyak.dao.BaseDao;
import by.beglyak.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cinemaService")
public class CinemaServiceImpl implements ServiceDao<Long, Cinema> {

    @Autowired
    @Qualifier("cinemaDaoBean")
    private BaseDao<Long,Cinema> baseDao;

    @Override
    @Transactional
    public void save(Cinema cinema) {
        baseDao.save(cinema);
    }

    @Override
    @Transactional
    public void update(Cinema cinema) {
        baseDao.update(cinema);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        baseDao.delete(id);
    }

    @Override
    @Transactional
    public Cinema getById(Long id) {
        return baseDao.getById(id);
    }

    @Override
    @Transactional
    public List<Cinema> getAll() {
        return baseDao.getAllCinemas();
    }
}
