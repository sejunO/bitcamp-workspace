package com.eomcs.oop.ex03;

public class Exam0160 {
  public static void main(String[] args) throws Exception {
    Po po = new Po("admin");

    Member m1 = new Member("이름", po);
    Member m2 = m1.clone();
    System.out.println(m1);

    System.out.println(m1.po.posi);
    System.out.println(m2.po.posi);

    m2.po.posi = "CEO";
    System.out.println(m1.po.posi);
    System.out.println(m2.po.posi);

  }

  static class Member implements Cloneable {
    String id;
    String password;
    Po po;
    Member(String id, Po po) {
      this.id = id;
      this.po = po;
    }

    @Override
    public Member clone() throws CloneNotSupportedException {
      Member copy = (Member) super.clone();
      copy.po = this.po.clone();
      return copy;
    }

    @Override
    public String toString() {
      return "Member [id=" + id + ", password=" + password + ", po=" + po + "]";
    }

  }

  static class Po implements Cloneable {
    String posi;

    Po (String posi) {
      this.posi = posi;
    }
    @Override
    public Po clone() throws CloneNotSupportedException {
      return (Po) super.clone();
    }
    @Override
    public String toString() {
      return "Po [posi=" + posi + "]";
    }

  }
}
