package CameraRentalApp;

public class User {
	 private String username;
	    private String password;
	    private double WalletBalance;

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }
	    public String getusername() {
	        return username;
	    }
	    public String getpassword() {
	        return password;
	    }
	    public void setWalletBalance() {
	        this.WalletBalance = 3000;
	    }
	    public double getWalletBalance() {
	        return WalletBalance;
	    }
	    public void deposit(double amount) {
	        WalletBalance += amount;
	    }
	    public void subtract(double amount) {
	        WalletBalance -= amount;
	    }
	}


