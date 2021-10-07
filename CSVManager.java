import java.io.*;
import java.nio.Buffer;
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

    public void print(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("Ship.csv"));

            //cheat sheet for csv file:
            //0=object,1=length,2=width,3=height,4=description,5=location

            while((line = br.readLine()) != null){
                System.out.println(line);   //prints of the lines of the csv file. nothing else
                String[] values = line.split(","); //breaks up each line into an array
                System.out.println("The object is: " + values[0] + " and is at location: " + values[5]);   //prints off an array value
                //for future reference can be added to an arraylist using Arrays.asList()
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
