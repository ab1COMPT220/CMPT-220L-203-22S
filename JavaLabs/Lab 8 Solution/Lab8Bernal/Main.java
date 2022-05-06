package base;

public class Main {

    public static void main(String[] args) {
       
	// write your code here
        NotUltimateList list = new NotUltimatelist();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list.length());
        list.printList();
        list.delete(3);
        list.printList();
        System.out.println(list.length());
        list.sort();
        list.printList();
    }

    private static class NotUltimatelist extends NotUltimateList {

        public NotUltimatelist() {
        }
    }
}


        
     
      
    
            
    
               
        
   
    
