import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.ejml.simple.SimpleMatrix;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class sent1 {
    public static String[] trimmer (String osent)throws IOException {
        String comma = ",";
        String quote = "\"";
        int evenodd = 0;
        int ccount = 0;
        String author = "";
        String time = "";
        String dash = "-";
        String text = "";
        String day = "";
        String month = "";
        String monthz = "";
        String year = ""; 
        String yearf = "";
        int dashc = 0;
        int delay = 0;
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";
        String five = "5";
        String six = "6";
        String seven = "7";
        String eight = "8";
        String eye = "i";
        String nine = "9";
        String zero = "0";
        String[] fail = {"0"};
        String monthf = "";
        String[] header = {"thing","thing","thing","thing","thing","thing"};
        try {
        if (osent.charAt(0) == eye.charAt(0)) {
            return (header);
        }

        for (int i = 0; i < osent.length(); i++) {
            if (osent.charAt(i) == quote.charAt(0)) {
                evenodd = evenodd+1;
                delay = 0;
            }
            if (evenodd%2 == 0) {
                if (osent.charAt(i) == comma.charAt(0)) {
                    ccount = ccount + 1;
                }
            }
            if (delay == 1 && ccount == 3) {
                text = text + osent.charAt(i);                                
            }
            if (ccount == 3) {
                delay = 1;                
            }
            if (delay == 1 && ccount == 1) {
                time = time + osent.charAt(i);   
            }
            if (ccount == 1) {
                delay = 1;               
            }
            if (delay == 1 && ccount == 7 && osent.charAt(i+1) != comma.charAt(0)) {
                author = author + osent.charAt(i+1);                                
            }
            if (ccount == 7) {
                delay = 1;   
            }
        }
        for (int n = 0; n < time.length(); n++) {
            
            if (dashc == 0) {
                year = year + time.charAt(n);
            }
            if (dashc == 1) {
                month = month + time.charAt(n);
                //System.out.println(month);
            }
            if (dashc == 2) {
                day = day + time.charAt(n);
            }
            if (time.charAt(n) == dash.charAt(0)) {
                    dashc = dashc + 1;
                }

        }
        for (int z = 0; z < 4; z++) {
            yearf = yearf + year.charAt(z);


        }
        monthz = month;
        //System.out.println(month + "BEFORE");


        
if (month.charAt(0) == zero.charAt(0) ) {
            if (month.charAt(1) == one.charAt(0)){
                monthf = monthf + "January";
                monthz = "01";
            } 
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == two.charAt(0)) {
            monthf = monthf + "Februrary";
            monthz = "02";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == three.charAt(0)) {
            monthf = monthf + "march";
            monthz = "03";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == four.charAt(0)) {
            monthf = monthf + "april";
            monthz = "04";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == five.charAt(0)) {
            monthf = monthf + "may";
            monthz = "05";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == six.charAt(0)) {
            monthf = monthf + "june";
            monthz = "06";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == seven.charAt(0)) {
            monthf = monthf + "july";
            monthz = "07";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == eight.charAt(0)) {
            monthf = monthf + "august";
            monthz = "08";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == nine.charAt(0)) {
            monthf = monthf + "september";
            monthz = "09";
        }
        if (month.charAt(0) == zero.charAt(0) && month.charAt(1) == zero.charAt(0)) {
            monthf = monthf + "october";
            monthz = "10";
        }
        if (month.charAt(0) == one.charAt(0) && month.charAt(1) == one.charAt(0)) {
            monthf = monthf + "november";
            monthz = "11";
        }
        if (month.charAt(0) == one.charAt(0) && month.charAt(1) == two.charAt(0)) {
            monthf = monthf + "december";
            monthz = "12";
        }



            }
        catch(Exception e) {
            return (fail);
}
        


        //System.out.println(yearf);
        //System.out.println(monthf);
        //System.out.println(day); 


        //ArrayList<String> raray = new ArrayList <>();
        //System.out.println(monthz);
        String[] rary = {yearf,monthf,day,author,text,monthz};
        //System.out.println(raray[0]);   
        return(rary);
    }


    public static String[] splitter (String wordSent)throws IOException {
        try{
         String[] swords =  wordSent.split(" ");
            //System.out.println(swords[0]);
            //System.out.println(swords[2]);
            return (swords);
    }
    catch(Exception e) {
        String[] fail = {"0"};
        return fail;
        }
}
        

/*
public static String[] sentiment (ArrayList <String[]> sentences){
    String[] inputInfo = {""};
    String[] hi = {""};
    String tester = "";
    try{
    
    //for (int w = 0; w < sentences.size(); w++) {
        StanfordCoreNLP stanfordcoreCoreNLP = Pipeline.getPipeline();

        inputInfo = sentences.get(w);
        tester = inputInfo[4];
        CoreDocument coreDocument = new CoreDocument (tester);
        StanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> sentences = coreDocument.sentences();
        for(CoreSentence sentence : sentences) {
            String yoooo = sentence.sentiment();
            System.out.println(yoooo + "   "+sentence);

        }

        
    
   // }
    
    System.out.println(tester);

    }
    catch(Exception e) {
        String[] fail = {"0"};
        return fail;
        }
        return(hi);
}
*/



public static int getSentiment(String tweet,String tempYear, String tempMonth,String tempDay,int startYear,int startMonth,int startDay,int middleYear,int middleMonth,int middleDay,int endYear,int endMonth,int endDay){
     


    try{
        
            Properties props = new Properties();
            props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
            StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
            Annotation annotation = pipeline.process(tweet);
            CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
        
            return RNNCoreAnnotations.getPredictedClass(tree);
    
        
        } catch (Exception e){
            return 0;
        }
    
}
}


        


    /*
    public static String[] author (String[] sent) {
        String writer = "";
        String checker = "1";
        try {
            writer = sent[7];
        } catch (ArrayIndexOutOfBoundsException e) {
            checker = "0";
        }   
        //System.out.println(writer+"!!!!!!!!!!!!!!!!!");
        String[] returner = {"","",""};
        returner [0] = writer;
        returner[1] = checker;
        return(returner);
    }
    */







//https://www.fusion-reactor.com/blog/how-to-fix-an-array-index-out-of-bounds-exception-in-java/