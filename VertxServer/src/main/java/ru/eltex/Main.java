package ru.eltex;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;


public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        vertx.createHttpServer().requestHandler(request->{
            System.out.println(request.uri());
            if (request.uri().equals("/get_users"))
            {
                request.response().putHeader("Content-Type","Application").end("id = "+ 0 + " Fio = \"Alex\"");
            } else {
                request.response().putHeader("Content-Type","Application").end("Error!");
            }
                }).listen(8082);


    }
}
