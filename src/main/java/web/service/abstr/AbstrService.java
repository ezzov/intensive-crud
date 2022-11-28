package web.service.abstr;

import java.util.List;

public interface AbstrService<T, K> {

    List<T> getAll();

    T getById(K id);

    void save(T obj);

    void update(T obj);

    void delete(T obj);

}
