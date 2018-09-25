package com.els.test.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoDB configuration
 *
 */
@Configurable
@EnableMongoRepositories("com.els.test.repository")
@Import(value = MongoAutoConfiguration.class)
public class DBConfig {
}