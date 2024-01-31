package com.example.demo.repository;

import java.sql.*;

public class DatabaseHandler {

    private static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static String DB_USERNAME = "postgres";

    private static String DB_PASSWORD = "1234";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public ResultSet selectLinkId(String link) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT id " +
                "FROM public.link " +
                "WHERE name = \'" + link + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getRubricsByLink(String link) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT h.id, h.name, h.href, h.link_id " +
                "FROM public.heading as h " +
                "JOIN public.link as l ON h.link_id = l.id " +
                "WHERE l.name = \'" + link + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsBySourseAndRubricAndDate(String sourse, String rubric, String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + sourse + "\'" +
                "AND h.name = \'" + rubric + "\'" +
                "AND n.date = \'" + date + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsBySourseAndRubric(String sourse, String rubric) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + sourse + "\'" +
                "AND h.name = \'" + rubric + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsBySourseAndDate(String sourse, String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + sourse + "\'" +
                "AND n.date = \'" + date + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsByRubricAndDate(String rubric, String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "AND h.name = \'" + rubric + "\'" +
                "AND n.date = \'" + date + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsBySourse(String sourse) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "JOIN public.link AS l ON l.id = h.link_id " +
                "WHERE l.name = \'" + sourse + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsByRubric(String rubric) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "AND h.name = \'" + rubric + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsByDate(String date) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT n.id, n.name, n.date, n.heading_id " +
                "FROM public.news AS n " +
                "JOIN public.heading AS h ON h.id = n.heading_id " +
                "AND n.date = \'" + date + "\'";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

    public ResultSet getNewsAll() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT id, name, date, heading_id " +
                "FROM public.news ";
        ResultSet result = statement.executeQuery(sqlQuery);

        return result;
    }

}
