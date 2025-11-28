package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        // ❗️ NO BorderLayout → usar coordenadas absolutas
        setLayout(null);

        // Cargar la imagen del mapa
        ImageIcon iconoMapa = new ImageIcon("./imagenes/mapa.png");

        this.labMapa = new JLabel(iconoMapa);
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));

        // Fijar el tamaño exacto y la posición exacta
        labMapa.setBounds(0, 0, iconoMapa.getIconWidth(), iconoMapa.getIconHeight());

        // Ajustar el panel al tamaño del mapa
        setPreferredSize(new Dimension(iconoMapa.getIconWidth(), iconoMapa.getIconHeight()));

        add(labMapa);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja los restaurantes en el mapa
        if (restaurantes != null)
        {
            g2d.setColor(Color.red);

            for (Restaurante r : restaurantes)
            {
                int x = r.getX();
                int y = r.getY();

                // dibujar el punto rojo
                g2d.fillOval(x - 3, y - 3, 7, 7);

                // dibujar el nombre al lado del punto
                g2d.drawString(r.getNombre(), x + 5, y - 5);
            }
        }
    }

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa(List<Restaurante> nuevosRestaurantes)
    {
        this.restaurantes = nuevosRestaurantes;
        repaint();
    }
}
