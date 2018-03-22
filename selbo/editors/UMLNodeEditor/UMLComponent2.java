package selbo.editors.UMLNodeEditor;


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

public class UMLComponent2 extends JPanel { // extends JFrame{
           
     int sizeX=800, sizeY=600;
    
     //EditorPanel 
     UMLSelboEditor editorPanel;
     
     JFrame frame; // = new JFrame("HelloWorldSwing");
     JMenu fileMenu = new JMenu("File");
     JMenu editMenu = new JMenu("Edit");
     JMenu otherMenu = new JMenu("Other");
     JMenu subMenu = new JMenu("SubMenu");
     JMenu subMenu2 = new JMenu("SubMenu2");
     JMenuBar menuBar = new JMenuBar();
     
     JPanel basePanel = new JPanel();
     JPanel tabbedPanel = new JPanel();                  
     //EditorPanel editorJPanel;

     
     FileAction fileAction = new FileAction();     
     DiagramPanel diagramPanel = null;
     
    public UMLComponent2()
    {
    
    }

    public void init()
    {
           frame = new JFrame("Violet UML Component - Demo");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            frame.pack();
            frame.setVisible(true);
            
            JMenuItem item;
            subMenu2.add(item = new JMenuItem("Extra 2"));
              //item.addActionListener(printListener);
            subMenu.add(item = new JMenuItem("Extra 1"));
              //item.addActionListener(printListener);
            subMenu.add(subMenu2);

            //Assemble the Other menu itself.
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
            ThemeManager.getInstance().switchToVistaBlueTheme();            
            
            //CREATE EDITOR PANEL            
            editorPanel = new UMLSelboEditor(frame);
            
            System.out.println("UMLSelboEditor(frame); ... Editor panel...");
            
            frame.add(editorPanel);            
            frame.setSize(sizeX-1, sizeY-1);
            
            
            //frame.setBounds(20, 20, 600,400);
             //System.out.println("Bounds...");                      
    }
    
    
     public void performSaveAs()
     {
         //DiagramPanel diagramPanel;
         //THIS IS
         //diagramPanel = fileAction.createDiagram(UseCaseDiagramGraph.class, frame);         
         fileAction.saveAs(diagramPanel, FileChooserServiceFactory.getInstance());         
     }
     
     public void performNewClassDiagram()
     {         
         System.out.println("public void performNewClass()");         
                  
         diagramPanel = fileAction.createDiagram(ClassDiagramGraph.class, frame);
                 
         editorPanel.setDiagramPanel(diagramPanel);
         editorPanel.repaint();
         refresh(frame);                          
     }
     
     public void performNewStateDiagram()
     {
         System.out.println("public void performNewUseCase()");         

         diagramPanel = fileAction.createDiagram(StateDiagramGraph.class, frame);
         
         editorPanel.setDiagramPanel(diagramPanel);
         editorPanel.repaint();
         frame.repaint();
         refresh(frame);          
     }
     
     public void refresh(JFrame frame)
     {                
      frame.setSize(sizeX, sizeY);
      System.out.println("SetSize??...");
     }
     
     public void performNewUseCase()
     {
         System.out.println("public void performNewUseCase()");         

         DiagramPanel diagramPanel = fileAction.createDiagram(UseCaseDiagramGraph.class, frame);
         editorPanel.setDiagramPanel(diagramPanel);
         editorPanel.repaint();
         frame.repaint();
         refresh(frame);                           
     }
     
     public void performNewActivity()
     {
         System.out.println("public void performNewUseCase()");         
         //editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(ActivityDiagramGraph.class, frame);
         editorPanel.setDiagramPanel(diagramPanel);
         editorPanel.repaint();
         refresh(frame); 
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
                    //UMLComponent mainFrame = new UMLComponent();
                    UMLComponent2 mainFrame = new UMLComponent2();
                    mainFrame.init();
                 //  mainFrame.performNewClassDiagram();
                    // mainFrame.performNewStateDiagram();                                        
                }
            });

          }
      }
