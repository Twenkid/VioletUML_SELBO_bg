package selbo.editors.UMLNodeEditor;

/*
 * Uses directly DiagramPanel, without EditorPanel.
 * No menu with the diagram.
 */

import javax.swing.*;

import java.awt.HeadlessException;

//package draw1;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import com.horstmann.violet.framework.action.FileAction;
import com.horstmann.violet.framework.file.FileChooserServiceFactory;
import com.horstmann.violet.framework.file.FileService;
import com.horstmann.violet.framework.gui.DiagramPanel;
import com.horstmann.violet.framework.gui.EditorFrame;
import com.horstmann.violet.framework.gui.SplashScreen;
import com.horstmann.violet.framework.gui.theme.ThemeManager;
import com.horstmann.violet.framework.util.VersionChecker;

import com.horstmann.violet.UMLEditor;
import com.horstmann.violet.framework.gui.EditorPanel;
import com.horstmann.violet.framework.gui.GraphPanel;


import com.horstmann.violet.framework.action.*;
import com.horstmann.violet.product.diagram.usecase.*;
import com.horstmann.violet.product.diagram.classes.*;
import com.horstmann.violet.product.diagram.state.*;
import com.horstmann.violet.product.diagram.activity.*;
import com.horstmann.violet.product.diagram.object.*;
import com.horstmann.violet.product.diagram.sequence.*;


import com.horstmann.violet.framework.file.*;

public class UMLComponent { // extends JFrame{
    
    
    UMLEditor umlEditor;    
    UMLComponent panel;
    
     JFrame frame; // = new JFrame("HelloWorldSwing");
     JMenu fileMenu = new JMenu("File");
     JMenu editMenu = new JMenu("Edit");
     JMenu otherMenu = new JMenu("Other");
     JMenu subMenu = new JMenu("SubMenu");
     JMenu subMenu2 = new JMenu("SubMenu2");
     JMenuBar menuBar = new JMenuBar();
     
     JPanel basePanel = new JPanel();
     JPanel tabbedPanel = new JPanel();
     
     EditorPanel editorPanel;
     
     FileAction fileAction = new FileAction();
     
     DiagramPanel diagramPanel = null;
     
     
    public UMLComponent()
    {
    
    }
                   
