package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.PhotoAlbumController;

/**
 * The type Select.
 */
public class select extends aButton implements ActionListener {
  PhotoAlbumController controller;
  Frame.DrawPanel panel;
  String[] snapIDs;


  /**
   * Instantiates a new Select.
   *
   * @param controller the controller
   * @param panel      the panel
   */
  public select(PhotoAlbumController controller, Frame.DrawPanel panel) {
    this.controller = controller;
    this.panel = panel;

  }


  /**
   * Choice of which snapshot to show.
   *
   * @return the string
   */
  public String choice() {
    snapIDs = this.controller.getSnaps().toArray(new String[0]);
    int snapIDsLength = snapIDs.length - 1;

    String getoption = (String) JOptionPane.showInputDialog(null, "What snapshot would you like to display", "Choose snapshot", JOptionPane.QUESTION_MESSAGE,null,snapIDs, snapIDs[snapIDsLength]);

    return getoption;

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    String option = this.choice();
    this.controller.setPhoto(option);
    this.panel.removeAll();
    this.panel.repaint();
    this.panel.revalidate();






  }



}
