/**
 * Absolute class that calculates the absolute value of an integer.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Absolute extends Operation{

    public Absolute(){
        count = 0;
        isBinary = false;
        name = "Absolute";
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
        int out;
        count ++;
        if( a >= 0){ out = a; }
        else{ out = -a; }
        return out;
    }
}
