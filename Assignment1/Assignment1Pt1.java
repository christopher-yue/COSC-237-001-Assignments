import java.util.*;

public class Assignment1Pt1 {
    public static final int MAX = 10;
    public static final int MIN = 1;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int size = 0;
        int num = 0;
        menu();
        String prompt = "Please enter your option: ";
        int option = getInt(in, prompt);
        while(option != 0){
            num++;
            switch(option){
                case 0:
                    break;
                case 1:
                    prompt = "Enter the size of square matrices: ";
                    size = getInt(in, prompt);
                    int[][] matrix1 = new int[size][size];
                    int[][] matrix2 = new int[size][size];
                    initRand(matrix1, size, MIN, MAX);
                    initRand(matrix2, size, MIN, MAX);
                    System.out.println("First matrix is:");
                    print(matrix1, size);
                    System.out.println("Second matrix is:");
                    print(matrix2, size);
                    System.out.println("The resulting matrix is:");
                    print(add(matrix1, matrix2, size), size);
                    break;
                case 2:
                    prompt = "Enter the size of square matrices: ";
                    size = getInt(in, prompt);
                    matrix1 = new int[size][size];
                    matrix2 = new int[size][size];
                    initRand(matrix1, size, MIN, MAX);
                    initRand(matrix2, size, MIN, MAX);
                    System.out.println("First matrix is:");
                    print(matrix1, size);
                    System.out.println("Second matrix is:");
                    print(matrix2, size);
                    System.out.println("The resulting matrix is:");
                    print(subtract(matrix1, matrix2, size), size);
                    break;
                case 3:
                    prompt = "Enter the size of square matrices: ";
                    size = getInt(in, prompt);
                    matrix1 = new int[size][size];
                    matrix2 = new int[size][size];
                    initRand(matrix1, size, MIN, MAX);
                    initRand(matrix2, size, MIN, MAX);
                    System.out.println("First matrix is:");
                    print(matrix1, size);
                    System.out.println("Second matrix is:");
                    print(matrix2, size);
                    System.out.println("The resulting matrix is:");
                    print(multiply(matrix1, matrix2, size), size);
                    break;
                case 4:
                    prompt = "Enter the size of the square matrix: ";
                    size = getInt(in, prompt);
                    matrix1 = new int[size][size];
                    initRand(matrix1, size, MIN, MAX);
                    prompt = "Enter the multiplication constant: ";
                    int multConst = getInt(in, prompt);
                    System.out.println("The matrix is: ");
                    print(matrix1, size);
                    System.out.println("The original matrix multiplied by 4 is: ");
                    print(multiplyByConst(matrix1, multConst, size), size);
                    break;
                case 5:
                    prompt = "Enter the size of the square matrix: ";
                    size = getInt(in, prompt);
                    matrix1 = new int[size][size];
                    initRand(matrix1, size, MIN, MAX);
                    System.out.println("The matrix is:");
                    print(matrix1, size);
                    System.out.println("The transposed matrix is:");
                    print(transpose(matrix1, size), size);
                    break;
                case 6:
                    prompt = "Enter the size of the square matrix: ";
                    size = getInt(in, prompt);
                    matrix1 = new int[size][size];
                    initRand(matrix1, size, MIN, MAX);
                    System.out.println("The matrix is: ");
                    print(matrix1, size);
                    System.out.println("The trace for this matrix is: " + trace(matrix1, size));
                    break;
                default:
                    System.out.println("Out of bounds!");
            }
            System.out.printf("%50s%n", "Command " + num + " completed.");
            menu();
            prompt = "Please enter your option: ";
            option = getInt(in, prompt);
        }

    }
    //get integer value from user
    public static int getInt(Scanner in, String prompt){
        System.out.print(prompt);
        while(!in.hasNextInt()){
            in.next();
            System.out.print("Not an integer. Try again! ");
            System.out.print(prompt);

        }
        return in.nextInt();
    }
    //print options
    public static void menu(){
        System.out.println("Your options are:");
        System.out.println("-----------------");
        System.out.printf(" %20s%n", "1) Add 2 matrices");
        System.out.printf(" %25s%n", "2) Subtract 2 matrices");
        System.out.printf(" %25s%n", "3) Multiply 2 matrices");
        System.out.printf(" %35s%n", "4) Multiply matrix by a constant");
        System.out.printf(" %22s%n", "5) Transpose matrix");
        System.out.printf(" %18s%n", "6) Matrix trace");
        System.out.printf(" %10s%n", "0) EXIT");
    }
    //print matrix
    public static void print(int[][] matrix, int size){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.printf("%5s", matrix[row][col]);
            }
            System.out.println();
        }
    }
    //assign random values to matrix
    public static void initRand(int[][] arr, int size, int low, int high){
        Random rand = new Random();
        int randNum;
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                randNum = rand.nextInt(high - low + 1) + low;
                arr[row][col] = randNum;
            }
        }
    }
    //add 2 matrices
    public static int[][] add(int[][] matrix1, int[][] matrix2, int size){
        int[][] sum = new int[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                sum[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }
        return sum;
    }
    //subtract 2 matrices
    public static int[][] subtract(int[][] matrix1, int[][] matrix2, int size){
        int[][] difference = new int[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                difference[row][col] = matrix1[row][col] - matrix2[row][col];
            }
        }
        return difference;
    }
    //multiply 2 matrices
    public static int[][] multiply(int[][] matrix1, int[][] matrix2, int size){
        int[][] product = new int[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                for(int i = 0; i < size; i++){
                    product[row][col] += matrix1[row][i] * matrix2[i][col];
                }
            }
        }
        return product;
    }
    //multiply matrix by constant
    public static int[][] multiplyByConst(int[][]matrix1, int constant, int size){
        int[][] product = new int[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                product[row][col] = matrix1[row][col] * constant;
            }
        }
        return product;
    }
    //transpose matrix
    public static int[][] transpose(int[][] matrix, int size){
        int[][] transposed = new int[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                transposed[row][col] = matrix[col][row];
            }
        }
        return transposed;
    }
    //get diagonal sum of matrix
    public static int trace(int[][] matrix, int size){
        int trace = 0;
        for(int row = 0; row < size; row++){
            trace += matrix[row][row];
        }
        return trace;
    }
}