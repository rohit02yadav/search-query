package com.learning.searchquery.controllers;

import com.learning.searchquery.model.SearchResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @RequestMapping(value = "/search",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchResponse search(@RequestParam("query") String query) {
        System.out.println("Query::"+query);
        return new SearchResponse();
    }
}
