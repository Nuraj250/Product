package business;

import dao.DAOFactory;
import dao.ProductDAO;
import entity.Product;


import java.util.ArrayList;


public class ProductBOImpl implements ProductBO {

    private ProductDAO productDAO;

    public ProductBOImpl() throws Exception {
        productDAO = (ProductDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.PRODUCT);

    }
    @Override
    public boolean add(Product productDto) throws Exception {
        return productDAO.add(productDto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return productDAO.delete(id);
    }

    @Override
    public Product search(String id) throws Exception {
        return productDAO.search(id);
    }

    @Override
    public boolean update(Product productDto) throws Exception {
        return productDAO.update(productDto);
    }

    @Override
    public ArrayList<Product> getAll() throws Exception {
        return productDAO.getAll();
    }
}

