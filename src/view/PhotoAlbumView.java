package view;

import controller.PhotoAlbumController;



/**
 * The type Photo album view.
 */
public class PhotoAlbumView {


  /**
   * Instantiates a new Photo album view.
   *
   * @param controller the controller
   * @param fWidth     the f width
   * @param fHeight    the f height
   */
  public PhotoAlbumView(PhotoAlbumController controller, int fWidth, int fHeight) {

    new Frame(fWidth, fHeight, controller);


  }










}