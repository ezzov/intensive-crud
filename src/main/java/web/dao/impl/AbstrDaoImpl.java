package web.dao.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import web.dao.abtr.AbstrDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@NoArgsConstructor
public abstract class AbstrDaoImpl<T,K> implements AbstrDao<T,K> {

    Class<T> typeClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<T> getAll() {
        return (List<T>) entityManager.createQuery("from " + typeClass.getSimpleName()).getResultList();
    }

    @Override
    public T getById(K id) {
        return entityManager.find(typeClass, id);
    }

    @Override
    public void save(T obj) {
        entityManager.persist(obj);
    }

    @Override
    public void update(T obj) {
        entityManager.merge(obj);
    }

    @Override
    public void delete(T obj) {
        entityManager.remove(obj);
    }
}
