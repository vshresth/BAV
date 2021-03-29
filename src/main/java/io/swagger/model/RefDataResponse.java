package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RefDataResponse {

    @JsonProperty("national_ids")
   private List<NationalIds> nationalIds;

    public List<NationalIds> getNationalIds() {
        return nationalIds;
    }

    public void setNationalIds(List<NationalIds> nationalIds) {
        this.nationalIds = nationalIds;
    }

    public static class NationalIds {
        @JsonProperty("id")
        private long id;
        @JsonProperty("scheme")
        private String scheme;
        @JsonProperty("type")
        private String type;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}


