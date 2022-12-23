package com.metaxiii.fr;

import com.metaxiii.fr.model.ItemWithId;
import com.metaxiii.fr.model.ItemWithIdAndName;
import org.javatuples.Pair;

public class App {
    public Pair<ItemWithId, ItemWithIdAndName> seeTuplesInAction() {
        final var itemWithId = new ItemWithId(1);
        final var itemWithName = new ItemWithIdAndName(1, "item with name");
        return Pair.with(itemWithId, itemWithName);
    }
}
