package com.metaxiii.fr.fakefeign.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private int codeStatus;
    private String message;
}
