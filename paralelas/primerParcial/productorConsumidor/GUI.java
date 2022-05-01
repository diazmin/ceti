package productorConsumidor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class GUI extends JPanel {
    private JPanel panel;
    private JButton almacen, consumer, productor, start, end;
    private JLabel consumerState, productorState, almacenState;
    private static volatile int estadoTienda;
    private final Object lock = new Object();
    
    public GUI()
    {   
        setLayout(new BorderLayout());
        almacen = new JButton(imageSize("almacen.png"));
        add(almacen, BorderLayout.NORTH);
 
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,3));
        
        //add components
        makeButton();
        almacenState = new JLabel("0");
        panel.add(almacenState);
        makeButton();
        consumer = new JButton(imageSize("consumidor.png"));
        panel.add(consumer);
        makeButton();
        productor = new JButton(imageSize("productor.png"));
        panel.add(productor);
        consumerState = new JLabel("0");
        panel.add(consumerState);
        makeButton();
        productorState = new JLabel("0");
        panel.add(productorState);
        makeButton();
        start = new JButton("start");
        panel.add(start);
        makeButton();
        makeButton();
        end = new JButton("end");
        panel.add(end);
        makeButton();

        //add panel to frame
        add(panel, BorderLayout.CENTER);

        //Procesos
        estadoTienda = 1;
        start.addActionListener(event -> {
            // ExecutorService executor = Executors.newSingleThreadExecutor(); 
            Runnable consumidor = () -> {
                while(true)
                {
                    try {
                            synchronized(lock)
                            {
                                if(estadoTienda == 0)
                                {
                                    System.out.println("consumer: a mimir");
                                    consumerState.setText("dormido");
                                    lock.wait();
                                }
                                else
                                {
                                    System.out.println("vaciando tienda...");
                                    consumerState.setText("vaciando...");
                                    estadoTienda = 0;
                                    almacenState.setText("vacio");
                                    lock.notify();
                                }
                            }
                            Thread.sleep(2000);   
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
                    
            };
            Runnable productor = () -> {
                while(true)
                { 
                    try {
                            synchronized(lock)
                            {
                                if(estadoTienda == 1)
                                {
                                    System.out.println("productor: a mimir");
                                    productorState.setText("dormido");
                                    lock.wait();
                                }else
                                {

                                    System.out.println("llenando tienda...");
                                    productorState.setText("llenando...");
                                    estadoTienda = 1;
                                    almacenState.setText("lleno");
                                    lock.notify();
                                }
                            }
                        Thread.sleep(2000);   
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            };
            Thread hilo1 = new Thread(productor);
		    hilo1.start();
            
            Thread hilo2 = new Thread(consumidor);
		    hilo2.start();

            try {
                hilo1.join(3000);
                hilo2.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
            // executor.submit(consumidor);
            // executor.submit(productor);
		    // executor.shutdown(); 
        });
        end.addActionListener(event -> {
            System.out.println("bye");
            System.exit(0);
        });
    }
    public void makeButton(){
        JButton button = new JButton();
        button.setEnabled(false);
        panel.add(button);
    }
    private ImageIcon imageSize(String ruta){
        ImageIcon imageIcon = new ImageIcon(ruta); 
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }

}

