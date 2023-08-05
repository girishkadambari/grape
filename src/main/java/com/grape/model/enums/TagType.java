package com.grape.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum TagType {
    FEED;

    public static List<TagType> parseInQuery(String value) {
        List<TagType> tagTypes = new ArrayList<>();
        Arrays.asList(value.split("#")).forEach(string -> {
            tagTypes.add(TagType.valueOf(string));
        });
        return tagTypes;
    }
}