import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.util.concurrent.Flow;

public class RestApi {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://drive.google.com/file/d/1q5fICXL0qVBKC3j5wMLc1ZYzOY_fgfrj");
        Gson gson = new Gson();
        String postJson = gson.toJson(transcript, Transcript.class);


        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization",Constants.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(postJson))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(postResponse.body());

        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        System.out.println(transcript.getStatus());
        transcript.setId("oqwj3gfdlj-3bb1-4501-9b53-bf7c099584c5");

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization",Constants.API_KEY)
                .build();

//        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(getResponse.body());
//            transcript = gson.fromJson(getResponse.body(), Transcript.class);
//            System.out.println(transcript.getStatus());

        while (true){

            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(getResponse.body(), Transcript.class);

            System.out.println(transcript.getStatus());
            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println(transcript.getText());



    }



}
