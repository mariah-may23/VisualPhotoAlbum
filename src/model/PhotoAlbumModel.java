package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhotoAlbumModel implements IPhotoAlbumModel {
  private IShape shape;
  private int snapNumber = 0;
  private final List<IShape> newShapes = new ArrayList<>();
  private final HashMap<String, List<IShape>> snapshot = new HashMap<>();
  private final List<String> commands = new ArrayList<>();
  List<String> snapsIDs = new ArrayList<>(Arrays.asList());



  @Override
  public IShape addShape(String type, String name, int x, int y, int firstDim, int secondDim, int r, int g, int b) {
    if (type.equalsIgnoreCase("rectangle")) {
      shape = new Rectangle(name, x, y, firstDim, secondDim, r, g, b);
      saveCommand(String.format("shape %s rectangle %d %d %d %d %d %d %d", name, x, y, firstDim, secondDim, r, g, b));

    }

    if (type.equalsIgnoreCase("oval")) {
      shape = new Oval(name, x, y, firstDim, secondDim, r, g, b);
      saveCommand(String.format("shape %s oval %d %d %d %d %d %d %d", name, x, y, firstDim, secondDim, r, g, b));


    }
    newShapes.add(shape);
    return shape;

  }

  @Override
  public void move(String shapeName, int x, int y) {
    IShape temp = newShapes.stream().filter(shapes -> shapes.getName().equalsIgnoreCase(shapeName)).findFirst().orElse(null);
    assert temp != null;
    temp.setXY(x, y);
    saveCommand(String.format("move %s %d %d", shapeName, x, y));
  }

  @Override
  public void recolor(String shapeName, int r, int g, int b) {
    IShape temp = newShapes.stream().filter(shapes -> shapes.getName().equalsIgnoreCase(shapeName)).findFirst().orElse(null);
    assert temp != null;
    saveCommand(String.format("color %s %d,%d, %d", shapeName, r, g, b));
    temp.setColor(r, g, b);

  }

  @Override
  public void reSize(String shapeName, int first, int second) {
    IShape temp = newShapes.stream().filter(shapes -> shapes.getName().equalsIgnoreCase(shapeName)).findFirst().orElse(null);
    assert temp != null;
    temp.setDimensions(first, second);
    saveCommand(String.format("resize %s %d %d", shapeName, first, second));
  }


  @Override
  public void remove(String shapeName) {
    IShape temp = newShapes.stream().filter(shapes -> shapes.getName().equalsIgnoreCase(shapeName)).findFirst().orElse(null);
    assert temp != null;
    newShapes.remove(temp);
    saveCommand(String.format("remove %s", shapeName));
  }


  @Override
  public void takeSnapshot(String description) { //store each snapshot in a list then store the shapes and id in a hashmap

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m");
    String text = date.format(formatter);

    String time = String.format("%s", text);

    String ID = String.format("%s-%d\n%s", time, snapNumber, description);
    snapNumber++;

    List<IShape> snaps = new ArrayList<>(Collections.unmodifiableList(newShapes));
    snapsIDs.add(ID);

    snapshot.put(ID, snaps);
    if (description != null) {
      saveCommand(String.format("snapshot %s",description));
    }
    else {
      saveCommand("snapshot");

    }

  }

  @Override
  public List<String> getSnapshotsList() {
    return snapsIDs;
  }

  public List<IShape> getSnapshotShapes(String ID) {
    return snapshot.get(ID);

  }

  @Override
  public List<IShape> getFirstSnapshot() {
    String lastID = this.getSnapshotsList().get(0); //last entry ID
    return this.getSnapshotShapes(lastID);
  }

  @Override
  public void saveCommand(String d) {
    commands.add(d);
  }

  @Override
  public String toString() {
    StringBuilder printed = new StringBuilder("");
    for (Object x : commands) {
      printed.append(x).append("\n");

    }
    return printed.toString();
  }


}

