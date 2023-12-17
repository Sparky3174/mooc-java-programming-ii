
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }
        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
       ArrayList<Integer> sums = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
                int sum = Arrays.stream(square[row]).sum();
                sums.add(sum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int column = 0; column < square[0].length; column++) { //for every column (we do magicSquare[0] because the length of the first row is always equal to the number of columns in the array))
            int sum = 0; //init sum
            for (int row = 0; row < square.length; row++) { //for every row in the array
                sum += square[row][column]; //add the selected value to the sum 
            }
            sums.add(sum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        
        //for every column in the array, start by getting the first value [0][0] and then add one to each, then do the opposite for the other diagonal
        ArrayList<Integer> sums = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < square[0].length; i++) {
            sum += square[i][i];
        }
        sums.add(sum);
        
        sum = 0;
        for (int col = square[0].length -1, row = 0; col >= 0; col--, row++) {
            sum += square[row][col];
        }
        sums.add(sum);
        
        return sums;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }
    
    public int[][] getArray() {
        return this.square;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
