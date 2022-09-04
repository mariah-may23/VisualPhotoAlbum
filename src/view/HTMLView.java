package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import controller.PhotoAlbumController;
import model.IShape;

/**
 * The type Html view.
 */
public class HTMLView {
  private final PhotoAlbumController controller;
  private String out;

  /**
   * Instantiates a new Html view.
   *
   * @param controller the controller
   * @param out        the out
   * @throws IllegalArgumentException the illegal argument exception
   */
  public HTMLView(PhotoAlbumController controller, String out) throws IllegalArgumentException{
    this.controller = controller;
    if(out==null) {
      throw new IllegalArgumentException("Output file needed");
    }
    this.out = out;


  }

  /**
   * Create view.
   *
   * @throws IOException the io exception
   */
  public void createView() throws IOException {
    StringBuilder v = new StringBuilder();
    v.append("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<h1>CS5004 Snapshot PhotoAlbum</h1>");

    while(true) {
      v.append("\n<div>");
      v.append(String.format("\n\t<h2>%s</h2>", this.controller.getPhotoID()));
      v.append("\n\t<svg width=\"1000\" height=\"1000\">");
      for (IShape s : this.controller.getPhoto()) {
        v.append("\n").append(s.hString());
      }
      v.append("\t</svg>");
      v.append("\n</div>");
      int next = this.controller.getNextPhoto();
      if(next == 0){
        break;
      }

    }

    v.append("\n</body>\n" +
            "</html>");
    FileWriter fstream = new FileWriter(out);
    BufferedWriter outFile = new BufferedWriter(fstream);
    outFile.write(v.toString());
    outFile.close();


  }

}
