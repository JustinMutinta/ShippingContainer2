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

        ArrayList<String[]> testArray2 = new ArrayList<>();

        shiptest.transferArray(testArray, testArray2, 3, "TestArray2");
        shiptest.transferArray(testArray, testArray2, 2, "TestArray2");

        shiptest.printArrayList(testArray2);
        System.out.println("------------------------------------");
        shiptest.printArrayList(testArray);

    }
}
