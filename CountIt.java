import java.util.*;
import java.util.ArrayList;
import java.io.File;
    /* @authors Nicky Patterson, Daniel Prvanov 
     * @desc A class used to calculate binomial equations using Longs as
     * the largest integer size declaration.
     */

    public class CountIt {
    public static void main(String[] args)throws Exception{
        String inputNumber;
        Scanner sc = new Scanner(System.in);

        /*for testing using test inputs of various sizes verrified against a scientific calculator 
        * using the binomial equation
         */
        /* 
        File file = new File("test.txt");
        Scanner sc2 = new Scanner(file);
        while(sc2.hasNextLine()){
            inputNumber= sc2.nextLine();

            if (inputNumber.isEmpty()) {
                break;
            } try {
                numbersGoIn(inputNumber);
            } catch (NumberFormatException e) {
                System.err.println("Invalid Input");
            }
        }
        */

        /* While there is a next line the scanner reads the input */
        while(sc.hasNextLine()){
            inputNumber= sc.nextLine();

            if (inputNumber.isEmpty()) {
                break;
            } try {
                numbersGoIn(inputNumber);
            } catch (NumberFormatException e) {
                System.err.println("Invalid Input");
            }
        }

        sc.close();
    }

    /* numbersGoIn
     * @input A string variable gotten from system.in
     * A method used to do the computing of the result of N!/K!(N-K)!.
     */
    public static void numbersGoIn(String input){
        Long n;
        Long k;
        boolean maxReach=false;
        int space = input.indexOf(' ');
        String pt1 = input.substring(0, space);
        
        String pt2 = input.substring(space+1,input.length());
        ArrayList<Long> other=new ArrayList<Long>(0);
        ArrayList<Long> nList=new ArrayList<Long>(0);
        n = Long.parseLong(pt1);//needs try catch?
        k = Long.parseLong(pt2);//needs try catch?
        if(k==Long.valueOf(1)){
            maxReach=true;
        }
        Long finalN;
        boolean kGreat =true;
        Long minus = n-k;
        boolean kOver;
        if(minus>k)kOver=true;
        else kOver=false;
        if(kOver){
        if(minus > k){
            finalN=n-minus;
            kGreat=false;
        }else{
            finalN=n-k;

        }

        if(kGreat){
        nList = nFact(finalN,n);
        }else{
        nList = nFact(n-finalN,n);
        }

        
        if(kGreat){
            other = otherFact(minus);
        }else{
            other = otherFact(k);
        }
        }
        else{
            if(minus > k){
                finalN=n-minus;
                kGreat=false;
            }else{
                finalN=n-k;

            }


            nList = nFact(finalN,n);

            if(kGreat){
                other = otherFact(k);
            }else{
                other = otherFact(minus);
            }
        }
            furtherReduce(nList, other);
        
        
            reduceX(nList, other, 13);
        
        
            reduceX(nList, other, 12);
        
        
            reduceX(nList, other, 11);
        
        
            reduceX(nList, other, 10);
        
        
            reduceX(nList, other, 9);
        
        
            reduceX(nList, other, 8);
        
        
            reduceX(nList, other, 7);
        
        
            reduceX(nList, other, 6);
        
        
            reduceX(nList, other, 5);
        
        
            reduceX(nList, other, 4);
        
        
            reduceX(nList, other, 3);
        
        
            reduceX(nList, other, 2);

        if(maxReach){
            System.out.println(n);
        }else{
        System.out.println(multiply(nList)/multiply(other));
        }

    }

    /* nFact
     * @input the Long n passed from system.in after conversion from 
     * string to long.
     * A method that creates an array list consisting of the factors of N.
     * @output an array list consisting of the factors of N.
     */
    public static ArrayList<Long> nFact(Long min, Long max){
        ArrayList<Long> out = new ArrayList<Long>(0);
        for(Long i = min+1; i < max+1; i++)
        {
            out.add(Long.valueOf(i));
        }
        return out;
    }

    /* otherFact
     * @input the smaller of K or N-K passed from system.in after conversion
     * from string to long.
     * A method that creates an array list consisting of the factors of either 
     * K or N-K.
     * @output an array list consisting of the factors of either K or N-K.
     */
    public static ArrayList<Long> otherFact(Long in){
        ArrayList<Long> out = new ArrayList<Long>(0);
        for(Long i = Long.valueOf(1); i < in+1; i++)
        {
            out.add(Long.valueOf(i));
        }
        return out;

    /* furtherReduce
     * @input an arrayList n and an arrayList other, array lists of factorials
     * gotten from N and K.    
     * A method that divides N and K by K, to simplify numbers within the arrayList.
     */   
    }
    public static void furtherReduce(ArrayList<Long> n, ArrayList<Long> other){
        for(int i=0;i<other.size();i++){
            for(int i2=0;i2<n.size();i2++){
                if(n.get(i2)%other.get(i)==0 && other.get(i)!=1){
                    n.set(i2,(n.get(i2)/other.get(i)));
                    other.set(i,Long.valueOf(1));
                }
            }
        }
    }

    /* reduceX
     * @input an arrayList N, and arrayList other, array lists of factorials gotten
     * from N and K, N being being the number you wish to simplify the two lists by.
     * A method that divides N and K by N, to simplify numbers within the arrayList.
     */
    public static void reduceX(ArrayList<Long> n, ArrayList<Long> other, int x){
        for(int i=0;i<other.size();i++){
            for(int i2=0;i2<n.size();i2++){
                if(n.get(i2)%x==0 && other.get(i)%x==0){
                    n.set(i2,(n.get(i2)/x));
                    other.set(i,(other.get(i)/x));
                }
            }
        }
    }

    /* multiply
     * @input an array list you wish to multiply.
     * Multiplies each number in the array by the next number
     * @output total multiplied array list.
     */
    public static Long multiply(ArrayList<Long> in){
        Long out=Long.valueOf(1);
        for(int i = 0;i<in.size();i++){
            out=out*in.get(i);
        }
        return out;
    } 
}