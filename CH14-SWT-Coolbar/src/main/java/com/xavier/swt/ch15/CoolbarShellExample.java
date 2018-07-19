package com.xavier.swt.ch15;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

public class CoolbarShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public CoolbarShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Coolbar Shell Example");

        final CoolBar bar = new CoolBar(s, SWT.BORDER);
        bar.setSize(475, 30);
        bar.setLocation(0,0);
        bar.setLocked(true);


        final Image saveIcon = new Image(d, this.getClass().getResourceAsStream(("/images/save.png")));
        final Image openIcon = new Image(d, this.getClass().getResourceAsStream(("/images/open.png")));
        final Image cutIcon = new Image(d, this.getClass().getResourceAsStream(("/images/cut.png")));
        final Image copyIcon = new Image(d, this.getClass().getResourceAsStream(("/images/copy.png")));
        final Image pasteIcon = new Image(d, this.getClass().getResourceAsStream(("/images/paste.png")));

        final CoolItem openCoolItem =new CoolItem(bar, SWT.PUSH);
        final Button openBtn = new Button(bar, SWT.PUSH);
        openBtn.setImage(openIcon);
        openBtn.pack();
        Point size = openBtn.getSize();
        openCoolItem.setControl(openBtn);
        openCoolItem.setSize(openCoolItem.computeSize(size.x, size.y));

        final CoolItem saveCoolItem = new CoolItem(bar, SWT.PUSH);
        final Button saveBtn = new Button(bar, SWT.PUSH);
        saveBtn.setImage(saveIcon);
        saveBtn.pack();;
        size = saveBtn.getSize();
        saveCoolItem.setControl(saveBtn);
        saveCoolItem.setSize(saveCoolItem.computeSize(size.x, size.y));

        final CoolItem cutCoolItem = new CoolItem(bar, SWT.PUSH);
        final Button cutBtn = new Button(bar, SWT.PUSH);
        cutBtn.setImage(cutIcon);
        cutBtn.pack();;
        cutCoolItem.setControl(cutBtn);
        cutCoolItem.setSize(cutCoolItem.computeSize(size.x, size.y));

        final CoolItem copyCoolItem = new CoolItem(bar, SWT.PUSH);
        final Button copyBtn = new Button(bar, SWT.PUSH);
        copyBtn.setImage(copyIcon);
        copyBtn.pack();;
        copyCoolItem.setControl(copyBtn);
        copyCoolItem.setSize(copyCoolItem.computeSize(size.x, size.y));

        final CoolItem pasteCoolItem = new CoolItem(bar, SWT.PUSH);
        final Button pasteBtn = new Button(bar, SWT.PUSH);
        pasteBtn.setImage(pasteIcon);
        pasteBtn.pack();;
        pasteCoolItem.setControl(pasteBtn);
        pasteCoolItem.setSize(pasteCoolItem.computeSize(size.x, size.y));

        final CoolItem fontCoolItem = new CoolItem(bar, SWT.PUSH);
        final Combo fontCombo = new Combo(bar, SWT.READ_ONLY | SWT.BORDER);
        String[] items = new String[] {"Arial", "Courier", "Times New Roman"};
        fontCombo.setItems(items);
        fontCombo.select(0);
        fontCombo.pack();
        size = fontCombo.getSize();
        fontCoolItem.setControl(fontCombo);
        fontCoolItem.setSize(fontCoolItem.computeSize(size.x, size.y));
        fontCoolItem.setMinimumSize(size);

        openBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Open");
            }
        });

        copyBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Copy");
            }
        });

        cutBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Cut");
            }
        });

        pasteBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Paste");
            }
        });

        saveBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Save");
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
