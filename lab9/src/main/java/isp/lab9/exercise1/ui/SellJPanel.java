package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SellJPanel extends JPanel {
    private StockMarketJFrame mainFrame;
    private JComboBox<String> symbolComboBox;
    private JTextField availableFundsTextField;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        symbolComboBox = new JComboBox<>();
        refreshSymbols();

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel totalGainLabel = new JLabel("Total gain:");
        JTextField totalGainTextField = new JTextField();
        totalGainTextField.setEditable(false);

        JButton sellButton = new JButton("Sell");
        sellButton.addActionListener(e -> {
            sellShares(quantityTextField, totalGainTextField);
        });

        JButton gainButton = new JButton("Get gain");
        gainButton.addActionListener(e -> {
            calculateTotalGain(quantityTextField, totalGainTextField);
        });

        JButton refreshButton = new JButton("Refresh symbols");
        refreshButton.addActionListener(e -> {
            refreshSymbols();
        });

        sellPanel.add(availableFundsLabel);
        sellPanel.add(availableFundsTextField);
        sellPanel.add(new JPanel());
        sellPanel.add(refreshButton);
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(totalGainLabel);
        sellPanel.add(totalGainTextField);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(gainButton);
        sellPanel.add(sellButton);

        add(sellPanel);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
    }

    private void calculateTotalGain(JTextField quantityTextField, JTextField totalGainTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            int quantity = Integer.parseInt(quantityTextField.getText());
            DecimalFormat formatter = new DecimalFormat("#,##0.##");
            totalGainTextField.setText(
                    formatter.format(stockPrice.multiply(new BigDecimal(quantity)))
            );
        } catch (NumberFormatException e) {
            totalGainTextField.setText("Invalid quantity!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sellShares(JTextField quantityTextField, JTextField totalGainTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            int quantity = Integer.parseInt(quantityTextField.getText());

            mainFrame.getPortfolio().sellShares(symbol, quantity, stockPrice);
            availableFundsTextField.setText(mainFrame.getPortfolio().getCash().toPlainString() + " $");
            refreshSymbols(); // update combo box if sold all shares
        } catch (NumberFormatException e) {
            totalGainTextField.setText("Invalid quantity!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshSymbols() {
        symbolComboBox.removeAllItems();
        for (String symbol : mainFrame.getPortfolio().getOwnedStocks().keySet()) {
            symbolComboBox.addItem(symbol);
        }
    }
}
