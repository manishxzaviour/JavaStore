import javax.swing.*;

public class Place {
    ImageIcon u = new ImageIcon();
    char usr = ' ';
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    Place(int pos, char clicked, boolean pl) {
        if (clicked == ' ') {
            if (pl) {
                u = Board.p;
                usr = 'P';
            } else {
                u = Board.c;
                usr = 'C';
            }
            switch (pos) {
                case 1:
                    Board.a1.setIcon(u);
                    board[0][0] = usr;
                    checkW();
                    break;
                case 2:
                    Board.a2.setIcon(u);
                    board[0][1] = usr;
                    checkW();
                    break;
                case 3:
                    Board.a3.setIcon(u);
                    board[0][2] = usr;
                    checkW();
                    break;
                case 4:
                    Board.b1.setIcon(u);
                    board[1][0] = usr;
                    checkW();
                    break;
                case 5:
                    Board.b2.setIcon(u);
                    board[1][1] = usr;
                    checkW();
                    break;
                case 6:
                    Board.b3.setIcon(u);
                    board[1][2] = usr;
                    checkW();
                    break;
                case 7:
                    Board.c1.setIcon(u);
                    board[2][0] = usr;
                    checkW();
                    break;
                case 8:
                    Board.c2.setIcon(u);
                    board[2][1] = usr;
                    checkW();
                    break;
                case 9:
                    Board.c3.setIcon(u);
                    board[2][2] = usr;
                    checkW();
                    break;
            }
        }
    }

    Place() {
        Board.a1.setIcon(Board.w);
        Board.a2.setIcon(Board.w);
        Board.a3.setIcon(Board.w);
        Board.b1.setIcon(Board.w);
        Board.b2.setIcon(Board.w);
        Board.b3.setIcon(Board.w);
        Board.c1.setIcon(Board.w);
        Board.c2.setIcon(Board.w);
        Board.c3.setIcon(Board.w);

        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        if (JOptionPane.showOptionDialog(null, null, "select tile", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"X", "O"}, null) == JOptionPane.YES_OPTION) {
            Board.p = Board.x;
            Board.c = Board.o;
        } else {
            Board.p = Board.o;
            Board.c = Board.x;
        }
    }

     void checkW() {
        if ((board[0][0] == 'P' && board[0][1] == 'P' && board[0][2] == 'P') || (board[1][0] == 'P' && board[1][1] == 'P' && board[1][2] == 'P') || (board[2][0] == 'P' && board[2][1] == 'P' && board[2][2] == 'P')) {
            Board.pPoint++;
            ref();
            new Place();
        } else if ((board[0][0] == 'P' && board[1][0] == 'P' && board[2][0] == 'P') || (board[0][1] == 'P' && board[1][1] == 'P' && board[2][1] == 'P') || (board[0][2] == 'P' && board[1][2] == 'P' && board[2][2] == 'P')) {
            Board.pPoint++;
            ref();
            new Place();
        } else if ((board[0][0] == 'P' && board[1][1] == 'P' && board[2][2] == 'P') || (board[0][2] == 'P' && board[1][1] == 'P' && board[2][0] == 'P')) {
            Board.pPoint++;
            ref();
            new Place();
        } else if ((board[0][0] == 'C' && board[0][1] == 'C' && board[0][2] == 'C') || (board[1][0] == 'C' && board[1][1] == 'C' && board[1][2] == 'C') || (board[2][0] == 'C' && board[2][1] == 'C' && board[2][2] == 'C')) {
            Board.cPoint++;
            ref();
            new Place();
        } else if ((board[0][0] == 'C' && board[1][0] == 'C' && board[2][0] == 'C') || (board[0][1] == 'C' && board[1][1] == 'C' && board[2][1] == 'C') || (board[0][2] == 'C' && board[1][2] == 'C' && board[2][2] == 'C')) {
            Board.cPoint++;
            ref();
            new Place();
        } else if ((board[0][0] == 'C' && board[1][1] == 'C' && board[2][2] == 'C') || (board[0][2] == 'C' && board[1][1] == 'C' && board[2][0] == 'C')) {
            Board.cPoint++;
            ref();
            new Place();
        }
    }

    void ref() {
        Board.youPoints.setText(String.valueOf(Board.pPoint));
        Board.containerL.add(Board.youPoints, Integer.valueOf(3));
        Board.cpuPoints.setText(String.valueOf(Board.cPoint));
        Board.containerL.add(Board.cpuPoints, Integer.valueOf(3));
        Board.frame.add(Board.containerL);
    }

}
