package com.example.talentrank.controller;

import com.example.talentrank.entity.Developer;
import com.example.talentrank.mapper.DeveloperMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DeveloperController {

//    @GetMapping("/developer")
//    public String hello() {
//        return "hello world";
//    }
String token= "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";
    @Autowired
    private DeveloperMapper developerMapper;
    @GetMapping("/developer")
    public Developer getDeveloper(){
        Developer developer = new Developer();
        developer.setId(1);
        developer.setUsername("doufuchuan");
        developer.setContributions(4);
        developer.setFollowers(2);
        developer.setRepos(5);
        developer.setNation("china");
        developer.setIssues(2);
        developer.setStars(5);
        developer.setTalent_rank(1);
        return developer;
    }

    @GetMapping("/developer/find")
    public List<Developer> findAll(){

//        try {
//            getDevelopers(1);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        return developerMapper.find();
    }

    public void getDevelopers(int since) throws Exception, IOException, InterruptedException {
        String url = "https://api.github.com/users?since="+since+"&per_page=20";

        JsonNode rootNode = req(url);
        List<Developer> developers = new ArrayList<>();
        for(JsonNode userNode: rootNode){
            Developer developer = new Developer();
            String username = userNode.path("login").asText();
            developer.setUsername(username);
            developer.setGithub_id(userNode.path("id").asInt());
            developer.setRepos(countRepos(username)[0]);
            developer.setFollowers(countFollowers(username));
            developer.setStars(countRepos(username)[1]);
            developer.setIssues(countIssues(username));
            developer.setTalent_rank(0);
            developers.add(developer);
            System.out.println(username);
            if(developerMapper.findByName(username)==null){
                developerMapper.insert(developer);
            }
        }

    }
    public JsonNode req(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "token " + token)
                .build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response =client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(response.body());
    }

    public int countFollowers(String username) throws Exception{
        String url = "https://api.github.com/users/" + username +"/followers";
        return req(url).size();
    }
    public int[] countRepos(String username) throws Exception{

//        String repos_url = userNode.path("repos_url").asText();
        String url = "https://api.github.com/users/" + username +"/repos";
        int[] res = new int[2];
        JsonNode r = req(url);
        res[0] = r.size();
        int totalStars = 0;

        for (JsonNode repoNode : r) {
            int stars = repoNode.path("stargazers_count").asInt();
            totalStars += stars;
        }
        res[1] = totalStars;
        return res;//返回仓库数和Star数
    }

    public int countIssues(String username) throws Exception{
        String url = "https://api.github.com/search/issues?q=author:"+username;
        return req(url).path("total_count").asInt();
    }
}
