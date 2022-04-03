import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class CalculationButton extends JButton implements ActionListener {

    protected Operation operation;
    protected JTextField text1;
    protected JTextField text2;
    protected JLabel result;
    protected CountInformer informer;

    public CalculationButton(String name, Operation op, JTextField text1, JTextField text2, JLabel result, CountInformer informer){
        super(name);
        this.text1 = text1;
        this.text2 = text2;
        this.result = result;
        this.informer = informer;

        addActionListener( this );
        operation = op;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( text1.getText().equals("") || text2.getText().equals("")){
            JDialog dialog = new JDialog();
            dialog.setLayout( new FlowLayout());
            JButton button = new JButton("I understood");
            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.setVisible(false);
                }
            });
            dialog.add( new JLabel("Please input 2 integers for Binary calculations"));
            dialog.add(new JLabel("And 1 integer for Unary Calculations"));
            dialog.add(new JLabel("Click button to continue"));
            dialog.add( button);
            dialog.setSize(300,150);
            dialog.setVisible(true);

        }
        else {
            int num2 = Integer.parseInt(text2.getText());
            int num1 = Integer.parseInt(text1.getText());
            result.setText("Result: " + operation.calculateResult( num1, num2 ));
            informer.countUpdated();
        }
        /*int num1 = Integer.parseInt (text1.getText());
        int num2 = Integer.parseInt (text2.getText());
        result.setText("Result: " + operation.calculateResult( num1, num2 ));
        informer.countUpdated();*/
    }
}