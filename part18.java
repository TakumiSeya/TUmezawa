/**
 *
 */

/**
 * @author b1014246
 *
 */
public class part18 {
  public static void main(String[] args) {
    System.out.println("Hello world");

    javax.swing.JFrame jf = new javax.swing.JFrame();
    jf.setBounds(100, 100, 750, 400);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

    javax.swing.JLabel jl = new javax.swing.JLabel("Hello world");
    jl.setFont(new java.awt.Font(null, 0, 50));
    jl.setForeground(java.awt.Color.RED);
    jf.add(jl);
  }
}
