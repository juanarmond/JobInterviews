// Cisco 1
public class HelloWorld{

    public static void main(String []args){
        
        int [] A = {4, 35, 80, 123, 12345, 44, 8, 5, 24, 3};
        int K = 4;
        int j=0;
        String t = "+-----";
        boolean stop =true;
        if(A.length<K){
            K = A.length;
        }
        
        String repeat =  String.format(String.format("%%%ds", K), " ").replace(" ",t);
        
            while(j<A.length){
                System.out.println(repeat + "+");
                System.out.print("|");
                for(int i=0;i<K;i++) {
                    if(j==A.length){
                        System.out.println();
                        repeat =  String.format(String.format("%%%ds", 2), " ").replace(" ",t);
                        System.out.print(repeat + "+");
                        stop = false;
                        break;
                    }
                    System.out.print(String.format("%5d", A[j])+ "|");
                    j++;
                }
                System.out.println();
            }
        if(stop){
         System.out.println(repeat + "+");   
        }
        
    }
}

// System.out.println("--------------------------------------------------");
//     System.out.printf("%10s %30s %20s %5s %5s", "STUDENT ID", "EMAIL ID", "NAME", "AGE", "GRADE");
//     System.out.println();
//     System.out.println("--------------------------------------------");