package main.java.mainGui;
/**
 * Program to control the GUI that manages each available static code
 * analysis tool and displays the associated output.
 *
 * @author Stephen Bapple
 * @author Travis Rebhan
 * @version v0.0.1
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.io.IOException;
import java.io.File;

public class StaticToolsGUI extends JFrame {
    private JPanel contentPane;
    private StaticToolsGUI f;
    private JPanel buttons;
    private JEditorPane htmlField;

    /** 
     *
     */
    public StaticToolsGUI() {
        // Create the main window.
        f = this;
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        contentPane.setPreferredSize(new Dimension(800, 600));
        
        // Set up the buttons pane.
        buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(100, 600));
        BoxLayout buttonLayout = new BoxLayout(buttons, BoxLayout.Y_AXIS);
        buttons.setLayout(buttonLayout);
        contentPane.add(buttons);
        
        // Set up the HTML pane;
        try {
            htmlField = new JEditorPane();
            File file = new File("/Users/developer/Documents/School/CodeAnalysisExtension/src/main/resources/checkstyle_report.html");
            htmlField.setPage(file.toURI().toURL());
            contentPane.add(htmlField);
        }
        catch (IOException e) {
            JTextArea error = new JTextArea(10, 10);
            error.setEditable(false);
            error.append("Error: could not locate or read html"
                         + "file containing output\n" + e.getMessage());
            contentPane.add(error);
        }

        // Show the GUI.
        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);
    }
    
    /** 
     *
     */
     
}
