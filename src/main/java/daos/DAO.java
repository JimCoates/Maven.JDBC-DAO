package daos;

import java.util.List;
import java.util.Set;

public interface DAO <T> {
    public T findByID(Integer SKU);

    public Set findAll();

    public Boolean update(T dto);

    public Boolean create(T dto);

    public Boolean delete(int id);
}
