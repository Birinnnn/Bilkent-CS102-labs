/**
 * Document class that has a name, Term array, a text, unique and total word count.
 * Also has a process method that scans a text and puts the unique words to the term array accordingly.
 *
 * @author Anıl İlağa
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Document {
    //instances
    private String fileName;
    private Term[] terms;
    private String text;
    private int wordCount;
    private int totalWordCount;

    //Default Constructor
    public Document(){
        terms = new Term[10000];
        wordCount = 0;
        totalWordCount = 0;
        fileName = "";
    }

    /**
     * Constructor that takes a string as parameter and initializes the instance variables.
     * Then scans the text, throws file not found exception error if text does not exist.
     *
     * @param - fileName
     * @throws - FileNotFoundException
     */
    public Document( String fileName ) throws FileNotFoundException {
        this.fileName = fileName;
        terms = new Term[10000];
        wordCount = 0;
        totalWordCount = 0;
        processDocument();
    }

    /**
     * Returns the number of words in the scanned text.
     * @return - totalWordCount
     */
    public int getTotalWordCount() {
        return totalWordCount;
    }

    /**
     * Takes an integer as parameter and sets it to total word number.
     * @param - totalWordCount
     */
    public void setTotalWordCount(int totalWordCount) {
        this.totalWordCount = totalWordCount;
    }

    /**
     * Returns the text string.
     * @return - text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the parameter to text
     * @param - text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the name of the file
     * @return - fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name to the given name.
     * @param - fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the word of the term
     * @return - Word
     */
    public String getTermWords() {
        String out = "";
        for( Term t : terms) {
            if (t != null) {
                out += t.getWord() + "\n" ;
            }
        }
        return out;
    }

    /**
     * Sets the term array to the given array.
     * @param - terms
     */
    public void setTerms(Term[] terms) {
        this.terms = terms;
    }

    /**
     * Scans the text from src file and throws file not found exception if file is not in the folder.
     * @throws FileNotFoundException
     */
    public void processDocument() throws FileNotFoundException {
        File file = new File( "src\\" + fileName );
        Scanner sc = new Scanner( file );

        while( sc.hasNext() ){//Continues until the end of the text
            totalWordCount ++;
            String temp = sc.next();
            temp = temp.replaceAll("[\\p{Punct}&&[^'-]]+", "");;//Removing punctuation except ' and - .
            int num = getCount( temp );

            if( num == 0 ){//Initializes the word if it is not inside the array.
                terms[wordCount]= new Term( temp.toLowerCase());
                terms[wordCount].incrementCount();
                wordCount ++;
            }
            else{//Increases the count if the array already contains the word.
                terms[getIndex(temp)].incrementCount();
            }
        }
    }

    /**
     * Calculates the frequency of the word using the count of the word and total word count.
     *
     * @param - word
     * @return - frequency
     */
    public double getFrequency( String word ){
        if( getIndex( word ) == -1){//Not inside the array
            return 0;
        }
        else{
            if( totalWordCount == 0){
                return 0;
            }
            return (terms[getIndex(word)].getCount() / (double)totalWordCount);//Calculation
        }
    }

    /**
     * Gets the index of the given word and returns the index.
     *
     * @param - Word
     * @return - index
     */
    public int getIndex( String word ){
        int i = -1;

        for( Term t : terms ){
            i++;
            if( t == null){//End of the term but couldn't find the word.
                return -1;
            }
            else if( word.equalsIgnoreCase( t.getWord() )){//t exists and same as word.
                return i;
            }
        }
        return -1;
    }

    /**
     * Creates a string array and fills it with string representation of most used terms.
     *
     * @return String array of most used terms.
     */
    public String[] getMostUsedTerms(){
        String[] words;
        int max = 0;
        int same = 0;
        words = new String[10000];

        for( Term t : terms){
            if( t != null && t.getCount() > max ) {
                max = t.getCount();
                same = 0;
                words = new String[10000];//Resets the array if there is a
                words[same] = t.getWord();
            }
            else if( t != null && t.getCount() == max){
                same++;
                words[same] = t.getWord();
            }
        }
        return words;
    }

    /**
     * Prints the most used terms as a whole string with a space between.
     *
     * @return Most used terms
     */
    public String printMostUsedTerms(){
        String out = "";
        for( String s : this.getMostUsedTerms() ){
            if( s != null ){
                out += s + " " ;
            }
        }
        return out;
    }

    /**
     * Takes a string as a parameter and returns the number of occurrences of the word.
     *
     * @param - Word
     * @return - count
     */
    public int getCount( String word ){
        for( Term t : terms ){
            if( t == null ){//End of the array couldn't find the word
                return 0;
            }
            else if( word.equalsIgnoreCase( t.getWord()) ){//Found the word inside the array
                return t.getCount();
            }
        }
        return 0;//Array is full but given word is not inside it.
    }
}