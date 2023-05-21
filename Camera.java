package CameraRentalApp;
import java.util.ArrayList;


public class Camera {
	 private static int id;
	    private static ArrayList<Camera> cameraList = new ArrayList<>();

	    private static String Brand;
	    private static String Model;
	    private static double Price;
	    private static boolean Available = true;
	    public Camera (int id, String Brand, String Model, double Price) {
	        this.id = id;
	        this.Brand = Brand;
	        this.Model = Model;
	        this.Price = Price;
	        this.Available = true;
	    }
	    public static int getId() {
	        return id;
	    }
	    public static String getBrand() {
	        return Brand;
	    }
	    public static String getModel() {
	        return Model;
	    }
	    public static double getPrice() {
	        return Price;
	    }
	    public static boolean isAvailable() {
	        return Available;
	    }
	    public void setAvailable(boolean b)
	    {
	        this.Available =b;
	    }

	}


