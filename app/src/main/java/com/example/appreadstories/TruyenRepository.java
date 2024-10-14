package com.example.appreadstories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TruyenRepository {

    private DatabaseHelper dbHelper;

    public TruyenRepository() {
        dbHelper = new DatabaseHelper();
    }

    public ArrayList<Truyen> getAllTruyen() {
        ArrayList<Truyen> truyenList = new ArrayList<>();
        Connection connection = dbHelper.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Truyen");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenTruyen = resultSet.getString("tenTruyen");
                String posterURL = resultSet.getString("posterURL");
                String moTa = resultSet.getString("moTa");

                Truyen truyen = new Truyen(id, tenTruyen, posterURL, moTa);
                truyenList.add(truyen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return truyenList;
    }
}
