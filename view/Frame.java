package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.IShape;
import controller.PhotoAlbumController;
import model.Shape;

/**
 * The type Frame.
 */
public class Frame extends JFrame{
  public int bWidth;
  public int bHeight;
  JButton previous;
  JButton select;
  JButton next;
  JButton quit;
  PhotoAlbumController controller;


  /**
   * Instantiates a new Frame.
   *
   * @param width      the width
   * @param height     the height
   * @param controller the controller
   */
  public Frame(int width, int height, PhotoAlbumController controller) {
    this.controller = controller;

    JFrame f = new JFrame();

    //use given frame dimensions to create button heights and widths
    bWidth = width / 4;
    bHeight = height - 50;

    //adding panels to the frame to hold the buttons
    JPanel bPanel = new JPanel();
    JPanel tPanel = new JPanel();
    JLabel label = new JLabel(this.controller.getPhotoID());
    label.setFont(new Font("Veranda", Font.BOLD,12));
    tPanel.add(label);
    tPanel.setBorder(new LineBorder(Color.BLACK));

    DrawPanel draw = new DrawPanel(this.controller, label);

    //now creating each button
    previous button1 = new previous(this.controller, draw);
    previous = button1.create(0, bHeight, bWidth, "<<PREV<<");
    previous.setFocusable(false);

    select button2 = new select(this.controller, draw);
    select = button2.create(bWidth, bHeight, bWidth, "^^SELECT^^");
    select.setFocusable(false);

    next button3 = new next(this.controller, draw);
    next = button3.create(bWidth * 2, bHeight, bWidth, ">>NEXT>>");
    next.setFocusable(false);

    quit button4 = new quit();
    quit = button4.create(bWidth * 3, bHeight, bWidth, "xxQUITxx");
    quit.setFocusable(false);


    //adding frame components
    f.setTitle("CS5004 Shapes Photo Album Viewer ");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.setLayout(new BorderLayout());
    f.setSize(width, height);
    f.getContentPane().setBackground(new Color(255, 216, 240));
    f.setVisible(true);


    //adding buttons to the panel
    bPanel.add(previous);
    bPanel.add(select);
    bPanel.add(next);
    bPanel.add(quit);
    bPanel.setBackground(new Color(255, 106, 228));

    //adding panels to frame
    f.getContentPane().add(bPanel, BorderLayout.PAGE_END);
    f.getContentPane().add(draw,BorderLayout.CENTER);
    f.getContentPane().add(tPanel, BorderLayout.PAGE_START);
    f.setVisible(true);

  }


  /**
   * The type Draw panel.
   */
  static class DrawPanel extends JPanel {
    private final PhotoAlbumController controller;
    private final JLabel label;

    /**
     * Instantiates a new Draw panel.
     *
     * @param controller the controller
     * @param label      the label
     */
    public DrawPanel(PhotoAlbumController controller, JLabel label) {
      this.controller = controller;
      this.label = label;

    }


    public void paintComponent(Graphics g) {
      this.label.setText(this.controller.getPhotoID());
      super.paintComponent(g);


      for( IShape s: this.controller.getPhoto()) {
        if (s.getType()== Shape.Oval) {
          g.setColor(new Color(s.getR(),s.getG(),s.getB()));
          g.drawOval(s.getX(),s.getY(),s.getFirstDimension(),s.getSecondDimension());
          g.fillOval(s.getX(),s.getY(),s.getFirstDimension(),s.getSecondDimension());
        }
        else if (s.getType()== Shape.Rectangle) {
          g.setColor(new Color(s.getR(),s.getG(),s.getB()));
          g.drawRect(s.getX(),s.getY(),s.getFirstDimension(),s.getSecondDimension());
          g.fillRect(s.getX(),s.getY(),s.getFirstDimension(),s.getSecondDimension());
        }

      }

    }


  }
}


