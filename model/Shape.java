package model;

public enum Shape {
  Oval("oval"),Rectangle ("rectangle");

  String type;
  Shape(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}

