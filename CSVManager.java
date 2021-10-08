import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//CSV work will be completed on this class
public class CSVManager {

    //reset() function will be to reset all csv objects to "default" settings. Otherwise once the program is ended,
    //users will be opening previous work
    public void reset(){
        //List<List<String>> creates a list inside a list of String value. That way content information is grouped together
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

        //need try and catch when working with files
        try {
            //create new csv file object
            FileWriter csvWriter = new FileWriter("Ship.csv");

            //for loop gets all objects in a list and creates string value separated by a ","
            //new line other wise when you read it, it will be assumed to be the same object
            for(List<String> rowData : contents){
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            //flush and close to show that no more information will be entered. Also, cleans things up.
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {   //catch in case there is a problem accessing the file. If the file is not present, will create a new one
            e.printStackTrace();
        }
    }

    //function to print contents of the csv file
    public void print(){
        String line = "";

        try {
            //BufferedReader object to read from the csv file
            BufferedReader br = new BufferedReader(new FileReader("Ship.csv"));

            //cheat sheet for csv file:
            //0=object,1=length,2=width,3=height,4=description,5=location

            while((line = br.readLine()) != null){
                System.out.println(line);   //prints of the lines of the csv file. nothing else
                String[] values = line.split(","); //breaks up each line into an array
                System.out.println("The object is: " + values[0] + " and is at location: " + values[5]);   //prints off an array value
                //for future reference can be added to an arraylist using Arrays.asList()
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> assignToArrayList(ArrayList<String[]> anArrayList){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("Ship.csv"));

            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                anArrayList.add(values);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anArrayList;
    }

    public void updateCSVFile(ArrayList<String[]> anArrayList){

        try {
            FileWriter csvWriter = new FileWriter("Ship.csv");

            for(String[] content : anArrayList){
                csvWriter.append(String.join(",", content));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
