
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.day;
        hash = 71 * hash + this.month;
        hash = 71 * hash + this.year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        //if the objects are the same return true
        if (this == obj) {
            return true;
        }
        //if the object is null return false
        if (obj == null) {
            return false;
        }
        //if the classes of each object are not the same, return false
        if (getClass() != obj.getClass()) {
            return false;
        }
        //checks if the variables stored in each date are the same, if not return false.
        final SimpleDate other = (SimpleDate) obj;
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }
    
    

}
