package com.xavier.swt.ch17.colordialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class ColorDialogExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public ColorDialogExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Color Dialog Example");
        s.setLayout(new FillLayout(SWT.VERTICAL));
        final Text t = new Text(s, SWT.BORDER|SWT.MULTI);
        final Button b = new Button(s, SWT.BORDER|SWT.PUSH);
        b.setText("Change Color");
        b.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                ColorDialog cd = new ColorDialog(s);
                cd.setText("Color Dialog");
                cd.setRGB(new RGB(255, 255, 255));
                RGB selectedColor = cd.open();
                if(selectedColor == null)
                    return;
                t.setBackground(new Color(d, selectedColor));
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
