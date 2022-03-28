package dao;

import entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;


public class ProductDAOImpl implements ProductDAO {


    @Override
    public boolean add(Product product) throws Exception {
        String sql = "INSERT INTO product VALUES(?,?,?,?)";
        return CrudOperation.executeUpdate(sql,
                product.getProduct_id(),
                product.getProduct_name(),
                product.getProduct_Qty(),
                product.getProduct_price());
    }

    @Override
    public boolean update(Product product) throws Exception {
        String sql = "UPDATE product set Product_name = ? , Product_Qty = ? ,Product_price = ? where Product_id = ?";
        return CrudOperation.executeUpdate(sql,
                product.getProduct_name(),
                product.getProduct_Qty(),
                product.getProduct_price(),
                product.getProduct_id());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE from product where Product_id = ?";
        return CrudOperation.executeUpdate(sql, id);
    }

    @Override
    public Product search(String id) throws Exception {
        Product product = null;
        String sql = "Select * from product where Product_id = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        while (rst.next()) {
            product = new Product(
                    rst.getString("Product_id"),
                    rst.getString("Product_name"),
                    rst.getString("Product_Qty"),
                    rst.getString("Product_price")
            );
        }
        return product;
    }

    @Override
    public ArrayList<Product> getAll() throws Exception {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * from product";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            products.add(new Product(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return products;
    }

    @Override
    public ArrayList<Product> getSearch(String t) throws Exception {
        return null;
    }

}
