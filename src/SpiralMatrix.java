class Solution {
    List<Integer> order;
    private void findOrder(int[][] matrix, int istart, int iend, int jstart, int jend) {
        if(istart > iend || jstart > jend);
        else {
            for(int j=jstart; j<=jend; j++) order.add(matrix[istart][j]);
            for(int i=istart+1; i<=iend; i++) order.add(matrix[i][jend]);
            for(int j=jend-1; istart!=iend && j>=jstart; j--) order.add(matrix[iend][j]);
            for(int i=iend-1; jstart!=jend && i>istart; i--) order.add(matrix[i][jstart]);
            findOrder(matrix, istart+1, iend-1, jstart+1, jend-1);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        order = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        findOrder(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
        return order;
    }
}
