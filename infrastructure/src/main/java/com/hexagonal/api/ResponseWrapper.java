package com.hexagonal.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseWrapper <T> {
    @JsonProperty("info")
    private Info info;
    @JsonProperty("results")
    private List<T> results;


    @Getter
    @Setter
    public static class Info {
        private int count;
        private int pages;
        private String next;
        private String prev;
    }
}
