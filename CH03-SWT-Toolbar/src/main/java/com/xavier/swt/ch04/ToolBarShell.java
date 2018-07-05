package com.xavier.swt.ch04;

import com.xavier.swt.ch02.ChildShell;
import com.xavier.swt.ch02.DialogExample;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

/**
 * Created by Xavier on 2018-07-04.
 */
public class ToolBarShell {
    Display d;
    Shell s;
    ToolBarShell() {
        d = new Display();
        s = new Shell(d);
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A ToolBar Example");

//       //Menu Bar
//        Menu m = new Menu(s, SWT.BAR);
//        s.setMenuBar(m);
//
//        final MenuItem fileMenuItem = new MenuItem(m, SWT.CASCADE);
//        fileMenuItem.setText("File");
//        final Menu fileMenu = new Menu(s, SWT.DROP_DOWN);
//        fileMenuItem.setMenu(fileMenu);
//        final MenuItem openMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//        openMenuItem.setText("&Open");
//        final Menu subMenu = new Menu(s, SWT.DROP_DOWN);
//        openMenuItem.setMenu(subMenu);
//        final MenuItem childMenuItem = new MenuItem(subMenu, SWT.PUSH);
//        //Keyboard shortcut
//        childMenuItem.setText("&Child");
//        final MenuItem dialogMenuItem = new MenuItem(subMenu, SWT.PUSH);
//        dialogMenuItem.setText("Dialog");
//        //Keyboard shortcut
//        //An accelerator is a two-key combination (the first key normally being the
//        // Control key), that causes the menu item's action event to fire
//        // whether or not the menu item is currently visible.
//        dialogMenuItem.setAccelerator(SWT.CTRL+'D');
//        final MenuItem seperator = new MenuItem(fileMenu, SWT.SEPARATOR);
//        final MenuItem exitMenuItem = new MenuItem(fileMenu, SWT.PUSH);
//        exitMenuItem.setText("Exit");
//
//        final MenuItem editMenuItem = new MenuItem(m, SWT.CASCADE);
//        editMenuItem.setText("Edit");
//        final Menu editMenu = new Menu(s, SWT.DROP_DOWN);
//        editMenuItem.setMenu(editMenu);
//        final MenuItem cutMenuItem = new MenuItem(editMenu, SWT.PUSH);
//        cutMenuItem.setText("Cut");
//        final MenuItem pasteMenuItem = new MenuItem(editMenu, SWT.PUSH);
//        pasteMenuItem.setText("Paste");
//        final MenuItem copyMenuItem = new MenuItem(editMenu, SWT.PUSH);
//        copyMenuItem.setText("Copy");
//
//        final MenuItem optionMenuItem = new MenuItem(m, SWT.CASCADE);
//        optionMenuItem.setText("Option");
//        final Menu optionMenu = new Menu(s, SWT.DROP_DOWN);
//        optionMenuItem.setMenu(optionMenu);
//        final MenuItem checkedOptionMenuItem = new MenuItem(optionMenu, SWT.CHECK);
//        checkedOptionMenuItem.setText("Checked Option");
//        checkedOptionMenuItem.setSelection(true);
//        final MenuItem separator2 = new MenuItem(optionMenu, SWT.SEPARATOR);
//        final MenuItem radioOneMenuItem = new MenuItem(optionMenu, SWT.RADIO);
//        radioOneMenuItem.setText("Radio One");
//        radioOneMenuItem.setSelection(true);
//        final MenuItem radioTwoMenuItem = new MenuItem(optionMenu, SWT.RADIO);
//        radioTwoMenuItem.setText("Radio Two");
//
//
//        final MenuItem windowMenuItem = new MenuItem(m, SWT.CASCADE);
//        windowMenuItem.setText("Window");
//        final Menu windowMenu = new Menu(s, SWT.DROP_DOWN);
//        windowMenuItem.setMenu(windowMenu);
//        final MenuItem maximizeMenuItem = new MenuItem(windowMenu, SWT.PUSH);
//        maximizeMenuItem.setText("Max");
//        final MenuItem minimizeMenuItem = new MenuItem(windowMenu, SWT.PUSH);
//        minimizeMenuItem.setText("Min");
//
//        final MenuItem helpMenuItem = new MenuItem(m, SWT.CASCADE);
//        helpMenuItem.setText("Help");
//        final Menu helpMenu = new Menu(s, SWT.DROP_DOWN);
//        helpMenuItem.setMenu(helpMenu);
//        final MenuItem aboutMenuItem = new MenuItem(helpMenu, SWT.PUSH);
//        aboutMenuItem.setText("About");

        //Toolbar
        final ToolBar toolBar = new ToolBar(s, SWT.HORIZONTAL);
        toolBar.setSize(300, 70);
        toolBar.setLocation(0,0);

        final Image saveIconImage = new Image(d, this.getClass().getResourceAsStream("/images/copy.png"));
        final Image openIconImage = new Image(d, this.getClass().getResourceAsStream("/images/open.png"));
        final Image cutIconImage = new Image(d, this.getClass().getResourceAsStream("/images/cut.png"));
        final Image copyIconImage = new Image(d, this.getClass().getResourceAsStream("/images/copy.png"));
        final Image pasteIconImage = new Image(d, this.getClass().getResourceAsStream("/images/paste.png"));

        final ToolItem saveToolItem = new ToolItem(toolBar, SWT.PUSH);
        saveToolItem.setImage(saveIconImage);
        saveToolItem.setToolTipText("Save File");
        saveToolItem.setText("Save File");
        final ToolItem openToolItem = new ToolItem(toolBar, SWT.PUSH);
        openToolItem.setImage(openIconImage);
        openToolItem.setToolTipText("Open File");
        final ToolItem cutToolItem = new ToolItem(toolBar, SWT.PUSH);
        cutToolItem.setImage(cutIconImage);
        cutToolItem.setToolTipText("Cut File");
        final ToolItem copyToolItem = new ToolItem(toolBar, SWT.PUSH);
        copyToolItem.setImage(copyIconImage);
        copyToolItem.setToolTipText("Copy File");
        final ToolItem pasteToolItem = new ToolItem(toolBar, SWT.PUSH);
        pasteToolItem.setImage(pasteIconImage);
        pasteToolItem.setToolTipText("Paste File");

//        //Menu Events
//        childMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                Shell parent = (Shell) childMenuItem.getParent().getParent();
//                ChildShell cs = new ChildShell(parent, SWT.CLOSE);
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        dialogMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                Shell parent = (Shell) dialogMenuItem.getParent().getParent();
//                DialogExample de = new DialogExample(parent);
//                de.open();
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        cutMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                System.out.println("Cut");
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        copyMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                System.out.println("Copy");
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        pasteMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                System.out.println("Paste");
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        maximizeMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                Shell parent = (Shell) maximizeMenuItem.getParent().getParent();
//                parent.setMaximized(true);
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        minimizeMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                Shell parent = (Shell) minimizeMenuItem.getParent().getParent();
//                parent.setMinimized(true);
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        aboutMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                System.out.println("About");
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        checkedOptionMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                if(checkedOptionMenuItem.getSelection()){
//                    System.out.println("Check Menu was checked");
//                } else {
//                    System.out.println("Check Menu was unchecked");
//                }
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        radioOneMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                if(radioOneMenuItem.getSelection()) {
//                    System.out.println("Radio One was checked");
//                }
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        radioTwoMenuItem.addSelectionListener(new SelectionListener() {
//            public void widgetSelected(SelectionEvent selectionEvent) {
//                if(radioTwoMenuItem.getSelection()){
//                    System.out.println("Radio Two was checked");
//                }
//            }
//
//            public void widgetDefaultSelected(SelectionEvent selectionEvent) {
//
//            }
//        });
//
//        //Add popup Menu
//        s.setMenu(createEditPopupMenu());

        s.open();
        while(!s.isDisposed()) {
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }

    private Menu createEditPopupMenu() {
        final Menu p = new Menu(s, SWT.POP_UP);
        final MenuItem cutMenuItem = new MenuItem(p, SWT.PUSH);
        cutMenuItem.setText("Cut");
        cutMenuItem.setAccelerator(SWT.CTRL + 'X');
        final MenuItem copyMenuItem = new MenuItem(p, SWT.PUSH);
        copyMenuItem.setText("Copy");
        copyMenuItem.setAccelerator(SWT.CTRL + 'c');
        final MenuItem pasteMenuItem = new MenuItem(p, SWT.PUSH);
        pasteMenuItem.setText("Paste");
        pasteMenuItem.setAccelerator(SWT.PUSH + 'v');

        cutMenuItem.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Popup Cut");
            }

            public void widgetDefaultSelected(SelectionEvent selectionEvent) {

            }
        });
        copyMenuItem.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Popup Copy");
            }

            public void widgetDefaultSelected(SelectionEvent selectionEvent) {

            }
        });
        pasteMenuItem.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Popup Paste");
            }

            public void widgetDefaultSelected(SelectionEvent selectionEvent) {

            }
        });

        return p;
    }
}
