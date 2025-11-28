package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Usamos 3 filas, una por cada grupo: Nombre, Calificación, Visitado
        setLayout(new GridLayout(3, 1));

        // Crea el campo para el nombre con una etiqueta al frente
        // TODO completar
        JPanel filaNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(12); // tamaño compacto como en el taller
        filaNombre.add(lblNombre);
        filaNombre.add(txtNombre);

        // Crea el selector para la calificación con una etiqueta al frente
        // TODO completar
        JPanel filaCalificacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCalificacion = new JLabel("Calificación:");
        cbbCalificacion = new JComboBox<>();
        cbbCalificacion.addItem("1");
        cbbCalificacion.addItem("2");
        cbbCalificacion.addItem("3");
        cbbCalificacion.addItem("4");
        cbbCalificacion.addItem("5");
        filaCalificacion.add(lblCalificacion);
        filaCalificacion.add(cbbCalificacion);

        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        // TODO completar
        JPanel filaVisitado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblVisitado = new JLabel("Visitado:");
        cbbVisitado = new JComboBox<>();
        cbbVisitado.addItem("Sí");
        cbbVisitado.addItem("No");
        filaVisitado.add(lblVisitado);
        filaVisitado.add(cbbVisitado);

        // Agregar todos los elementos al panel
        // TODO completar
        add(filaNombre);
        add(filaCalificacion);
        add(filaVisitado);
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
        // TODO completar
        return cbbVisitado.getSelectedItem().equals("Sí");
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
        // TODO completar
        return txtNombre.getText();
    }
}

