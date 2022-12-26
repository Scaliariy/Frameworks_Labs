/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.Support;

import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author Erlkonig
 */
public class Utils {
    public static String calculatePopularDomain(LinkedList<Student> studs) throws EmailException{
          Map<String,Integer> mails=new HashMap<String,Integer>(); 
          String tempDomain="";
          String popularDomain="";
          int count=0;
          for(Student st:studs){
              if(Utils.patternMatches(st.getEmail())){
              tempDomain=Utils.getEmailDomain(st.getEmail());
              if(mails.containsKey(tempDomain)){count=mails.get(tempDomain)+1;}
              else{count=1;}
              mails.put(tempDomain,count);
            }
          else{throw new EmailException();}
          }
        Set<String> keys= mails.keySet();
        int max=0;
        for(String current:keys){
        if(max<mails.get(current)){
        max=mails.get(current);
        popularDomain=current;
        }
        }
        return popularDomain;
      }   
    public static double calculateMeanAge(LinkedList<Student> studs){
        double tempAge=0;
        int count=0;
        for(Student st:studs){
            int age=Integer.parseInt(st.getAge());
            if(age>0){
            tempAge+=age;
            count++;
            }
        }
        if(count==0){return -1;}
        return tempAge/count;
    }   
     public static boolean patternMatches(String emailAddress) {
        //регулярний вираз для перевірки введеного email
        String regexPattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    } 
     public static String getEmailDomain(String someEmail)
    {
        return  someEmail.substring(someEmail.indexOf("@") + 1);
    }
     public static double calculateYoungestStudent(LinkedList<Student> studs) {
        String youngestStudentName = "";
         double minAge = 0;
        for (Student st : studs) {
            int age = Integer.parseInt(st.getAge());
            if (age < minAge || minAge == 0) {
                minAge = age;
                youngestStudentName = st.getName();
            }
        }
        return minAge;
    }

    public static double calculateOldestStudent(LinkedList<Student> studs) {
        String oldestStudentName = "";
        double maxAge = 0;
        for (Student st : studs) {
            int age = Integer.parseInt(st.getAge());
            if (age > maxAge || maxAge == 0) {
                maxAge = age;
                oldestStudentName = st.getName();
            }
        }
        return maxAge;
    }

    public static double calculateSumduDomain(LinkedList<Student> studs) throws EmailException{
        String tempDomain;
        double count = 0;
        for (Student st : studs) {
            if (Utils.patternMatches(st.getEmail())) {
                tempDomain = Utils.getEmailDomain(st.getEmail());
                if (tempDomain.contains("sumdu")) {
                    count++;
                }
            } else {
                throw new EmailException();
            }
        }
        return count;
    }

    public static String calculateDifferentGroups(LinkedList<Student> studs) {
        Map<String, Integer> groups = new HashMap<String, Integer>();
        String tempGroup = "";
        int count = 0;
        for (Student st : studs) {
            tempGroup = st.getGroup();
            if (groups.containsKey(tempGroup)) {
                count = groups.get(tempGroup) + 1;
            } else {
                count = 1;
            }
            groups.put(tempGroup, count);
        }

        String result = "";

        for (Map.Entry<String, Integer> entry : groups.entrySet()) {
            result += entry.getKey() + " : " + entry.getValue() + "\n";
        }

        return result;
    }

    public static String calculateNumberStudentsFromDifferentFaculties(LinkedList<Student> studs) {
        Map<String, Integer> faculties = new HashMap<String, Integer>();
        String tempFaculty = "";
        int count = 0;
        for (Student st : studs) {
            tempFaculty = st.getFaculty();
            if (faculties.containsKey(tempFaculty)) {
                count = faculties.get(tempFaculty) + 1;
            } else {
                count = 1;
            }
            faculties.put(tempFaculty, count);
        }

        String result = "";

        for (Map.Entry<String, Integer> entry : faculties.entrySet()) {
            result += entry.getKey() + " : " + entry.getValue() + "\n";
        }

        return result;
    }

}
