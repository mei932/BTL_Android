package com.example.appreadstories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ChapterRepository {

    private DatabaseHelper dbHelper;

    public ChapterRepository() {
        dbHelper = new DatabaseHelper();
    }

    public ArrayList<Chapter> getChaptersByTruyenId(int truyenId) {
        ArrayList<Chapter> chapterList = new ArrayList<>();
        Connection connection = dbHelper.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Chapter WHERE idTruyen = " + truyenId);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idTruyen = resultSet.getInt("idTruyen");
                String tenChapter = resultSet.getString("tenChapter");
                String linkChapter = resultSet.getString("linkChapter");

                Chapter chapter = new Chapter(id, idTruyen, tenChapter, linkChapter);
                chapterList.add(chapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return chapterList;
    }
}
