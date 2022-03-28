package controller;

import business.BOFactory;
import business.ProductBO;
import business.ProductBOImpl;
import common.IDGenerator;
import entity.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductController implements Initializable {

    @FXML
    private TableView<Product> tableProduct;

    @FXML
    private TextField txtProID;

    @FXML
    private TextField txtProName;

    @FXML
    private TextField txtProPrice;

    @FXML
    private TextField txtProqty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setProduct();
            loadAllProduct();
            setClear();

        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void addProduct(ActionEvent event) throws Exception {

        try {
            String Product_id = txtProID.getText();
            String Product_name = txtProName.getText();
            String Product_Qty = txtProqty.getText();
            String Product_price = txtProPrice.getText();

            Product product = new Product(Product_id, Product_name, Product_Qty, Product_price);

            ProductBOImpl productBO = BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PRODUCT);
            boolean isProduct = productBO.add(product);
            if (isProduct) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated Sucsess..!", ButtonType.OK);
                alert.show();
                setProduct();
                loadAllProduct();
                setClear();
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deleteProduct(ActionEvent event) throws Exception {

        try {
            String id = txtProID.getText();

            ProductBO productBO = (ProductBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PRODUCT);
            boolean isDeleteProduct = productBO.delete(id);
            if (isDeleteProduct) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer Deleted success...!", ButtonType.OK);
                alert.show();
                loadAllProduct();
                setClear();
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchPro(ActionEvent event) throws Exception {
        try {
            String id = txtProID.getText();

            ProductBO productBO = (ProductBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PRODUCT);
            Product searchProduct = productBO.search(id);
            if (searchProduct != null) {
                txtProID.setText(searchProduct.getProduct_id());
                txtProName.setText(searchProduct.getProduct_name());
                txtProqty.setText(searchProduct.getProduct_Qty());
                txtProPrice.setText(searchProduct.getProduct_price());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "NO Such Customer..!", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    void updateProduct(ActionEvent event) throws Exception {

        try {
            String Product_id = txtProID.getText();
            String Product_name = txtProName.getText();
            String Product_Qty = txtProqty.getText();
            String Product_price = txtProPrice.getText();

            Product product = new Product(Product_id, Product_name, Product_Qty, Product_price);

            ProductBOImpl productBO = BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PRODUCT);
            boolean isProduct = productBO.update(product);
            System.out.println(isProduct);
            if (isProduct) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated Sucsess..!", ButtonType.OK);
                alert.show();
                setProduct();
                loadAllProduct();
                setClear();
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setProduct() throws Exception {
        try {
            String ProductID;
            ProductID = IDGenerator.getNewID("product", "Product_id", "P");
            txtProID.setText(ProductID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllProduct() throws Exception {
        ProductBO productBO = BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PRODUCT);
        ArrayList<Product> productBOAll = productBO.getAll();

        tableProduct.setItems(FXCollections.observableArrayList(productBOAll));

        tableProduct.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Product_id"));
        tableProduct.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Product_name"));
        tableProduct.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Product_Qty"));
        tableProduct.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Product_price"));
    }


    private void setClear() throws Exception {
        txtProName.clear();
        txtProqty.clear();
        txtProPrice.clear();
    }

    @FXML
    void tableProduct(MouseEvent event) {
        tableProduct.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                if (observable.getValue() != null) {
                    Product value = observable.getValue();
                    txtProID.setText(value.getProduct_id());
                    txtProName.setText(value.getProduct_name());
                    txtProqty.setText(value.getProduct_Qty());
                    txtProPrice.setText(value.getProduct_price());
                }

            }
        });

    }

    @FXML
    void btnHome(KeyEvent event) {

    }
}
