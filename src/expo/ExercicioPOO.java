package expo;

import expoo.dao.DaoComida;
import expoo.entidades.Comida;

public class ExercicioPOO {

	public static void main(String[] args) {
		DaoComida dc = new DaoComida();
		
//		Comida c1 = new Comida("Francesa", "Ratatoille", 40.0);
//		DaoComida dc = new DaoComida();
//		if(dc.salvar(c1)) {
//		System.out.println("Comida cadastrado");
//		}
		
		
		Comida comida = dc.consultar(1);
		comida.setCulinaria("Brasileira");
		comida.setNome("Feijoada");
		comida.setPreco(40.0);
		if(dc.alterar(comida)) {
			System.out.println("Comida alterada");
			System.out.println(comida);
		}
		
		comida = dc.consultar(1);
		System.out.println(comida);
		System.out.println("Fim!");
		
	}

}
