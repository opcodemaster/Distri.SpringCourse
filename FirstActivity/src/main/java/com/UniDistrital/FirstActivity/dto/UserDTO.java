package com.UniDistrital.FirstActivity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Address address;
    private Long id;
    private String email;
    private String username;
    private String password;
    @JsonProperty("name")
    private Names names;
    private String phone;
    @JsonProperty("__v")
    private String unkKey;

    @Data
    @Builder
    public static class Geolocation {
        private String lat;
        @JsonProperty("long")
        private String longN;
    }

    @Data
    @Builder
    public static class Address {
        private Geolocation geolocation;
        private String city;
        private String street;
        private int number;
        @JsonProperty("zipcode")
        private String zipCode;
    }

    @Data
    @Builder
    public static class Names {
        @JsonProperty("firstname")
        private String firstname;
        @JsonProperty("lastname")
        private String lastName;
    }
}