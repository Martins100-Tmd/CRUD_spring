package com.martins.first.Api;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tools.jackson.databind.ObjectMapper;

@Service
public class Custom {
    Logger logger = Logger.getLogger(Custom.class.getName());
    HttpClient client;

    public Custom() {
        if (this.client == null || this.client.isTerminated()) {
            this.client = HttpClient.newHttpClient();
        }

    }

    public UserObj fetchCustomURL(String url) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json").GET().build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = response.body();
            UserObj user = mapper.readValue(responseBody, UserObj.class);
            SaveToFile(responseBody);
            return user;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return null;
        }
    }

    public String postRestAction(String url, ResponseType bodyval) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(bodyval);
            HttpRequest request = HttpRequest.newBuilder().uri(
                    URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(BodyPublishers.ofString(body)).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(request);
            return response.body();
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return null;
        }
    }

    public List<UserObj> fetchMultipleURL(List<String> urls) {
        List<UserObj> response = urls.stream().map(this::fetchCustomURL).collect(Collectors.toList());
        System.out.println(response);
        return response;
    }

    private void SaveToFile(String document) {
        if (document != null) {
            UUID file_id = UUID.randomUUID();
            File file = new File("../Data/" + file_id);
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(document);
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }
}
