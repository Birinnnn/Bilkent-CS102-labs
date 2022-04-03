/**
 * Term class that has 2 instance variables word and count.
 * Also has an increment method that increases the count.
 *
 * @author Anıl İlağa
 */
public class Term {
    //instances
    private String word;
    private int count;

    /**
     * Constructor that sets the word to the given string
     * and sets count to 0.
     * @param word
     */
    public Term( String word ){
        this.word = word;
        count = 0;
    }

    /**
     * Returns the word of the term
     * @return - Word
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word of the term to the given string.
     * @param - Word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Returns the count of the term.
     * @param - Count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count of the term to the given integer.
     * @param - Count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * This function increases the count of the term by 1.
     */
    public void incrementCount(){
        count ++;
    }

    /**
     * To string method of the term class which is the word.
     * @return - Word
     */
    public String toString(){
        return this.getWord();
    }
}