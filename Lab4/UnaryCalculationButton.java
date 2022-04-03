/**
 * UnaryCalculationButton class that stores an unary operation and does calculation according to operation.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UnaryCalculationButton extends CalculationButton{

    public UnaryCalculationButton(String name, Operation op, JTextField text1, JTextField text2, JLabel result, CountInformer informer) {
        super(name,op, text1, text2, result,informer);
        setBackground(Color.RED);
    }

    public void actionPerformed(ActionEvent e) {
        text2.setText("0");
        super.actionPerformed(e);
    }
}
