package model;

/**
 * The interface Shape.
 */
public interface IShape {
  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets type.
   *
   * @return the type
   */
  Shape getType();

  /**
   * Gets color.
   *
   * @return the color
   */
  String getColor();

  /**
   * Gets x.
   *
   * @return the x
   */
  int getX();

  /**
   * Gets Y.
   *
   * @return the Y
   */
  int getY();

  /**
   * Gets first dimension.
   *
   * @return the dimension
   */
  int getFirstDimension();

  /**
   * Gets second dimension.
   *
   * @return the dimension
   */
  int getSecondDimension();

  /**
   * Sets color.
   */
  void setColor(int red, int green, int blue);

  /**
   * Sets xy.
   */
  void setXY(int xpos, int ypos);

  /**
   * Set dimensions.
   */
  void setDimensions(int first, int second);

  int getR();

  int getG();

  int getB();

  String hString();



}