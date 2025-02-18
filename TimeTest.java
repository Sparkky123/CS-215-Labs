package recursion;

import java.time.*;

public class TimeTest {

    public static void main(String[] args) {
    	final int MAX_SIZE = 250_000;
        Ar_UList myUList = new Ar_UList();
        LocalDateTime currentTime = LocalDateTime.now();
        
        for (int i=0; i <= MAX_SIZE-1; i++) {
            myUList.putItem(i);
    		
        }
		LocalDateTime postexetime = LocalDateTime.now();
		System.out.println("Ar_UList add item time: " + Duration.between(currentTime, postexetime).toMillis() + " ms");

		
		currentTime = LocalDateTime.now();
        for (int i=0; i <= MAX_SIZE-1; i++) {
            myUList.getItem(i);
        }
        postexetime = LocalDateTime.now();
        System.out.println("Ar_UList search time: " + Duration.between(currentTime, postexetime).toMillis() + " ms");
        
        
        Ar_SList mySList= new Ar_SList();
        currentTime = LocalDateTime.now();
        try {
            for (int i = 0; i < MAX_SIZE; i++) {
                mySList.putItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        postexetime = LocalDateTime.now();
        System.out.println("Ar_SList add item time: " + Duration.between(currentTime, postexetime).toMillis() + " ms");
        
        
        currentTime = LocalDateTime.now();
        try {
        	for (int i=0; i < MAX_SIZE; i++) {
                mySList.getItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        postexetime = LocalDateTime.now();
        System.out.println("Ar_SList search time: " + Duration.between(currentTime, postexetime).toMillis() + " ms");
        
        
        
        
    }
}