package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.PhotoAlbumController;


/**
 * The type Previous.
 */
public class previous extends aButton implements ActionListener {
  PhotoAlbumController controller;
  Frame.DrawPanel panel;

  /**
   * Instantiates a new Previous.
   *
   * @param controller the controller
   * @param panel      the panel
   */
  public previous(PhotoAlbumController controller, Frame.DrawPanel panel) {
    this.controller = controller;
    this.panel = panel;

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    int result = this.controller.getPreviousPhoto();

    if(result == 0) {
      JOptionPane.showMessageDialog(null,"Beginning of photo album. No snapshots to show before this one");
      return;
    }
    this.panel.removeAll();
    this.panel.repaint();
    this.panel.revalidate();

  }
}
