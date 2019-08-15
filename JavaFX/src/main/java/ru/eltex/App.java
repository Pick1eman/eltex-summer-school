package ru.eltex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class App extends Application {
    private static Integer Length = 1920;
    private static Integer Width = 1080;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(new File("src/main/resources/win.fxml").toURL());
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        HttpClientOptions httpClientOptions = new HttpClientOptions().setProtocolVersion(HttpVersion.HTTP_2).setSsl(true).setUseAlpn(true).setTrustAll(true);
        HttpClient httpClient = vertx.createHttpClient(httpClientOptions);
        Text output = new Text("");
        Group group = new Group(output);
        Scene scene = new Scene(group);
        httpClient.requestAbs(HttpMethod.GET,"http://localhost:8081/get_users", result->{
            result.bodyHandler(body->{
                User users[];
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    System.out.println(body.toString());
                    users = objectMapper.readValue(body.toString(), User[].class);
                    for(User user:users)
                    {
                        output.setText(output.getText() + "\n" +user.getId() + ". " + user.getFio() + "; " + user.getPhone());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        ).end();
        output.setLayoutX(10);
        output.setLayoutY(10);
        group = new Group(output);
        scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Users");
        primaryStage.setWidth(Length);
        primaryStage.setHeight(Width);
        primaryStage.show();
    }
}
