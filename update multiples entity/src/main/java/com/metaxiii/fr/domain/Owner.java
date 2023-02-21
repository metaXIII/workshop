package com.metaxiii.fr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    private long id;
    private String name;
    private String doNotUpdate;
}
