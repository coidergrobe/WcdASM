package com.example.model;

import com.example.da.ProductDataAccess;

import java.sql.SQLException;

public class ProductCreateBean {
    private int id;
    private String name, description;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean createProduct () throws SQLException, ClassNotFoundException {
        return new ProductDataAccess().getInsertProducts(id, name, description);
    }

}
