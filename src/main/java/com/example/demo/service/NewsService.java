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

    public List<News> getNewsByParams(String source, String rubric, String date) throws SQLException {

        if (source != null && rubric != null && date != null) {
            return getNewsBySourceAndRubricAndDate(source, rubric, date);
        } else if (source != null && rubric != null) {
            return getNewsBySourceAndRubric(source, rubric);
        } else if (source != null && date != null) {
            return getNewsBySourceAndDate(source, date);
        } else if (rubric != null && date != null) {
            return getNewsByRubricAndDate(rubric, date);
        } else if (source != null) {
            return getNewsBySource(source);
        } else if (rubric != null) {
            return getNewsByRubric(rubric);
        } else if (date != null) {
            return getNewsByDate(date);
        } else {
            return getNewsAll();
        }
    }

    private List<News> getNewsBySourceAndRubricAndDate(String source, String rubric, String date) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourceAndRubricAndDate(source, rubric, date)) {
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

    private List<News> getNewsBySourceAndRubric(String source, String rubric) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourceAndRubric(source, rubric)) {
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

    private List<News> getNewsBySourceAndDate(String source, String date) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySourceAndDate(source, date)) {
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

    private List<News> getNewsBySource(String source) throws SQLException {
        List<News> news = new ArrayList<>();

        try (ResultSet result = databaseHandler.getNewsBySource(source)) {
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
