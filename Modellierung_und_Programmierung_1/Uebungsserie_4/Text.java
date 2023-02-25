import java.lang.String;
import java.lang.StringBuilder;
import java.io.*;
import java.util.*;

public class Text {

    StringBuilder text;

    public Text(){
        StringBuilder text = new StringBuilder();
        this.text = text;
    }

    public void leseTextAusDatei(String dateiName){
        File file = new File(dateiName);
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ){
        readLine(bufferedReader);
        }
        catch (FileNotFoundException fnfEx) {
            fnfEx.printStackTrace(System.err);
        }
        catch (IOException ioEx){
            ioEx.printStackTrace(System.err);
        }

        }

    private void readLine(
            BufferedReader bufferedReader
            ) throws IOException{
        String line = bufferedReader.readLine();
        while (line != null){
            text.append(line + " ");
            line = bufferedReader.readLine();
        }
    }

    public String toString(){
        String textStrNeu = text.toString();
        return textStrNeu;
    }
}
