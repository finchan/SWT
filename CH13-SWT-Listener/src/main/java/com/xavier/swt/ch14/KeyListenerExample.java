package com.xavier.swt.ch14;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class KeyListenerExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public KeyListenerExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Listener Example");
        s.setLayout(new RowLayout());

        final Combo c = new Combo(s, SWT.BORDER | SWT.DROP_DOWN);
        c.add("狮子");
        c.add("Tigers");
        c.add("Bears");
        c.add("Oh My!");

        c.addKeyListener(new KeyListener() {
            String selectedItem = "";
            public void keyPressed(KeyEvent keyEvent) {
                if(c.getText().length() >0){
                    return;
                }
                String key = Character.toString(keyEvent.character);
                String [] items = c.getItems();
                int i = 0;
                for(String item : items) {
                    if(item.toLowerCase().startsWith(key.toLowerCase())){
                        c.select(i);
                        selectedItem = item;
                        return;
                    }
                    i++;
                }
            }

            public void keyReleased(KeyEvent keyEvent) {
                if(selectedItem.length() > 0) {
                    c.setText(selectedItem);
                }
                selectedItem = "";
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
