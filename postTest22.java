package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postTest22 {
    //I Gede Arya Krisnadi
    String endpoint1 = "https://api.themoviedb.org/3/movie/now_playing?languge=en-US&page=1";
    String endpoint2 = "https://api.themoviedb.org/3/movie/popular?languge=en-US&page=1";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MWMzMWI1NjI1ODY2NGE1ZGRjMTc1YjUzYzc5OGRjMiIsInN1YiI6IjY1MzZjMTgxYzhhNWFjMDExY2YxMTIyOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bsLc-URE3eRrh0JXOfrlzDFUpo3BGu6hz0VH05F1hc0";

    @Test
    public void tesGetNowPlaying(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get(endpoint1);
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeaders());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void tesGetMoviePopular(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get(endpoint2);
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeaders());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testMovieRating() {
        JSONObject request = new JSONObject();
        request.put("value","8.5");
        System.out.println(request.toJSONString());
        given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/299054/rating")
                .then()
                .statusCode(201)
                .log().all();
    }



}
