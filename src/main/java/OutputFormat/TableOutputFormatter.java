package OutputFormat;

import java.util.List;

public class TableOutputFormatter implements OutputFormatter {
    public void printToConsole(List<String> data) {

        for(String rows : data){
            String[] row = rows.split(",");
            System.out.format("|%-3s |%-30s |%-10s |%-15s|", row[0],  row[1],  row[2],  row[3]);
            System.out.println();
        }
    }
}
