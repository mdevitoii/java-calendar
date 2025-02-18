// Michael DeVito II

public class calendar {
    // method that takes in the month and year and returns what day of the week each day falls on
    public static int[] getDays(int m, int y, int[] numDays){
        int[] textDays = new int[numDays.length];
        for (int d = 1; d < numDays.length + 1; d++){
            int y0 = y - (14 - m) / 12;
            int x = y0 + y0/4 - y0/100 + y0/400;
            int m0 = m+12 * ((14-m)/12)-2;
            int d0 = (d+x+(31*m0)/12)%7;
            textDays[d-1] = d0;
        }
        return textDays;
    }

    // methods that takes in the month and returns the number of days that month has
    public static int[] getNumOfDays(int m, int y) {
        int numOfDays = 31;
        switch (m) {
            case 2:
                boolean isLeapYear = (y % 4 == 0);
                isLeapYear = isLeapYear && (y % 100 != 0);
                isLeapYear = isLeapYear || (y % 400 == 0);
                if (isLeapYear){
                    numOfDays = 29;
                } else {
                    numOfDays = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numOfDays = 30;
                break;
        }
        int[] numDays = new int[numOfDays];
        for (int i = 0; i < numOfDays; i++) {
            numDays[i] = i + 1;
        }
        return numDays;
    }

    // method that converts the month from int to String
    public static String getMonth(int m){
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m-1];
    }

    // method that takes the number of days, which day of the week each day is, and the month
    // side effect: prints a calendar
    public static void printCalendar(int[] textDays, int[] numDays, int m){
        StdOut.println("\t\t\t\t----- " + getMonth(m) + " -----");
        StdOut.println("Sun\t\tMon\t\tTue\t\tWed\t\tThu\t\tFri\t\tSat");

        String[][] month = new String[6][7];
        int currentDay = 0;
        for (int d = 0; d < 7; d++){
            if (d<textDays[0]){
                month[0][d] = " ";
            }
            else if (d == textDays[0]){
                month[0][d] = Integer.toString(numDays[currentDay]);
                currentDay++;
            } else {
                month[0][d] = Integer.toString(numDays[currentDay]);
                currentDay++;
            }
        }

        for (int r = 1; r < 6; r++){
            for (int c = 0; c < 7; c++){
                if (currentDay < numDays.length){
                    month[r][c] = Integer.toString(numDays[currentDay]);
                    currentDay++;
                } else {
                    month[r][c] = " ";
                    currentDay++;
                }

            }
        }

        // print the calendar
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                StdOut.print(month[i][j] + "\t\t");
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        StdOut.print("Enter the month (ex: 4): ");
        int m = StdIn.readInt();
        StdOut.print("Enter the year (ex: 2025): ");
        int y = StdIn.readInt();
        int[] numDays = getNumOfDays(m,y);
        int[] textDays = getDays(m,y,numDays);
        printCalendar(textDays,numDays,m);

    }
}
