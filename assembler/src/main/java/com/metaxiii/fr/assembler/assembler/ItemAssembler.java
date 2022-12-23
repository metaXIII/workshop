package com.metaxiii.fr.assembler.assembler;

import com.metaxiii.fr.assembler.domain.Item;
import com.metaxiii.fr.assembler.model.ItemModel;
import com.metaxiii.fr.assembler.model.SecondModelAskedByEmmanuel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ItemAssembler {

    public ItemModel toModel(final Item item) {
        return ItemModel
                .builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .askDate(LocalDateTime.now())
                .build();
    }

    public SecondModelAskedByEmmanuel otherModel(final Item item) {
        return SecondModelAskedByEmmanuel
                .builder()
                .itemModel(this.toModel(item))
                .haveEmmanuelAskThisNewProperty(true)
                .build();
    }
}
