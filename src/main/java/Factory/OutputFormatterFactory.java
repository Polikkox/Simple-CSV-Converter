package Factory;

import OutputFormat.JsonOutputFormatter;
import OutputFormat.OutputFormatter;
import OutputFormat.TableOutputFormatter;
import OutputFormat.XmlOutputFormatter;
import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {

    public OutputFormatter createByFormat(OutPutFormat outputFormat){
        if(outputFormat == null){
            return null;
        }
        switch (outputFormat.toString()) {
            case "TABLE":
                return new TableOutputFormatter();
            case "JSON":
                return new JsonOutputFormatter();
            case "XML":
                return new XmlOutputFormatter();
        }
        return null;
    }
}
