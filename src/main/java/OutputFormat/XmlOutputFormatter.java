package OutputFormat;

import java.util.List;

public class XmlOutputFormatter implements OutputFormatter {

    public void printToConsole(List<String> data) {
        String[] heading = data.get(0).split(",");
        StringBuilder XML = new StringBuilder();
        String space = "  ";

        XML.append("<root>\n");

        for(int numberOfRow = 1; numberOfRow < data.size(); numberOfRow++){
            XML.append(space).append("<row-").append(numberOfRow - 1).append(">\n");
            String[] tempRow = data.get(numberOfRow).split(",");

            for(int i = 0; i < heading.length; i++){
                XML.append(space).append(space).append("<").append(heading[i]).append(">");
                XML.append(tempRow[i]);
                XML.append("</").append(heading[i]).append(">\n");
            }
            XML.append(space).append("</row-").append(numberOfRow - 1).append(">\n");

        }
        XML.append("</root>");
        System.out.println(XML.toString());
    }
}
