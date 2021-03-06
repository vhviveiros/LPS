package view;

import javax.swing.*;

public class Tools {
    public static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
