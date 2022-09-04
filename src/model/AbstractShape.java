package model;

public abstract class AbstractShape implements IShape {
  private String name;
  private Shape type;
  private int r;
  private int g;
  private int b;
  private int x; //min corner
  private int y; //min corner
  private int firstDim; //width for rect or radius x for oval
  private int secondDim; //height for rect or radius y for oval

  AbstractShape(String name, int x, int y, int firstDim, int secondDim,
                int r, int g, int b) { //create shape with name and color
    this.name = name;
    this.x = x;
    this.y = y;
    this.firstDim = firstDim;
    this.secondDim = secondDim;
    this.r = r;
    this.g = g;
    this.b = b;

  }
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getColor() {
    return String.format("%d %d %d",this.r,this.g,this.b);
  }



  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }


  @Override
  public int getFirstDimension() {
    return this.firstDim;
  }

  @Override
  public int getSecondDimension() {
    return this.secondDim;
  }

  @Override
  public int getR() {
    return this.r;
  }
  @Override
  public int getG() {
    return this.g;
  }
  @Override
  public int getB() {
    return this.b;
  }

  @Override
  public void setColor(int red, int green, int blue) {
    this.r = red;
    this.g = green;
    this.b = blue;

  }

  @Override
  public void setXY(int xpos, int ypos) {
    this.x = xpos;
    this.y = ypos;

  }

  @Override
  public void setDimensions(int first, int second) {
    this.firstDim = first;
    this.secondDim = second;


  }
}