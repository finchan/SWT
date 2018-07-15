package com.xavier.swt.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class GridLayout {
    Display d = new Display();
    Shell s = new Shell(d);
    public GridLayout(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A GridLayout Example");
        org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
        layout.numColumns = 3;
        s.setLayout(layout);

        final Label l1 = new Label(s, SWT.BOLD);
        l1.setText("Column One");
        final Label l2 = new Label(s, SWT.BOLD);
        l2.setText("Column Two");
        final Label l3 = new Label(s, SWT.BOLD);
        l3.setText("Column Three");
        final Text t1 = new Text(s, SWT.BORDER);
        final Text t2 = new Text(s, SWT.BORDER);
        final Text t3 = new Text(s, SWT.BORDER);
        final Text t4 = new Text(s, SWT.BORDER);
        final Text t5 = new Text(s, SWT.BORDER);

        GridData gd = new GridData();
        gd.horizontalAlignment = GridData.CENTER;
        l1.setLayoutData(gd);
        gd = new GridData();
        gd.horizontalAlignment = GridData.CENTER;
        l2.setLayoutData(gd);
        gd = new GridData();
        gd.horizontalAlignment = GridData.CENTER;
        l3.setLayoutData(gd);

        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t1.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t2.setLayoutData(gd);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 30;
        gd.verticalSpan=2;
        t3.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t4.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t5.setLayoutData(gd);

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
