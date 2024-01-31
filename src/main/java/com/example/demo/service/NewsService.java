package com.example.demo.service;

import com.example.demo.repository.DatabaseHandler;
import com.example.demo.model.News;
import com.example.demo.model.Rubric;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public List<Rubric> getRubricsByLink(String link) throws SQLException {
        List<Rubric> rubrics = new ArrayList<>();

        try (ResultSet result = databaseHandler.getRubricsByLink(link)) {
            while (result.next()) {
                rubrics.add(new Rubric(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return rubrics;
    }

    public List<News> getNewsByParams(String sourse, String rubric, String date) throws SQLException {

        if (sourse != null && rubric != null && date != null) {
            return getNewsBySourseAndRubricAndDate(sourse, rubric, date);
        } else if (sourse != null && rubric != null) {
            return getNewsBySourseAndRubric(sourse, rubric);
        } else if (sourse != null && date != null) {
            return getNewsBySourseAndDate(sourse, date);
        } else if (rubric != null && date != null) {
            return getNewsByRubricAndDate(rubric, date);
        } else if (sourse != null) {
            return getNewsBySourse(sourse);
        } else if (rubric != null) {
            return getNewsByRubric(rubric);
        } else if (date != null) {
            return getNewsByDate(date);
        } else {
            return getNewsAll();
        }
    }

    private List<News> getNewsBySourseAndRubricAndDate(String sourse, String rubric, String date) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourseAndRubricAndDate(sourse, rubric, date)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsBySourseAndRubric(String sourse, String rubric) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourseAndRubric(sourse, rubric)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsBySourseAndDate(String sourse, String date) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourseAndDate(sourse, date)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsByRubricAndDate(String rubric, String date) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsByRubricAndDate(rubric, date)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsBySourse(String sourse) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourse(sourse)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsByRubric(String rubric) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsByRubric(rubric)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsByDate(String date) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsByDate(date)) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }

    private List<News> getNewsAll() throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsAll()) {
            while (result.next()) {
                news.add(new News(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        }

        return news;
    }
}
