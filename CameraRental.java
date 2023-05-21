package CameraRentalApp;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CameraRental {
	private static ArrayList<Camera> cameraList = new ArrayList<>();

    private static ArrayList<Camera> totalList = new ArrayList<Camera>();
    private static ArrayList<String> cameraName = new ArrayList<>();
    private static ArrayList<String> cameraModel = new ArrayList<>();
    private static ArrayList<Integer> cameraPrice = new ArrayList<>();
    private static ArrayList<Integer> cameraID = new ArrayList<>();
    private static int counter = 3;
    private static User userLoggedIn;
    private static int cameraId;
    public static void main(String[] args) {
        System.out.println("Welcome To Camera Rental App");
        login();
        OptionsToBeDisplayed();
    }
    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login to continue");
        System.out.println("Enter the username: ");
        String username = scanner.nextLine();
        System.out.println("Enter the password: ");
        String password = scanner.nextLine();
        if(password.equalsIgnoreCase("admin123")) {
            userLoggedIn = new User(username, password);
        }
        else {
            System.out.println("UserName or Password wrong");
            login();
        }
    }
    private static void DefaultCamera() {
        /*Camera camera1 = new Camera(1, "Nikon", "IG240", 600);
        cameraList.add(camera1);
        totalList.add(1,cameraList.get(1));
        Camera camera2 = new Camera(2, "Canon", "xl45", 700);
        cameraList.add(camera2);
        totalList.add(2, cameraList.get(1));
        Camera camera3 = new Camera(3, "Sony", "Xp13", 800);
        cameraList.add(camera3);
        totalList.add(3,cameraList.get(1));*/
        cameraID.add(1);
        cameraModel.add("Nikon");
        cameraName.add("IG240");
        cameraPrice.add(700);
        cameraID.add(2);
        cameraModel.add("Canon");
        cameraName.add("xl45");
        cameraPrice.add(700);
        cameraID.add(3);
        cameraModel.add("Sony");
        cameraName.add("Xp13");
        cameraPrice.add(700);

        //cameraId = 4;
    }
    private static void OptionsToBeDisplayed() {
        DefaultCamera();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" OPTIONS");
            System.out.println("1. MY CAMERA");
            System.out.println("2. RENT A CAMERA");
            System.out.println("3. VIEW ALL CAMERAS");
            System.out.println("4. MY WALLET");
            System.out.println("5. EXIT");
            System.out.println(" ");
            System.out.print("Enter your Choice: ");
            int Choice = scanner.nextInt();
            switch (Choice) {
                case 1:
                    MyCamera();
                    break;
                case 2:
                    RentCamera();
                    break;
                case 3:
                    ViewAllCameras();
                    break;
                case 4:
                    MyWallet();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

// TODO Auto-generated method stub
    private static void MyCamera() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OPTIONS");
            System.out.println("1. ADD");
            System.out.println("2. REMOVE");
            System.out.println("3. VIEW ALL CAMERAS");
            System.out.println("4. GO TO PREVIEWS MENU");
            System.out.println(" ");
            System.out.println("Enter your Choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCamera();
                    break;
                case 2:
                    removeCamera();
                    break;
                case 3:
                    ViewMyCamera();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    private static void addCamera() {
        int cameraaddcounter = 4;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Camera Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter the Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the PricePerDay (INR): ");
        int price = scanner.nextInt();
        cameraID.add(counter,cameraaddcounter);
        cameraModel.add(counter,brand);
        cameraName.add(counter,model);
        cameraPrice.add(counter,price);
        counter++;
        Camera camera = new Camera(cameraaddcounter, brand, model, price);
        cameraList.add(camera);
        cameraaddcounter++;
        System.out.print("Your Camera Has Been Successfully Added!");
    }
    private static void removeCamera() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Camera Id to Remove: ");
        int cameraId = scanner.nextInt();
        for (Camera camera : cameraList) {
            if (camera.getId() ==cameraId) {
                cameraList.remove(camera);
                int index = counter-1;
                cameraID.remove(index);
                cameraName.remove(index);
                cameraModel.remove(index);
                cameraPrice.remove(index);
                counter--;
                System.out.println("camera is successfully removed!");
                System.out.println(" ");
                return;
            }
        }
        System.out.println("OOPS! CAMERA ID NOT FOUND");
    }
    private static void ViewMyCamera() {
        System.out.println("My Cameras: ");
        System.out.println("CameraId Brand Price(PerDay) Status");
        for (Camera camera : cameraList) {
            System.out.println(camera.getId() +" " + camera.getBrand()+ " " +camera.getModel()+ " " +camera.getPrice()+" "+ camera.isAvailable());
        }
    }
    private static void RentCamera() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Following Is The List Of Available Camera(s)");
        System.out.println("CameraId Brand Model PricePerDay Status");
        for (Camera camera : cameraList) {
            if (Camera.isAvailable()) {
                System.out.println(camera.getId() +" "+  camera.getBrand()+" "+ camera.getModel() +" " + camera.getPrice() + "Available");
            }
        }
        System.out.print("ENTER THE CAMERAID YOU WANT TO RENT: ");
        int cameraId = scanner.nextInt();
        for (Camera camera : cameraList) {
            if (camera.getId() == cameraId && Camera.isAvailable()) {
                double price = camera.getPrice();
                if (userLoggedIn.getWalletBalance() >= price) {
                    userLoggedIn.subtract(price);
                    camera.setAvailable(false);
                    System.out.println("YOUR TRANSACTION FOR CAMERA WITH RENT INR HAS SUCCESSFULLY COMPLETED.\n" + camera.getBrand() +" "+ camera.getModel()+" "+price);
                    return;
                } else {
                    System.out.println("ERROR: TRANSACTION FAILED DUE TO IN SUFFICIENT WALLET BALANCE. PLEASE DEPOSITE THE AMOUNT TO YOUR WALLET");
                    return;
                }
            }
        }
        System.out.println("CameraId not Found or Already rented");
    }
    private static void ViewAllCameras() {
        System.out.println("All Cameras: ");
        System.out.println("CameraID BRAND MODEL PRICEPERDAY STATUS");
        for (int i= 0 ; i < counter; i++) {
            System.out.println(cameraID.get(i)+ " " + cameraModel.get(i)+ " " +cameraName.get(i)+ ""+ cameraPrice.get(i) +" "+ Camera.isAvailable());
        }
    }
    private static void MyWallet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("YOUR BALANCE IS INR" + userLoggedIn.getWalletBalance());
        System.out.println(" ");
        System.out.println("DO YOU WANT TO DEPOSITE MONEY TO YOUR WALLET? (1. yes, 2.no)");
        int choice = scanner.nextInt();
        if (choice ==1) {
            System.out.print("ENTER THE AMOUNT (INR): ");
            double amount = scanner.nextDouble();
            userLoggedIn.deposit(amount);
            System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY");
            System.out.println("CURRENT BALANCE: INR" + userLoggedIn.getWalletBalance());
        }
    }
}



