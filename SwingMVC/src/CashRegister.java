import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashRegister {
    private Map<String, Product> productCatalog;
    private List<Product> scannedItems;
    private double subtotal;

    public CashRegister(String productFilePath) {
        productCatalog = new HashMap<>();
        scannedItems = new ArrayList<>();
        subtotal = 0.0;
        try {
            loadProductsFromFile(productFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadProductsFromFile(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String upc = parts[0].trim();
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                productCatalog.put(upc, new Product(upc, name, price));
            }
        }
        br.close();
    }

    public Product addItemByUPC(String upc) {
        Product product = productCatalog.get(upc);
        if (product != null) {
            scannedItems.add(product);
            subtotal += product.getPrice();
            return product;
        }
        return null;
    }

    public List<Product> getScannedItems() {
        return new ArrayList<>(scannedItems);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public List<String> getAllUPCCodes() {
        return new ArrayList<>(productCatalog.keySet());
    }

    public void clearRegister() {
        scannedItems.clear();
        subtotal = 0.0;
    }
}