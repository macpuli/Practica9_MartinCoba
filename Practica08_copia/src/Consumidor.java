class Consumidor implements Runnable {
	BufferLimitado b = null;
	int num_consumos=0, t_consumo=0, consumidos=0;
	public Consumidor( BufferLimitado initb ,  int n, int t) {

		b = initb;
		num_consumos=n; t_consumo=t;
		new Thread( this ).start();

	}
	public void run() {
		double item;
		while( (consumidos<num_consumos)) {

			item = b.fetch();
			b.cambiarBarra();
			System.out.println( "Artículo extraído " + item );
			System.out.println(b.count + " en el buffer");
			consumidos++;
			Util.mySleep(t_consumo);

		}

	}
}
