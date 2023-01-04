package com.metaxiii.fr.assembler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    private int id;
    private String name;
    private double price;
    @JsonProperty(value = "ask_date")
    private LocalDateTime askDate;
}
