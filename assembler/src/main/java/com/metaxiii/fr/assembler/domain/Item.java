package com.metaxiii.fr.assembler.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Item {
    private int id;
    private String name;
    private double price;
}
