
public class MagicSquareFactory {

    private int currentRow;
    private int currentColumn;
    private int previousRow;
    private int previousColumn;
    private MagicSquare square;

    public MagicSquare createMagicSquare(int size) {
        //this is not my original answer, I have already completed this assignment, but after seeing someone else's code, i decided to implement their methodology into my own design
        //Now, the currentRow, previousRow, etc. are all contained in their own local variables
        //And what used to be (isOccupied, isOutside) now transform those variables as they are called, instead of only returning a boolean value.

        this.square = new MagicSquare(size);

        if (size % 2 == 0) { //cannot make a magic square out of a even size
            return null;
        }

        // implement the creation of a magic square with the Siamese method algorithm here
        int centerOfArray = (square.getWidth() / 2);
        this.currentRow = 0; //siamese method always start at the first row
        this.currentColumn = centerOfArray; //and middle column

        for (int i = 1; i <= (square.getHeight() * square.getWidth()); i++) { //performs the siamese method once for every space present in the square (ie: the area of the square)
            square.placeValue(currentColumn, currentRow, i); //places the value on the square
            this.previousRow = currentRow; //updates the previous row incase it is needed for siamese method
            this.previousColumn = currentColumn;//updates the previous column incase it is needed for siamese method

            calcNextMove(); //attempt to perform placement tranformation of siamese method
        }
        System.out.println(square); //printing square for verification
        return square;
    }

    public void calcOccupied() {
        if (square.readValue(currentColumn, currentRow) != 0) { //if the square trying to be reached is already filled (i.e: not 0)
            currentRow = previousRow + 1; //put the next number underneath the first
            currentColumn = previousColumn;
        }
    }

    public void calcNextMove() {
        currentRow--; //attempt siamese method (move up + to right)
        currentColumn++;

        calcOutside(); //perform any necessary transformations if the new placement is outside valid placement
        calcOccupied(); //perform any necessary transformations if the new placement is already occupied
    }

    public void calcOutside() {
        if (currentColumn > square.getWidth() - 1) { //checks if the placement  is outside the valid number of columns
            //right
            currentColumn = 0; //if so, wrap to the left side
        }
        if (currentRow < 0) { //checks if the placement is outside the valid number of rows
            //up
            currentRow = square.getHeight() - 1; //if so, wrap to the bottom
        }
    }
}
