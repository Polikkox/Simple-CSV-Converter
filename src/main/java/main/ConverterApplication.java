package main;

import Controller.SimpleCsvConverter;
import Factory.OutPutFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import java.io.File;

@ComponentScan({"Controller", "MODEL", "Factory"})
@SpringBootApplication
public class ConverterApplication {

    public static void main(String[] args) {

        if(args.length < 1){
            System.out.println("No input file defined");
            return;
        }
        handleInputArgs(args);
    }

    private static void handleInputArgs(String[] args){

        File file;
        OutPutFormat outPutFormat = null;
        if(args.length == 1){
            int path = 0;
            file = new File("src/main/resources/" + args[path]);
            outPutFormat = OutPutFormat.TABLE;
        }
        else if(args.length == 2){
            int path = 1;
            int format = 0;
            file = new File("src/main/resources/" + args[path]);
            for(OutPutFormat enumFormat : OutPutFormat.values()){
                if(enumFormat.toString().equals(args[format].toUpperCase())){
                    outPutFormat = enumFormat;
                }
            }
            if(outPutFormat == null){
                System.out.println("Format not found");
                return;
            }
        }
        else {
            System.out.println("Invalid arguments");
            return;
        }
        runConverter(file, outPutFormat);
    }

    private static void runConverter(File file, OutPutFormat outPutFormat){
        ApplicationContext context = SpringApplication.run(ConverterApplication.class);
        SimpleCsvConverter simpleCsvConverter = context.getBean(SimpleCsvConverter.class);
        if (file.exists()) {
            simpleCsvConverter.convert(file, outPutFormat);
        }
        else{
            System.out.println("File does not exist");
        }
    }
}
