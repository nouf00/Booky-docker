package com.booky_bakend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class BookRespons implements Serializable {
    private List<String> isbn_10;
    private String title;
    private int number_of_pages;
    private List<AuthorKey> authors;
    private List<Integer> covers;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AuthorKey {
        private String key;
        public String getKey() { return key; }

        public String getOLID() {
            if (key != null && key.startsWith("/authors/")) {
                return key.replace("/authors/", "");
            }
            return null;
        }
    }
}






