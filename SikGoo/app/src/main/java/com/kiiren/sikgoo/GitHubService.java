package com.kiiren.sikgoo;

/**
 * Created by 120897 on 2017-09-05.
 */
import com.squareup.retrofit2.*;

public interface GitHubService {
    @GET("/users/{user}/repos")
    List<Repo> listRepos(@Path("user") String user);
}