import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.wb.swt.SWTResourceManager;

public class BufferLimitado {
	final int size = 10; int consumo, produccion;
	double buffer[] = new double[size];
	int inBuf = 0, outBuf = 0, count=0;
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador isEmpty = new SemaforoContador(0);
	SemaforoContador isFull = new SemaforoContador( size );

	Shell shlProblemaProductorconsumidor = new Shell();
	
	
	ProgressBar progressBar = new ProgressBar(shlProblemaProductorconsumidor, SWT.NONE);
	Label lblN = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	
	Label rojo1 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	Label verde1 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	Label rojo2 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	Label verde2 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	Label rojo3 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	Label verde3 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	Label separador = new Label(shlProblemaProductorconsumidor, SWT.NONE);
	
	Image rojo = new Image(Display.getCurrent(), "30red.png");
	ImageData dataRojo = rojo.getImageData();
	Image noRojo = new Image(Display.getCurrent(), "30noRed.png");
	ImageData dataNoRojo = noRojo.getImageData();
	Image verde = new Image(Display.getCurrent(), "30green.png");
	ImageData dataVerde = verde.getImageData();
	Image noVerde = new Image(Display.getCurrent(), "30noGreen.png");
	ImageData dataNoVerde = noVerde.getImageData();
	int producidos;

	/**
	 * Launch the application.
	 * @param args
	 
	
	public static void main(String[] args) {
		try {
			BufferLimitado window = new BufferLimitado();
			
			Productor productor = new Productor( window );
			Consumidor consumidor = new Consumidor( window );
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlProblemaProductorconsumidor.open();
		shlProblemaProductorconsumidor.layout();
		while (!shlProblemaProductorconsumidor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public void setCP(int c, int p){
		consumo=c; produccion=p;
	}
	public void cambiarBarra(){
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				progressBar.setSelection(count);
				lblN.setText(count + "");
			}
		});
	}
	public void deposit( double value )
	{
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				rojo1.setImage(rojo);
				verde1.setImage(noVerde);
			}
		});
		isFull.P(); // espera si el buffer está lleno
		
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				rojo3.setImage(rojo);
				verde3.setImage(noVerde);
				separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
				

			}
		});
		mutex.P(); // asegura la exclusión mutua
		buffer[inBuf] = value;
		inBuf = (inBuf + 1) % size;

		//cambiarBarra();
		count++;
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				rojo3.setImage(noRojo);
				verde3.setImage(verde);
				separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
			}
		});
		mutex.V();
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				rojo1.setImage(noRojo);
				verde1.setImage(verde);

			}
		});
		isEmpty.V(); // notifica a algún consumidor en espera

		System.out.println(count + " en el buffer");
		//Util.mySleep(produccion);  

	}
	public double fetch()
	{

		double value;
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				rojo2.setImage(rojo);
				verde2.setImage(noVerde);
			}
		});
		isEmpty.P(); // esperar si el buffer está vacío
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				rojo3.setImage(rojo);
				verde3.setImage(noVerde);
				separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
		});
		mutex.P(); // asegura la exclusión mutua
		value = buffer[outBuf]; // lee desde el buffer
		outBuf = (outBuf+1) % size;

		//cambiarBarra();
		
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				rojo3.setImage(noRojo);
				verde3.setImage(verde);
				separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));

			}
		});
		mutex.V();
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				rojo2.setImage(noRojo);
				verde2.setImage(verde);

			}
		});
		isFull.V(); // notifica a cualquier productor en espera
		//Util.mySleep(consumo);  
		count--;
		
		return value;

	}
	public void setProducidos(int p){
		producidos=p;
		System.out.println(producidos);
		progressBar.setSelection(producidos);
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlProblemaProductorconsumidor.setSize(400, 350);
		shlProblemaProductorconsumidor.setText("Problema productor-consumidor");
		
		progressBar.setBounds(43, 200, 250, 30);
		progressBar.setMaximum(10);
		
		
		rojo1.setBounds(59, 10, 30, 30);
		rojo1.setText("New Label");
		
		
		verde1.setBounds(59, 42, 30, 30);
		verde1.setText("New Label");
		
		rojo2.setBounds(299, 10, 30, 30);
		rojo2.setText("New Label");
		
		verde2.setBounds(299, 42, 30, 30);
		verde2.setText("New Label");
		
		rojo3.setBounds(299, 168, 30, 30);
		rojo3.setText("New Label");
		
		verde3.setBounds(299, 200, 30, 30);
		verde3.setText("New Label");
		
		separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		
		
		separador.setBounds(314, 77, 1, 85);
		rojo1.setImage(noRojo);
		rojo2.setImage(noRojo);
		rojo3.setImage(noRojo);
		verde1.setImage(noVerde);
		verde2.setImage(noVerde);
		verde3.setImage(noVerde);
		Button btnHazAlgo = new Button(shlProblemaProductorconsumidor, SWT.NONE);
		btnHazAlgo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlProblemaProductorconsumidor.close();
				
				
				
				
				//setProducidos(buffer.inBuf);
//				progressBar.setSelection(producidos);
//				if(buffer.mutex.value==false)
//					separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
//				else
//					separador.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
				
				
				
			}
		});
		btnHazAlgo.setBounds(43, 266, 75, 25);
		btnHazAlgo.setText("Salir");
		
		Label lblProcesoConsumidor = new Label(shlProblemaProductorconsumidor, SWT.WRAP);
		lblProcesoConsumidor.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblProcesoConsumidor.setBounds(43, 92, 84, 38);
		lblProcesoConsumidor.setText("Proceso consumidor");
		
		Label lblProcesoProductor = new Label(shlProblemaProductorconsumidor, SWT.WRAP);
		lblProcesoProductor.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblProcesoProductor.setText("Proceso productor");
		lblProcesoProductor.setBounds(185, 34, 75, 38);
		
		Label lblBufferDeElementos = new Label(shlProblemaProductorconsumidor, SWT.NONE);
		lblBufferDeElementos.setFont(SWTResourceManager.getFont("Arial", 11, SWT.NORMAL));
		lblBufferDeElementos.setBounds(43, 236, 147, 15);
		lblBufferDeElementos.setText("Buffer de elementos");
		
		Label separador_1 = new Label(shlProblemaProductorconsumidor, SWT.NONE);
		separador_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		separador_1.setBounds(74, 136, 1, 58);
		
		Label lblProducidos = new Label(shlProblemaProductorconsumidor, SWT.NONE);
		lblProducidos.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblProducidos.setBounds(230, 236, 66, 15);
		lblProducidos.setText("en el buffer");
		
		lblN.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblN.setBounds(206, 236, 18, 15);
		lblN.setText("n");

	}
}
