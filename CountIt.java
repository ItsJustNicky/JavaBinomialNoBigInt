import java.util.*;
import java.util.ArrayList;
public class CountIt {
    public static void main(String[] args){
        String inputNumber;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            inputNumber= sc.nextLine();
            if(inputNumber.compareTo("")==0)break; 
            numbersGoIn(inputNumber);
        }

        sc.close();
    }

    /*
     * TO DO LIST:
     * ADD if check for if N is smaller or larger than k
     * currently only works with N greater than K
     */
    public static void numbersGoIn(String input){
        Long n;
        Long k;
        boolean maxReach=false;
        int space = input.indexOf(' ');
        String pt1 = input.substring(0, space);
        if(pt1.contains("9223372036854775807")){
            maxReach=true;
        }
        String pt2 = input.substring(space+1,input.length());
        ArrayList<Long> other=new ArrayList<Long>(0);
        ArrayList<Long> nList=new ArrayList<Long>(0);
        n = Long.parseLong(pt1);//needs try catch?
        k = Long.parseLong(pt2);//needs try catch?
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
            System.out.println("9223372036854775807");
        }else{
        System.out.println(multiply(nList)/multiply(other));
        }

    }

    public static ArrayList<Long> nFact(Long min, Long max){
        ArrayList<Long> out = new ArrayList<Long>(0);
        for(Long i = min+1; i < max+1; i++)
        {
            out.add(Long.valueOf(i));
        }
        return out;
    }
    public static ArrayList<Long> otherFact(Long in){
        ArrayList<Long> out = new ArrayList<Long>(0);
        for(Long i = Long.valueOf(1); i < in+1; i++)
        {
            out.add(Long.valueOf(i));
        }
        return out;
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
    public static void reduceX(ArrayList<Long> n, ArrayList<Long> other, int x){
        for(int i=0;i<other.size();i++){
            for(int i2=0;i2<n.size();i2++){
                if(n.get(i2)%x==0 && other.get(i)%x==0){
                    n.set(i2,(n.get(i2)/x));
                    other.set(i,(other.get(i)/x));
                }
            }
        }
       // System.out.println(n.toString());
    }
    public static Long multiply(ArrayList<Long> in){
        Long out=Long.valueOf(1);
        for(int i = 0;i<in.size();i++){
            out=out*in.get(i);
            //System.out.println(out);
        }
        return out;
    } 
}