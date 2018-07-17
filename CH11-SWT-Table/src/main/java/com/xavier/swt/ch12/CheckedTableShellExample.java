package com.xavier.swt.ch12;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;


public class CheckedTableShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public CheckedTableShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Button Example");
        s.setLayout(new FillLayout());

        Table t = new Table(s, SWT.BORDER|SWT.CHECK|SWT.FULL_SELECTION);

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

        item1.setChecked(true);
        boolean item1Checked = item1.getChecked();
        System.out.println(item1Checked);

        TableItem [] items = t.getItems();
        for(TableItem item : items) {
            if(item.getText(2).equals("Ohio")){
                item.setBackground(new Color(d, 175,255, 64));
            }
        }

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
