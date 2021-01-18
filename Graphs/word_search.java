class Solution {
    public boolean dfs(char[][] board,int x,int y,String word,int ind){
        //if ind is equal to the length of the word means word is found return true
        if(ind==word.length())
            return true;
        //boundary conditions
        if(x<0 || y<0 || x>=board.length || y>=board[0].length)
            return false;
        //if board[x][y] is equal to the character at ind then call dfs in 4 directions
        if(board[x][y]==word.charAt(ind)){
            //store board[x][y] in temp and assin some other Character
            char temp=board[x][y];
            board[x][y]='A';
            if(dfs(board,x+1,y,word,ind+1) || dfs(board,x-1,y,word,ind+1) || dfs(board,x,y+1,word,ind+1) || dfs(board,x,y-1,word,ind+1)) 
                return true;
            //if the word does not exist the change the board[x][y] in to temp
            board[x][y]=temp;
        }
        return false; 
    }
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //if the board[i][j] equals to the first letter then call dfs function
                char ch1=board[i][j];
                char ch2=word.charAt(0);
                if(ch1==ch2){
                    if(dfs(board,i,j,word,0))
                        return true;
                }
            }
        }
        return false;
    }
}