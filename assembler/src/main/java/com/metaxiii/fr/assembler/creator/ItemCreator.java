package com.metaxiii.fr.assembler.creator;

import com.metaxiii.fr.assembler.domain.Item;
import com.metaxiii.fr.assembler.dto.ItemInput;
import org.springframework.stereotype.Component;

@Component
public class ItemCreator {
    public Item toDomain(final ItemInput input) {
        return Item
                .builder()
                .name(input.getName())
                .price(input.getPrice())
                .build();
    }
}
