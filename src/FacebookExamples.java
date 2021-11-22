import java.util.*;

public class FacebookExamples {

    public static String rotationalCipher(String input, int rotationFactor) {
        if (input == null) return "";

        final int ENGLISH_ALPHABET_SIZE = 26;
        final int NUMBER_MAX_RANGE = 10;
        StringBuilder output = new StringBuilder();

        for (char ch : input.toCharArray()) {
            int charInCipher = 0;
            if (Character.isDigit(ch)) {
                int numberValue = Character.getNumericValue(ch) + (rotationFactor % NUMBER_MAX_RANGE);
                charInCipher = numberValue >= NUMBER_MAX_RANGE ? numberValue - NUMBER_MAX_RANGE : numberValue;
                output.append(charInCipher);
            } else if (Character.isAlphabetic(ch)) {
                char diffChar = Character.isLowerCase(ch) ? 'a' : 'A';
                int letterValue = (ch - diffChar) + (rotationFactor % ENGLISH_ALPHABET_SIZE);
                charInCipher = (letterValue >= ENGLISH_ALPHABET_SIZE ? letterValue - ENGLISH_ALPHABET_SIZE : letterValue) + diffChar;
                output.append((char) charInCipher);
            } else {
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static int[] countSubArray(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            count = countLeftSubArray(arr, i, count, i - 1) + countRightSubArray(arr, i, count, i + 1);
            output[i] = ++count;
        }
        return output;
    }

    private static int countLeftSubArray(int[] arr, int index, int count, int left) {
        if (left < 0) return count;

        if (arr[index] > arr[left])
            count++;
        else
            return count;

        return countLeftSubArray(arr, index, count, --left);
    }

    private static int countRightSubArray(int[] arr, int index, int count, int right) {
        if (right >= arr.length) return count;

        if (arr[index] > arr[right])
            count++;
        else
            return count;

        return countRightSubArray(arr, index, count, ++right);
    }

    public static int numberOfWays(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }

        int twice_count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (hm.get(k - arr[i]) != null)
                twice_count += hm.get(k - arr[i]);

            if (k - arr[i] == arr[i])
                twice_count--;
        }

        return twice_count / 2;
    }

