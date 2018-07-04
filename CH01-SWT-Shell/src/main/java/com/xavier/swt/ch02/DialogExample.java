package com.xavier.swt.ch02;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018/7/4.
 */
public class DialogExample  extends Dialog {
    DialogExample(Shell parent) {
        super(parent);
    }

    public String open() {
        Shell parent = getParent();
        Shell dialog = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

        dialog.setSize(100, 100);
        dialog.setText("Shell Dialog");
        dialog.open();
        Display display = parent.getDisplay();
        dialog.setImage(new Image(display, this.getClass().getResourceAsStream("/images/bean.ico")));
        while(!dialog.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        return "After Dialog";
    }
}
