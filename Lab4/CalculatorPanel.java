/**
 * Calculator panel that creates a calculation panel which has 8 operations
 * Addition Subtraction Division Factorial Square Multiplication Inverse Absolute.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
import javax.swing.*;
import java.awt.*;

public class CalculatorPanel extends JPanel implements CountInformer {
    private Operation[] operation;
    private JTextField text1, text2;
    private JLabel label3;
    private JLabel resultLabel;

    public CalculatorPanel(){

        //Operations
        operation = new Operation[8];
        Operation addOp = new Addition();
        Operation subOp = new Subtraction();
        Operation multOp = new Multiplication();
        Operation divOp = new Division();
        Operation squareOp = new Square();
        Operation factOp = new Factorial();
        Operation absOp = new Absolute();
        Operation inverseOp = new AddInverse();
        //Initializing
        operation[0] = addOp;
        operation[1] = subOp;
        operation[2] = multOp;
        operation[3] = divOp;
        operation[4] = squareOp;
        operation[5] = factOp;
        operation[6] = absOp;
        operation[7] = inverseOp;

        //Size and layout
        setPreferredSize( new Dimension(700,110));
        setLayout(new BorderLayout());

        //Panels
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        //Labels and Text field
        JLabel label1 = new JLabel("Number 1:");
        text1 = new JTextField(8);
        JLabel label2 = new JLabel("Number 2:");
        text2 = new JTextField( 8);
        resultLabel = new JLabel("Result: " );

        north.add( label1);
        north.add( text1 );
        north.add( label2);
        north.add( text2 );
        north.add( resultLabel);

        //Initializing buttons
        CalculationButton add = new CalculationButton("Add", operation[0],text1,text2,resultLabel, this);
        CalculationButton subtract = new CalculationButton("Subtract", operation[1],text1,text2,resultLabel, this);
        CalculationButton multiple = new CalculationButton("Multiple", operation[2],text1,text2,resultLabel, this);
        CalculationButton divide = new CalculationButton("Divide", operation[3],text1,text2,resultLabel,this);
        UnaryCalculationButton square = new UnaryCalculationButton("Square", operation[4],text1,text2,resultLabel, this);
        UnaryCalculationButton fact = new UnaryCalculationButton("Factorial", operation[5],text1,text2,resultLabel,this );
        UnaryCalculationButton abs = new UnaryCalculationButton("Absolute", operation[6],text1,text2,resultLabel,this);
        UnaryCalculationButton inverse = new UnaryCalculationButton( "Add Inverse", operation[7],text1,text2,resultLabel,this);

        //Adding buttons
        center.add(add);
        center.add(square);
        center.add(subtract);
        center.add(fact);
        center.add(multiple);
        center.add(abs);
        center.add(divide);
        center.add(inverse);

        //Initializing count label
        label3 = new JLabel();
        calculateAndUpdateCountMessage();
        south.add(label3);

        //Adding members
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);
    }

    public void calculateAndUpdateCountMessage() {
        String label = "";
        for( Operation op : operation ){
            label += op.getName() + " : " + op.getCount() + " ";
        }
        label3.setText( label );
    }

    @Override
    public void countUpdated() {
        calculateAndUpdateCountMessage();
    }
}
interface CountInformer{
    void countUpdated();
}