package view;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The type A button.
 */
public abstract class aButton extends JButton implements ActionListener{
  JButton b;

  /**
   * Create buttons.
   *
   * @param x     the x
   * @param y     the y
   * @param width the width
   * @param name  the name
   * @return the j button
   */
  public JButton create(int x, int y, int width, String name) {
    b = new JButton();
    b.setBounds(x,y,width,25);
    b.addActionListener(this);
    b.setText(name);

    return b;

  }
}
