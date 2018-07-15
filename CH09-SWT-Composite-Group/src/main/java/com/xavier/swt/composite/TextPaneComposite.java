package com.xavier.swt.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class TextPaneComposite extends Composite {
    public TextPaneComposite(Composite parent, int style) {
        super(parent, style);
        this.setLayout(new FillLayout());
        final Text t = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
    }
}
