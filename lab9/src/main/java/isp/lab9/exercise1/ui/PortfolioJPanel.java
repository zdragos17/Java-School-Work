package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 */
public class PortfolioJPanel extends JPanel {
    private StockMarketJFrame frame;
    private JTable jTablePortfolio;
    private JLabel cashLabel;

    public PortfolioJPanel(StockMarketJFrame frame) {
        this.frame = frame;
        initComponent();
    }

    private void initComponent() {
        setLayout(new BorderLayout());


        jTablePortfolio = new JTable();
        jTablePortfolio.setModel(createPortofolioTableModel());
        JScrollPane scrollPane = new JScrollPane(jTablePortfolio);
        add(scrollPane, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());


        cashLabel = new JLabel();
        updateCashLabel();
        bottomPanel.add(cashLabel, BorderLayout.WEST);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshTable());
        bottomPanel.add(refreshButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private DefaultTableModel createPortofolioTableModel() {
        String[] columnNames = {"Symbol", "Quantity", "Price", "Total value"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (frame == null) return tableModel;

        UserPortfolio portfolio = frame.getPortfolio();
        Map<String, Integer> ownedStocks = portfolio.getShares();
        if (ownedStocks == null) return tableModel;

        for (Map.Entry<String, Integer> entry : ownedStocks.entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            BigDecimal price = frame.getMarketService().getPriceForSymbol(symbol);
            if (price == null) price = BigDecimal.ZERO;
            BigDecimal total = price.multiply(BigDecimal.valueOf(quantity));
            tableModel.addRow(new Object[]{
                    symbol,
                    quantity,
                    price.toPlainString(),
                    total.toPlainString()
            });
        }

        return tableModel;
    }

    private void refreshTable() {
        jTablePortfolio.setModel(createPortofolioTableModel());
        updateCashLabel();
    }

    private void updateCashLabel() {
        if (frame != null && frame.getPortfolio() != null) {
            BigDecimal cash = frame.getPortfolio().getCash();
            cashLabel.setText("Available cash: " + cash.toPlainString());
        }
    }
}
