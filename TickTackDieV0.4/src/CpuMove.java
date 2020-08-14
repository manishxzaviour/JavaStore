
class CpuMove {
    int[] move = {-1, -1};

    void cpuM() {
        int bestScore = -1000;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (Place.board[i][j] == ' ') {
                    Place.board[i][j] = 'C';
                    int score = miniMax(false);
                    if (bestScore > score) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                    Place.board[i][j] = ' ';
                }
        new Place(checkPos(move[0], move[1]), ' ', false);
    }

    private int checkPos(int pos1, int pos2) {
        int flag = 0;
        for (int i = 0; i < pos1; i++)
            for (int j = 0; j < pos2; j++)
                flag++;
        return flag;
    }

    private int miniMax(boolean max) {
        int score = eval();
        if (score == 10)
            return 10;
        else if (score == -10)
            return -10;
        else if (!movesL())
            return 0;
        int bestScore;
        if (max) {
            bestScore = -1000;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    if (Place.board[i][j] == ' ') {
                        Place.board[i][j] = 'C';
                        bestScore = Math.max(bestScore, miniMax(false));
                        Place.board[i][j] = ' ';
                    }
                }
            return bestScore;
        } else {
            bestScore = 1000;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    if (Place.board[i][j] == ' ') {
                        Place.board[i][j] = 'P';
                        bestScore = Math.min(bestScore, miniMax(true));
                        Place.board[i][j] = ' ';
                    }
                }
            return bestScore;
        }
    }

    private boolean movesL() {
        for (char[] x : Place.board)
            for (char y : x)
                if (y == ' ')
                    return true;
        return false;
    }

    private int eval() {
        if ((Place.board[0][0] == 'P' && Place.board[0][1] == 'P' && Place.board[0][2] == 'P') || (Place.board[1][0] == 'P' && Place.board[1][1] == 'P' && Place.board[1][2] == 'P') || (Place.board[2][0] == 'P' && Place.board[2][1] == 'P' && Place.board[2][2] == 'P')) {
            return 10;
        } else if ((Place.board[0][0] == 'P' && Place.board[1][0] == 'P' && Place.board[2][0] == 'P') || (Place.board[0][1] == 'P' && Place.board[1][1] == 'P' && Place.board[2][1] == 'P') || (Place.board[0][2] == 'P' && Place.board[1][2] == 'P' && Place.board[2][2] == 'P')) {
            return 10;
        } else if ((Place.board[0][0] == 'P' && Place.board[1][1] == 'P' && Place.board[2][2] == 'P') || (Place.board[0][2] == 'P' && Place.board[1][1] == 'P' && Place.board[2][0] == 'P')) {
            return 10;
        } else if ((Place.board[0][0] == 'C' && Place.board[0][1] == 'C' && Place.board[0][2] == 'C') || (Place.board[1][0] == 'C' && Place.board[1][1] == 'C' && Place.board[1][2] == 'C') || (Place.board[2][0] == 'C' && Place.board[2][1] == 'C' && Place.board[2][2] == 'C')) {
            return -10;
        } else if ((Place.board[0][0] == 'C' && Place.board[1][0] == 'C' && Place.board[2][0] == 'C') || (Place.board[0][1] == 'C' && Place.board[1][1] == 'C' && Place.board[2][1] == 'C') || (Place.board[0][2] == 'C' && Place.board[1][2] == 'C' && Place.board[2][2] == 'C')) {
            return -10;
        } else if ((Place.board[0][0] == 'C' && Place.board[1][1] == 'C' && Place.board[2][2] == 'C') || (Place.board[0][2] == 'C' && Place.board[1][1] == 'C' && Place.board[2][0] == 'C')) {
            return -10;
        }
        return 0;
    }
}