public class ClasePrueba{
	
	public ClasePrueba(String suma){
		super(suma);
	}
	public ClasePrueba(String resta){
		super(resta);
	}

	public static void main(String[] args) {
		ClaseInservible su = new ClaseInservible();
		ClaseInservible re = new ClaseInservible();
		System.out.println(su.Suma());

	}
}