    public static boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array_a.length; i++) {
            if (map.get(array_a[i]) != null)
                map.put(array_a[i], map.get(array_a[i]) + 1);
            else
                map.put(array_a[i], 1);
        }
                ;

        for (int i = 0; i < array_b.length; i++) {
            if (map.get(array_b[i]) == null)
                return false;
            map.put(array_b[i], map.get(array_b[i]) + 1);
        }

        for (int value : map.values())
            if (value % 2 != 0) return false;

        return true;
    }

    public static int[] findSignatureCounts(int[] arr) {
        int[] signatures = new int[arr.length];

        for (int i = 0; i < signatures.length; i++)
            signatures[i]++;

        for (int i = 0; i < arr.length; i++) {
            int k = i;

            while (arr[k] != i + 1) {
                signatures[i]++;
                k = arr[k] - 1;
            }
        }

        return signatures;
    }

    public static int matchingPairs(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return 0;

        Set<Character> unmatchedS = new HashSet<>();
        Set<Character> unmatchedT = new HashSet<>();

        int length = t.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                unmatchedS.add(s.charAt(i));
                unmatchedT.add(t.charAt(i));
            }
        }

        if (unmatchedS.isEmpty()) return length - 2;

        int result = length - unmatchedS.size();
        int count = 0;
        for (char ch : unmatchedS) {
            if (unmatchedT.contains(ch)) {
                count++;
                if (count == 2) break;
            }
        }

        return count + result;
    }

    public static String minLengthSubstring(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()){
            int count = tMap.getOrDefault(ch, 0);
            tMap.put(ch, count + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (char ch : s.toCharArray()){
            int count = sMap.getOrDefault(ch, 0);
            sMap.put(ch, count + 1);
        }

        for (char ch : tMap.keySet()) {
            if (sMap.get(ch) == null || tMap.get(ch) > sMap.get(ch)) return "";
        }

        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> answerMap = new HashMap<>();
        String minSubString = s;

        while (left <= right && right < s.length()) {
            char chRight = s.charAt(right);
            if (tMap.containsKey(chRight)) {
                int count = answerMap.getOrDefault(chRight, 0);
                answerMap.put(chRight, count + 1);

                if (tMap.get(chRight).intValue() == answerMap.get(chRight).intValue())
                    formed++;

                while (formed == tMap.size()) {
                    int rightIndex = right + 1 <= s.length() ? right + 1 : right;
                    if (s.substring(left, rightIndex).length() < minSubString.length())
                        minSubString = s.substring(left, rightIndex);
                    char chLeft = s.charAt(left++);
                    if (answerMap.get(chLeft) == null)
                        continue;
                    int leftCount = answerMap.get(chLeft);
                    answerMap.replace(chLeft, --leftCount);
                    if (leftCount < tMap.get(chLeft))
                        formed--;
                }

            }
            right++;
        }

       return minSubString;
    }

    public static String findEncryptedWord(String s) {
        return findEncryptedWord(s, new StringBuilder());
    }

    private static String findEncryptedWord(String s, StringBuilder encrypted) {
        if (s.isEmpty()) return "";

        if(s.length() == 2)
            return encrypted.append(s).toString();

        int splitIndex = 0;
        if (s.length() % 2 == 0)
            splitIndex = (s.length() / 2) - 1;
        else
            splitIndex = s.length() / 2;

        encrypted.append(s.charAt(splitIndex));
        findEncryptedWord(s.substring(0, splitIndex), encrypted);
        findEncryptedWord(s.substring(splitIndex + 1), encrypted);
        return encrypted.toString();
    }

    public static int canGetExactChange(int targetMoney, int[] denominations) {
        if (targetMoney < 1) return 0;
        return canGetExactChange(denominations, targetMoney, new int[targetMoney]);
    }

    private static int canGetExactChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        // Checking the answer
        if (count[rem - 1] != 0) return count[rem - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = canGetExactChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static boolean isBalanced(String s) {
        if (s == null || s == "") return true;

        final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
        final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (leftBrackets.contains(ch)) {
                stack.push(ch);
                continue;
            }

            if (rightBrackets.contains(ch)) {
                if(stack.empty()) return false;

                char leftBracket = stack.pop();
                if (leftBrackets.indexOf(leftBracket) != rightBrackets.indexOf(ch))
                    return false;
            }
        }
        return stack.empty();
    }

    public static int[] findPositions(int[] arr, int x) {
        int[] result = new int[x];
        int j = 0;
        for (int i = 0; i < x; i++) {
            int count = 0;
            int maxIndex = j;
            int max = arr[j];
            while (j < arr.length && count < x) {
                if (arr[j] != -1)
                    count++;
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
                if (arr[j] - 1 >= 0)
                    arr[j] -= 1;
                j++;
            }
            j = j > arr.length - 1 ? 0 : j;
            arr[maxIndex] = -1;
            result[i] = maxIndex + 1;
        }
        return result;
    }

    public static int[] findMaxProduct(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[] answers = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            queue.add(arr[i]);

            if (queue.size() < 3)
                answers[i] = -1;
            else {
                int x = queue.remove();
                int y = queue.remove();
                int z = queue.remove();

                answers[i] = x * y * z;

                queue.add(x);
                queue.add(y);
                queue.add(z);
            }
        }

        return answers;
    }

    public static int maxCandies(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int number : arr)
            queue.add(number);

        int refillNumbers = 0;
        int answer = 0;
        for (int i = 0; i < k; i++) {
            int largestBag = queue.remove();
            if (refillNumbers > largestBag)
                answer += refillNumbers;
            else
                answer += largestBag;
            queue.add(largestBag / 2);
        }

        return answer;
    }

    public static int[] findMedian(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>( Collections.reverseOrder());
        PriorityQueue<Integer> medianQueue = new PriorityQueue<>();
        int[] answers = new int[arr.length];

        int n, top = 0;
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            n = (queue.size() / 2) + 1;

            if (queue.size() % 2 != 0)
                top = 1;
            else
                top = 2;

            while (n-- > 0)
                medianQueue.add(queue.remove());

            if (top > 1) {
                int x = medianQueue.remove();
                int y = medianQueue.remove();
                answers[i] = (x + y) / 2;
                queue.add(x);
                queue.add(y);
            } else {
                answers[i] = medianQueue.remove();
                queue.add(answers[i]);
            }

            while (!medianQueue.isEmpty()) {
                queue.add(medianQueue.remove());
            }
        }
        return answers;
    }

    // Find possible split array into 2 equal arrays
    public static boolean balancedSplitExists(int[] arr) {
        // Write your code here
       if (arr == null || arr.length == 0)
           return false;

       Arrays.sort(arr);

       int leftSum = 0, rightSum = 0;
       for (int number : arr)
           leftSum += number;

       for (int i = arr.length - 1; i >= 0; i--) {
           leftSum -= arr[i];
           rightSum += arr[i];

           if (leftSum == rightSum)
               if (arr[i - 1] < arr[i])
                   return true;
       }
       return false;
    }

    // Return the number of distinct triangles in the list.
    public static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        if (arr == null || arr.size() == 0)
            return 0;

        Set<String> set = new HashSet<>();
        for (Sides triangle : arr) {
            int[] sides = {triangle.a, triangle.b, triangle.c};
            Arrays.sort(sides);
            set.add(Arrays.toString(sides));
        }

        return set.size();
    }

    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] sum = new int[revenues.length];
        int[] result = new int[milestones.length];

        sum[0] = revenues[0];
        for (int i = 1; i < revenues.length; i++)
            sum[i] = sum[i - 1] + revenues[i];

        for (int i = 0; i < milestones.length; i++) {
            int day = binarySearch(sum, milestones[i]);
            result[i] = day < 0 ? day : day + 1;
        }
        return result;
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (target < array[middle])
                right = middle - 1;
            else if (target > array[middle])
                left = middle + 1;
            else
                return middle;
        }
        return left < array.length ? left : -1;
    }

    public static int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        float maxG = growthRates[0];
        for (float g : growthRates)
            if (g > maxG)
                maxG = g;

        double users = 0;
        int days = 0;

        while (users < 1e9) {
            users = Math.pow(maxG, ++days);
        }
        return days;
    }

    public static int minOperations(int[] arr) {
        // Write your code here
        int count = 0;
        boolean sorted = false;
        int i = 0;

        while(!sorted) {
            int low = -1;
            int high = -1;
            int j = arr.length -1;

            while(i < arr.length && arr[i] == i+1) {
                i++;
            }

            while(j >= 0 && arr[j] != i+1) {
                j--;
            }

            low = i;
            high = j;

            while(low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }

            if(i >= j) {
                sorted = true;
            } else {
                count++;
            }
        }
        return count;
    }

    public static int getTotalTime(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int num: arr)
            queue.add(num);

        int sum = 0;
        while (queue.size() > 1) {
            int currentSum = 0;
            currentSum+= queue.remove();
            currentSum+= queue.remove();
            queue.add(currentSum);
            sum += currentSum;
        }
        return sum;
    }

    public static int[] findMinArray(int[] arr, int k) {
        // Write your code here
        for (int i = k -1;i >=0; i--)
            swap(arr, i, i + 1);
        return arr;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int minOverallAwkwardness(int[] arr) {
        // Write your code here
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i+=2)
            diff = Math.max(diff, arr[i] - arr[i - 2]);

        for (int i = 3; i < arr.length; i+=2)
            diff = Math.max(diff, arr[i] - arr[i - 2]);

        return Math.max(diff, arr[arr.length - 1] - arr[arr.length - 2]);

    }

}
