package org.example.arrays;

//TC: O(NlogN)
//SC: O(1)
//Problem link: https://leetcode.com/problems/rotate-image/description/
//Level: Medium
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m1 = 0, n1 = 0;
        int m2 = n-1, n2 = n-1;
        while(m1 < m2){
            int[] r2 = interchangeRowAndCol1(matrix[m1], m1, m2, n1, n2, matrix);
            int[] r1 = interchangeRowAndCol2(matrix[m2], m1, m2, n1, n2, matrix);
            interchangeRowAndCol3(r1, r2, matrix, m1, m2, n1, n2);
            n1 ++;
            m1 ++;
            m2 --;
            n2 --;
        }
    }
    private int[] interchangeRowAndCol1(int[] mat, int m1, int m2, int n1, int n2, int[][] matrix){

        int len = m2-m1+1;
        int[] ans = new int[len];
        int i = 0;
        while(m1 <= m2){
            ans[i] = matrix[m1][n2];
            matrix[m1][n2] = mat[n1];
            n1 ++;
            m1 ++;
            i ++;
        }
        // System.out.println("Arrays.toString(): "  + Arrays.toString(ans));
        return ans;

    }
    private int[] interchangeRowAndCol2(int[] mat, int m1, int m2, int n1, int n2, int[][] matrix){

        int len = m2-m1+1;
        int[] ans = new int[len];
        int i = 0;
        int n = n1;
        while(m1 <= m2){
            ans[i] = matrix[m1][n];
            matrix[m1][n] = mat[n1];
            n1 ++;
            m1 ++;
            i ++;
        }
        // System.out.println("Arrays.toString(): "  + Arrays.toString(ans));
        return ans;

    }
    private void interchangeRowAndCol3(int[] r1, int[] r2, int[][] matrix, int m1, int m2, int n1, int n2){
        int i = r1.length-1, n = n1;
        while(i > -1){
            matrix[m1][n] = r1[i];
            n ++;
            i --;
        }
        i = r2.length-1; n = n1;
        while(i > -1){
            matrix[m2][n] = r2[i];
            n ++;
            i --;
        }
    }
}
