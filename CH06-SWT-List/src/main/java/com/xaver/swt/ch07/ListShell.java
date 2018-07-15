package com.xaver.swt.ch07;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018-07-15.
 */
public class ListShell {
    Display d = new Display();
    Shell s = new Shell(d);
    public ListShell(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A List Example");
        /*******************
         *  List Shell Begin
         *******************/
        final List l = new List(s, SWT.SINGLE | SWT.BORDER|SWT.V_SCROLL|SWT.H_SCROLL);
        l.setBounds(5,5, 75, 95);
        l.add("Item One");
        l.add("Item Two");
        l.add("Item Three");
        l.add("Item Four");
        l.add("Item Five");
        l.add("Item Three and a half", 3);
        l.setItem(3, "New Item");
//        l.remove(3);
//        l.remove(1,3);
//        int n [] = {1,3,5};
//        l.remove(n);

        //remove (1,3) mean remove index(123), remove({1,3,5}) means
        //remove(1), remove(3), remove(5)
//        l.remove("Item Three and a half");
//        l.removeAll();

        String items[] = {"Item One", "Item Two", "Item Three", "Item Four"};
        final List l2 = new List(s, SWT.MULTI | SWT.BORDER);
        l2.setBounds(5, 105, 75, 75);
        l2.setItems(items);
        l2.select(l.indexOf("Item Four"));
        l2.setSelection(0);
        int n1[] = {1,3};
        l2.setSelection(n1);
//        l2.select(0,2);

        final List l3 = new List(s, SWT.MULTI | SWT.BORDER);
        l3.setBounds(5,190, 100, 95);
        l3.add("Item One");
        l3.add("Item Two");
        l3.add("Item Three");
        l3.add("Item Four");
        l3.add("Item Five");
        l3.add("Item Three and a half", 3);
        int i = l3.indexOf("Item One");
        int x = l3.indexOf("Item Two");
        int y = l3.indexOf("Item Three");
//        l3.select(y);
//        l3.select(x);
//        l3.remove(i);
        l3.remove(i);
        l3.select(y);
        l3.select(x);

        l.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                String [] selected = l.getSelection();
                System.out.println(selected[0]);
            }
        });

        l3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                String [] selected = l3.getSelection();
                for(String str : selected) {
                    System.out.println(str);
                }
            }
        });

        /*******************
         *  List Shell End
         *******************/
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
