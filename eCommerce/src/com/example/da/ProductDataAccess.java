package com.example.da;

import com.example.entity.Product;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDataAccess {
    private PreparedStatement searchStatement;
    private PreparedStatement insertStatement;

    public PreparedStatement getSearchStatement() throws SQLException, ClassNotFoundException {
        if (searchStatement==null) {
            // 2. Ket noi
            Connection connection = new DBConnection().getConnection();

            // 3. Tao statement

            searchStatement = connection
                    .prepareStatement("SELECT * FROM product WHERE name LiKE ?");
        }
        return searchStatement;
    }

    public List<Product> getProductsByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getSearchStatement();

        // Process

        statement.setString(1,"%"+name+"%");

        // Tra ve ket qua cua query
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new LinkedList<>();

        while(resultSet.next()){
            products.add(new Product(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("description")));
        }

        return products;
    }

    public PreparedStatement getInsertStatement() throws SQLException, ClassNotFoundException {
        if(insertStatement == null){
            Connection connection = new DBConnection().getConnection();

            insertStatement = connection.
                    prepareStatement("INSERT INTO `product`(`id`, `name`, `description`) VALUES (?,?,?)");
        }
        return insertStatement;
    }

    public boolean getInsertProducts(int id, String name, String description) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getInsertStatement();

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, description);

        int resultSet = statement.executeUpdate();
        if(resultSet == 1){
            return true;
        }else{
            return false;
        }

    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        if(productList!=null){
//            System.out.println("Succeed");
//        }
//    }
}
