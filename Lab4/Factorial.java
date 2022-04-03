/**
 * Factorial class that calculates the factorial of the given integer.
 *
 * Name: Anıl İlağa Date: 17.11.2021
 */
public class Factorial extends Operation{
    public Factorial(){
        name = "Fact";
        isBinary = false;
        count = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int calculateResult(int a, int b) {

        int result = 1;
        if( a > 0 ){
            for( int temp = a; temp > 0; temp--){
                result *= temp;
            }
            count++;
        }

        return result;
    }
}
