import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static char[][] lettersArray = new char[3][3];
    public static char winner;
    public static int playedRow = 0;
    public static int playedCol = 0;
    public static int temp;
    public static int currentPlayer;
    public static void main (String[] args){
    
       setBoard();
       play();

       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
                System.out.print(lettersArray[i][j] + "  ");
           }
           System.out.println();
        }
    }

    static void setBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lettersArray[i][j] = '-';
            }
        }
    }
    static void play(){
        int round = 1;
        while (round<10){
            if (round%2 == 0){
                currentPlayer = 2;
            }
            else{
                currentPlayer = 1;
            }
            playerTurn();
            while(isEmpty()==false){
                playerTurn();
            }
            
            if (winCheck() == true){
                if (winner == 'X'){
                    System.out.println("Player 1 wins!");
                }
                else{
                    System.out.println("Player 2 wins!");
                }
                break;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(lettersArray[i][j] + " ");
                }
                System.out.println();
            }
            round++;
        }
       
        //System.out.println("No one wins. Try again!");
        
       
    }

    static boolean rowWinCheck(){
        for (int i=0; i<3; i++)
          if (lettersArray[i][0] == lettersArray[i][1] && lettersArray[i][1] == lettersArray[i][2]){
            if(lettersArray[i][0] == 'X' || lettersArray[i][0] == 'O'){
                winner = lettersArray[i][0];
                return true;
            }
            return false;
          }
       return false;
    }

    static boolean colWinCheck(){
        for (int i=0; i<3; i++){
          if (lettersArray[0][i] == lettersArray[1][i] && lettersArray[2][i] == lettersArray[1][i]){
            if(lettersArray[0][i] == 'X' || lettersArray[0][i] == 'O'){
                winner = lettersArray[0][i];
                return true;
            }
            return false;
          }
        }
       return false;
    }
   
    static boolean diagonallWinCheck(){
          if (lettersArray[0][0] == lettersArray[1][1] && lettersArray[2][2] == lettersArray[1][1]){
            if(lettersArray[0][0] == 'X' || lettersArray[0][0] == 'O'){
                winner = lettersArray[0][0];
            return true;
            }
            return false;
          }
          else if(lettersArray[0][2]== lettersArray[1][1] && lettersArray[1][1] == lettersArray[2][0]){
            if(lettersArray[0][2] == 'X' || lettersArray[0][2] == 'O'){
                winner = lettersArray[0][2];
                return true;
            }
            return false;
          }
          
       return false;
    }

    static boolean winCheck(){
        if (colWinCheck() || rowWinCheck() || diagonallWinCheck()){
            return true;
        }
        return false;
    }

    static int getValidInt(){
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean check = false;
        while (check == false){
            try{
                temp = scan.nextInt();
                check = true;
                return temp;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input. Oopsies. Try again");
                scan.nextLine();
            }
        }
        scan.nextLine();
        scan.close();
        return temp;
    }

    static boolean validInt(int a){
        if (a == 0 || a == 1 || a == 2){
            return true;
        }
        return false;
    }

    static void playerTurn(){
        System.out.println ("Player " + currentPlayer+ " enter a row to place O:");
        temp = getValidInt();
        while (validInt(temp) == false){
            System.out.println ("Not a valid input. Please try again");
            temp = getValidInt();
            continue;
        }
        
        playedRow = temp;

        System.out.println("Player " + currentPlayer + " enter a column to place O");
        temp = getValidInt();
        while (validInt(temp) == false){
            System.out.println ("Not a valid input. Please try again");
            temp = getValidInt();
            continue;
        }
        playedCol = temp;
    }
 
    static boolean isEmpty(){
        if (lettersArray[playedRow][playedCol] == '-'){
            if (currentPlayer == 2)
                lettersArray[playedRow][playedCol] = 'O';
            else{
                lettersArray[playedRow][playedCol] = 'X';
            }
            return true;
        }
        else{
            System.out.println("That has already been played. Try again.");
        }
        return false;
    }


}