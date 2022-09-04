package model;


import java.util.List;

/**
 * IPhotoAlbumModel Interface.
 */
public interface IPhotoAlbumModel {
  /**
   * Add Ishape shape.
   *
   * @param type      the type
   * @param name      the name
   * @param x         the x
   * @param y         the y
   * @param firstDim  the first dim
   * @param secondDim the second dim
   * @param r         the r
   * @param g         the g
   * @param b         the b
   * @return the shape
   */
  IShape addShape(String type, String name, int x, int y, int firstDim, int secondDim,
                  int r, int g, int b);

  /**
   * Move the shape to a different position.
   *
   * @param shapeName the shape name
   * @param x         the x
   * @param y         the y
   */
  void move(String shapeName, int x, int y);

  /**
   * Recolor the shape.
   *
   * @param name the name
   * @param r    the r
   * @param g    the g
   * @param b    the b
   */
  void recolor(String name,int r, int g, int b);

  /**
   * Re size the shape.
   *
   * @param name   the name
   * @param first  the first
   * @param second the second
   */
  void reSize(String name,int first, int second);

  /**
   * Remove the shape from the page.
   *
   * @param name the name
   */
  void remove(String name);

  /**
   * Take snapshot of the current shapes on the page.
   *
   * @param description the description
   * @return
   */
  void takeSnapshot(String description);

  /**
   * Print snapshots lists as a string with details.
   * @return string snapshots list
   */
  List<String> getSnapshotsList();

  /**
   * Save command.
   * @param d the d
   */
  void saveCommand(String d);


  /**
   * Gets list of shapes for a specific snapshot.
   * @param ID (the snapshot ID)
   * @return the snapshot shapes as a list
   */
  List<IShape> getSnapshotShapes(String ID);


  /**
   * Gets first snapshot.
   * @return the first snapshot
   */
  List<IShape> getFirstSnapshot();






}
