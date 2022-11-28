package web.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.abtr.AbstrDao;
import web.service.abstr.AbstrService;

import java.util.List;

@Service
@NoArgsConstructor
public abstract class AbstrServiceImpl<T, K> implements AbstrService<T, K> {

    private AbstrDao<T, K> dao;

    @Autowired
    public AbstrServiceImpl(AbstrDao<T, K> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public T getById(K id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void save(T obj) {
        dao.save(obj);
    }

    @Override
    @Transactional
    public void update(T obj) {
        dao.update(obj);
    }

    @Override
    @Transactional
    public void delete(K id) {
        dao.delete(id);
    }
}
