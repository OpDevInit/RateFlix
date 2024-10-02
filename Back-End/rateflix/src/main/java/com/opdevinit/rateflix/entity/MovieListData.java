package com.opdevinit.rateflix.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieListData(Object []Search) {
    
}
