package Util;



import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RandomClient {
    private final String apiKey;
    private static int id = 1;
    HttpClient client;


    public RandomClient(String api) {
        apiKey = api;
        //https://github.com/stleary/JSON-java
        //https://api.random.org/json-rpc/2/basic
        //https://api.random.org/json-rpc/2/request-builder
        client = HttpClient.newHttpClient();
    }

    public int[] generateTeamInts() {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("n", 10);
        paramsMap.put("min", 0);
        paramsMap.put("max", 9);
        paramsMap.put("replacement", false);
        paramsMap.put("base", 10);

        String request = createRequest(paramsMap, "generateIntegers");
        String response = send(request);
        JSONObject jsonObject = new JSONObject(response);

        if (!jsonObject.has("error")) {
            try {
                String integers = jsonObject.getJSONObject("result").getJSONObject("random").get("data").toString();
                String[] numberStrs = integers.replace("[", "").replace("]", "").split(",");
                int[] numbers = new int[numberStrs.length];
                for (int i = 0; i < numberStrs.length; i++) {
                    numbers[i] = Integer.parseInt(numberStrs[i]);
                }
                return numbers;
            } catch (JSONException e) {
                //errors
            }
        } else {
            //error goes here
        }
        return null;

    };

    private String createRequest(Map<String, Object> paramsMap, String method) {
        JSONObject json = new JSONObject();
        json.put("jsonrpc", "2.0");
        paramsMap.put("apiKey", apiKey);
        json.put("method", method);
        json.put("params", paramsMap);
        json.put("id", id++);

        String ret = json.toString();
        return ret;
    }

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
