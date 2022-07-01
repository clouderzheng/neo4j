package com.night.neo4j.config;

import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Date 2022/6/30 20:38
 * @created by zhengjingyun
 * @desc
 */
@Configuration
@EnableNeo4jRepositories("com.night.neo4j.repository")
@EnableTransactionManagement
public class Neo4jConfig {
    @Value("${spring.data.neo4j.url}")
    private String url;

    @Bean(name = "session")
    public Session neo4jSession() {
        Driver driver = GraphDatabase.driver(url);
        return driver.session();
    }
}