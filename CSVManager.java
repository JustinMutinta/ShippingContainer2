import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVManager {

    public void reset(){
        List<List<String>> contents = Arrays.asList(
                Arrays.asList("BMW","70", "70", "70","BMW Vehicle", "Unassigned"),
                Arrays.asList("Honda", "70", "70", "70", "Honda Vehicle", "Unassigned"),
                Arrays.asList("Box of pens", "30", "30", "30", "This is a box of Pens", "Unassigned"),
                Arrays.asList("Box of Chairs", "30", "30", "30", "This is a box of Chairs", "Unassigned"),
                Arrays.asList("Box of Tables", "30", "30", "30", "This is a box of Tables", "Unassigned"),
                Arrays.asList("Box of Cameras", "30", "30", "30", "This is a box of Cameras", "Unassigned"),
                Arrays.asList("Box of Coffee", "30", "30", "30", "This is a box of Coffee", "Unassigned"),
                Arrays.asList("Box of Coffee", "30", "30", "30", "This is a box of Coffee", "Unassigned")
        );

        try {
            FileWriter csvWriter = new FileWriter("Ship.csv");

            for(List<String> rowData : contents){
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
