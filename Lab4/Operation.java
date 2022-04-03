/**
 * Abstract operation class that has a name, count and a boolean isBinary true if operation is binary false if not.
 * CalculateResult function calculates the result accordingly.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public abstract class Operation {
    protected int count;
    protected boolean isBinary;
    protected String name;
    public abstract int getCount();
    public abstract String getName();
    public abstract int calculateResult( int a, int b);
}
