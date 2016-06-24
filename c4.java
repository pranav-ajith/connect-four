import java.applet.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*; 

public class c4 extends Applet implements MouseListener{
    int turn = 0;
    int j,i ;
    int size = 100;
    char[][] board = new char[6][7];
    public void init() {
        setFocusable(true);
        addMouseListener(this);

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {

            }
        }

    }
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(0,0,700,600);
        resize(1500,1000);
        g.setColor(Color.black);

        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                g.setColor(Color.white);
                g.fillOval(100*j,100*i,100,100);
                if (board[i][j] == 'r') {
                    g.setColor(Color.red);
                    g.fillOval(100*j,100*i,100,100); }
                if (board[i][j] == 'b')      {
                    g.setColor(Color.blue);                  
                    g.fillOval(100*j,100*i,100,100);}            
                if (board[i][j] == 'e')    {
                    g.setColor(Color.white);      
                    g.fillOval(100*j,100*i,100,100);}
            }
        }
        
        if (winning() == 'r'){
            g.setColor(Color.red);
            g.drawString("Red is the Winner!!" ,750, 500);
            g.drawString("Click anywhere to place your block and start a new game.", 750, 520);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                   board[i][j] = 'e';
                }
        }}
        
        if (winning() == 'b'){
        g.setColor(Color.blue);
        g.drawString("Blue is the Winner!!" ,800, 500); 
        g.drawString("Click anywhere to place your block and start a new game.", 750, 520);
            for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                   board[i][j] = 'e';
                }
        } }

    }
    public void mouseClicked(MouseEvent e) {
        e.getX();
        e.getY();

        int x = e.getX() / 100;
        int y = e.getY()  / 100;

        placePiece (x);    

      
        repaint();
    }

    boolean placePiece (int col) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] != 'b' && board[i][col] != 'r') {
                if (turn%2 == 0) {
                    board[i][col] = 'r'; 
                    }
                else if (turn%2 == 1) {
                    board [i][col] = 'b';
                    }
                    turn++;
                return true;} 
        }
        return false;       
    }    
    
     char winning () {
         for (int i = 0; i < board[0].length ; i++) {
            for (int j = 0; j < board.length; j++) {
                
                if (i + 3 >= board[0].length){
                break;
            }
                if (board[j][i] == board[j][i+1] && board[j][i+1] == board[j][i+2] && board[j][i+2] == board[j][i+3]) {
                    if (board[j][i] == 'r'){
                    return 'r';}
                    if (board[j][i] == 'b'){
                    return 'b';}
                }
            }
        }
        
         for (int i = 0; i < board[0].length ; i++) {
            for (int j = 0; j < board.length; j++) {
                
                if (j + 3 >= board.length){
                break;
            }
                if (board[j][i] == board[j+1][i] && board[j+1][i] == board[j+2][i] && board[j+2][i] == board[j+3][i]) {
                    if (board[j][i] == 'r'){
                    return 'r';}
                    if (board[j][i] == 'b'){
                    return 'b';}
                }
            }
        }

         for (int i = 0; i < board[0].length ; i++) { //diagonal
            for (int j = 0; j < board.length; j++) {
                
                if (i + 3 >= board[0].length || j + 3 >= board.length) {
                continue;
            }
                if (board[j][i] == board[j+1][i+1] && board[j+1][i+1] == board[j+2][i+2] && board[j+2][i+2] == board[j+3][i+3]) {
                    if (board[j][i] == 'r'){
                    return 'r';}
                    if (board[j][i] == 'b'){
                    return 'b';}
                }
            }
        } 
        
            for (int i = 0; i < board[0].length ; i++) { //diagonal
            for (int j = 0; j < board.length; j++) {
                
                if (i + 3 >= board[0].length || j - 3 < 0) {
                continue;
            }
                if (board[j][i] == board[j-1][i+1] && board[j-1][i+1] == board[j-2][i+2] && board[j-2][i+2] == board[j-3][i+3]) {
                    if (board[j][i] == 'r'){
                    return 'r';}
                    if (board[j][i] == 'b'){
                    return 'b';}
                }
            }
        } 
        
        return 'h';
    }
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
