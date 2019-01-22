package OutputFormat;

import java.util.List;

public class JsonOutputFormatter implements OutputFormatter{
    public void printToConsole(List<String> data) {
        String[] heading = data.get(0).split(",");
        StringBuilder JSON = new StringBuilder();
        String space = "  ";

        JSON.append("[\n");

        for(int numberOfRow = 1; numberOfRow < data.size(); numberOfRow++){
            JSON.append(space).append("{\n");
            String[] tempRow = data.get(numberOfRow).split(",");

            for(int i = 0; i < heading.length; i++){
                JSON.append(space).append(space).append("\"").append(heading[i]).append("\": ");
                JSON.append("\"").append(tempRow[i]).append("\"");
                JSON.append(",\n");
            }
            JSON.append(space).append("}\n");

        }
        JSON.append("]");
        System.out.println(JSON.toString());
    }
}
