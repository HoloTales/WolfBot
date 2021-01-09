package Util;



import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.JSONObject;


public class RandomClient {
    private final String apiKey;
    HttpClient client = HttpClient.newHttpClient();


    public RandomClient(String api) {
        apiKey = api;
        //https://github.com/stleary/JSON-java
        //https://api.random.org/json-rpc/2/basic
        //https://api.random.org/json-rpc/2/request-builder
        HttpClient client = HttpClient.newHttpClient();
    }

    public Integer[] generateTeamInts() {
        return null;


        /*JsonR
        String s = rpcClient.createRequest()
                .method("generateIntegers")
                .param("n", Integer.toString(10))
                .param("min", Integer.toString(0))
                .param("max", Integer.toString(9))
                .param("replacement", false)
                .param("apiKey", apiKey)
                .param("base", "10")
                .returnAs(String.class)
                .id(0).;
        System.out.println(s);
        return null;*/
    };

    private String send(String request) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.random.org/json-rpc/2/invoke"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(request))
                .build();
        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();
        } catch (Exception e) {
            return "fail";
        }
    }
}
