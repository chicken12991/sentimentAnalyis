import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
public class driver1{
    public static void main(String[] args)throws IOException{
        //try {
        int startYear = 2020;
        int startMonth = 04;
        int startDay = 12;
        int middleYear = 2020;
        int middleMonth = 05;
        int middleDay = 26;
        int endYear = 2020;
        int endMonth = 06;
        int endDay = 3;
        String[] searchWords = {"protests","protest","protesters"};

        
        String fail = "0";
        String path = "C:\\Users\\mccal\\Desktop\\java\\java project\\Covid-19 Twitter Dataset (Apr-Jun 2020).csv"; // fill in this line with the correct path
        String line = "";
        String data4 = "";
        int num = 0;
        int tempNum = 0;
        String data = "";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        ArrayList<String[]> dabigone = new ArrayList <>();
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        while((data = reader.readLine()) != null && num < 11000000) {
            

            String datas[] = sent1.trimmer(data);
            if (datas[0].charAt(0) != fail.charAt(0)) {
                
            //System.out.println(datas[0]);
            //System.out.println(datas[1]);
            //System.out.println(datas[2]);
            //System.out.println(datas[3]);
            //System.out.println(datas[4]);
            //System.out.println(datas[5]);
            
            data4 = datas[4];

            String wordsFinal[] = sent1.splitter(data4);
            for (int y = 0; y < wordsFinal.length; y++){
                words.putIfAbsent(wordsFinal[y],0);

                if (words.containsKey(wordsFinal[y])) {
                    tempNum = words.get(wordsFinal[y]);
                    tempNum = tempNum + 1;
                    words.put(wordsFinal[y],tempNum+1);



                    //System.out.println(wordsFinal[y]+ "   "+words.get(wordsFinal[y]));

                }
            }
            
            
            dabigone.add(datas);
            num = num+1;
            //System.out.println(num + "!!!!!!");
            //System.out.println (dabigone.size() + " size");
            }
            //sent1.sentiment(dabigone);


            









            //System.out.println(datas[0]);
            
            //System.out.println(num+"    "+data);
            //String[] author = sent1.author(datas);
            //System.out.println(author[1]);
            
            //System.out.println(author[1]);
            

        }

        String[] temp = {""};
        String tempsentence = "";
        String tempYear = "";
        String tempDay = "";
        String tempMonth = "";
        double numberTotal = 0;
        double numberTotal2 = 0;
        double number = 0;
        double number2 = 0;
        double number3 = 0;
        double number4 = 0;
        double SD = 0;
        double SD2 = 0;
        ArrayList<Double> dabigonestats = new ArrayList <>();
        ArrayList<Double> dabigonestats2 = new ArrayList <>();
        double timesActivated = 0;
        double timesActivated2 = 0;
        String tempDate= "" ;
        
        for (int w = 0; w < dabigone.size(); w++) {
            try {
            temp = dabigone.get(w);
            tempsentence = temp[4];
            tempYear = temp[0];
            tempMonth = temp[5];
            tempDay = temp[2];
            int intYear=Integer.parseInt(tempYear);  
            int intMonth=Integer.parseInt(tempMonth);  
            int intDay=Integer.parseInt(tempDay);
            //System.out.println(intDay + "the DAY is this rn");
            //System.out.println(tempMonth + "the DAY is this rn");
            String[] sentArray = tempsentence.split(" ");
            for (int h = 0; h < sentArray.length;h++) {
                if (sentArray[h].equals(searchWords[0]) || sentArray[h].equals(searchWords[1]) || sentArray[h].equals(searchWords[2])) {

            if (intYear >= startYear && intYear <= middleYear && intMonth >= startMonth && intMonth <= middleMonth && intDay >= startDay && intDay <= middleDay){ 
                


                number = sent1.getSentiment(tempsentence,tempYear,tempMonth,tempDay,startYear,startMonth,startDay,middleYear,middleMonth,middleDay,endYear,endMonth,endDay);
                System.out.println(number);
                System.out.println(tempsentence);
            
            
                System.out.println(w);
                System.out.println(tempMonth + "the MONTH is this rn");
                System.out.println(tempDay + "the DAY is this rn");
                numberTotal = numberTotal + number;
                timesActivated = timesActivated + 1;
                dabigonestats.add(number);




            }


            if (intYear >= middleYear && intYear <= endYear && intMonth >= middleMonth && intMonth <= endMonth){  
                if (intMonth < endMonth || intMonth==endMonth && intDay <= endDay) {


                number2 = sent1.getSentiment(tempsentence,tempYear,tempMonth,tempDay,startYear,startMonth,startDay,middleYear,middleMonth,middleDay,endYear,endMonth,endDay);
                System.out.println(number);
            
            
                System.out.println(w);
                System.out.println(tempMonth + "the MONTH is this rn");
                System.out.println(tempDay + "the DAY is this rn");
                numberTotal2 = numberTotal2 + number2;
                timesActivated2 = timesActivated2 + 1;
                dabigonestats2.add(number);
                }



        }

        


            }
            }
        //System.out.println("with 0 being very negative and 4 being very positive, the averrage tweet on twitter is:  "+numberTotal/timesActivated);
        } catch (Exception e){
            
        }
        }
        System.out.println(numberTotal);
        System.out.println(" BEFORE the date the average sentiment was"+ numberTotal/timesActivated);
        System.out.println(numberTotal2);
        System.out.println(" AFTER the date the average sentiment was"+ numberTotal2/timesActivated2);

        for (int u = 0; u < dabigonestats.size();u++){
            //System.out.println(dabigonestats.get(u)+"hihihi");
            number3 = (dabigonestats.get(u)-(numberTotal/timesActivated))*(dabigonestats.get(u)-(numberTotal/timesActivated));
            //System.out.println (number3);
            number4 = number4 + number3;
            //System.out.println (number4);
            SD = Math.sqrt(number4/(timesActivated-1.0));
            

            

        }
        System.out.println ("the sd 1 is  "+SD);
        number4 = 0;

        for (int y = 0; y < dabigonestats2.size();y++){
            //System.out.println(dabigonestats.get(u)+"hihihi");
            number3 = (dabigonestats2.get(y)-(numberTotal2/timesActivated2))*(dabigonestats2.get(y)-(numberTotal2/timesActivated2));
            //System.out.println (number3);
            number4 = number4 + number3;
            //System.out.println (number4);
            SD2 = Math.sqrt(number4/(timesActivated2-1.0));
            

            

        }
        System.out.println ("the sd 2 is  "+SD2);
        System.out.println ("the times 1 is  "+timesActivated);
        System.out.println ("the times 2 is  "+timesActivated2);





        File file1 = new File("output.txt");
        FileWriter fw = new FileWriter(file1);
        PrintWriter pw  = new PrintWriter(fw);
        pw.write(" BEFORE the date the average sentiment was"+ numberTotal/timesActivated +" with "+ numberTotal+" instances and a SD of"+SD+"\n AFTER the date the average sentiment was"+ numberTotal2/timesActivated2+" with "+ numberTotal2+" instances and an sd of "+ SD2);
        pw.close();



    
   // catch(Exception e) {
            
//}






}
}


//https://www.youtube.com/watch?v=IMfMyd3M1Cw
//https://sentry.io/answers/how-to-compare-strings-in-java/#:~:text=To%20compare%20strings%20in%20Java%20for%20equality%2C%20you%20should%20use,equals()%20.&text=If%20uppercase%20and%20lowercase%20difference,equalsIgnoreCase()%20.

