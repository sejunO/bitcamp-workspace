package com.eomcs.pms.filter;

import com.eomcs.pms.handler.Request;

public interface FilterChain {
  void doFilter(Request request) throws Exception;
}
