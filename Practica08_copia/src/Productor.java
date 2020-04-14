import java.util.Random;
class Productor implements Runnable{
	BufferLimitado b = null;
	int num_productos=0, t_produccion=0, producidos=0;
	public Productor( BufferLimitado initb, int n, int t ) {

		b = initb;
		num_productos=n; t_produccion=t;
		new Thread( this ).start();

	}
	public void run() {
		double item;
		Random r = new Random();
		while( (producidos < num_productos) ) {

			item = r.nextDouble();
			
			System.out.println( "Artículo producido " + item );
			b.deposit( item );
			b.cambiarBarra();
			producidos++;

			Util.mySleep(t_produccion);

		}

	}
}
