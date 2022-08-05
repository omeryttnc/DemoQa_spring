package QA.utilities;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
@SpringBootApplication
@Execution(ExecutionMode.CONCURRENT)
public class ReadTxt {

    public static List<String> returnUserFullName(String filename){
        List<String> fullNameList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                // String ssn = line.split(",")[0]; sadece ssn veriyor
                fullNameList.add(line.split(",")[1] + " " + line.split(",")[2] + " " + line.split(",")[3] );
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fullNameList;
    }
    public static String returntitle(String filename){
       String fullNameList = "";
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                fullNameList=(line );
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fullNameList;
    }
}
