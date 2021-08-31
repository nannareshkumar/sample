package codereview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CashRegister {
    public static void main(String[] args) throws FileNotFoundException {

        String pathName = "D:\\sample\\src\\codereview\\currency.txt";
        //Scanner fileInput = new Scanner(file);
        Scanner fileInput = null;
        try {
            fileInput = (args.length <= 0) ? new Scanner(new File(pathName))
                    : new Scanner(System.in);
            while (fileInput.hasNextLine()) {
                printCashChange(fileInput.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            fileInput.close();
        }
    }

    private static void printCashChange(String line) {
//        float pp = Float.parseFloat(line.split(";")[0]);
//        float ch = Float.parseFloat(line.split(";")[1]);

        String[] fields = line.split(";", 2);
        float pp = Float.parseFloat(fields[0]);
        float ch = Float.parseFloat(fields[1]);

        System.out.println(" price " + pp + " cash "+ ch + " " + getCashChange(pp, ch));

        System.out.println( getCashChangeAfter(pp, ch));
    }

    private static String getCashChangeAfter(float price, float cash) {

        if (cash < price) { return "ERROR"; }
        if (cash == price) { return "ZERO"; }

        float cashBack = cash - price;
        StringBuilder change = new StringBuilder();

        for (Denomination d : Denomination.values()) {
            while (cashBack >= d.getValue()) {
                cashBack -= d.getValue();
                change.append(d).append(',');
            }
        }
        change.setLength(change.length() - 1);
        return change.toString();
    }

    private static String getCashChange(float price, float cash) {
        if (cash < price) { return "ERROR"; }
        if (cash == price) { return "ZERO"; }
        float cashBack = cash - price;


        StringBuilder change = new StringBuilder();

        while (cashBack > 0.01f) {
            if (cashBack >= 100.0f) {
                change.append("ONE HUNDRED");
                cashBack -= 100.0f;
            } else if (cashBack >= 50.0f) {
                change.append("FIFTY");
                cashBack -= 50.0f;
            } else if (cashBack >= 20.0f) {
                change.append("TWENTY");
                cashBack -= 20.0f;
            } else if (cashBack >= 10.0f) {
                change.append("TEN");
                cashBack -= 10.0f;
            } else if (cashBack >= 5.0f) {
                change.append("FIVE");
                cashBack -= 5.0f;
            } else if (cashBack >= 2.0f) {
                change.append("TWO");
                cashBack -= 2.0f;
            } else if (cashBack >= 1.0f) {
                change.append("ONE");
                cashBack -= 1.0f;
            } else if (cashBack >= 0.5f) {
                change.append("HALF DOLLAR");
                cashBack -= 0.5f;
            } else if (cashBack >= 0.25f) {
                change.append("QUARTER");
                cashBack -= 0.25f;
            } else if (cashBack >= 0.1f) {
                change.append("DIME");
                cashBack -= 0.1f;
            } else if (cashBack >= 0.05f) {
                change.append("NICKEL");
                cashBack -= 0.05f;
            } else {
                change.append("PENNY");
                cashBack -= 0.01f;
            }
            change.append(",");
        }
        change.setLength(change.length() - 1);

        return change.toString();
    }
}
