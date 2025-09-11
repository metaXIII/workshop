package com.metaxiii.fr.bettertesting.domain;

import com.metaxiii.fr.bettertesting.enums.StatusEnum;

public record Item(Long id, String name, String description, StatusEnum status, Boolean isAvailable) {}
