public class MySwingMVCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Assemble all the pieces of the MVC
		Model m = new Model("Isaiah", "Godinez");
		View v = new View("MVC with IGodinez");
		Controller c = new Controller(m, v);

		// create scanner
		Scanner scanner = new Scanner();

		CashRegister cashRegister = new CashRegister("products.txt");
		Display display = new Display("Display");
		RegisterController registerController = new RegisterController(cashRegister, display, scanner);

		// Initialize controllers
		c.initController();
		registerController.initController();  // ADD THIS LINE!
	}

}