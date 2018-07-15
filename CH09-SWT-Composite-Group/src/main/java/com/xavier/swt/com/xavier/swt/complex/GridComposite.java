package com.xavier.swt.com.xavier.swt.complex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class GridComposite extends Composite {
    public GridComposite(Composite parent, int style) {
        super(parent, style);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        this.setLayout(layout);

        final Label l1 = new Label(this, SWT.BOLD);
        l1.setText("Column One");
        final Label l2 = new Label(this, SWT.BOLD);
        l2.setText("Column Two");
        final Label l3 = new Label(this, SWT.BOLD);
        l3.setText("Column Three");
        final Text t1 = new Text(this, SWT.BORDER);
        final Text t2 = new Text(this, SWT.BORDER);
        final Text t3 = new Text(this, SWT.BORDER);
        final Text t4 = new Text(this, SWT.BORDER);
        final Text t5 = new Text(this, SWT.BORDER);
        final Text t6 = new Text(this, SWT.BORDER);

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
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t3.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t4.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t5.setLayoutData(gd);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = 30;
        t6.setLayoutData(gd);
    }
}
