/**
 * AddInverse class that calculates the inverse number of the parameter according to addition.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class AddInverse extends Operation{

    public AddInverse(){
        count = 0;
        isBinary = false;
        name = "Addition Inverse";
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
        return -a;
    }
}
