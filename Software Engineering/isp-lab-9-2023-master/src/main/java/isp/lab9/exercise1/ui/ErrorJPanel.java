package isp.lab9.exercise1.ui;

import javax.swing.*;

public class ErrorJPanel extends JPanel {
    public ErrorJPanel(String message) {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JLabel errorLabel = new JLabel(message);
        errorPanel.add(errorLabel);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> errorPanel.setVisible(false));
        errorPanel.add(okButton);

    }
}