    public void init()
    {
            frame = new JFrame("HelloWorldSwing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Add the ubiquitous "Hello World" label.            
            // JLabel label = new JLabel("Hello World");
            // frame.getContentPane().add(label);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
            
            //DrawTab2 tab = new DrawTab2();
            
            JTabbedPane tabbedPane = new JTabbedPane();
            //ImageIcon icon = createImageIcon("images/actoruml.gif");
           // ImageIcon icon = new ImageIcon("images/actoruml.gif");
            //ImageIcon icon = new ImageIcon("c:/actoruml.gif");
            ImageIcon icon = new ImageIcon("c:/actor-20x27.gif");
            
            tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            
            JComponent panel1 = makeTextPanel("Panel #1");
            tabbedPane.addTab("Tab 1", icon, panel1,
                              "Does nothing");
            tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

            JComponent panel2 = makeTextPanel("Panel #2");
            tabbedPane.addTab("Tab 2", icon, panel2,
                              "Does twice as much nothing");
            tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
            
            
            JMenuItem item;
            subMenu2.add(item = new JMenuItem("Extra 2"));
              //item.addActionListener(printListener);
            subMenu.add(item = new JMenuItem("Extra 1"));
              //item.addActionListener(printListener);
            subMenu.add(subMenu2);

            // Assemble the Other menu itself.
            otherMenu.add(subMenu);
            
            
            /*
            otherMenu.add(item = new JCheckBoxMenuItem("Check Me"));
            */
            
            item = new JCheckBoxMenuItem("Save as...");                      
            item.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    performSaveAs();
                }
            });
            otherMenu.add(item);
            
            
              //item.addActionListener(printListener);
            otherMenu.addSeparator(  );
            ButtonGroup buttonGroup = new ButtonGroup(  );
            otherMenu.add(item = new JRadioButtonMenuItem("Radio 1"));
              //item.addActionListener(printListener);
            buttonGroup.add(item);
            otherMenu.add(item = new JRadioButtonMenuItem("Radio 2"));
              //item.addActionListener(printListener);
            buttonGroup.add(item);
            otherMenu.addSeparator(  );
            otherMenu.add(item = new JMenuItem("Potted Plant", 
                                 new ImageIcon("image.gif")));
               //item.addActionListener(printListener);

            // Finally, add all the menus to the menu bar.
            
            item = new JCheckBoxMenuItem("Use Case");
            item.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    performNewUseCase();
                }
            });
            fileMenu.add(item);
            
            item = new JCheckBoxMenuItem("Class Diagram");
            item.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    performNewClassDiagram();
                }
            });
            fileMenu.add(item);
            
            item = new JCheckBoxMenuItem("State Transition");
            item.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    performNewStateDiagram();
                }
            });
            fileMenu.add(item);
                                                          
            menuBar.add(fileMenu);
                        
            menuBar.add(editMenu);
            menuBar.add(otherMenu);
                                              
            //basePanel.setLayout(new BorderLayout());          
            basePanel.setLayout(new BorderLayout());
            basePanel.add(menuBar, BorderLayout.NORTH);
            
            frame.setLayout(new BorderLayout());
            frame.add(basePanel, BorderLayout.NORTH);
             
             //ThemeManager.getInstance().applyPreferedTheme();
             //ThemeManager.getInstance().switchToClassicMetalTheme();
              //ThemeManager.getInstance().switchToBasicTheme(className);
          ThemeManager.getInstance().switchToVistaBlueTheme();
            
          frame.setSize(799, 599);
       }
         
     public void performSaveAs()
     {        
         fileAction.saveAs(diagramPanel, FileChooserServiceFactory.getInstance());         
     }
     
     public void performNewClassDiagram()
     {        
         System.out.println("public void performNewClass()");
         
         if (diagramPanel != null) frame.remove(diagramPanel);
         diagramPanel = fileAction.createDiagram(ClassDiagramGraph.class, frame);
         diagramPanel.repaintGraph();
         frame.add(diagramPanel, BorderLayout.SOUTH);
         frame.repaint();
     }
     
     public void performNewStateDiagram()
     {
         System.out.println("public void performNewUseCase()");         

         diagramPanel = fileAction.createDiagram(StateDiagramGraph.class, frame);
         frame.add(diagramPanel, BorderLayout.SOUTH);
         frame.repaint();
         frame.setSize(800,600);         
     }
     
     public void performNewUseCase()
     {
         System.out.println("public void performNewUseCase()");         
         //editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(UseCaseDiagramGraph.class, frame);
         frame.add(diagramPanel, BorderLayout.SOUTH);
         frame.repaint();
         frame.setSize(800,600);
     }
     
     public void performNewActivity()
     {
         System.out.println("public void performNewUseCase()");         
         //editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(ActivityDiagramGraph.class, frame);
         frame.add(diagramPanel, BorderLayout.SOUTH);
         frame.repaint();
         frame.setSize(800,600);
     
         //diagramPanel.getGraphPanel().SetPlugInMode(frame);
     }
     
     
     
     protected static JComponent makeTextPanel(String text) {
            JPanel panel = new JPanel(false);
            JLabel filler = new JLabel(text);
            filler.setHorizontalAlignment(JLabel.CENTER);
            panel.setLayout(new GridLayout(1, 1));
            panel.add(filler);
            return panel;
        }
        
     
        /** Returns an ImageIcon, or null if the path was invalid. */
     /*
        protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }
        */
                
      public static void main(String[] args) {
            //Schedule a job for the event-dispatching thread:
            //creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    UMLComponent mainFrame = new UMLComponent();
                    mainFrame.init();
                    //mainFrame.performNewClassDiagram(); 
                    //mainFrame.performNewStateDiagram();
                    /*
                     If performNewClassDiagram etc. is performed in the initialization,
                     the diagram appears directly in the frame.
                     However, if it is activated via menu, there are problems in initial appearing of the diagram.
                     frame.repaint() does not solve the problem, neither diagram.repaintDiagram().
                                          
                     Diagram panel is repainted after resize of the frame.                 
                    */
                    
                }
            });

          }
      }
