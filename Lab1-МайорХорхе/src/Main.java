import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int sizeA = (17 - 5) + 1;
        int[] a = new int[sizeA];
        for(int i=0; i<sizeA; i++) {
            a[i] = i + 5;
        }

        double[] x = new double[19];
        int min = -2, max = 10;
        for(int i=0; i<16; i++) {
            x[i] = Math.random() * (max - min + 1) + min;
        }

        final int[] listNumbers = new int[] {7, 12, 13, 14, 15, 17};
        double[][] results = new double[sizeA][16];
        for(int i=0; i<sizeA; i++) {
            int curr = a[i];
            for(int j=0; j<16; j++) {
                if(curr == 16) {
                    results[i][j] = Math.pow(2 / Math.sin(Math.pow(Math.E, x[j])), 3);
                } else if(IntStream.of(listNumbers).anyMatch(number -> number == curr)) {
                    results[i][j] = Math.sin(Math.cos(Math.cos(x[j])));
                } else {
                    results[i][j] = Math.asin(Math.sin(Math.cbrt(Math.log(Math.abs(x[j])))));
                }
            }
        }

        for(int i=0; i<sizeA; i++) {
            for(int j=0; j<16; j++) {
                String spaces = "       "; //7
                double curr = results[i][j];
                if(curr >= 100000 || curr <= -100000) {
                    spaces = " "; //1
                } else if(curr >= 10000 || curr <= -1000) {
                    spaces = "  "; // 2
                } else if(curr >= 1000) {
                    spaces = "   "; // 3
                } else if(curr <= -100) {
                    spaces = "    "; // 4
                } else if(curr >= 100 || curr <= -10) {
                    spaces = "     "; // 5
                } else if(curr >=10 || curr < 0) {
                    spaces = "      "; //6
                }
                System.out.printf("%,.4f" + spaces, results[i][j]);
            }
            System.out.print("\n");
        }
    }
}
