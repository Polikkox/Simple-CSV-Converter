package Controller;

import OutputFormat.OutputFormatter;
import Factory.OutPutFormat;
import Factory.OutputFormatterFactory;
import MODEL.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class SimpleCsvConverter {

    private FileReader fileReader;
    private OutputFormatterFactory outputFormatterFactory;

    @Autowired
    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory){
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(File file, OutPutFormat outPutFormat){
        List<String> data = this.fileReader.readData(file);
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outPutFormat);
        outputFormatter.printToConsole(data);
    }
}
