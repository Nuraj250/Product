package business;

import entity.Product;

import java.util.ArrayList;

public interface ProductBO extends SuperBo {
    boolean add(Product productDto) throws Exception;

    boolean delete(String id) throws Exception;

    Product search(String id) throws Exception;

    boolean update(Product productDto) throws Exception;

    ArrayList<Product> getAll() throws Exception;
}
