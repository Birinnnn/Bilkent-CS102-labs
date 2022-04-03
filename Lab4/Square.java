/**
 * Square class that calculates the square value of an integer.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Square extends Operation{

    public Square(){
        name = "Square";
        isBinary = false;
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
        return a*a;
    }
}
