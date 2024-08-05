import java.util.*;

class NumberGuess{
   static int min=1;
   static int max=10;
   static int attempts=7;
   static int rounds=3;


    public static void main(String args[]){
        Random random=new Random();
        Scanner sc=new Scanner(System.in);

        int tot_score=0;

        System.out.println("\nWELCOME TO NUMBER GUESSING GAME\n");
        System.out.println("\nNumber of rounds : 3");
        System.out.println("Number of attempts for every round is 7.\n");

        for(int x=1;x<=rounds;x++){
            int num=random.nextInt(max)+min;
            int curr_attempts=0;
            System.out.println("\nROUND : "+x);
            System.out.println("You have to guess the number between "+min+" and "+max+" in "+attempts+" attempts.\n");

            while(curr_attempts<attempts){
                System.out.print("Enter your guess : ");
                int guess=sc.nextInt();
                System.out.println();
                curr_attempts+=1;

                if(guess==num){
                    int score=attempts-curr_attempts;
                    tot_score+=score;
                    System.out.println("CONGRATULATIONS!!!!\nYou guessed the number successfully.\nAttempts "+curr_attempts+"\nScore of this round : "+score);
                    break;
                }
                
                else if(guess>num){
                    int left=attempts-curr_attempts;
                    System.out.println("Number you guessed which is "+guess+" is greater than generated number.\nAttempts you have left : "+left+"\n");
                }

                else if(guess<num){
                    int left=attempts-curr_attempts;
                    System.out.println("Number you guessed which is "+guess+" is lesser than generated number.\nAttempts you have left : "+left+"\n");
                }
            }

            if(curr_attempts==attempts){
                System.out.println("You lost the round : "+x);
                System.out.println("The number is : "+num+"\n");
            }
        }

        System.out.println("\n\n!!!!!GAME OVER!!!!!\nTotal Score : "+tot_score+"\n");
        sc.close();
    }
}