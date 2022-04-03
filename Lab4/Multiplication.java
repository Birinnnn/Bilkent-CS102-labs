/**
 * Multiplication class that calculates the absolute value of an integer.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Multiplication extends Operation{

    public Multiplication(){
        name = "Multiple";
        isBinary = true;
        count = 0;
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateResult(int a, int b) {
        count++;
        return a*b;
    }
}
