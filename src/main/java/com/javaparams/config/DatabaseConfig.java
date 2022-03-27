package com.javaparams.config;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.java.Log;

@Profile("heroku")
@Configuration
@Log
public class DatabaseConfig {

    private static final String STR_COLON     = ":";
    private static final String JDBC_MYSQL    = "jdbc:mysql://";
    private static final String ENV_MYSQL_URL = "JAWSDB_URL";

    @Bean
    public DataSource dataSource() {

        URI jdbUri;
        HikariDataSource ds = null;
        try {
            jdbUri = new URI(System.getenv(ENV_MYSQL_URL));
            String username = jdbUri.getUserInfo().split(STR_COLON)[0];
            String password = jdbUri.getUserInfo().split(STR_COLON)[1];
            String port = String.valueOf(jdbUri.getPort());
            String jdbcUrl = JDBC_MYSQL + jdbUri.getHost() + STR_COLON + port + jdbUri.getPath();

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(jdbcUrl);
            ds = new HikariDataSource(config);
            ds.setUsername(username);
            ds.setPassword(password);

            log.info(" DB conn: " + ds);

        } catch (URISyntaxException e) {
            log.info("Database error:" + e.getMessage());
        }
        return ds;

    }

}
