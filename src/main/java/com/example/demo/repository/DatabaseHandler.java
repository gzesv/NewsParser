package com.example.demo.repository;

import java.sql.*;

public class DatabaseHandler {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USERNAME = "postgres";

    private static final String DB_PASSWORD = "1234";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public ResultSet selectLinkId(String link) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT id " +
                "FROM public.link " +
                "WHERE name = \'" + link + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getRubricsByLink(String link) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT h.id, h.name, h.href, h.link_id " +
                "FROM public.heading as h " +
                "JOIN public.link as l ON h.link_id = l.id " +
                "WHERE l.name = \'" + link + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsBySourceAndRubricAndDate(String source, String rubric, String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + source + "\'" +
                "AND h.name = \'" + rubric + "\'" +
                "AND n.date = \'" + date + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsBySourceAndRubric(String source, String rubric) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + source + "\'" +
                "AND h.name = \'" + rubric + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsBySourceAndDate(String source, String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + source + "\'" +
                "AND n.date = \'" + date + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsByRubricAndDate(String rubric, String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "WHERE h.name = \'" + rubric + "\'" +
                "AND n.date = \'" + date + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsBySource(String source) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + source + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsByRubric(String rubric) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "WHERE h.name = \'" + rubric + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsByDate(String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "WHERE n.date = \'" + date + "\'";

        return statement.executeQuery(sqlQuery);
    }

    public ResultSet getNewsAll() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT id, name, date, heading_id " +
                "FROM public.news ";

        return statement.executeQuery(sqlQuery);
    }

}
