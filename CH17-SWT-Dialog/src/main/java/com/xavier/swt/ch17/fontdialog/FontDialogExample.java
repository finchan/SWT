package com.xavier.swt.ch17.fontdialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class FontDialogExample {
    Display d = new Display();
    Shell s = new Shell(d);
    final FontDialog fd =  new FontDialog(s);

    public FontDialogExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Font Dialog Example");
        s.setLayout(new FillLayout(SWT.VERTICAL));
        final Text t = new Text(s, SWT.BORDER|SWT.MULTI|SWT.WRAP|SWT.V_SCROLL);
        t.setText("//Initialized FontDialog. To track  FD state, place FD as a member property in class.");
        final Button b = new Button(s, SWT.BORDER|SWT.PUSH);
        b.setText("Change Font");

        //Initialized FontDialog. To track  FD state, place FD as a member property in class.
        fd.setRGB(new RGB(0, 0, 0));
        fd.setText("Select Font");
        final FontData defaultFont = new FontData("Courier", 10, SWT.BOLD);
        fd.setFontData(defaultFont);

        b.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                FontData selectedFont = fd.open();
                if(selectedFont == null)
                    return;
                t.setForeground(new Color(d, fd.getRGB()));
                t.setFont(new Font(d, selectedFont));
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
