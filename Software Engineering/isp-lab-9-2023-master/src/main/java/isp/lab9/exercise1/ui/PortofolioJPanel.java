package isp.lab9.exercise1.ui;

import javax.swing.*;

/**
 *  todo: implement portfolio panel; for each owned stock add symbol, quantity, price per unit, total price of the position
 *  it should look similar to the 'Market' panel
 */
public class PortofolioJPanel extends JPanel {

    private StockMarketJFrame frame;

    public PortofolioJPanel(StockMarketJFrame frame) {
        this.frame = frame;
        initComponent();
    }

    private void initComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTable jTablePortfolio = new JTable();
        jTablePortfolio.setModel(frame.getMarketService());
        JScrollPane portfolioScrollablePane = new JScrollPane(jTablePortfolio);
        add(portfolioScrollablePane);
    }

}
