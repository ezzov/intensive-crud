package web.dao.abtr;

import java.util.List;

public interface AbstrDao<T,K> {

    List<T> getAll();

    T getById(K id);

    void save(T obj);

    void update(T obj);

    void delete(K id);

}
