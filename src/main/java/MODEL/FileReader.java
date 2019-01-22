package MODEL;

import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileReader {

    public List<String> readData(File file){
        List<String> list = new ArrayList<>();

        try {
            list = Files.readAllLines(file.toPath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
