package com.metaxiii.fr.cleanarchitecture.service.impl;

import com.metaxiii.fr.cleanarchitecture.dao.UserRightDao;
import com.metaxiii.fr.cleanarchitecture.service.UserRightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRightServiceImpl implements UserRightService {

  private final UserRightDao userRightDao;
}
