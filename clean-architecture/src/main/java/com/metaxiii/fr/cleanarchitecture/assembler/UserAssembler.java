package com.metaxiii.fr.cleanarchitecture.assembler;

import com.metaxiii.fr.cleanarchitecture.domain.User;
import com.metaxiii.fr.cleanarchitecture.domain.UserRight;
import com.metaxiii.fr.cleanarchitecture.model.UserModel;
import com.metaxiii.fr.cleanarchitecture.utils.Tuple2;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

  public UserModel toFindUser(final Tuple2<User, UserRight> tuples) {
    final var user = tuples.first();
    final var userRight = tuples.second();
    return new UserModel(user.firstName(), user.lastName(), userRight.rights());
  }
}
