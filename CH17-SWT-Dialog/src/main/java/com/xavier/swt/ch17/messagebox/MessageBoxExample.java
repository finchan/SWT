package com.xavier.swt.ch17.messagebox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class MessageBoxExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public MessageBoxExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A MessageBox Example");
        Menu menuBar = new Menu(s, SWT.BAR);
        MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
        fileItem.setText("File");

        Menu filemenu  = new Menu(s, SWT.DROP_DOWN);
        MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
        exitItem.setText("Exit");
        s.setMenuBar(menuBar);
        fileItem.setMenu(filemenu );

        exitItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                MessageBox msg = new MessageBox(s, SWT.ICON_QUESTION|SWT.YES|SWT.NO);
                msg.setText("Exiting Application");
                msg.setMessage("Do you really want to exit?");
                int response = msg.open();
                if(response == SWT.YES) {
                    System.exit(0);
                }
            }
        });

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
