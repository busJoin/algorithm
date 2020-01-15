package com.chang;

import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @User: chang
 */
public class HTTPClientTest {
    @Test
    public void testName() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://dida365.com/#q/all/today")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, responseBodyHandler);
        String body = response.body();
        System.out.println(body);

        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        HttpResponse<String> body1 = sendAsync.get();
        System.out.println(body1);
        System.out.println("======================");
        sendAsync.thenApply(t->t.body()).thenAccept(System.out::println);
    }
}
