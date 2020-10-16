package com.eomcs.design_pattern.flyweight.after;

import java.util.HashMap;
import java.util.Map;

public class BrushPool {

  Map<String, Brush> brushMap = new HashMap<>();

  public Brush getBrush(String pattern) {
    Brush brush = brushMap.get(pattern);
    if (brush == null) {
      System.out.println(pattern + " 브러시 생성");
      brush = new Brush(pattern);
      brushMap.put(pattern, brush);
    }
    return brush;
  }
}
