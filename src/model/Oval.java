package model;

/**
 * The type oval.
 */
public class Oval extends AbstractShape {

  public Oval(String name, int x, int y, int firstDim, int secondDim, int r, int g, int b) {
    super(name, x, y, firstDim, secondDim, r, g, b);
  }


  @Override
  public Shape getType() {
    return Shape.Oval;
  }

  @Override
  public String toString(){
    return String.format("%s %d %d %d %d %s",
            this.getType(),this.getX(),this.getY(),
            this.getFirstDimension(),this.getSecondDimension(),this.getColor());
  }

  @Override
  public String hString() {
    return String.format("\t\t<ellipse id=\"O\" cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" fill=\"rgb(%d,%d,%d)\">\n\t\t</ellipse>",
            this.getX(),this.getY(),this.getFirstDimension(),this.getSecondDimension(),this.getR(),this.getG(),this.getB());
  }
}
