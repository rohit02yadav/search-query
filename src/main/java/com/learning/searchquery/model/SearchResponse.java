package com.learning.searchquery.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class SearchResponse {
    private String response = "response";

    @JsonProperty
    public String getResponse() {
        return response;
    }
}
