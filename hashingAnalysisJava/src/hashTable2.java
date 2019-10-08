import javax.xml.soap.Node;
import java.util.Random;
//separate chaining collision resolution scheme

public class hashTable2 {

    public int mod(int key, int tableSize) { //key mod table size hash function
        int hashValue = key % tableSize;
        return hashValue; //calculated location based on method
    }

    public int midSquare(int key, int tableSize) { //mid-square hash function
        int hashValue = 0;
        key = (int) Math.pow(key, 2);
        double numBitsKeySquared = Integer.bitCount(key) * 2;
        double numBitsTableSize = Integer.bitCount(tableSize) * 2;
        int powerTwo = (int) Math.ceil((numBitsKeySquared - numBitsTableSize) / 2);
        hashValue = (int) (key / (Math.pow(2, powerTwo))) % tableSize;
        return hashValue;
    }

      Node head;
       static class Node{  //created Node class
            int data;
            Node next;
            Node(int d){
                data = d;
                next = null;
            }
        }


    public static void main(String[] args) {
        int tableSize = 512; //changed manually, (128, 256, 512)
        hashTable2 hash1 = new hashTable2();
        Node hashTable[] = new Node[tableSize];
        int numCollisions = 0;
        int hashValue = 0;
        double loadFactor = 0.0;
        int keyList[] = new int[tableSize];
        int hashValueList[] = new int[tableSize];
        int collisionList[] = new int[tableSize];
        double loadFactorList[] = new double[tableSize];


        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new Node(i);
            hashTable[i].data = -1;
        }
        Random random = new Random();
        int key = 0;
        for (int i = 0; i < tableSize; i++) {
            key = random.nextInt((3 * tableSize) + 1); //generate random key values
            keyList[i] = key;
            hashValue = hash1.midSquare(key, tableSize); //switch between mod and midSquare
            hashValueList[i] = hashValue;

            if (hashTable[hashValue].data == -1) {
                hashTable[hashValue].data = key;
            } else {
                numCollisions++;
                Node temp = hashTable[hashValue];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new Node(i);
                temp.next.data = key;
            }
            collisionList[i]=numCollisions;
            loadFactor = (double)i/tableSize;
            loadFactorList[i]=loadFactor;
        }

        for (int i = 0; i<tableSize;i++){
            // System.out.print("Key Value: " + keyList[i] +" ");
            //System.out.print("Hash Value: " + hashValueList[i]+" ");
            System.out.println(collisionList[i]);
            //System.out.println(loadFactorList[i]);
            //System.out.println("");

        }
        for (int i = 0; i<tableSize;i++){
            System.out.println(loadFactorList[i]);
        }
    }

}
