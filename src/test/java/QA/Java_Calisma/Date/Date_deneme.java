package QA.Java_Calisma.Date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Date_deneme {
    Date date = new Date();

    @Test
    void name() {
        /**
         * bugun gunler den eylul 03  2022
         *
         * zaman
         *
         * HH 24 saatlik saate
         * hh 12 saatlik saate
         *
         * mm dakika
         *
         * ss saniye
         *
         * aa AM PM
         *
         *
         *
         *
         * gun
         * yyyy  yili
         *
         * MMMM September
         * MMM Sept
         * MM 09
         * M 9
         *
         * dd  gunu iki haneli --> 03
         * d   gunu eger tek hanli ise tek hane verecek --> 3
         *
         * EEEE gunun adi
         */


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH : mm : ss");
        System.out.println("simpleDateFormat.format(date) = " + simpleDateFormat.format(date));
        System.out.println("**************");

        SimpleDateFormat simpleDateFormatAMPM = new SimpleDateFormat("hh : mm : ss / aa");
        System.out.println("simpleDateFormatAMPM.format(date) = " + simpleDateFormatAMPM.format(date));

        System.out.println("**************");
        SimpleDateFormat simpleDateFormatAMPM2 = new SimpleDateFormat("h : mm : ss / aa");
        System.out.println("simpleDateFormatAMPM.format(date) = " + simpleDateFormatAMPM2.format(date));

        System.out.println("**************");
//September 19, 2022
        SimpleDateFormat simpleDateFormatAYGUNYIL = new SimpleDateFormat("MMMM dd, yyyy");
        System.out.println("simpleDateFormatAMPM.format(date) = " + simpleDateFormatAYGUNYIL.format(date));

        System.out.println("**************");
//2022-09-19
        SimpleDateFormat simpleDateFormatAYGUNYIL2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("simpleDateFormatAMPM.format(date) = " + simpleDateFormatAYGUNYIL2.format(date));


        System.out.println("**************");
        SimpleDateFormat simpleDateFormatAYGUNYIL3 = new SimpleDateFormat("EEEE, MMMM dd");
        System.out.println("simpleDateFormatAMPM.format(date) = " + simpleDateFormatAYGUNYIL3.format(date));

    }

    public String getDate() {
        Date date = new Date();

        SimpleDateFormat simpleDateFormatAYGUNYIL3 = new SimpleDateFormat("EEEE, MMMM dd");
        return simpleDateFormatAYGUNYIL3.format(date);
    }

    //bugunun tarihini cekiyor
    Calendar calendar = Calendar.getInstance();

    @Test
    void test2() {
        SimpleDateFormat simpleDateFormatAYGUNYIL3 = new SimpleDateFormat("EEEE, MMMM dd hh:mm:ss");

        calendar.add(Calendar.DATE, 10);

        System.out.println("simpleDateFormatAYGUNYIL3.format(calendar.getTime()) = " + simpleDateFormatAYGUNYIL3.format(calendar.getTime()));

    }
    //Sunday, September 25

    LocalDate now = LocalDate.now();

    @Test
    void test3() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM d");
        System.out.println("dtf.format(now) = " + dtf.format(now));
        System.out.println("now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).format(dtf) = " + now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).format(dtf));

        System.out.println("***************************");

        for (int i = 0; i < 6; i++) {

            System.out.println(i + " : " + now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).plusDays(7 * i).format(dtf));
        }


    }

    public void datePicker() {
        String year = "2022";
        String month = "July";
        String day = "10";


        while (true) {
            String monthyear = "Sunday, September 25";
            String arr[] = monthyear.split(" ");
            String mont = arr[0];
            String yr = arr[1];
            if (mont.equals(month) && yr.equals(year))
                break;


        }
    }

    @Test
    void test4() throws ParseException {
        String dat2 = "Sep 25";

        SimpleDateFormat simpleDateFormatAYGUNYIL2 = new SimpleDateFormat("MMM dd");
        String localdate = simpleDateFormatAYGUNYIL2.format(date);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
        System.out.println("sdf.parse(date).before(sdf.parse(dat2)) = " + sdf.parse(localdate).before(sdf.parse(dat2)));


    }
}
