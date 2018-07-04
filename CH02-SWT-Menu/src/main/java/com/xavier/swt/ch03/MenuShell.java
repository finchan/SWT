package com.xavier.swt.ch03;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018-07-04.
 */
public class MenuShell {
    Display d;
    Shell s;
    MenuShell() {
        d = new Display();
        s = new Shell(d);
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Shell Menu Example");
       //Menu Bar
        Menu m = new Menu(s, SWT.BAR);
        s.setMenuBar(m);

        final MenuItem fileMenuItem = new MenuItem(m, SWT.CASCADE);
        fileMenuItem.setText("File");
        final Menu fileMenu = new Menu(s, SWT.DROP_DOWN);
        fileMenuItem.setMenu(fileMenu);
        final MenuItem openMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        openMenuItem.setText("File");
        final Menu subMenu = new Menu(s, SWT.DROP_DOWN);
        openMenuItem.setMenu(subMenu);
        final MenuItem childMenuItem = new MenuItem(subMenu, SWT.PUSH);
        childMenuItem.setText("Child");
        final MenuItem dialogMenuItem = new MenuItem(subMenu, SWT.PUSH);
        dialogMenuItem.setText("Dialog");
        final MenuItem seperator = new MenuItem(fileMenu, SWT.SEPARATOR);
        final MenuItem exitMenuItem = new MenuItem(fileMenu, SWT.PUSH);
        exitMenuItem.setText("Exit");

        final MenuItem editMenuItem = new MenuItem(m, SWT.CASCADE);
        editMenuItem.setText("Edit");
        final Menu editMenu = new Menu(s, SWT.DROP_DOWN);
        editMenuItem.setMenu(editMenu);
        final MenuItem cutMenuItem = new MenuItem(editMenu, SWT.PUSH);
        cutMenuItem.setText("Cut");
        final MenuItem pasteMenuItem = new MenuItem(editMenu, SWT.PUSH);
        pasteMenuItem.setText("Paste");
        final MenuItem copyMenuItem = new MenuItem(editMenu, SWT.PUSH);
        copyMenuItem.setText("Copy");

        final MenuItem windowMenuItem = new MenuItem(m, SWT.CASCADE);
        windowMenuItem.setText("Window");
        final Menu windowMenu = new Menu(s, SWT.DROP_DOWN);
        windowMenuItem.setMenu(windowMenu);
        final MenuItem maximizeMenuItem = new MenuItem(windowMenu, SWT.PUSH);
        maximizeMenuItem.setText("Max");
        final MenuItem minimizeMenuItem = new MenuItem(windowMenu, SWT.PUSH);
        minimizeMenuItem.setText("Min");

        final MenuItem helpMenuItem = new MenuItem(m, SWT.CASCADE);
        helpMenuItem.setText("Help");
        final Menu helpMenu = new Menu(s, SWT.DROP_DOWN);
        helpMenuItem.setMenu(helpMenu);
        final MenuItem aboutMenuItem = new MenuItem(helpMenu, SWT.PUSH);
        aboutMenuItem.setText("About");

        s.open();
        while(!s.isDisposed()) {
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
