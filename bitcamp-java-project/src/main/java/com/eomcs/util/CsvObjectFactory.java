package com.eomcs.util;

public interface CsvObjectFactory<T> {
  T create(String csv);
}
