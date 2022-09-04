package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {

  public Rectangle(String name, int x, int y, int firstDim, int secondDim, int r, int g, int b) {

    super(name, x, y, firstDim, secondDim, r, g, b);

  }

  @Override
  public Shape getType() {
    return Shape.Rectangle;
  }

  @Override
  public String toString(){
    return String.format("%s %d %d %d %d %s",
            this.getType(),this.getX(),this.getY(),
            this.getFirstDimension(),this.getSecondDimension(),this.getColor());
  }

  @Override
  public String hString() {
    return String.format("\t\t<rect id=\"R\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"rgb(%d,%d,%d)\">\n\t\t</rect>",
            this.getX(),this.getY(),this.getFirstDimension(),this.getSecondDimension(),this.getR(),this.getG(),this.getB());
  }
}