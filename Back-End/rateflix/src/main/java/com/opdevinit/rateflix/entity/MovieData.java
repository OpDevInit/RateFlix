package com.opdevinit.rateflix.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieData( String Title,String Released,String Runtime,String Genre,String Plot,String Poster,Object []Ratings,String Type) { 

}
