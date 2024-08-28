import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main{

    private static final ArrayList<Item> items = new ArrayList<>();
    private static final DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price"}, 0);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inventory Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // Create and set up the table
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            // Create buttons
            JButton addButton = new JButton("Add Item");
            JButton updateButton = new JButton("Update Item");
            JButton deleteButton = new JButton("Delete Item");

            // Create input fields
            JPanel inputPanel = new JPanel(new GridLayout(5, 2));
            inputPanel.add(new JLabel("ID:"));
            JTextField idField = new JTextField();
            inputPanel.add(idField);
            inputPanel.add(new JLabel("Name:"));
            JTextField nameField = new JTextField();
            inputPanel.add(nameField);
            inputPanel.add(new JLabel("Quantity:"));
            JTextField quantityField = new JTextField();
            inputPanel.add(quantityField);
            inputPanel.add(new JLabel("Price:"));
            JTextField priceField = new JTextField();
            inputPanel.add(priceField);

            // Add components to frame
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(inputPanel, BorderLayout.NORTH);
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(addButton);
            buttonPanel.add(updateButton);
            buttonPanel.add(deleteButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            // Add button actions
            addButton.addActionListener(e -> addItem(idField, nameField, quantityField, priceField));
            updateButton.addActionListener(e -> updateItem(idField, nameField, quantityField, priceField));
            deleteButton.addActionListener(e -> deleteItem(idField));

            frame.setVisible(true);
        });
    }

    private static void addItem(JTextField idField, JTextField nameField, JTextField quantityField, JTextField priceField) {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            if (idExists(id)) {
                JOptionPane.showMessageDialog(null, "ID already exists.");
                return;
            }

            Item item = new Item(id, name, quantity, price);
            items.add(item);
            tableModel.addRow(new Object[]{id, name, quantity, price});

            clearFields(idField, nameField, quantityField, priceField);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter correct values.");
        }
    }

    private static void updateItem(JTextField idField, JTextField nameField, JTextField quantityField, JTextField priceField) {
        try {
            int id = Integer.parseInt(idField.getText());

            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if (item.getId() == id) {
                    item.setName(nameField.getText());
                    item.setQuantity(Integer.parseInt(quantityField.getText()));
                    item.setPrice(Double.parseDouble(priceField.getText()));
                    tableModel.setValueAt(item.getName(), i, 1);
                    tableModel.setValueAt(item.getQuantity(), i, 2);
                    tableModel.setValueAt(item.getPrice(), i, 3);

                    clearFields(idField, nameField, quantityField, priceField);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Item with ID not found.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter correct values.");
        }
    }

    private static void deleteItem(JTextField idField) {
        try {
            int id = Integer.parseInt(idField.getText());

            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if (item.getId() == id) {
                    items.remove(i);
                    tableModel.removeRow(i);
                    clearFields(idField, new JTextField(), new JTextField(), new JTextField());
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Item with ID not found.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter correct values.");
        }
    }

    private static boolean idExists(int id) {
        return items.stream().anyMatch(item -> item.getId() == id);
    }

    private static void clearFields(JTextField idField, JTextField nameField, JTextField quantityField, JTextField priceField) {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    static class Item {
        private int id;
        private String name;
        private int quantity;
        private double price;

        public Item(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
