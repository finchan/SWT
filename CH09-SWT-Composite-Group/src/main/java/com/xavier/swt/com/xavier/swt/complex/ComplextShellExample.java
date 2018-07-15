package com.xavier.swt.com.xavier.swt.complex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018-07-15.
 */
public class ComplextShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public ComplextShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Complex Shell Example");

        GridLayout layout = new GridLayout();
        layout.numColumns = 4;
        s.setLayout(layout);

        GridComposite gc = new GridComposite(s, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 4;
        gc.setLayoutData(gd);

        RowComposite rc = new RowComposite(s, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 4;
        gd.horizontalAlignment = SWT.CENTER;
        rc.setLayoutData(gd);

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
