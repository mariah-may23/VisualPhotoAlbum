package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.PhotoAlbumController;

/**
 * The type Next.
 */
public class next extends aButton implements ActionListener {
  PhotoAlbumController controller;
  Frame.DrawPanel panel;

  /**
   * Instantiates a new Next.
   *
   * @param controller the controller
   * @param panel      the panel
   */
  next(PhotoAlbumController controller, Frame.DrawPanel panel) {
    this.controller =controller;
    this.panel = panel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    int result = this.controller.getNextPhoto();

    if(result == 0) {
      JOptionPane.showMessageDialog(null,"End of photo album. No snapshots to show after this one");
      return;
    }
    this.panel.removeAll();
    this.panel.repaint();
    this.panel.revalidate();

  }

}
