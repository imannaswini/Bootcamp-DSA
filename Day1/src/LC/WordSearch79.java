package LC;

public class WordSearch79
 {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true; // Found the word
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        char temp = board[x][y]; // Store the current character
        board[x][y] = '#'; // Mark as visited

        // Explore all four directions
        boolean found = dfs(board, word, index + 1, x + 1, y) ||
                        dfs(board, word, index + 1, x - 1, y) ||
                        dfs(board, word, index + 1, x, y + 1) ||
                        dfs(board, word, index + 1, x, y - 1);

        board[x][y] = temp; // Restore the original character
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word)); // Output: true
    }
    
}
