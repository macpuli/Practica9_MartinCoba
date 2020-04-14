import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWindow {

	protected Shell shlParmetrosAElegir;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlParmetrosAElegir.open();
		shlParmetrosAElegir.layout();
		while (!shlParmetrosAElegir.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlParmetrosAElegir = new Shell();
		shlParmetrosAElegir.setSize(450, 313);
		shlParmetrosAElegir.setText("Par\u00E1metros a elegir");
		shlParmetrosAElegir.setLayout(new GridLayout(9, false));
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Label lblNewLabel = new Label(shlParmetrosAElegir, SWT.NONE);
		lblNewLabel.setText("Art\u00EDculos a consumir");
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Spinner consumir = new Spinner(shlParmetrosAElegir, SWT.BORDER);
		consumir.setMaximum(10000000);
		consumir.setMinimum(1);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(shlParmetrosAElegir, SWT.NONE);
		lblNewLabel_2.setText("Art\u00EDculos a producir");
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Spinner producir = new Spinner(shlParmetrosAElegir, SWT.BORDER);
		producir.setMaximum(10000000);
		producir.setMinimum(1);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(shlParmetrosAElegir, SWT.NONE);
		lblNewLabel_1.setText("Tiempo producci\u00F3n");
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Spinner produccion = new Spinner(shlParmetrosAElegir, SWT.BORDER);
		produccion.setMaximum(10000000);
		produccion.setMinimum(1);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Label lblNewLabel_3 = new Label(shlParmetrosAElegir, SWT.NONE);
		lblNewLabel_3.setText("Tiempo consumo");
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Spinner consumo = new Spinner(shlParmetrosAElegir, SWT.BORDER);
		consumo.setMaximum(10000000);
		consumo.setMinimum(1);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		new Label(shlParmetrosAElegir, SWT.NONE);
		
		Button btnNewButton = new Button(shlParmetrosAElegir, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					BufferLimitado window = new BufferLimitado();
					window.setCP(consumo.getSelection(), produccion.getSelection());
					
					Productor productor = new Productor( window, producir.getSelection(), produccion.getSelection() );
					Consumidor consumidor = new Consumidor( window, consumir.getSelection(), consumo.getSelection() );
					window.open();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				shlParmetrosAElegir.close();
			}
		});
		btnNewButton.setText("Ejecutar");

	}

}
