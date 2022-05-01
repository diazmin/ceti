// package filosofos;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class GUI extends JPanel implements Iterable {
    private JPanel panel;
    private JButton start, end;
    private volatile JButton t1, t2, t3, t4, t5;
    private JButton f1, f2, f3, f4, f5;
    private String philosopherImage, tenedorImage;
    // private static volatile int availableForks;
    private Thread hilo1, hilo2, hilo3, hilo4, hilo5;
    private Filosofo objF1, objF2, objF3, objF4, objF5;
    private Tenedor objT1, objT2, objT3, objT4, objT5;
    private final Object lock = new Object();
    ArrayList<Tenedor> tenedores = new ArrayList<>();
    ArrayList<Tenedor> availables = new ArrayList<>();
    int cont = 0;
    public GUI()
    {   
        philosopherImage = "platon.png";
        tenedorImage = "tenedor.png";
        setLayout(new BorderLayout());
        start = new JButton("start");
        add(start, BorderLayout.NORTH);
    
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,3));
        
        //buttons
        t1 = new JButton(imageSize(tenedorImage));
        f1 = new JButton(imageSize(philosopherImage));
        t2 = new JButton(imageSize(tenedorImage));
        f2 = new JButton(imageSize(philosopherImage));
        JButton white1 = new JButton();
        f3 = new JButton(imageSize(philosopherImage));
        t3 = new JButton(imageSize(tenedorImage));
        JButton white2 = new JButton();
        t4 = new JButton(imageSize(tenedorImage));
        f4 = new JButton(imageSize(philosopherImage));
        t5 = new JButton(imageSize(tenedorImage));
        f5 = new JButton(imageSize(philosopherImage));
        panel.add(t1);
        panel.add(f1);
        panel.add(t2);
        panel.add(f2);
        white1.setEnabled(false);
        panel.add(white1);
        panel.add(f3);
        panel.add(t3);
        panel.add(white2);
        white2.setEnabled(false);
        panel.add(t4);
        panel.add(f4);
        panel.add(t5);
        panel.add(f5);
        
        //add panel to frame
        add(panel, BorderLayout.CENTER);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        end = new JButton("end");
        add(end, BorderLayout.SOUTH);
        
        objF1 = new Filosofo(f1);
        objF2 = new Filosofo(f2);
        objF3 = new Filosofo(f3);
        objF4 = new Filosofo(f4);
        objF5 = new Filosofo(f5);

        objT1 = new Tenedor(t1);
        objT2 = new Tenedor(t2);
        objT3 = new Tenedor(t3);
        objT4 = new Tenedor(t4);
        objT5 = new Tenedor(t5);

        tenedores.add(objT1);
        tenedores.add(objT2);
        tenedores.add(objT3);
        tenedores.add(objT4);
        tenedores.add(objT5);

        //Procesos
        start.addActionListener(event -> {

            //-----------------Runnables------------------------
            Runnable filosofo1 = () -> {
                tasks(objF1, objT1, objT2);
            };
            Runnable filosofo2 = () -> {
                tasks(objF2, objT1, objT3);
            };
            Runnable filosofo3 = () -> {
                tasks(objF3, objT2, objT4);
            };
            Runnable filosofo4 = () -> {
                tasks(objF4, objT3, objT5);
            };
            Runnable filosofo5 = () -> {
                tasks(objF5, objT4, objT5);
            };
            
            // //---------------------Threads----------------------
            hilo1 = new Thread(filosofo1);
            hilo2 = new Thread(filosofo2);
            hilo3 = new Thread(filosofo3);
            hilo4 = new Thread(filosofo4);
            hilo5 = new Thread(filosofo5);
            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
            try {
                hilo1.join(2000);
                hilo2.join(2000);
                hilo3.join(2000);
                hilo4.join(2000);
                hilo5.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    
        end.addActionListener(event -> System.exit(0));
    }
    public void tasks(Filosofo filosofo, Tenedor tenedor1, Tenedor tenedor2){
        while(true)
                {
                    try {
                        synchronized(lock)
                        {
                            for(Tenedor t: tenedores){
                                if(t.getEstado())
                                    cont++;
                                    // availables.add(t);
                                    if(cont == 2){
                                        filosofo.setforksOnHisHands(2);
                                        filosofo.comiendo();
                                        tenedor1.setImagen("white.jpeg");
                                        tenedor2.setImagen("white.jpeg");
                                        tenedor1.setEstado(false);                               
                                        tenedor2.setEstado(false);                               
                                        Thread.sleep(2000);   
                                        lock.notify();
                                    }    
                            }
                            
                            filosofo.setforksOnHisHands(0);
                            filosofo.pensando();
                            tenedor1.setImagen("tenedor.png");
                            tenedor2.setImagen("tenedor.png");
                            tenedor1.setEstado(true);                               
                            tenedor2.setEstado(true);   
                            cont = 0; 
                            lock.wait();          
                        }
                        Thread.sleep(2000);   
                    } 
                    catch (InterruptedException e) { e.printStackTrace();}
                }  
    }

    private ImageIcon imageSize(String ruta){
        ImageIcon imageIcon = new ImageIcon(ruta); 
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}


