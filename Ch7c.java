import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ch7c {
    public static void main(String[] args) {
        ArrayList<Integer> primes = sieve(100000);
        for(int k : primes){
            System.out.print(k + " ");
        }
        int[] solution = goldbach(9765342);
        System.out.println("\n" + solution[0] + " " + solution[1]);
        ArrayList<Integer> bigsum = addBigInt(new ArrayList<>(Arrays.asList(1,2,3,4,5)), new ArrayList<>(Arrays.asList(9,9,9,9,9)));
        for (int k : bigsum){
            System.out.print(k);
        }
    }

    public static ArrayList<Integer> sieve(int n){
        boolean[] primes = new boolean[n];
        ArrayList<Integer> ret = new ArrayList<>();
        Arrays.fill(primes, 2, n ,true);
        for (int i = 2; i < n; i++) {
            if(primes[i]){
                for (int j = i*2; j < n; j += i){
                    primes[j] = false;
                }
                ret.add(i);
            }
        }
        return ret;
    }
    public static int[] goldbach(int n){
        //precondition: n is even
        ArrayList<Integer> primes = sieve(n);
        HashSet<Integer> primeset = new HashSet<>(primes);

        for (int i = 1; i < primes.size()/2 + 1; i++) {
            if(primeset.contains(n-primes.get(i))){
                return new int[]{primes.get(i), n-primes.get(i)};
            }
        }
        return new int[]{-1,-1};
    }
    public static ArrayList<Integer> addBigInt(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> sum = new ArrayList<>();
        if(a.size() < b.size()){
            while(a.size() < b.size()){
                a.add(0,0);
            }
        }else if(a.size() > b.size()){
            while(a.size() > b.size()){
                b.add(0,0);
            }
        }

        for(int i = 0; i < a.size(); i++){
            sum.add(a.get(i) + b.get(i));
        }

        for(int i = a.size()-1; i > 0; i--){
            if(sum.get(i) > 9){
                sum.set(i,sum.get(i)-10);
                sum.set(i-1,sum.get(i-1)+1);
            }
        }

        if(sum.get(0) > 9){
            sum.set(0,sum.get(0)-10);
            sum.add(0,1);
        }
        return sum;
    }
}
