package com.xavier.swt.ch17.filedialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class FileDialogExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public FileDialogExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A FileDialog Example");

        final Menu m = new Menu(s, SWT.BAR);
        final MenuItem fileItem = new MenuItem(m, SWT.CASCADE);
        fileItem.setText("&File");
        final Menu fileMenu = new Menu(s, SWT.DROP_DOWN);
        fileItem.setMenu(fileMenu);
        final MenuItem openMenuItem = new MenuItem(fileMenu, SWT.PUSH);
        openMenuItem.setText("&Open File");
        final MenuItem saveMenuItem = new MenuItem(fileMenu, SWT.PUSH);
        saveMenuItem.setText("&Save File");
        final MenuItem openDirectoryMenuItem = new MenuItem(fileMenu, SWT.PUSH);
        openDirectoryMenuItem.setText("Open &Directory");

        s.setMenuBar(m);
        openMenuItem.addSelectionListener(new Open());
        saveMenuItem.addSelectionListener(new Save());
        openDirectoryMenuItem.addSelectionListener(new OpenDirectory());

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }

    class Open extends SelectionAdapter{
        @Override
        public void widgetSelected(SelectionEvent selectionEvent) {
            FileDialog fd = new FileDialog(s, SWT.OPEN);
            fd.setText("Open File");
            fd.setFilterPath("F:\\Source\\jquery-easyui-1.4.4");
            String [] filterExt = {"*.txt","*.js","*.*"};
            fd.setFilterExtensions(filterExt);
            String selected = fd.open();
            System.out.println(selected);
        }
    }

    class OpenDirectory extends SelectionAdapter{
        @Override
        public void widgetSelected(SelectionEvent selectionEvent) {
            DirectoryDialog dd = new DirectoryDialog(s);
            dd.setText("Choose a Directory");
            dd.setFilterPath("F:\\Source\\jquery-easyui-1.4.4");
            String selected = dd.open();
            System.out.println(selected);
        }
    }

    class Save extends SelectionAdapter{
        @Override
        public void widgetSelected(SelectionEvent selectionEvent) {
            FileDialog fd = new FileDialog(s, SWT.SAVE);
            fd.setText("Save File");
            fd.setFilterPath("F:\\Source\\jquery-easyui-1.4.4");
            String [] filterExt = {"*.txt","*.js","*.*"};
            fd.setFilterExtensions(filterExt);
            String selected = fd.open();
            System.out.println(selected);
        }
    }
}
