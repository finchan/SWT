package com.xavier.swt.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class FormLayout {
    Display d = new Display();
    Shell s = new Shell(d);
    public FormLayout(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A FormLayout Example");
        org.eclipse.swt.layout.FormLayout layout = new org.eclipse.swt.layout.FormLayout();
        s.setLayout(layout);

        final Label l1 = new Label(s, SWT.RIGHT|SWT.BORDER);
        l1.setText("FIrst Name");
        FormData fd = new FormData();
        fd.top = new FormAttachment(10, 10);
        fd.left = new FormAttachment(0, 10);
        fd.bottom = new FormAttachment(30,0);
        fd.right = new FormAttachment(40,0);
        l1.setLayoutData(fd);

        final Label l2 = new Label(s, SWT.RIGHT|SWT.BORDER);
        l2.setText("Last Name");
        fd = new FormData();
        fd.top = new FormAttachment(l1, 10);
        fd.left = new FormAttachment(0, 10);
        fd.bottom = new FormAttachment(50,0);
        fd.right = new FormAttachment(40,0);
        l2.setLayoutData(fd);

        final Text t1 = new Text(s, SWT.BORDER);
        fd = new FormData();
        fd.top = new FormAttachment(l1, 0, SWT.TOP);
        fd.left = new FormAttachment(l1, 10);
        fd.right = new FormAttachment(l1, 100, SWT.RIGHT);
        t1.setLayoutData(fd);
        final Text t2 = new Text(s, SWT.BORDER);
        fd = new FormData();
        fd.top = new FormAttachment(l2, 0, SWT.TOP);
        fd.left = new FormAttachment(l2, 10);
        fd.right = new FormAttachment(l2, 100, SWT.RIGHT);
        t2.setLayoutData(fd);

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
