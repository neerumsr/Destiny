package com.company;


/////////////////////////////////////////////////////////////////////////////////////////////
// You can edit all or part of the default code for your purpose
// Please refer to the following input/output example when you need
// Standard Input Examples
//long a = sc.nextlong();                 // Example of input one long variable
//double b = sc.nextDouble();           // Example of input one double variable
//long AB = sc.nextLong();              // Exmaple of input one long variable
//String str = sc.next();               // Example of input one string
//char c = str.charAt(0);               // Example of input one char variable from string
/////////////////////////////////////////////////////////////////////////////////////////////
// Standard Output Examples
//long a = 0;
//double b = 1.0;
//long AB = 12345678901234567L;
//String str = "ABCDEFG";
//char c = 'b';
//System.out.prlongln(a);                // Example of output one long variable
//System.out.prlongln(b);                // Example of output one double variable
//System.out.prlongln(AB);               // Exmaple of output one long variable
//System.out.prlongln(str);              // Example of output one string
//System.out.prlongln(c);                // Example of output one char variable
/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/*
   As the name of the class should be Solution, using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
*/


/////////////////////////////////////////////////////////////////////////////////////////////
// You can edit all or part of the default code for your purpose
// Please refer to the following input/output example when you need
// Standard Input Examples
//long a = sc.nextlong();                 // Example of input one long variable
//double b = sc.nextDouble();           // Example of input one double variable
//long AB = sc.nextLong();              // Exmaple of input one long variable
//String str = sc.next();               // Example of input one string
//char c = str.charAt(0);               // Example of input one char variable from string
/////////////////////////////////////////////////////////////////////////////////////////////
// Standard Output Examples
//long a = 0;
//double b = 1.0;
//long AB = 12345678901234567L;
//String str = "ABCDEFG";
//char c = 'b';
//System.out.prlongln(a);                // Example of output one long variable
//System.out.prlongln(b);                // Example of output one double variable
//System.out.prlongln(AB);               // Exmaple of output one long variable
//System.out.prlongln(str);              // Example of output one string
//System.out.prlongln(c);                // Example of output one char variable
/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/*
   As the name of the class should be Solution, using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
*/
class Main {

    static int M = 0;
    static int crossRoads[][];

    public static void main(String args[]) throws Exception {
		/*
		   The method below means that the program will read from sample_input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in sample_input.txt file,
		   and call below method to read from the file when using nextlong() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		*/
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		/*
		   Make new scanner from standard input System.in, and read data.
		*/
        System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        Scanner sc = new Scanner(System.in);

		/*
		   Read each test case from standard input.
		*/
        long T = sc.nextInt();
        for (long test_case = 1; test_case <= T; test_case++) {
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Please, implement your algorithm from this section.
			*/
            /////////////////////////////////////////////////////////////////////////////////////////////

            M = sc.nextInt();

            if (! (M>=15 && M<=100) ){
                System.out.println("Input Error");
                sc.close();
                return;
            }

            int[][] matrix = new int[M][M];

            for( int i=0; i<M; i++ ) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            for( int i=0; i<M; i++ ) {
                for (int j = 0; j < M; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }



            for( int row=1; row<M-1; row++ ) {
                for (int col = 1; col < M - 1; col++) {
                    if (matrix[row][col] == 0) {
                        //System.out.println("Crossroads @  " + row + "   " + col);
                        findCrossroads(matrix, row, col);
                    }
                }
            }
        }

        sc.close(); // close the scanner object
    }

    private static void findCrossroads(int[][] matrix, int row, int col) {
        int direction = 0;
        if( (matrix[row][col-1] + matrix[row][col+1] + matrix[row-1][col] + matrix[row+1][col]) == 1) {
            System.out.println("Looks like cross road  " + "row = " + row + " Col = " + col);
            if (matrix[row][col-1] == 1)
                direction = 1;
            else if (matrix[row][col+1] == 1)
                direction = 2;
            else if (matrix[row-1][col] ==1)
                direction = 3;
            else
                direction = 4;


        }

    }
}
