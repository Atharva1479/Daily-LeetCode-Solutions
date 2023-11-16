/* 54. Spiral Matrix - Medium

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100 */

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {

            return result;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;
        
        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {

                result.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {

                result.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {

                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {

                    result.add(matrix[i][left]);
                }
                left++;
            }
        }     
        return result;
    }
}
//Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the matrix. 
//Space Complexity: O(1)