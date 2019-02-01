//cjh170230
//Connor Hulla
package hashtable;
import java.math.*;
public class HashTable
{
    /*load factor constant: .5 once the size of the array is half of the
    capacity, we will resize it to the next prime number thats more thn 
    double our current size.*/
    final double load_factor = .5;
    int N;
    int numElements;
    int[] arr;
    //constructor: we start with 11, a small prime number
    HashTable()
    {
        numElements = 0;
        N = 11;
        arr = new int[N];
    }
    
    public int get(int k)
    {
        int i = 0;
        /*arrays are initialized to 0, so if a value of 0 is stored we know its
        an empty spot*/
        while(arr[(k + i*i) % N] != 0)
        {
            //if k + i^2 % N is our key, return the value at our key
            if(arr[(k + i*i) % N] == k)
                return arr[(k + i*i) % N];
            i++; //otherwise, keep going
        }
        return -1; 
        //returns -1 if we couldn't find the value associated with our key
    }
    
    //quadratic hashing formula: (k + i^2) % N
    public void add(int k)
    {
        int i = 0, arrIndex = 0;
        boolean spotFound = false;
        //while a spot hasn't been found
        while(spotFound == false)
        {
           //set our index to the key + i^2
           arrIndex = (k + i*i) % N;
           //if the spot is 0, that means we can store a value here
           if(arr[arrIndex] == 0)
           {
               //store the value at the index we found
               arr[arrIndex] = k;
               spotFound = true;
           }
           i++;
        }
        //increase the number of elements. If our array is 50% full, rehash
        numElements++;
        
        if(N *load_factor <= numElements)
            reHash();
    }
    
    public void reHash()
    {
        //store the oldsize
        int oldSize = N;
        //create a big integer thats twice as large as our current size
        BigInteger b = new BigInteger(String.valueOf(N * 2));
        //find the next prime number from the doubled value
        b = b.nextProbablePrime();
        //set our new capacity to the integer value of our bigInt
        N = b.intValue(); 
        int arrIndex = 0, k = 0;
        boolean spotFound = false;
        int newArr[] = new int[N];
        
        //this will transfer the data from our old array to the new one
        for(int j = 0; j < oldSize; j++)
        {
            int i = 0;
            k = arr[j];
            /*if k = 0, that means there was nothing stored in this element
            of the array*/
            if(k == 0)
                continue;
            while(spotFound == false)
            {
               arrIndex = (k + i*i) % N; 
               if(newArr[arrIndex] == -1)
               {
                   newArr[arrIndex] = k;
                   spotFound = true;
               }
               i++;
            }
            spotFound = false;
        }
        //set the array equal to our new array
        arr = newArr;
    }
    
    public void print()
    {
        for(int i = 0; i < N; i++)
        {
            if(arr[i] != -1)
                System.out.println(arr[i]);
        }
    }
}
