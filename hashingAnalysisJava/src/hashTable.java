import java.util.Random;
//open addressing collision resolution

public class hashTable {

    public int mod(int key, int tableSize) { //key mod table size hash function
        int hashValue = key % tableSize;
        return hashValue;
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


    public static void main(String[] args) {
        hashTable hash1 = new hashTable();
        int tableSize = 512; //changed manually (128, 256, 512)
        int numCollisions = 0;
        int hashValue = 0;
        double loadFactor = 0.0;
        int hashTable[] = new int[tableSize];
        int keyList[] = new int[tableSize];
        int hashValueList[] = new int[tableSize];
        int collisionList[] = new int[tableSize];
        double loadFactorList[] = new double[tableSize];


        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1;
        }
        Random random = new Random();
        int key = 0;
        for (int i = 0; i < tableSize; i++) {
            key = random.nextInt((3 * tableSize) + 1);
            keyList[i] = key;
            hashValue = hash1.midSquare(key, tableSize); //switch between mod and midSquare
            hashValueList[i] = hashValue;

            if (hashTable[hashValue] == -1) {
                hashTable[hashValue] = key;
            } else {
                numCollisions++;


                int index = hashValue;
                while (hashTable[index] != -1) {
                    if (index == tableSize - 1) {
                        index = 0;
                    } else {
                        index++;
                    }
                }
                hashTable[index] = key;
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
