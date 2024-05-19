package org.example.arrays;

import java.util.Arrays;

//TC: O(N*M)
//SC: O(1)
//Problem link: https://leetcode.com/problems/set-matrix-zeroes/
//Level: Medium
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int col0 = 1;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j == 0){
                        col0 = 0;
                    }
                    else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for(int i = 1; i < m; i ++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i], 0);
            }
        }

        for(int i = 1; i < n; i ++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < m; j ++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            Arrays.fill(matrix[0], 0);
        }
        if(col0 == 0){
            for(int j = 0; j < m; j ++){
                matrix[j][0] = 0;
            }
        }
    }
}
