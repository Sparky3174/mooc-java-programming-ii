
import java.lang.StringBuilder;

public class Program {

    public static void main(String[] args) {
        // Test your method here
        int[][] matrix = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
//        return Arrays.toString(array); //welp, i tried

//for every row, add each column to the string
        StringBuilder string = new StringBuilder(); //make new stringbuilder
        for (int row = 0; row < array.length; row++) { //for every row in the array
            for (int column = 0; column < array[row].length; column++) { //for every value (column) in the specified row in the array
                string.append(array[row][column]); //append the object located at the current row + column location specified (You can think of this as x (row) and y (column)
            }
            string.append("\n"); //append a new line at the end of each row
        }
        return string.toString(); //return the resulting table.
    }
    
    //REMEMBER that the arrays start at 0! i.e: upper left corner is 0,0; middle left is 1,0; middle right is 1,3
    //Also, unlike a coordinate plane, the "Y" (row) value goes FIRST

}
