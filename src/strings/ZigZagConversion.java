package strings;

public class ZigZagConversion {
    /*
   Leetcode : 6

   THOUGHT :
   Create  arrays of StringBuffer(s) : sb[numRows]
   For numRows = 3, the sequence of inserting into sb array is 0,1,2,1,0,1,2,1,0,1,2.
   Once we hit index numRows - 1 we decrement index by 1. Upon hitting 0 we increment by 1

   Iterate through the input string
   sb[i] = string[itr]
   When i == 0, incr = 1.
   When i == (numRows - 1), incr = -1
   i = i + incr
   */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        char[] chs = s.toCharArray();

        //create numRows arrays of StringBuffer(s)
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {

            sb[i] = new StringBuilder();   //init every sb element **important step!!!!
        }

        // increment will help in setting the boundary.
        int increment = 1;
        // index will determine the sb array
        int index = 0;

        // pick a character and put in appropriate array
        for (int i = 0; i < chs.length; i++) {

            sb[index].append(chs[i]);

            // based on the boundry set increment to 1 or -1
            if (index == 0) increment = 1; // 0,1,2

            if (index == numRows - 1) increment = -1; // 1,0

            // set the next index position
            index += increment; // 0,1,2,1,0,1,2,1,0,1,2
        }

        // append all the sb arrays
        String result = "";
        for (int i = 0; i < sb.length; i++) {

            result += sb[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(str + " zigzag in " + rows + " rows is : " + convert(str, rows));

        rows = 4;
        System.out.println(str + " zigzag in " + rows + " rows is : " + convert(str, rows));
    }
}
