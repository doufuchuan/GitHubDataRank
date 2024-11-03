package com.example.talentrank.utils;

import com.example.talentrank.entity.Developer;

import java.io.IOException;
import java.util.List;

public interface GithubService {
    public List<Developer> getDevelopers(int since) throws Exception, IOException, InterruptedException;
}
