package ru.eltex;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        HttpClientOptions httpClientOptions = new HttpClientOptions().setProtocolVersion(HttpVersion.HTTP_2).setSsl(true).setUseAlpn(true).setTrustAll(true);
        HttpClient httpClient = vertx.createHttpClient(httpClientOptions);
        httpClient.requestAbs(HttpMethod.GET,"https://api.vk.com/method/users.get?user_ids=<your_id>&fields=bdate&access_token=<your_token>&v=5.101",
            result->{
                System.out.println(result.statusCode());
                    result.bodyHandler(body->{
                        System.out.println(body.toString());
                });
            }
        ).end();
    }
}
