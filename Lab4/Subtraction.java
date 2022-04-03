/**
 * Subtraction class that calculates the subtraction value of two integers.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Subtraction extends Operation{

    public Subtraction(){
        name = "Subtract";
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
        return a-b;
    }
}
