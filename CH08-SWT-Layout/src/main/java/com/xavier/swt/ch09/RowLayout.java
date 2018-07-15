package com.xavier.swt.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

/**
 * Created by Xavier on 2018-07-15.
 */
public class RowLayout {
    Display d = new Display();
    Shell s = new Shell(d);
    public RowLayout(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A RowLayout Example");
        org.eclipse.swt.layout.RowLayout layout = new org.eclipse.swt.layout.RowLayout(SWT.VERTICAL);
        layout.wrap = false;
        layout.pack = false;
        s.setLayout(layout);
        final Text t = new Text(s, SWT.SINGLE | SWT.BORDER);
        final Button b1 = new Button(s, SWT.CENTER);
        b1.setText("OK");
        final Button b2 = new Button(s, SWT.CENTER);
        b2.setText("Cancel");
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
