import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CSVManager shiptest = new CSVManager();

        shiptest.reset();
        //System.out.println("Complete");

        //shiptest.print();

        ArrayList<String[]> testArray = new ArrayList<>();

        shiptest.assignToArrayList(testArray);

        //System.out.println(testArray.get(0)[0]);
        for(int i = 0; i < testArray.size(); i++){
            System.out.println("The name of the object is a: " + testArray.get(i)[0] + ", and its location is: "
            + testArray.get(i)[5]);
        }

        testArray.get(0)[5] = "Assigned";
        shiptest.updateCSVFile(testArray);

    }
}
