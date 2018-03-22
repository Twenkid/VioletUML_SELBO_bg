
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

public class UMLSelboEditor extends EditorPanel { // extends JFrame{
    
    
    /*
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
     JFrame ownerFrame;
     */
     
     
    JFrame ownerFrame;
    public UMLSelboEditor(JFrame owner)
    {
     super(owner);
     ownerFrame = owner;
    }
 }
