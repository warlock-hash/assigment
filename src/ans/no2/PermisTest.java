package ans.no2;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class PermisTest {

    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty("user.home"));

        try
        {
            // ye lines mujhe is liye change karni parhi qk humari ye class packge use karhe
            // agar packge nhi hoga to ye code exactly chale ga
            Scanner scObj = new Scanner (new File("src/ans/no2/input.txt"));

            int no1 = scObj.nextInt();
            int no2 = scObj.nextInt();
            System.out.println("The two nos are : " + no1 + ", " + no2);

            // Write to a File
            Formatter outObj = new Formatter(new File("src/ans/no2/output.txt"));
            int totalSum = no1 + no2;
            System.out.println("The total sum value is " + totalSum);
            outObj.format("%d", totalSum);
            outObj.close();
        }
        catch(Exception ee)
        {
            System.out.println("Error "+ee.toString());
        }
    }

}
