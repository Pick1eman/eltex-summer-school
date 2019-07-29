package ru.eltex;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.Properties;

public class Main
{
    public static void main(String[]args) throws UnknownHostException
    {
        Properties prop = new Properties();
        MongoClient mongoClient = MongoClients.create(prop.getProperty("host"));
        MongoDatabase db = mongoClient.getDatabase(prop.getProperty("dbname"));
        MongoCollection<Document> table = db.getCollection(prop.getProperty("table"));

        Document document = new Document("name","Vyanceslav").append("phone","1420").append("password","qwerty");
        table.insertOne(document);

        for (Document cur:table.find())
        {
            System.out.println(cur.toJson());
        }
    }

}
