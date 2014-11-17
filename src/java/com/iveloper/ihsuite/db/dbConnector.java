/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.db;

import com.iveloper.ihsuite.ws.Operations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class dbConnector {

    private String host;
    private String port;
    private String database;
    private String user;
    private String pass;
    private String dbvendor;
    private String driver;

    /**
     *
     */
    public Connection connection;

    /**
     *
     * @param configuration_path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public dbConnector(String configuration_path) throws FileNotFoundException, IOException {

        Properties props = new Properties();
        props.load(new FileInputStream(configuration_path));
        host = props.getProperty("datasource.hostname");
        port = props.getProperty("datasource.port");
        database = props.getProperty("datasource.database");
        user = props.getProperty("datasource.username");
        pass = props.getProperty("datasource.password");
        dbvendor = props.getProperty("datasource.dbvendor");
        driver = props.getProperty("datasource.driver");

    }

    /**
     *
     * @param configuration_path
     * @param dbid
     * @throws IOException
     */
    public dbConnector(String configuration_path, int dbid) throws IOException {
        this(configuration_path);
        database = database + String.format("%03d", dbid);
    }

    /**
     *
     * @param configuration_path
     * @param dbid
     * @throws IOException
     */
    public dbConnector(String configuration_path, String dbid) throws IOException {
        this(configuration_path);
        database = database + dbid;
    }

    /**
     *
     * @return
     */
    public String getDatabase() {
        return database;
    }

    /**
     *
     * @param database
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void connect() throws ClassNotFoundException, SQLException {

        Class.forName(driver);

        String url = getConnectionURL();
        Logger.getLogger(Operations.class.getName()).log(Level.INFO, "DB Connection URL: {0}", url);

        connection = DriverManager.getConnection(url, user, pass);
        Logger.getLogger(Operations.class.getName()).log(Level.INFO, "Connected to {0} database", database);
    }

    private String getConnectionURL() {
        String connectionurl;
        switch (dbvendor) {
            case "mysql":
            case "postgresql":
                connectionurl = "jdbc:" + dbvendor + "://" + host + ":" + port + "/" + database;
                break;
            case "sqlserver":
                connectionurl = "jdbc:" + dbvendor + "://" + host + ":" + port + ";"
                        + "databaseName=" + database + ";user=" + user + ";password=" + pass + ";";
                break;
            case "oracle":
                connectionurl = "jdbc:" + dbvendor + ":thin:@" + host + ":" + port + ":" + database;
                break;
            default:
                connectionurl = "jdbc:" + dbvendor + "://" + host + ":" + port + "/" + database;
                break;
        }
        return connectionurl;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public boolean disconnect() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();
            Logger.getLogger(Operations.class.getName()).log(Level.INFO, "Disconnected from {0} database", database);
        }
        return (true);

    }
}
