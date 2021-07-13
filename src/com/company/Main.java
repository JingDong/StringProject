package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Exercise 1: Count Vowels test
        Vowels vowels = new Vowels();
        vowels.solution();

      // Exercise 2: Palindrome test
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.solution());

        //Exercise 3: Count words
        Words words = new Words();
        words.solution();

        //Exercise 4: Consonant
        Consonants consonant = new Consonants();
        consonant.solution();


        //Exercise 5: LastLetterCount
        LastLetterCount lastLetterCount = new LastLetterCount();
        lastLetterCount.solution();
    }

    //Exercise 1: Count Vowels
    public static class Vowels {
        public void solution(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ex 1: Count Vowels. Please input your string:");
            String s = sc.nextLine();
            int[] count = new int[5];
             for(int i = 0; i < s.length(); i++){
                char c = Character.toUpperCase(s.charAt(i));
                switch(c){
                    case 'A':
                        count[0]++;
                        break;
                    case 'E':
                        count[1]++;
                        break;
                    case 'I':
                        count[2]++;
                        break;
                    case 'O':
                        count[3]++;
                        break;
                    case 'U':
                        count[4]++;
                        break;

                }
            }
        System.out.println("count in the string: ");
        System.out.println("A: " + count[0]);
        System.out.println("E: " + count[1]);
        System.out.println("I: " + count[2]);
        System.out.println("O: " + count[3]);
        System.out.println("U: " + count[4]);
        }
    }

    //Exercise 2: Palindrome
    public static class Palindrome{
        public boolean solution(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ex 2: Check Palindrome. Please input your string:");
            String s = sc.nextLine();
            if(s.isEmpty()) return true;
            int start = 0;
            int end = s.length() - 1;
            while(start < end){
                if(s.charAt(start) != s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

    }


    // Exercise 3: Count Words in a String
    public static class Words{
        public void solution(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ex 3: Count words in a String. Please input your string:");
            String s = sc.nextLine();
            String[] words = s.split(" ");
            System.out.println("Total " + words.length + " words in the string." );
        }
    }

    //Exercise 4: Count consonants
    public static class Consonants{
        public void solution(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ex 4: Count consonants. Please input your string:");
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder(s);
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++){
                char c = Character.toLowerCase(s.charAt(i));
                if(!vowels.contains(c)){
                    count[c- 'a']++;
                    sb.setCharAt(i,'*');
                }
            }
            //display the consonant count
            for(int i = 0; i < count.length; i++){
                int ascii = i + (int)'a';
                String str = Character.toString((char)ascii);
                if(!vowels.contains(str.charAt(0))){
                    System.out.println(str + ": " + count[i]);
                }
            }
            System.out.println(sb);
        }
    }



    //Exercise 5: Last letter Count
    public static class LastLetterCount{
        public void solution(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ex 5: Last letter count. Please input your string:");
            String s = sc.nextLine();
            int sCount = 0;
            int yCount = 0;
            int sIndex = -1;
            int yIndex = -1;
            String[] words = s.split(" ");
            for(int i = 0; i < words.length; i++){
                char lastChar = Character.toLowerCase(words[i].charAt(words[i].length() - 1));
                if(lastChar == 's'){
                    sCount++;
                    if(sIndex == -1){
                        sIndex = i;
                    }
                }
                else if(lastChar == 'y'){
                    yCount++;
                    if(yIndex == -1){
                        yIndex = i;
                    }
                }
            }
            System.out.println("Number of words that ending with 's': " + sCount);
            System.out.println("Number of words that ending with 'y': " + yCount);

            //switch first word ending with 's' and 'y'
            String tmp = words[sIndex];
            words[sIndex] = words[yIndex];
            words[yIndex] = tmp;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < words.length; i++){
                sb.append(words[i]);
                if(i != words.length - 1){
                    sb.append(" ");
                }
            }
            System.out.println("New sentence after switch: " + sb);
        }
    }

}
