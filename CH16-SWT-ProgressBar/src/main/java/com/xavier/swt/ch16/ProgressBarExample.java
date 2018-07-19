package com.xavier.swt.ch16;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public ProgressBarExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A ProgressBar Example");

        final ProgressBar bar = new ProgressBar(s, SWT.HORIZONTAL);
        bar.setMinimum(0);
        bar.setMaximum(100);
        bar.setBounds(10,10, 200, 20);

        Button b = new Button(s, SWT.PUSH);
        b.setBounds(10, 50, 40, 20);
        b.setText("*Start*");

        b.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                int progress = 0;
                //Increase one unit per loop
//                for (int n = 0; n<=1000000000;n++ ) {
//                    if(n%10000000==0){
//                        progress++;
//                        bar.setSelection(progress);
//                    }
//                }

                //increase 10 unit per loop
                for (int n = 1; n <= 1000000000; n++) {
                    if (n % 100000000 == 0) {
                        progress+=10;
                        bar.setSelection(progress);
                    }
                }
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
