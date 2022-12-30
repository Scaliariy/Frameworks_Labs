/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.Support;

/**
 *
 * @author Erlkonig
 */
public class StatsCalculator {

    private static StatsCalculator instance;//to perform Singleton

    private static double meanAge;
    private static double maxAge;
    private static double minAge;
    private static String popularMail;
    private static double sumduMails;
    private static String NumberDifferentGroups;
    private static String NumberStudentsFromDifferentFaculties;

    private StatsCalculator() {//to perform Singleton
    }

    public static StatsCalculator getInstance() {//to perform Singleton
        if (instance == null) {
            instance = new StatsCalculator();
        }
        return instance;
    }

    public double getMeanAge() {
        return meanAge;
    }

    public double getMaxAge() {
        return maxAge;
    }

    public double getMinAge() {
        return minAge;
    }

    public String getPopularMailDomain() {
        return popularMail;
    }

    public double getSumduMails() {
        return sumduMails;
    }

    public String getNumberDifferentGroups() {
        return NumberDifferentGroups;
    }

    public String getNumberStudentsFromDifferentFaculties() {
        return NumberStudentsFromDifferentFaculties;
    }

    public static void setMeanAge(double meanAge) {
        StatsCalculator.meanAge = meanAge;
    }

    public static void setMaxAge(double maxAge) {
        StatsCalculator.maxAge = maxAge;
    }

    public static void setMinAge(double minAge) {
        StatsCalculator.minAge = minAge;
    }

    public static void setPopularMail(String popularMail) {
        StatsCalculator.popularMail = popularMail;
    }

    public static void setSumduMails(double sumduMails) {
        StatsCalculator.sumduMails = sumduMails;
    }

    public static void setNumberDifferentGroups(String NumberDifferentGroups) {
        StatsCalculator.NumberDifferentGroups = NumberDifferentGroups;
    }

    public static void setNumberStudentsFromDifferentFaculties(String NumberStudentsFromDifferentFaculties) {
        StatsCalculator.NumberStudentsFromDifferentFaculties = NumberStudentsFromDifferentFaculties;
    }

}
