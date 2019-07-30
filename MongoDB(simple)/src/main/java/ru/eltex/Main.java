package ru.eltex;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main
{
    public static void main(String[]args) throws  IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
        prop.load(fis);
        MongoClient mongoClient = MongoClients.create(prop.getProperty("db.host"));
        MongoDatabase db = mongoClient.getDatabase(prop.getProperty("db.name"));
        MongoCollection<Document> table = db.getCollection(prop.getProperty("db.table"));
        table.deleteMany(new BasicDBObject());


        Document document = new Document("name","Vyanceslav").append("phone","1420").append("password","qwerty");
        table.insertOne(document);

        Document document2 = new Document("name","Eugene").append("phone","2312").append("password","none");
        table.insertOne(document2);

        for (Document current: table.find())
        {
            System.out.println(current.toJson());
        }

        for (Document cur:table.find())
        {
            System.out.println(cur.toJson());
        }
    }

}
