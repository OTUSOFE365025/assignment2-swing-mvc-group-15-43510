import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Display {
    // View uses Swing framework to display scanned items to user
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JScrollPane scrollPane;
    private JLabel subtotalLabel;
    private JPanel bottomPanel;

    public Display(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocation(100, 50);
        frame.setLayout(new BorderLayout());

        // Create list model and list for scanned items
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        scrollPane = new JScrollPane(itemList);
        scrollPane.setPreferredSize(new Dimension(380, 200));

        // Create subtotal label
        subtotalLabel = new JLabel("Subtotal: $0.00");
        subtotalLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create bottom panel
        bottomPanel = new JPanel();
        bottomPanel.add(subtotalLabel);

        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void addItem(String itemDescription) {
        listModel.addElement(itemDescription);
    }

    public void updateSubtotal(double subtotal) {
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
    }

    public void clearDisplay() {
        listModel.clear();
        updateSubtotal(0.0);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    public JList<String> getItemList() {
        return itemList;
    }

    public void setItemList(JList<String> itemList) {
        this.itemList = itemList;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JLabel getSubtotalLabel() {
        return subtotalLabel;
    }

    public void setSubtotalLabel(JLabel subtotalLabel) {
        this.subtotalLabel = subtotalLabel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }
}