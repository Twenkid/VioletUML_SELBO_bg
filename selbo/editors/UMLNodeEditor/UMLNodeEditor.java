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

public class UMLNodeEditor extends JPanel { // extends JFrame{
    
    
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
     
     
    public UMLNodeEditor()
    {
    
    }

    public void init2()
    {
           JFrame frame = new JFrame("HelloWorldSwing");
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
            
            //otherMenu.add(item = new JCheckBoxMenuItem("Save as..."));
            
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
            
            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(otherMenu);
                                              
            //basePanel.setLayout(new BorderLayout());          
            basePanel.setLayout(new BorderLayout());
            basePanel.add(menuBar, BorderLayout.NORTH);
            
            frame.setLayout(new BorderLayout());
            
            //frame.setLayout(new GridLayout(1,1));
            //frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
            
         //=====================   frame.add(basePanel, BorderLayout.NORTH);
            
            
            ///frame.add(basePanel);// BorderLayout.NORTH);         
            
            //tabbedPanel.setLayout(new BorderLayout());            
            //tabbedPanel.setSize(300, 300);            
            //tabbedPanel.add(tabbedPane, BorderLayout.NORTH);
            //tabbedPanel.add(tabbedPane, BorderLayout.CENTER);
            
            
            //tabbedPanel.setSize(600,300);
            
            //basePanel.add(tabbedPanel);
            
            //tabbedPane.setSize(300, 300);
            
            //frame.add(tabbedPanel, BorderLayout.SOUTH);
             //frame.add(tabbedPanel);
                        
            frame.add(tabbedPane, BorderLayout.CENTER);
            //DiagramPanel diagramPanel = //this.getActiveEditor().getUMLDiagramPanel();
                                 //==========================
                                //frame.add(tabbedPane, BorderLayout.CENTER);
                               //===========================
            
            
            //frame.add(tabbedPane);
                        
            //frame.add(menuBar);           
                                
            //frame.add(tabbedPane);
            
            
            //umlEditor = new UMLEditor();
            
          //=========== STARTING ROUTINE ==========
            UMLEditor editor = new UMLEditor();
            //editor.startingMode = CMDLINE_STARTING_MODE;
            editor.setStartingMode(editor.CMDLINE_STARTING_MODE); //
            
           
            /*String startedWithWebStart = System.getProperty("startedWithWebStart", "false");
            if ("true".equals(startedWithWebStart))
            {
                editor.startingMode = WEBSTART_STARTING_MODE;
            }
            */
            
            
            //frame.add(editor.)
            
            
            //frame.add(umlEditor.ge)
            
            frame.setSize(600, 400);
            editor.createWorkspace();
            frame.add(editor.editorFrame);
            
            
            
            
            //tabbedPane.set
            
            //tabbedPane.setLocation(30, 100);
            //menuBar.setLocation(20, 40);
            
            
            
            
            //frame.add(tab);
            
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
            
            //frame.setLayout(new GridLayout(1,1));
            //frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
            
         //=====================
             frame.add(basePanel, BorderLayout.NORTH);
                      
                        
            // frame.add(tabbedPane, BorderLayout.CENTER);
            //DiagramPanel diagramPanel = //this.getActiveEditor().getUMLDiagramPanel();
                                 //==========================
                                //frame.add(tabbedPane, BorderLayout.CENTER);
                               //===========================
            

        /*
            
          //=========== STARTING ROUTINE ==========
            UMLEditor editor = new UMLEditor();
            //editor.startingMode = CMDLINE_STARTING_MODE;
            editor.setStartingMode(editor.CMDLINE_STARTING_MODE); //
                       
            frame.setSize(600, 400);
            editor.createWorkspace();
            frame.add(editor.editorFrame);
        */
            
            
          //  UMLEditor editor = new UMLEditor();
            ThemeManager.getInstance().applyPreferedTheme();
            //SplashScreen splashScreen = new SplashScreen();
            //splashScreen.setVisible(true);
            VersionChecker checker = new VersionChecker();
         //   checker.check(editor.JAVA_VERSION);
            // try
            // {
            // System.setProperty("apple.laf.useScreenMenuBar", "true");
            // }
            // catch (SecurityException ex)
            // {
            // // well, we tried...
            // }
            /*
            this.editorFrame = new EditorFrame();
            this.editorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            */
         
         System.out.println("Before Editor Panel...");
         //this.editorPanel = new EditorPanel(frame);     
         System.out.println("After Editor Panel...");
         //UseCaseDiagramGraph useCase = new UseCaseDiagramGraph();
         if (frame == null) System.out.println("NULLLLL???.");
         
         //FileChooserService fileChoose = new FileChooserService();
         //DiagramPanel diagramPanel;
         //THIS IS
         
         //HEEEEEEEEEEEEEEEEEEEEERRRRRRRRRRRREEEEEEEEEEE
        ///* 
         //this.editorPanel = new EditorPanel(frame);
                  //diagramPanel = fileAction.createDiagram(UseCaseDiagramGraph.class, frame);
        //*/
             
                              // fileAction.saveAs(diagramPanel, FileChooserServiceFactory.getInstance());
         /////////
         
         System.out.println("After Create Diagram...");
         
         
         //editorPanel.addTabbedPane()
         //editorPanel.create //addTabbedPane()
            
         //fileAction
            
            //FileAction fileAction = new FileAction();
            //SplashScreen.displayOverEditor(editorFrame, 1000);
            /*
            if (this.args != null && this.args.length != 0)
            {
                for (int i = 0; i < this.args.length; i++)
                {
                    fileAction.open(this.args[i], editorFrame);
                }
            }
            */
            
            String[] filePaths = FileService.getOpenedFilesDuringLastSession();
            
            /*
            fileAction.open(filePaths, editorFrame);
            String activeDiagramFile = FileService.getActiveDiagramFile();
            editorFrame.setActiveDiagramPanel(activeDiagramFile);
            editorFrame.setVisible(true);
            splashScreen.setVisible(false);
            splashScreen.dispose();
            */

            //editor.installGraphPlugins();
            
                // editorPanel = new EditorPanel(frame);
            
     // diagramPanel = fileAction.createDiagram(UseCaseDiagramGraph.class, frame);
            //this.add(diagramPanel);
         // editorPanel.add(diagramPanel);
            
            
                 //frame.add(editorPanel);
            //this.editorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //FileAction fileAction = new FileAction();
            
        //    UMLEditor editor = new UMLEditor();
            //editor.startingMode = CMDLINE_STARTING_MODE;
          //  editor.setStartingMode(editor.CMDLINE_STARTING_MODE); //
            
            //EditorPanel panel = new EditorPanel(frame);
            editorPanel = new EditorPanel(frame);
                
            System.out.println("Editor panel...");
            
            frame.add(editorPanel);
            frame.setSize(800,600);
            //frame.setBounds(20, 20, 600,400);
            System.out.println("Bounds...");
            
            
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
         /*
        //diagramPanel.d
         frame.remove(diagramPanel);
         frame.remove(editorPanel);
         */
         //editorPanel.remove(diagramPanel);
                           // editorPanel = new EditorPanel(frame);  -- unneeded
         
         //frame.remove(diagramPanel);
         System.out.println("public void performNewClass()");
         if (diagramPanel != null) frame.remove(diagramPanel);
         diagramPanel = fileAction.createDiagram(ClassDiagramGraph.class, frame);
         
         //GraphPanel panel = diagramPanel.getGraphPanel();
         diagramPanel.getGraphPanel().SetPlugInMode(frame);
         
         //GraphPanel panel = diagramPanel.getGraphPanel(); //etGraphPanel();
         
         //.SetPlugInMode(frame); //
         //diagramPanel.get
         frame.repaint();
         /*
         frame.remove(this.editorPanel);
         frame.remove(this.diagramPanel);
         */
         
         /*
         this.editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(ClassDiagramGraph.class, frame);
         frame.repaint();
         */
         //diagramPanel = nw
     }
     
     public void performNewStateDiagram()
     {
         System.out.println("public void performNewUseCase()");         
         //editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(StateDiagramGraph.class, frame);
         //frame.add(diagramPanel);
             editorPanel.add(diagramPanel);
         //diagramPanel.getGraphPanel().SetPlugInMode(frame);
     }
     
     public void performNewUseCase()
     {
         System.out.println("public void performNewUseCase()");         
         //editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(UseCaseDiagramGraph.class, frame);
         //diagramPanel.getGraphPanel().SetPlugInMode(frame);
     }
     
     public void performNewActivity()
     {
         System.out.println("public void performNewUseCase()");         
         //editorPanel = new EditorPanel(frame);
         diagramPanel = fileAction.createDiagram(ActivityDiagramGraph.class, frame);
     
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
                    //UMLComponent mainFrame = new UMLComponent();
                    UMLNodeEditor mainFrame = new UMLNodeEditor();
                    mainFrame.init();
                  // mainFrame.performNewClassDiagram();
                    mainFrame.performNewStateDiagram();                                        
                }
            });

          }
      }
