package com.xavier.swt.ch12;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by Xavier on 2018/7/16.
 */
public class TableShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public TableShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Button Example");
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER);

        TableColumn tc1 = new TableColumn(t, SWT.CENTER);
        TableColumn tc2 = new TableColumn(t, SWT.CENTER);
        TableColumn tc3 = new TableColumn(t, SWT.CENTER);
        tc1.setText("First Name");
        tc2.setText("Last Name");
        tc3.setText("Address");
        tc1.setWidth(100);
        tc2.setWidth(100);
        tc3.setWidth(100);
        t.setHeaderVisible(true);
        t.setLinesVisible(true);

        TableItem item1 = new TableItem(t, SWT.NONE);
        item1.setText(new String[] {"Tim", "Hatton", "Kentucky"});
        TableItem item2 = new TableItem(t, SWT.NONE);
        item2.setText(new String[] {"Caitlyn", "Warner", "Ohio"});
        TableItem item3 = new TableItem(t, SWT.NONE);
        item3.setText(new String[] {"Resse", "Miller", "Ohio"});

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
