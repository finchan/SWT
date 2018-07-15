package com.xavier.swt.com.xavier.swt.complex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Created by Xavier on 2018-07-15.
 */
public class RowComposite extends Composite {
    final Button okBtn;
    final Button cancelBtn;
    public RowComposite(Composite parent, int style) {
        super(parent, SWT.NO_FOCUS);
        RowLayout layout = new RowLayout();
        layout.pack = false;
        layout.wrap = false;
        this.setLayout(layout);

        okBtn = new Button(this, SWT.PUSH);
        cancelBtn = new Button(this, SWT.PUSH);
        okBtn.setText("OK");
        okBtn.setSize(30, 20);
        cancelBtn.setText("Cancel");
        cancelBtn.setSize(30, 20);

        cancelBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Cancel was clicked");
            }
        });
    }
}
