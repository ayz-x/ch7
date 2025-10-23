import java.util.Arrays;

public class Ch7 {
    public static void main(String[] args) {
        int[] array = new int[(int) (Math.random()*50)];
        System.out.println("Array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*2000-1000);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println(indexOfMax(array));
        boolean[] sieve = sieve(1000);

        for(int i = 0; i < sieve.length; i++){
            System.out.print(i + " " + sieve[i] + " ");
        }
        System.out.println();
        System.out.println(areFactors(2, new int[]{2,4,6,8}));
        System.out.println(arePrimeFactors(210, new int[]{2,3,5,7}));
        int[] hist = letterHist("Hello, World!");
        for(int i = 0; i < 26; i++){
            System.out.print((char)(i + 'a') + ":" + hist[i] + ",");
        }
        System.out.println();
        System.out.println(anagramChecker("allen downey", "well annoyed"));
    }
    public static int indexOfMax(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > array[index]){
                index = i;
            }
        }
        return index;

    }
    public static boolean[] sieve(int n){
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, 2, n ,true);
        for (int i = 2; i < n; i++) {
            if(primes[i]){
                for (int j = i*2; j < n; j += i){
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
    public static boolean areFactors(int n, int[] a){
        for (int x : a){
            if(x%n != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean arePrimeFactors(int n, int[] a){
        for(int x: a){
            if(!isPrime(x)){
                return false;
            }
        }
        int y = 1;
        for(int x: a){
            y *= x;
        }
        return y == n;
    }
    public static boolean isPrime(int n){
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static int[] letterHist(String s){
        int[] count = new int[26];
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                count[c - 'a']++;
            }
        }
        return count;
    }
    public static boolean anagramChecker(String s1, String s2){
        //CCC 2007 J4 lol
        int[] count = new int[26];
        int[] count2 = new int[26];
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            if(Character.isLetter(s1.charAt(i))){
                count[s1.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if(Character.isLetter(s2.charAt(i))){
                count2[s2.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(count[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}
