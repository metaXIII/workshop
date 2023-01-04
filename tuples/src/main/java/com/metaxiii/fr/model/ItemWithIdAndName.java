package com.metaxiii.fr.model;

public class ItemWithIdAndName {
    private final int id;
    private final String name;

    public ItemWithIdAndName(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
