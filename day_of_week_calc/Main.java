import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.text.DateFormat;
import javax.swing.JOptionPane;

class Main {
  

  public static void main(String[] args) {
    
    Scanner dated = new Scanner (System.in);
    
    
    System.out.println("\nAnswer all questions with numbers");
    System.out.println("-------------------");
    System.out.println("Month : ");
    System.out.print("\t");
    int month = dated.nextInt();

    System.out.println("Day : ");
    System.out.print("\t");
    int day = dated.nextInt();

    System.out.println("Year : ");
    System.out.print("\t");
    String year = dated.next();


    int monthkey = 60;
    int lyear = Integer.parseInt(year);
    boolean leapyear = lyear%4==0;
    int checker = lyear%100;
    int checker2 = lyear%400;
    if(checker==0&&checker2==0){
      leapyear=true;
    }else if(checker==0){
      leapyear=false;
    }
    switch (month)
    {
      case 1:
      if(leapyear==true){
        monthkey=4;
      }else{
        monthkey=3;
      }
      break;


      case 2:
      if(leapyear==true){
        monthkey=29;
      }else{
        monthkey=28;
      }
      break;

      case 3:
      monthkey=14;
      break;

      case 4:
      monthkey=4;
      break;

      case 5:
      monthkey=9;
      break;

      case 6:
      monthkey=6;
      break;
      
      case 7:
      monthkey=11;
      break;

      case 8:
      monthkey=8;
      break;

      case 9:
      monthkey=5;
      break;

      case 10:
      monthkey=10;
      break;

      case 11:
      monthkey=7;
      break;

      case 12:
      monthkey=12;
      break;

     


    }
    int daycounter=day;
    int daymonthadd=999;


    switch (day)
    {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      if(day<monthkey){
        for (daycounter = day; daycounter<=monthkey-7; daycounter=daycounter+7){
        if(monthkey-7 == daycounter || monthkey+7==daycounter||monthkey==daycounter){
          daymonthadd=0;
        }
      

        }
      }else if (day>monthkey){
        for (daycounter = day; daycounter>=monthkey+7; daycounter=daycounter-7){
        if(monthkey-7 == daycounter || monthkey+7==daycounter||monthkey==daycounter){
          daymonthadd=0;
        }
        }
        
      }
      daymonthadd=monthkey-daycounter;
      break;

    

    


    }

    String yearNum = year;
    String strYear = String.valueOf(yearNum);
    String ypart1 = strYear.substring(0,2);
    String ypart2 = strYear.substring(2);

    int yearadd=99;

    switch(ypart1)
    {
      case "11":
      case "15":
      case "19":
      case "23":
      case "27":
      case "31":
      case "35":
      case "39":
      case "43":
      case "47":
      case "51":
      case "55":
      case "59":
      case "63":
      case "67":
      case "71":
      case "75":
      case "79":
      case "83":
      case "87":
      case "91":
      case "95":
      case "99":
      yearadd=3;
      break;

      case "12":
      case "16":
      case "20":
      case "24":
      case "28":
      case "32":
      case "36":
      case "40":
      case "44":
      case "48":
      case "52":
      case "56":
      case "60":
      case "64":
      case "68":
      case "72":
      case "76":
      case "80":
      case "84":
      case "88":
      case "92":
      case "96":
      yearadd=2;
      break;


      case "13":
      case "17":
      case "21":
      case "25":
      case "29":
      case "33":
      case "37":
      case "41":
      case "45":
      case "49":
      case "53":
      case "57":
      case "61":
      case "65":
      case "69":
      case "73":
      case "77":
      case "81":
      case "85":
      case "89":
      case "93":
      case "97":
      yearadd=0;
      break;

      case "10":
      case "14":
      case "18":
      case "22":
      case "26":
      case "30":
      case "34":
      case "38":
      case "42":
      case "46":
      case "50":
      case "54":
      case "58":
      case "62":
      case "66":
      case "70":
      case "74":
      case "78":
      case "82":
      case "86":
      case "90":
      case "94":
      case "98":
      yearadd=5;
      break;

    }

    int balch = Integer.parseInt(ypart2);
    int year2add = balch/12;
    int year3add = balch%12;
    int year4add = year3add/4;

    int dayof = (year2add+year3add+year4add-daymonthadd+yearadd)%7;

    //System.out.println("\n\ndigit /12: "+year2add);
    //System.out.println("digit /12 remainder: "+year3add);
    //System.out.println("remainder /4: "+year4add);
    //System.out.println("month day thing: "+daymonthadd);
    //System.out.println("year code: "+yearadd);
    





    











    if(dayof==0){
      System.out.println("\n\nYour date was a Sunday");
    }else if(dayof==1){
      System.out.println("\n\nYour date was a Monday");
    }else if(dayof==2){
      System.out.println("\n\nYour date was a Tuesday");
    }else if(dayof==3){
      System.out.println("\n\nYour date was a Wednesday");
    }
    else if(dayof==4){
      System.out.println("\n\nYour date was a Thursday");
    }else if(dayof==5){
      System.out.println("\n\nYour date was a Friday");
    }else if(dayof==6){
      System.out.println("\n\nYour date was a Saturday");
    }

    String dob = month+"/"+day+"/"+year;

    if(valDOB(dob)){
      System.out.println( "Valid Date");
    }else{
      System.out.println( "Invalid Date");
      
    }
    
  }




  

  public static boolean valDOB(String DOB){

    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    Date BOD = null;
    df.setLenient(false);

    try{

      BOD = df.parse(DOB);
      return true;



    }
    catch (Exception e){
      return false;
    }
  }
   
   
    
 
  
   
}
