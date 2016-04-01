package se.leinonen.hmc.internal.config;

import com.mongodb.rx.client.MongoClient;
import com.mongodb.rx.client.MongoClients;
import com.mongodb.rx.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by leinonen on 2016-03-30.
 */
@Configuration
public class MongoStorageConfiguration {

    @Bean
    public MongoDatabase getMongoDatabase(
            @Value("${mongo.url}") String url,
            @Value("${mongo.db}") String dbName) {

        System.out.println("Mongo: " + url + ", " + dbName);

        MongoClient mongoClient = MongoClients.create(url);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database;
    }
}
