package com.grape.specificiations;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchOperation operation;
    private Object value;

    public Object getValue() {
        if (value instanceof String) {
            //value = java.net.URLDecoder.decode(value.toString());
            return value.toString()
                    .replaceAll("ts_like", "~")
                    .replaceAll("ts_negation", "!")
                    .replaceAll("ts_single_quote", "'")
                    .replaceAll("ts_colon", ":")
                    .replaceAll("ts_semicolon", ";")
                    .replaceAll("ts_greater_than", ">")
                    .replaceAll("ts_lesser_than", "<")
                    .replaceAll("ts_at_sign", "@")
                    .replaceAll("ts_dollar_sign", "\\$")
                    .replaceAll("ts_asterisk", "*")
                    .replaceAll("ts_percentage", "%")
                    .replaceAll("ts_space", " ")
                    .replaceAll("ts_comma", ",")
                    .replaceAll("ts_array_open", "[")
                    .replaceAll("ts_array_close", "]");
        } else {
            return value;
        }
    }
}
