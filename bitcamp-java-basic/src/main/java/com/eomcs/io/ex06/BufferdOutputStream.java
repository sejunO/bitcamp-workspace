package com.eomcs.io.ex06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdOutputStream extends FileOutputStream {

  public BufferdOutputStream(String name) throws FileNotFoundException {
    super(name);
  }

  byte[] buf = new byte[8192];
  int corsor;

  @Override
  public void write(int b) throws IOException {
    if (buf.length == corsor) {
      this.write(buf);
      corsor = 0;
    }

    buf[corsor++] = (byte) b;
  }

  @Override
  public void flush() throws IOException {
    if (corsor > 0) {
      this.write(buf, 0, corsor);
      corsor = 0;
    }
  }
}
