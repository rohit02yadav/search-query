package com.learning.searchquery.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    public List<String> search(String query) {
        List<List<String>> items = new ArrayList<>();
        return items.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
