package com.metaxiii.fr.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class OwnerEntityProjectionDTO implements Serializable {
    private Long id;
    private String name;
}