public class RegisterController {
    private CashRegister cashRegister;
    private Display display;
    private Scanner scanner;

    public RegisterController(CashRegister c, Display d, Scanner s) {
        cashRegister = c;
        display = d;
        scanner = s;
    }

    public void initController() {
        scanner.getScanButton().addActionListener(e -> handleScan());
    }

    private void handleScan() {
        String upc = String.valueOf(scanner.generateUPC());
        Product product = cashRegister.addItemByUPC(upc);

        if (product != null) {
            display.addItem(product.toString());
            display.updateSubtotal(cashRegister.getSubtotal());
        }
    }
}