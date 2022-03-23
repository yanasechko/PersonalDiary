package com.diary.repository;

import com.diary.contracts.IUserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL implements IUserRepository {

    private final String source;

    public MySQL(String source) {
        this.source = source;
    }

    @Override
    public Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(source);
    }

    @Override
    public ResultSet executeQuery(String query)
            throws SQLException, ClassNotFoundException {
        return getConnection().createStatement().executeQuery(query);
    }

    @Override
    public Object executeSQL(String sql)
            throws SQLException, ClassNotFoundException {
        return getConnection().createStatement().execute(sql);
    }

}
