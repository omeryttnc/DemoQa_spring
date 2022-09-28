package QA.Java_Calisma.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DATE_CALENDER {

    public static String getTodayMonth() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM");
        Date date = new Date();
        return format.format(date);
    }

    public static String getTodaysDay() {
        SimpleDateFormat format = new SimpleDateFormat("d");
        Date date = new Date();
        return format.format(date);
    }



    public static String getTodayMonthYear() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy");
        Date date = new Date();
        return format.format(date);
    }

    public static String getTodayYear_month_day() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return format.format(date);
    }

    public static String getTodayMonthDayYear() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        Date date = new Date();
        return format.format(date);
    }
    //date_compare de kullanilan method icin yazildi
    public static boolean dateCompare(String firstDate, String secondDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM/dd");

        boolean b = false;
        try {
            b = sdf.parse(firstDate).before(sdf.parse(secondDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean date_compare(String date) {
        // su anki saati alip istenilen formata ceviriyor
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM/dd");
        String formattedDate = myDateObj.format(myFormatObj);

        int bosluk = date.indexOf(" ") + 1;  // ilk boslugu kaldiriyor
        String tarih = date.substring(bosluk); // gunu cikarmis olduk
        int bosluk2 = tarih.indexOf(" "); // ay ile gunu ayirdik
        String ay = tarih.substring(0, bosluk2); // ayi ve altta gunu aldik
        String gun = tarih.substring(bosluk2 + 1).substring(0, tarih.substring(bosluk2 + 1).length() - 2);
        String d = (ay + "/" + gun);
        return (dateCompare(formattedDate, d)); // suanki gunden girilen tarih onde ise true veriyor
    }
    public static String date() {
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, MMMM dd");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public static String convertTime_to_am_pm(String dateInString) {
        //Displaying given time in 12 hour format with AM/PM
        //date = "22.30";
        //old format
        // SimpleDateFormat sdf_old = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        SimpleDateFormat sdf_old = new SimpleDateFormat("hh:mm:ss");
        Date date3 = null;
        SimpleDateFormat sdf_new = null;
        try {
            date3 = sdf_old.parse(dateInString);
            //new format
            sdf_new = new SimpleDateFormat("hh:mm aa");
            //formatting the given time to new format with AM/PM
            // System.out.println("Given time in AM/PM: "+sdf_new.format(date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf_new.format(date3);
    }


    // format method cagrildiginda dinamic yazilabilir. ornegin: "dd/MM/yyyy" veya "MM-dd-yyyy"
    public static String getMeTomorrow(String format) {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +1);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * Bugunden kac gun sonrasi isteniyorsa plus day kismina int olarak yaziliyor.
     * formati da kendimiz giriyoruz
     *
     * @return bugun+plusday
     * @author Abdullah
     * @since 06.06.2022
     */
    public static String getMeADayFromFuture(String format, int plusDay) {
        //Kac gun sonrasinin tarihini almak istiyorsak plusDayé onu yaziyoruz.

        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +plusDay);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * weekly update test i icin database tarih formatinda bir gun sonrasini veriyor
     *
     * @return yarinin tarihi
     * @author omer
     * @since 21.04.2022
     */
    public static String getMeTomorrow_databaseUpdateWeeklyOrder() {
        String format = "YYYY-MM-dd";
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +1);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * Abdullah
     *
     * @return bugunu haftanin gunu olarak donuyor.pazartesiyi ilk gun kabul ediyor.
     */
    public static int getTheDayofTheWeek() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }


    public static String getMe10days_databaseUpdateWeeklyOrder() {
        String format = "YYYY-MM-dd";
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +10);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * weekly update test i icin database tarih formatinda 4 gun sonrasini veriyor
     *
     * @return 4 gun sonraki tarih
     * @author omer
     * @since 21.04.2022
     */
    public static String getMe4days_databaseUpdateWeeklyOrder() {
        String format = "YYYY-MM-dd";
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(format);
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +4);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * @param day
     * @return
     */
    public static String getDateForPromoCode(int day) {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, +day);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    /**
     * @return Database'deki formata gore local date ve saati
     */
    public static String getCurrentDateAndTime() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

        cal.add(Calendar.DATE, 1);
        //  System.out.println("Tomorrow is "+dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

}
