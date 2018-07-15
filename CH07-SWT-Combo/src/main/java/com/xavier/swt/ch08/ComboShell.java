package com.xavier.swt.ch08;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class ComboShell {
    Display d = new Display();
    Shell s = new Shell(d);
    public ComboShell(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Combo Example");
        /*****************************************************
         * Combo Box
         *****************************************************/
        final Combo c = new Combo(s, SWT.READ_ONLY);
        c.setBounds(50,50, 150,65);
        String [] items = {"Item One", "Item Two", "Item Three", "Item Four","Item Five","Item Six"};
        c.setItems(items);
        c.select(1);
        final Text t = new Text(s, SWT.SINGLE|SWT.BORDER);
        t.setBounds(50, 80, 150, 30);

        final Combo c2 = new Combo(s, SWT.READ_ONLY);
        c2.setBounds(250, 50, 150, 65);
        c2.setEnabled(false);

        final Combo c3 = new Combo(s, SWT.DROP_DOWN);
        c3.setItems(new String[] {"Item One", "Item Two", "Item Three"});
        c3.setBounds(250, 80, 150, 65);
        c3.setText("Item One");
        c3.select(0);
        c3.setTextLimit(20);
        System.out.println(c3.getSelectionIndex());
        c3.deselectAll();
        c3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.keyCode == 13) {
                    c3.add(c3.getText(),0);
                    c3.select(0);
                }
            }
        });

        final Combo c4 = new Combo(s, SWT.SIMPLE);
        c4.setBounds(50, 120, 150, 80);
        c4.setItems(new String[] {"Item One", "Item Two", "Item Three", "Item Four"});


        String item = c.getText();
        System.out.println(item);
        int selectedItemIndex = c.getSelectionIndex();
        System.out.println(selectedItemIndex);
        //setText("Text")==select() // Only work on - SWT.READ_ONLY combo box
        c.setText("Item Five");
        //remove method just like list method - removeAll, remove(index), remove(indexRange), remove(IndexArray), remove(Text)
        c.remove(0,2);

        c.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if(c.getText().equals("Item Four")){
                    String [] items = {"ItemFourA", "ItemFourB"};
                    c2.setItems(items);
                    c2.setEnabled(true);
                    c2.select(0);
                } else if(c.getText().equals("Item Five")) {
                    String[] items = {"ItemFiveA", "ItemFiveB"};
                    c2.setItems(items);
                    c2.select(0);
                    c2.setEnabled(true);
                } else {
                    c2.removeAll();
                    c2.add("Not Applicable");
                    c2.setText("Not Applicable");
                    c2.setEnabled(false);
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
