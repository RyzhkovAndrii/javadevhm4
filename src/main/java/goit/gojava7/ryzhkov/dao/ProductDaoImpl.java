package goit.gojava7.ryzhkov.dao;

import goit.gojava7.ryzhkov.model.Product;

import java.util.UUID;

public class ProductDaoImpl extends HibernateDao<Product, UUID> implements ProductDao {

    public ProductDaoImpl() {
        setType(Product.class);
    }

}
