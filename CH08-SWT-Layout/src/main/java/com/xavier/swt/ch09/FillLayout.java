package com.xavier.swt.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class FillLayout {
    Display d = new Display();
    Shell s = new Shell(d);
    public FillLayout(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A FillLayout Example");
        s.setLayout(new org.eclipse.swt.layout.FillLayout(SWT.VERTICAL));
        final Text t = new Text(s, SWT.MULTI|SWT.BORDER|SWT.WRAP|SWT.V_SCROLL);
        final Button b = new Button(s, SWT.BORDER);
        b.setText("OK");
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
