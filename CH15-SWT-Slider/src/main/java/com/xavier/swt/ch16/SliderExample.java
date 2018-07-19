package com.xavier.swt.ch16;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

public class SliderExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public SliderExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Slider Example");

        final Slider  slide = new Slider(s, SWT.HORIZONTAL);
        slide.setBounds(115, 50, 25, 15);
        slide.setMinimum(0);
        slide.setMaximum(100);
        slide.setIncrement(1);

        final Text t = new Text(s, SWT.BORDER);
        t.setBounds(115, 25, 25, 25);
        t.setText("0");

        slide.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                t.setText(new Integer(slide.getSelection()).toString());
            }
        });

        final Slider  slide2 = new Slider(s, SWT.HORIZONTAL);
        slide2.setBounds(115, 100, 101, 15);
        slide2.setMinimum(0);
        slide2.setMaximum(110);
        slide2.setPageIncrement(10);
        slide2.setIncrement(1);
        slide2.setThumb(10);

        final Text t2 = new Text(s, SWT.BORDER);
        t2.setBounds(115, 75, 25, 25);
        t2.setText("0");

        slide2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                t2.setText(new Integer(slide2.getSelection()).toString());
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
