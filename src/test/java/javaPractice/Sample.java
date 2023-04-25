package javaPractice;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import util.extentReport.ExtentTestManager;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Sample {
//    @Test
    public void palindrome(Method method){

        int n = 121;
        int r, reminder=0, original = n;
        ExtentTestManager.startTest(method.getName(), "Palindrome");
        while(n>0){
            r = n%10;
            n=n/10;
            reminder=(reminder*10)+r;
        }
        if(reminder==original){
            System.out.println("Polindurm num: "+reminder);
        } else {
            System.out.println("this is not Polindurm num: "+reminder);
        }

        // String
        String name = "amma";
        String revName = "";
        for (int i=(name.length())-1; i>=0; --i) {
            revName += name.charAt(i);
        }

        if((revName.toLowerCase()).equals(name.toLowerCase())){
            System.out.println("Given String is Palindrome :" + revName);
        } else  {
            System.out.println("Given String is not Palindrome :" + revName);
        }
    }

//    @Test
    public void fibonacci(Method method){
        ExtentTestManager.startTest(method.getName(), "fibonacci");
        int n = 0, r, n1=1,n3, count = 10;
        ExtentTestManager.getTest().log(Status.INFO,"Fibonacci: ");
        ExtentTestManager.getTest().log(Status.INFO," "+n);
        ExtentTestManager.getTest().log(Status.INFO," "+n1);
        for(r=0; r<count; r++) {
            n3 = n+n1;
            ExtentTestManager.getTest().log(Status.INFO," "+n3);
            n=n1;
            n1=n3;
        }

        // just print
        int num = 0, num1 = 1;
        int num2, count1 = 20;

        System.out.print(num+ ", "+num1+", ");
        for(int i = 0; i<count1; i++) {
            num2=num+num1;
            System.out.print(num2+ ", ");
            num = num1;
            num1 = num2;
        }
    }

//    @Test
    public void primeNumFindingFromGivenArray(Method method){
        /**
         * Get prime numbers from given array
         */
        ExtentTestManager.startTest(method.getName(), "PrimeNum");
        int[] n = {1,2,3,4,5,6,7,8,9,10};
        int r;
        for(int num : n){
            boolean isPrime = true;
            for(r=2; r<=Math.sqrt(num); r++){
                if(num%r == 0) {
                    isPrime = false;
//                   break;
                }
            }
            if(isPrime && num>1){
                ExtentTestManager.getTest().log(Status.INFO, "PrimeNum: " + num);
                System.out.println("Prime: "+num);
            } else {
                System.out.println("Not Prime: "+num);
            }

        }

        /**
         * Verify a given number is prime or not
         */
        int gNum =2;
        if(gNum%2==0 ||gNum%3 ==0 && gNum>2){
            System.out.println("Mod: "+gNum%2);
            ExtentTestManager.getTest().log(Status.INFO, "Not PrimeNum: " + gNum);
        }else {
            ExtentTestManager.getTest().log(Status.INFO, "PrimeNum: " + gNum);
        }

    }

//    @Test
    public void findDuplicate(Method method){
        ExtentTestManager.startTest(method.getName(), "PrimeNum");
        String name = "schools";

        int count;

        char[] ch= name.toCharArray();
        for(int i=0; i<=ch.length;i++){
            count=1;
            for(int j=i+1; j<ch.length;j++){
                if(ch[i]==ch[j]){
                    count++;
                    ch[j]='0';
                }
            }
            if(count>1&&ch[i] != '0'){
                System.out.println(ch[i]+": "+count);
            }
        }
    }

//    @Test
    public void getSubString(Method method){
        ExtentTestManager.startTest(method.getName(), "Substring");
        String name = "abc cat";
        System.out.println(name.substring(4));

        //array - Modifying a string in array
        String s[] = { "Java", "T", "Point" };
        System.out.print("Before Setting : ");
        for (String x : s) {
            System.out.print(x + " ");
        }
        Array.set(s, 1, "for");
        System.out.print("\nAfter Setting : ");
        for (String x : s) {
            System.out.print(x + " ");
        }

    }

    @Test // to return multiple duplicates
    public void compareTwoArraysAndGetDuplicates(Method method){
        ExtentTestManager.startTest(method.getName(), "Compare Arrays");
        String[] set1 = {"a","b","c"};
        String[] set2 = {"c","b","d"};
        List<String> dup = new ArrayList<String>();
        for(int i=0; i< set1.length;i++){
//            String tem = set1[i];
            for(int j=0; j< set2.length;j++){
                if (set1[i].equals(set2[j])){
                    dup.add(set1[i]);
                }
            }
        }
        String[] dupArray = new String[dup.size()];
        for (int i = 0; i<dupArray.length; i++){
            dupArray[i] = dup.get(i);
        }
//        System.out.println("Duplicate: "+dupArray.length);
//        System.out.println("Dup: "+dup.size());

        System.out.println("Duplicate names: " + dup);

    }

    @Test
    public void duplicateArrayComparission() {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {3, 5, 7, 9, 11};

        ArrayList<Integer> duplicates = new ArrayList<Integer>();

        for(Integer i : arr1) {
            for(Integer j : arr2) {
                if(i.equals(j)) {
                    duplicates.add(i);
                    break;
                }
            }
        }

        System.out.println("Duplicates: " + duplicates);

        /**
         * String array duplicates
         */
        String[] array1 = {"apple", "banana", "orange", "pear"};
        String[] array2 = {"lemon", "banana", "peach", "pear"};

        List<String> list1 = Arrays.asList(array1);
        List<String> list2 = Arrays.asList(array2);

        List<String> duplicates1 = new ArrayList<String>();

        for (String elem : list1) {
            if (list2.contains(elem)) {
                duplicates1.add(elem);
            }
        }

        System.out.println("Duplicate names: " + duplicates1);
    }

    @Test
    public void selectRandomItemFromList(){
        Random rand = new Random();
        List<String> givenList = Arrays.asList("one", "two", "three", "four");
        String randomElement = "";

        for (int i = 0; i < givenList.size(); i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        System.out.println(randomElement);
    }

    @Test
    public void printReverseString() {
        String str = "Testing Reverse";
        char[] ch = str.toCharArray();
        String rev = "";
//
//        for(int i = ch.length-1; i>=0; i--){
//            rev+=ch[i];
//        }
//        System.out.println(rev);

        // Reverse words in the string
        String words[] = str.split("\\s");
        for (int i=0; i<words.length; i++){
            String word = words[i];
            String revW = "";
            for (int j=word.length()-1; j>=0;j--){
                revW += word.charAt(j);
            }
            rev += revW+" ";
        }
        System.out.println(rev);
    }

    @Test
    public void findSumOf9Num(){
        int[] num = {1,2,3,6,8,9};
        for(int i=num.length-1; i>0; i--){
            for(int j=i+1; j<num.length; j ++) {
                if(num[i]+num[j] == 9) {
                    System.out.println(num[i]+ " " + num[j]);
                }
            }
        }

    }
    @Test
    public void findMinAndMaxNum(){
        int[] num = {1,2,3,6,8,9,1};
        int min= num[0], max = num[0];
        for(int i=1; i<num.length; i++){
            if(num[i] < min) {
                min = num[i];
            } else if(num[i] > max) {
                max = num[i];
            }
        }
        System.out.println("min: "+ min);
        System.out.println("min: "+ max);
    }
}
