package com.metaxiii.fr.cleanarchitecture.domain;

public record User(
  Long id,
  String firstName,
  String lastName,
  String username,
  String password,
  String email,
  String phone
) {}
