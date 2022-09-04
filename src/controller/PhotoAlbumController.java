package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.IPhotoAlbumModel;
import model.IShape;

/**
 * The type Photo album controller.
 */
public class PhotoAlbumController {
  private final Readable readable;
  private final IPhotoAlbumModel model;
  String name;
  String type;
  int fDim;
  int y;
  int x;
  int sDim;
  int r;
  int g;
  int b;
  int snapIndex;
  int snapsLength;
  String photoID;
  List<IShape> shapes = new ArrayList<>(Arrays.asList());


  /**
   * Instantiates a new Photo album controller.
   *
   * @param readable the readable
   * @param model    the model
   * @throws IllegalArgumentException the illegal argument exception
   */
  public PhotoAlbumController(Readable readable, IPhotoAlbumModel model)
          throws IllegalArgumentException{
    this.model = model;

    if (readable ==null) {
      throw new IllegalArgumentException("No file to be read");
    }
    this.readable = readable;
  }

  /**
   * View album.
   */
  public void viewAlbum() {
    if (this.model == null) {
      throw new IllegalArgumentException("Cant be null");
    }
    Scanner s = new Scanner(readable);

    try {

      while (s.hasNext()) {

        String line = s.next();

        switch (line) {

          case "shape" -> { //adding the shape
            name = s.next();
            type = s.next();
            x = s.nextInt();
            y = s.nextInt();
            fDim = s.nextInt();
            sDim = s.nextInt();
            r = s.nextInt();
            g = s.nextInt();
            b = s.nextInt();
            this.model.addShape(type, name, x, y, fDim, sDim, r, g, b);
          }

          case "move" -> { //moving the shape
            name = s.next();
            x = s.nextInt();
            y = s.nextInt();
            this.model.move(name, x, y);
          }

          case "color" -> { //re-coloring the shape
            name = s.next();
            r = s.nextInt();
            g = s.nextInt();
            b = s.nextInt();
            this.model.recolor(name, r, g, b);
          }
          case "resize" -> { //resizing the shape
            name = s.next();
            fDim = s.nextInt();
            sDim = s.nextInt();
            this.model.reSize(name, fDim, sDim);
          }

          case "remove" -> { //removing the shape
            name = s.next();
            this.model.remove(name);
          }

          case "snapshot" -> { //taking snapshot of all current shapes
            this.model.takeSnapshot(s.nextLine());
          }
        }
      }

      shapes = model.getFirstSnapshot();
      snapIndex = 0;
      snapsLength = this.getSnaps().size() - 1;
      photoID = this.getSnaps().get(snapIndex);

    }
    catch (Exception e) {
      System.out.println("File could not be found");
    }

  }


  /**
   * Sets photo to be displayed on the page.
   * @param ID the id
   */
  public void setPhoto(String ID) {
    snapIndex = this.getSnaps().indexOf(ID);
    photoID = ID;
    shapes = model.getSnapshotShapes(ID);
  }

  /**
   * Gets list of current pages shapes.
   * @return the photo
   */
  public List<IShape> getPhoto() {
    return shapes;
  }

  /**
   * Gets current page photo id.
   * @return the photo id
   */
  public String getPhotoID() {
    return photoID;

  }

  /**
   * Gets list of all snapshot ids.
   * @return the snaps
   */
  public List<String> getSnaps() {
    return model.getSnapshotsList();
  }

  /**
   * Gets previous photo.
   * @return the previous photo
   */
  public int getPreviousPhoto() {
    if(snapIndex==0) {
      return 0;
    }
    else {
      String prev = this.getSnaps().get(snapIndex - 1);
      this.setPhoto(prev);
      return 1;
    }
  }

  /**
   * Gets next photo.
   * @return the next photo
   */
  public int getNextPhoto() {
    if(snapIndex == snapsLength) {
      return 0;
    }
    else {
      String next = this.getSnaps().get(snapIndex + 1);
      this.setPhoto(next);
      return 1;
    }

  }



}
