package com.eomcs.corelib.ex01;

public class E999 {
  static class Member {
    String name;
    int age;

    Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (age != other.age)
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Member member1 = new Member("오세준", 27);
    Member member2 = new Member("오세준", 27);


  }

}
