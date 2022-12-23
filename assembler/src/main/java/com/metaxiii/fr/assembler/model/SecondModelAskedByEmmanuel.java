package com.metaxiii.fr.assembler.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SecondModelAskedByEmmanuel {
    @JsonUnwrapped
    private ItemModel itemModel;

    private boolean haveEmmanuelAskThisNewProperty;
}
