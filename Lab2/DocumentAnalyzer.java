/**
 * Main method that creates a document array according to user input and initializes
 * the array with scanned files. Application has 3 options:
 * Option 1- Displays the frequency of a user entered word in given document(s).
 * Option 2- Finds the most frequent terms in each document.
 * Prints out the most frequent term for each document and the number of appearance in the document.
 * Option 3- Calculates the tf-idf of user entered word for each document.
 *
 * @author Anıl İlağa
 */
import java.lang.Math;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class DocumentAnalyzer {
    public static void main( String[] args ) throws FileNotFoundException {
        //variables
        Scanner input = new Scanner( System.in );
        int i = 0;
        Document[] documents;
        int documentsLength = 0;
        boolean taken = false;

        do {
            System.out.print("Enter the number of documents: ");
            if( input.hasNextInt()){
                i = input.nextInt();
                if( i > 0)
                    taken = true;//Correct input
                else{//Negative or zero
                    System.out.println("Enter a positive integer please.");
                }
            }
            else{//If user inputs non-allowed type.
                System.out.println( "Integer only ");
                input.next();
            }
        }while ( !taken );

        input = new Scanner(System.in);
        documentsLength = i;
        documents = new Document[documentsLength];

        for(int j = 0; j < documentsLength; j++ ){
            System.out.print("Enter the name of the Document " + (j+1) + ": ");
            String fileName = input.nextLine();
            documents[j] = new Document( fileName );
        }

        boolean quit = false;

        while( !quit ){
            System.out.println("\nMenu Options\n" +
                               "1. Display the frequency of a word\n" +
                               "2. Display the most frequent words and their number of appearances in each document\n" +
                               "3. Calculate the tf-idf of a word");
            System.out.print(  "Enter an option (4 to quit):\n");
            String choice;

            if( input.hasNext() && documents != null ){
                choice = input.next();
                input.nextLine();
                if( choice.equals("1") ){//Displaying the frequency (Opt 1)
                    System.out.print("Enter the word which you want to find the frequency: ");
                    String word = input.next();
                    for( int index = 0; index < documentsLength; index++){
                        System.out.printf("\nDocument %d" +
                                "\n word: %s" +
                                "\n term frequency: %.6f" , (index + 1), word ,documents[index].getFrequency(word));
                    }
                }
                else if( choice.equals("2") ){//Printing out the most frequent term (Opt 2)
                    for( int index = 0; index < documentsLength; index++){
                        System.out.printf("\nDocument %d" +
                                "\n word(s): " , (index + 1));
                        System.out.print(documents[index].printMostUsedTerms());
                        System.out.print("\n number of appearance: " + documents[index].getCount(documents[index].getMostUsedTerms()[0]));
                    }
                }
                else if( choice.equals("3") ){//Calculating the tf-idf (Opt 3)
                    System.out.println("Enter the word which you want to calculate tf-idf:");
                        String word = input.next();
                        for( int index = 0; index < documentsLength; index++){
                            System.out.printf("\nDocument %d" +
                                    "\n word:" + word +
                                    "\n tf-idf: %.6f"  ,(index + 1) ,calcTfIdf(word, documents[index], documents));
                        }
                }
                else if( choice.equals("4")){//Quit
                    quit = true;
                    System.out.println("Done!");
                }
                else{
                    System.out.println("Sorry wrong input let's try again");//Non of these above
                    input = new Scanner( System.in );
                }
            }
        }
    }

    /**
     * This is a method that takes 3 parameters: a string, current document and document array.
     * Then calculates and returns the tf-idf accordingly.
     *
     * @param - word
     * @param - currentDocument
     * @param - allDocuments
     * @return tf-idf
     */
    public static double calcTfIdf( String word, Document currentDocument, Document[] allDocuments){
        double calculation;
        int numOfDocumentsIncludingWord = 0;

        for( Document d: allDocuments){
            if( d.getCount(word) > 0 ){
                numOfDocumentsIncludingWord++;
            }
        }

        if(currentDocument.getFrequency(word) == 0){
            return 0;
        }

        calculation = (currentDocument.getFrequency(word)) *
                      (Math.log( allDocuments.length / (double)numOfDocumentsIncludingWord ));

        return calculation;
    }
}