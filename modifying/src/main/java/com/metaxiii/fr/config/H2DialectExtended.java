package com.metaxiii.fr.config;

import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2DialectExtended extends H2Dialect {

  @Override
  public String toBooleanValueString(boolean bool) {
    return bool ? "TRUE" : "FALSE";
  }
}
