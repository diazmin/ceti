import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tenedor{
    private boolean estado;
    private JButton btn; 

    public Tenedor(JButton btn)
    {
        this.btn = btn;
        estado = true; //available
    }

    public void setImagen(String imagen)
    {
        btn.setIcon(imageSize(imagen));
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }

    public boolean getEstado()
    {
        return estado;
    }
    private ImageIcon imageSize(String ruta){
        ImageIcon imageIcon = new ImageIcon(ruta); 
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}