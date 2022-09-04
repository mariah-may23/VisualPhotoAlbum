import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


import view.HTMLView;
import model.IPhotoAlbumModel;
import controller.PhotoAlbumController;
import model.PhotoAlbumModel;
import view.PhotoAlbumView;

public class PhotoAlbumMain {
  public static void main(String[] args) throws IOException {

    int i = 0;
    int fDim;
    int sDim;
    int in;
    int v;
    int out = 0;

    in = Arrays.asList(args).indexOf("-in");
    out = Arrays.asList(args).indexOf("-out");
    v = Arrays.asList(args).indexOf("-v");
    if (v < 0) {
      v = Arrays.asList(args).indexOf("-view");
    }

    IPhotoAlbumModel model = new PhotoAlbumModel();
    PhotoAlbumController controller = new PhotoAlbumController(new FileReader(args[in + 1]), model);
    controller.viewAlbum();

    if (args[v + 1].equalsIgnoreCase("graphical")) {
      int length = Arrays.asList(args).size() - 1;
      try {
        fDim = Integer.parseInt(args[length]);
        sDim = Integer.parseInt(args[length - 1]);
      }
      catch (NumberFormatException e) {
        fDim = 1000;
        sDim = 1000;
      }


      PhotoAlbumView view = new PhotoAlbumView(controller, fDim, sDim);
    }
    else if (args[v + 1].equalsIgnoreCase("web")) {
      if (out != 0) {
        HTMLView hview = new HTMLView(controller,args[out + 1]);
        hview.createView();
      }
      else {
        System.out.println("No output file specified. Now exiting...");
        System.exit(1);
      }
    }




  }
}