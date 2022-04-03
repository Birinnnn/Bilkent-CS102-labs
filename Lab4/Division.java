/**
 * Division class that calculates the division of two int values.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Division extends Operation{

    public Division(){
        name = "Divide";
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
        return (int)((double)a/b);
    }
}
