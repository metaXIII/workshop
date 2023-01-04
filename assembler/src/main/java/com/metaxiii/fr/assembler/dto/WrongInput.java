package com.metaxiii.fr.assembler.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WrongInput {
    @NotNull
    private String name;

    @NotNull
    private double price;
}
