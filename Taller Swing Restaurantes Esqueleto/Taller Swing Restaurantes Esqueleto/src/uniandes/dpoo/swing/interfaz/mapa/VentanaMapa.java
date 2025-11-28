package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{
    private PanelMapaVisualizar panelMapa;
    private List<Restaurante> restaurantes;
    private JRadioButton radTodos;
    private JRadioButton radVisitados;

    public VentanaMapa()
    {
        setLayout(new BorderLayout());

        panelMapa = new PanelMapaVisualizar();
        add(panelMapa, BorderLayout.CENTER);

        JPanel panelOpciones = new JPanel(new FlowLayout());

        radTodos = new JRadioButton("Todos");
        radTodos.setActionCommand("todos");
        radTodos.addActionListener(this);

        radVisitados = new JRadioButton("Visitados");
        radVisitados.setActionCommand("visitados");
        radVisitados.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radTodos);
        grupo.add(radVisitados);

        radTodos.setSelected(true);

        panelOpciones.add(radTodos);
        panelOpciones.add(radVisitados);

        add(panelOpciones, BorderLayout.SOUTH);

        setTitle("Mapa de Restaurantes");
        pack();
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actualizarMapa(List<Restaurante> nuevosRestaurantes)
    {
        this.restaurantes = nuevosRestaurantes;
        panelMapa.actualizarMapa(nuevosRestaurantes);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();

        if (comando.equals("todos"))
        {
            panelMapa.actualizarMapa(restaurantes);
        }
        else if (comando.equals("visitados"))
        {
            java.util.List<Restaurante> visitados = new java.util.ArrayList<>();

            for (Restaurante r : restaurantes)
            {
                if (r.isVisitado())
                {
                    visitados.add(r);
                }
            }

            panelMapa.actualizarMapa(visitados);
        }
    }
}

