import java.io.IOException;
 
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class TagText {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
 
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/english-bidirectional-distsim.tagger");
        PrintWriter printOut = new PrintWriter("Brown_Corpus_tagged.txt");
        String fileName = "Brown_Corpus.txt";
        int numLines = numLines(fileName);
        System.out.println(numLines);
        Scanner fromFile = new Scanner(new FileReader(fileName));
        for(int i = 0; i < numLines; i++){
            String line = fromFile.nextLine();
            String tagged = tagger.tagString(line);
            printOut.println(tagged);
        }
        printOut.close();
        System.out.println("Finished all lines!");
        /*
        // The sample string
        String sample = "Local police have hesitated to prosecute them because of the heavy court costs involved even for the simplest offense.";
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
        // Output the result
        System.out.println(tagged);
        */
    }

    public static int numLines(String fileName) throws IOException {
        int fileLines = 0;
        Scanner fromFile = new Scanner(new FileReader(fileName));

        while (fromFile.hasNext()) {
            String newLine = fromFile.nextLine();
            fileLines++;
        }
        fromFile.close();
        return fileLines;
    }
}