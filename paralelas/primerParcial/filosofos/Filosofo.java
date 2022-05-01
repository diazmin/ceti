import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Filosofo{

    private String estado;
    private JButton imagen; 
    private int forksOnHisHands;

    public Filosofo(JButton btn)
    {
        this.imagen = btn;
        // imagen.setIcon(imageSize("platon.png"));
    }
    public boolean comiendo()
    {
        System.out.println("comiendo...");
        estado = "comiendo";
        imagen.setIcon(imageSize("comida.png"));
        return true;

    }
    public boolean pensando()
    {
        System.out.println("pensando...");
        estado = "pensando";
        imagen.setIcon(imageSize("platon.png"));
        return true;

    }
    public String getEstado()
    {
        return estado;
    }
    public void setforksOnHisHands(int numTenedores)
    {
        this.forksOnHisHands = numTenedores;
    }

    private ImageIcon imageSize(String ruta){
        ImageIcon imageIcon = new ImageIcon(ruta); 
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
