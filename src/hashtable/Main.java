//cjh170230
//Connor Hulla
package hashtable;

public class Main {

    //Testing the hash table by adding some numbers. The hash table was designed
    //to hold positive integers
    public static void main(String[] args) 
    {
        HashTable values = new HashTable();
        values.add(821);
        values.add(820);
        values.add(231);
        values.add(178);
        values.add(999);
        values.add(100);
        values.add(811);
        values.add(426);
        values.add(381);
        values.add(981);
        values.add(881);
        values.add(121);
        values.add(771);
        values.add(901);
        values.add(333);
        values.add(122);
        values.add(344);
        values.add(543);
        values.add(677);
        values.print();
        //testing the retrieval functions of the hashtable
        System.out.println("We will now test the get function");
        System.out.println(values.get(333));
        System.out.println(values.get(677));
        System.out.println(values.get(821));
        
    }
    
}
