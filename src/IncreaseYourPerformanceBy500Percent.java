/**
 * Created by XGY_X1C on 6/18/2016.
 */

//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//        For example, Given s = “eceba”,
//
//        T is "ece" which its length is 3.

public class IncreaseYourPerformanceBy500Percent {
    /**
     * Average running time 23ms
     *
     * @param s
     * @return
     */
    public int SLOW_lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();
        Character[] set = new Character[2]; // Uhmm Object? array?
        set[0] = s.charAt(0);
        set[1] = null;
        int max = 2;
        int start = 0, intern = 1;
        int i;
        for (i = 1; i < s.length(); i++) {
            //check if in
            if (s.charAt(i) != set[0]) { // calling String::charAt every time?
                if (set[1] != null) {
                    if (s.charAt(i) != set[1]) {
                        // This is actually calling public static int max(int a, int b) {return (a >= b) ? a : b;}
                        max = Math.max(max, i - start);
                        start = intern;
                        intern = i;
                        set[0] = s.charAt(i - 1); //String::charAt
                        set[1] = s.charAt(i);
                    }
                } else {
                    set[1] = s.charAt(i);
                }
            }
            if (s.charAt(i) != s.charAt(intern)) intern = i;
        }
        max = Math.max(max, i - start);

        return max;
    }


    /**
     * Same logic but some easy optimizations if you know some CS fundamentals
     * Average running time 4ms
     *
     *
     * @param s
     * @return
     */
    public int VERYFAST_lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();
        char[] arr = s.toCharArray(); // change to array for locality
        char set0 = arr[0]; // no Object and array, just primitive data type
        char set1 = ' ';
        int max = 2, start = 0, intern = 1;
        int i;
        for (i = 1; i < arr.length; i++) {
            char c = arr[i]; // get value for once
            if (c != set0) {
                if (set1 != ' ' && c != set1) {
                    max = i - start > max ? i - start : max; // we are not going to call Math::max again
                    start = intern;
                    intern = i;
                    set0 = arr[i - 1];
                    set1 = c;
                } else {
                    set1 = c;
                }
            }
            if (c != arr[intern]) {
                intern = i;
            }
        }
        max = i - start > max ? i - start : max; // same here
        return max;
    }
}
