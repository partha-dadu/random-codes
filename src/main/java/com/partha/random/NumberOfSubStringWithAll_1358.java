package com.partha.random;

public class NumberOfSubStringWithAll_1358 {

    /**
     * Input: s = "abcabc"
     * Output: 10
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are :
     * "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc"
     */

    public static void main(String[] args) {
        String str = "abcabc";
        NumberOfSubStringWithAll_1358 numberOfSubStringWithAll1358 = new NumberOfSubStringWithAll_1358();
        int result = numberOfSubStringWithAll1358.getNumberOfSubStrings(str);
        System.out.println("Result " + result);
        numberOfSubStringWithAll1358.numberOfSubstrings(str);
    }

    public int getNumberOfSubStrings(String s) {
        int[] lastSeen = {-1, -1, -1};// 0,1,2 represent a,b,c
        char[] array = s.toCharArray();
        int i = 0;
        int count = 0;
        while (i < array.length) {
            switch (array[i]) {
                case 'a':
                    lastSeen[0] = i;
                    break;
                case 'b':
                    lastSeen[1] = i;
                    break;
                case 'c':
                    lastSeen[2] = i;
                    break;
            }
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int min = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                count = count + min + 1;
            }
            i++;
        }
        return count;
    }


    public int numberOfSubstrings(String s) {
        char[] strArray = s.toCharArray();
        int size = strArray.length;
        int[] hash = new int[3];
        int result = 0;

        int right = 0;
        int left = 0;
        while (right < size) {
            switch (strArray[right]) {
                case 'a':
                    hash[0] = hash[0] + 1;
                    break;
                case 'b':
                    hash[1] = hash[1] + 1;
                    break;
                case 'c':
                    hash[2] = hash[2] + 1;
                    break;
            }
            if (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                result = result + (size - right);

                while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                    switch (strArray[left]) {
                        case 'a':
                            hash[0] = hash[0] - 1;
                            break;
                        case 'b':
                            hash[1] = hash[1] - 1;
                            break;
                        case 'c':
                            hash[2] = hash[2] - 1;
                            break;
                    }

                    left++;
                    if (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                        result = result + (size - right);
                    }
                }
            }
            right++;
        }
        return result;
    }
}
