import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        Rotational Cipher
//        var output = RotationalCipher.rotationalCipher("Zebra-493", 0);
//        Contiguous Subarrays
//        int[] numbers = {3, 4, 7, 6, 2};
//        var output = RotationalCipher.countSubArray(numbers);
//        Pair Sums
//        var output = FacebookExamples.numberOfWays(numbers, 6);
//        Reverse to Make Equal
//        int[] numbers = {937,396,309,316,278,305,937,563,385,816,333,523,874,47,281,984,431,692};
//        int[] numbers2 = {937,385,816,937,309,523,281,278,316,396,984,431,47,333,692,874,563,305};
//        var output = FacebookExamples.areTheyEqual(numbers,numbers2);
//        Passing Yearbooks
//        int[] array = {3, 2, 1};
//        var output = FacebookExamples.findSignatureCounts(array);
//        Matching Pairs
//        var output = FacebookExamples.matchingPairs("abcd", "adcb");
//        Minimum Length Substrings
//        String s = new String(Files.readAllBytes(Paths.get("src/s.txt")));
//        String t = new String(Files.readAllBytes(Paths.get("src/t.txt")));
//        var output = FacebookExamples.minLengthSubstring(s, t);
//        Encrypted Words
//        var output = FacebookExamples.findEncryptedWord("abc");
//        Change in a Foreign Currency
//        int[] denominations = {1, 2, 5};
//        var output = FacebookExamples.canGetExactChange( 11, denominations);
//        Balance Brackets
//        var output = FacebookExamples.isBalanced( "{[()]");
//        Queue Removals
//        int[] numbers = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
//        var output = FacebookExamples.findPositions(numbers, 4);
//        Reverse Operations
//        LinkedList linkedList = new LinkedList();
//        linkedList.addFirst(16);
//        linkedList.addFirst(12);
//        linkedList.addFirst(9);
//        linkedList.addFirst(8);
//        linkedList.addFirst(2);
//        linkedList.addFirst(1);
//        System.out.println(Arrays.toString(linkedList.convertLinkedListToArray()));
//        linkedList.reverse(linkedList.first);
//        var output = linkedList.convertLinkedListToArray();
//        System.out.println(Arrays.toString(output));
//        Number of Visible Nodes
//        Tree tree = new Tree();
//        tree.insert(8);
//        tree.insert(10);
//        tree.insert(3);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(14);
//        tree.insert(4);
//        tree.insert(7);
//        tree.insert(13);
//        var output = tree.visibleNodesByLevelOrder();
//        Largest Triple Products
//        int[] numbers = {2, 1, 2, 1, 2};
//        var output = FacebookExamples.findMaxProduct(numbers);
//        int[] numbers = {2, 1, 7, 4, 2};
//        var output = FacebookExamples.maxCandies(numbers, 3);
//        int[] numbers = {5, 15, 1, 3};
//        var output = FacebookExamples.findMedian(numbers);
//        int[] numbers = {12, 7, 6, 7, 6};
//        var output = FacebookExamples.balancedSplitExists(numbers);
//        ArrayList<FacebookExamples.Sides> sides = new ArrayList<>();
//        sides.add(new FacebookExamples.Sides(2, 2, 3));
//        sides.add(new FacebookExamples.Sides(3, 2, 2));
//        sides.add(new FacebookExamples.Sides(2, 5, 6));
//        var output = FacebookExamples.countDistinctTriangles(sides);
//        Revenue Milestones
//        int[] revenues = {700, 800, 600, 400, 600, 700};
//        int[] milestones = {3100, 2200, 800, 2100, 1000};
//        var output = FacebookExamples.getMilestoneDays(revenues, milestones);
//        1 Billion Users
//        float[] growthRate = {1.5F};
//        var output = FacebookExamples.getBillionUsersDay(growthRate);
//        int[] p = {3, 1, 2};
//        var output = FacebookExamples.minOperations(p);
//        int[] p = {4, 2, 1, 3};
//        var output = FacebookExamples.getTotalTime(p);
        int[] p = {8, 9, 11, 2, 1};
        var output = FacebookExamples.findMinArray(p, 3);
        System.out.println(Arrays.toString(output));

    }
}
