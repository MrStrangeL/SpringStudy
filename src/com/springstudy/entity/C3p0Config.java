package com.springstudy.entity;

public class C3p0Config {
    private String user;
    private String password;
    private String driverClass;
    private String jdbcUrl;

    public C3p0Config() {
    }

    public C3p0Config(String user, String password, String driverClass, String jdbcUrl) {
        this.user = user;
        this.password = password;
        this.driverClass = driverClass;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public String toString() {
        return "C3p0Config [user="+user+",password="+password+",driverClass="+driverClass+",jdbcUrl="+jdbcUrl+"]";
    }
}
