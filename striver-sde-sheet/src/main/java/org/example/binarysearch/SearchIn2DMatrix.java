package org.example.binarysearch;

//Time Complexity: O(logm+logn)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/search-a-2d-matrix/
//Level: Medium
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = findRowIndex(matrix, target);
        if (rowIndex == -1)
            return false;
        int targetIndex = findIndex(matrix[rowIndex], target);
        return targetIndex != -1;
    }

    private int findRowIndex(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = m - 1;
        while (l <= h) {
            int mid = h - (h - l) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target)
                return mid;
            else if (matrix[mid][0] > target)
                h = mid - 1;
            else if (matrix[mid][n - 1] < target)
                l = mid + 1;
        }
        return -1;
    }

    private int findIndex(int[] mat, int k) {
        int l = 0, h = mat.length - 1;
        while (l <= h) {
            int mid = h - (h - l) / 2;
            if (mat[mid] == k)
                return mid;
            else if (mat[mid] > k)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
