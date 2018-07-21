package com.xavier.swt.ch17.pringdialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.*;

public class PrintDialogExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public PrintDialogExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Print Dialog Example");
        s.setLayout(new FillLayout(SWT.VERTICAL));

        final Text t = new Text(s, SWT.BORDER|SWT.MULTI);
        t.setText("Test Printer Cabability");
        final Button b = new Button(s, SWT.BORDER|SWT.PUSH);
        b.setText("Print");
        b.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                PrintDialog pd = new PrintDialog(s, SWT.NONE);
                pd.setText("Print");
                PrinterData pdd = pd.open();
                if(pdd == null)
                    return;

                //Printer Function!!!
                Printer p = new Printer(pdd);
                p.startJob("PrintJob");
                p.startPage();
                Rectangle trim = p.computeTrim(0, 0,0,0);
                Point dpi = p.getDPI();
                int leftMargin = dpi.x + trim.x;
                int topMargin = dpi.y/2 + trim.y;
                GC gc = new GC(p);
                Font font = gc.getFont();
                String printText = t.getText();
                Point extent = gc.stringExtent(printText);
                gc.drawString(printText, leftMargin, topMargin+font.getFontData()[0].getHeight());
                p.endPage();
                gc.dispose();
                p.endJob();
                p.dispose();
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
