package averagesentenceslength;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

 //C:\Users\GRECIA\Prueba_archivos.txt

public class AverageSentencesLength {
   
    public static void main(String[] args) {
       
        try{
            Scanner scan1 = new Scanner(System.in);
            String path = scan1.nextLine(); //1° RECIBIR PATH
            scan1.close();
         
            ArrayList <String> sentences = new ArrayList <> ();
            //2° DELIMITAR X DEFAULT . ? ! ; :
            //3° USER AGREGA DELIMITER CON FLAG -d
            Pattern delimSentence = Pattern.compile("([\\.?!;:]+\\s*)|(-d.\\s*)");  
            Scanner scan = new Scanner(new File(path), 
                    "ISO-8859-1").useDelimiter(delimSentence);
            
            while(scan.hasNext()){
                String aux = scan.next();
                sentences.add(aux);
                //System.out.println(aux);
            }
            //System.out.println("Numero oraciones: "+sentences.size());
            
            //4° CONTAR PALABRAS DEFAULT >= 3digs
            //5° USER AGREGA FLAG -l PARA CONSIDERAR PALABRA
            Pattern delimWord = Pattern.compile("(-l)\\p{Alpha}+\\p{Punct}?|"
                    + "(\\p{Alpha}\\p{Alpha}\\p{Alpha}+\\p{Punct}?)");
            Matcher m;
            int wordsNumber = 0;
            double averageWordPerSentence;
            
            
            for(String s: sentences){
                m = delimWord.matcher(s);
                while(m.find()){
                    wordsNumber++;
                }
                //System.out.println("words: " + wordsNumber);
            }
            //System.out.println("total words: " + wordsNumber);
            averageWordPerSentence = wordsNumber/(double)sentences.size();
            System.out.println(String.format("%.2f", averageWordPerSentence));
            
            scan.close();
            
	} catch(Exception e){
		System.err.println(e.getMessage());
	}
        
        
    }
    
}
