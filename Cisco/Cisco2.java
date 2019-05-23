// Cisco 2
public class HelloWorld{

    public static void main(String []args){
        
        String A;
        String B;
        A = "23A84Q";
        B = "K2Q25J";
        
        int[] cardA = new int[A.length()];
        int[] cardB = new int[B.length()];
        
        int scoreA = 0;
        int scoreB = 0;
        int i =0;
            for (char a: A.toCharArray()) {
                    if(a=='A'){cardA[i]  = 14;}
                    else if(a=='K'){cardA[i]  = 13;}
                    else if(a=='Q'){cardA[i]  = 12;}
                    else if(a=='J'){cardA[i]  = 11;}
                    else if(a=='T'){cardA[i]  = 10;}
                    else{
                        cardA[i]  =Character.getNumericValue(a);
                    }
                    i++;
            }
        
        i = 0;
            for(char b: B.toCharArray()){
                if(b=='A'){cardB[i]  = 14;}
                else if(b=='K'){cardB[i]  = 13;}
                else if(b=='Q'){cardB[i]  = 12;}
                else if(b=='J'){cardB[i]  = 11;}
                else if(b=='T'){cardB[i]  = 10;}
                else{
                    cardB[i]  = Character.getNumericValue(b);
                }
                i++;
            }
        
        for(int x=0; x<cardA.length; x++){
            System.out.println(cardA[x] + " " + cardB[x]);
            if (cardA[x] > cardB[x]){
                scoreA++;
                    System.out.println("scoreA "+scoreA);
                }else{
                    scoreB++;
                    System.out.println("scoreB "+scoreB);
                }
        }  
        
        if(scoreA> scoreB){
            System.out.print(scoreA);
        }else{
            System.out.print(scoreB);
        }
    }
}