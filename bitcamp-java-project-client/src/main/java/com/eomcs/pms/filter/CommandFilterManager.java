package com.eomcs.pms.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.handler.Request;

public class CommandFilterManager implements FilterChain {
  List<CommandFilter> filters = new ArrayList<>();
  int cursor = 0;
  public void add(CommandFilter filter) {
    filters.add(filter);
  }
  public void reset() {
    this.cursor = 0;
  }

  public void init(Map<String, Object> context) throws Exception {
    for (CommandFilter filter : filters) {
      filter.init(context);
    }
  }

  public void destroy() {
    for (CommandFilter filter : filters) {
      filter.destroy();
    }
  }
  @Override
  public void doFilter(Request request) throws Exception{
    if (cursor >= filters.size()) {
      return;
    }
    CommandFilter nextFilter = filters.get(cursor++);
    nextFilter.doFilter(request, this);
  }
}
