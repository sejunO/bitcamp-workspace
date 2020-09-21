package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferdInputStream extends FileInputStream {

  public BufferdInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  byte[] buf = new byte[8192];
  int size;
  int corsor;

  @Override
  public int read() throws IOException {
    if (size == corsor) {
      if ((this.size = this.read(buf)) == -1) {
        return -1;
      }
      corsor = 0;
    }
    return buf[corsor++] & 0x000000ff;
  }

}
