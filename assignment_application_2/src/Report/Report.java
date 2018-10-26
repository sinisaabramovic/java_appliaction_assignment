package Report;

import java.io.*;
import java.util.List;
import Currency.Currency;

// Base Report class
public class Report {

    private static Report ourInstance = new Report();

    public static Report getInstance() {
        return ourInstance;
    }

    private Report() {

    }

    public void writeToHtml(List<Currency> curencies, String outputHtmlFile){
        try {
            BufferedReader br = new BufferedReader(new FileReader(outputHtmlFile));

            File f = new File("data/result.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html>");
            bw.newLine();
            bw.write("<head><meta charset=\"UTF-8\"></head>");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();
            bw.write("<h1>Data Report</h1>");
            bw.newLine();
            bw.write("<table>");
            bw.newLine();

            for (Currency currency : curencies) {
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getCurrencyNum().key + "</td>" + "<td>" + currency.getCurrencyNum().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getDate().key + "</td>" + "<td>" + currency.getDate().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getState().key + "</td>" + "<td>" + currency.getState().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getCurrencyCode().key + "</td>" + "<td>" + currency.getCurrencyCode().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getUnit().key + "</td>" + "<td>" + currency.getUnit().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getCurrencyForBuy().key + "</td>" + "<td>" + currency.getCurrencyForBuy().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getMiddleForCurrency().key + "</td>" + "<td>" + currency.getMiddleForCurrency().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>" + currency.getSellForCurrency().key + "</td>" + "<td>" + currency.getSellForCurrency().value + "</td>");
                bw.write("</tr>");
                bw.newLine();
                bw.write("<tr>");
                bw.write("<td>&nbsp;</td>");
                bw.write("</tr>");
                bw.newLine();
            }

            bw.write("</table>");
            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");

            br.close();
            bw.close();

        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
