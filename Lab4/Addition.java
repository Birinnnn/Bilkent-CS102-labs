/**
 * Addition class that calculates sum of the values.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Addition extends Operation{

    public Addition(){
        name = "Add";
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
        return a+b;
    }
}
