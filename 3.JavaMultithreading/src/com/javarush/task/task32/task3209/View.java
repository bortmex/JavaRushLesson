package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * Created by alexa on 03.09.2017.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() throws HeadlessException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void selectedTabChanged() {
        if(tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        } else if(tabbedPane.getSelectedIndex()==1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this,
                "Eggs are not supposed to be green.",
                "Inane custom dialog",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex()==0;
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException c) {
            ExceptionHandler.log(c);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException c) {
            ExceptionHandler.log(c);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void init() {
        initGui();
        WindowListener winListener = new FrameListener(this);
        addWindowListener(winListener);
        setVisible(true);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
        //setJMenuBar(jMenuBar);

    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(1000, 600));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void exit() {
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Новый": controller.createNewDocument();
            break;
            case "Открыть": controller.openDocument();
            break;
            case "Сохранить": controller.saveDocument();
            break;
            case "Сохранить как...": controller.saveDocumentAs();
            break;
            case "Выход": controller.exit();
            break;
            case "О программе": showAbout();
            break;
        }
    }
}
