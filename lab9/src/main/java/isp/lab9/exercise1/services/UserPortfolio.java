/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Uses Lombok to get rid of boilerplate code.
 *
 * @author mihai.hulea
 * @author radu.miron
 */
@Data // it creates getters, setters, equals(), hashCode() and toString() (at compile time)
@AllArgsConstructor // it creates the constructor with arguments for all the attributes (at compile time)
public class UserPortfolio extends AbstractTableModel {



    private BigDecimal cash;
    private Map<String, Integer> shares;// a map of number of shares by stock symbol



    public UserPortfolio(Map<String, Integer> shares) {
        this.shares = shares;
    }

    public void buyShares(String symbol, int quantity, BigDecimal stockPrice) {
        BigDecimal totalPrice = stockPrice.multiply(BigDecimal.valueOf(quantity));
        if (cash.compareTo(totalPrice) >= 0) {
            cash = cash.subtract(totalPrice);
            if (shares.containsKey(symbol)) {
                shares.put(symbol, shares.get(symbol) + quantity);
            } else {
                shares.put(symbol, quantity);
            }


        } else {
            System.out.println("Not enough money to buy");
        }
//        this.fireTableDataChanged();
        System.out.println("DONE");
    }
    public boolean sellShares(String symbol, int quantity, BigDecimal stockPrice) {
        if (shares.containsKey(symbol) && shares.get(symbol) >= quantity) {
            shares.put(symbol, shares.get(symbol) - quantity);
            if (shares.get(symbol) == 0) {
                shares.remove(symbol);
            }
            cash = cash.add(stockPrice.multiply(BigDecimal.valueOf(quantity)));
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    public Map<String, Integer> getOwnedStocks() {
        return shares;
    }

    @Override
    public int getRowCount() {
        return shares.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "SYMBOL";
            case 1:
                return "VALUE";
        }
        return "N/A";
    }

}
