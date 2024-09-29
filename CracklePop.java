public class CracklePop {
    public static void main (String[] args) {
        for (int i=1; i <= 100; i++){
            if (i%3 == 0 || i%5 == 0) {
               if (i%3 == 0) {
      	        System.out.print ("Crackle");
               }
                if (i%5 == 0) {
                    System.out.print ("Pop");
                }

               System.out.println();
            }
            else{
                System.out.println(i);
            }
        }
    }

    }