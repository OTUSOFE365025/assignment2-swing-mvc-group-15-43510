// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;


public class Scanner {
	// Scanner uses Swing framework to create a UPC code
	private JFrame frame;
	private JPanel scannerPanel;
	private JButton scanButton;
	private List<String> upcCodes;
	private Random random;

	public Scanner() {
		frame = new JFrame("Scanner");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setLocation(300,50);
		frame.setVisible(true);

		// Load UPC codes from file
		upcCodes = new ArrayList<>();
		random = new Random();
		loadUPCCodesFromFile("products.txt");

		// Create UI elements
		scanButton = new JButton("Scan");
		scannerPanel = new JPanel();

		// Add UI element to frame
		scannerPanel.add(scanButton);
		frame.getContentPane().add(scannerPanel);

		scanButton.addActionListener(e -> generateUPC());
	}

	private void loadUPCCodesFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length >= 1) {
					upcCodes.add(parts[0].trim());
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			upcCodes.add("12345");
		}
	}

	public int generateUPC() {
		int upcCode;

		if (upcCodes.isEmpty()) {
			upcCode = 12345;
		} else {
			int randomIndex = random.nextInt(upcCodes.size());
			upcCode = Integer.parseInt(upcCodes.get(randomIndex));
		}

		System.out.println(upcCode);
		return upcCode;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}


}