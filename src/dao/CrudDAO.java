package dao;

import java.util.ArrayList;

public interface CrudDAO<T ,ID> extends SuperDAO{
    boolean add(T t)throws Exception;

    boolean update(T t)throws Exception;

    boolean delete(ID t)throws Exception;

    T search(ID t)throws Exception;

    ArrayList<T> getAll()throws Exception;

    ArrayList<T> getSearch(ID t)throws Exception;

}
