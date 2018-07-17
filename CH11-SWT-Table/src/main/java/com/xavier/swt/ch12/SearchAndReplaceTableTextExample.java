package com.xavier.swt.ch12;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by Xavier on 2018/7/17.
 */
public class SearchAndReplaceTableTextExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public SearchAndReplaceTableTextExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Button Example");
        s.setLayout(new FillLayout());
        GridLayout layout = new GridLayout();
        layout.numColumns = 4;
        s.setLayout(layout);

        GridData gridData = new GridData(GridData.FILL_BOTH);
        gridData.horizontalSpan = 4;
        final Table t = new Table(s, SWT.BORDER);
        t.setLayoutData(gridData);
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

        final Text searchText = new Text(s, SWT.BORDER);
        final Text replaceText = new Text(s, SWT.BORDER);
        final Button btn = new Button(s, SWT.NONE);
        btn.setText("REPLACE");

        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                TableItem [] items = t.getItems();
                for(TableItem item : items) {
                    item.setBackground(Display.getCurrent().getSystemColor(SWT.TRANSPARENCY_ALPHA));
                    if(item.getText(2).equals(searchText.getText())){
                        item.setText(2, replaceText.getText());
                    }
                }
            }
        });

        item1.setText(new String[]{"CELL1", "CELL2", "CELL3"});
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
