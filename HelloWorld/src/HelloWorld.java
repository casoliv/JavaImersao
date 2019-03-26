
public class HelloWorld {
	
	public static void main (String[] args) {
		if (args == null || args.length == 0) {
			System.out.println (" Você não informou nenhum argumento");
		}
		else { 	
			System.out.println("Hello World");
			for (int i=0; i<args.length; i++) {
				System.out.print(args[i] +" ");
			}
		}
	}
	
	public static void main4 (String args[]) {
		 Usuario usuario = new Usuario();
		 usuario.setLogin("casoliv");
		 usuario.setSenha("a1b2c3");
		 usuario.setNome("Cassia");
		 usuario.setSobrenome("Oliveira");
		 usuario.setCpf("12345678901");
		
		 System.out.println(usuario.getLogin() + " - " + 
		                  usuario.getSenha() + " - " +
				          usuario.getNome()  + " " +
		                  usuario.getSobrenome() + " - " +
		                  usuario.getCpf());
		 
		 Funcionario funcionario = new Funcionario();
		 Cliente     cliente     = new Cliente();
		 
		 cliente.setEndereco("Av Grecia 1050");
		 funcionario.setMatricula(59295);
		 
		 System.out.println(usuario.getNome() + "-" + cliente.getEndereco() +"-" + funcionario.getMatricula());;
	}
	   
	
	public static void main2 (String args[]) {
		Veiculo corsa = new Veiculo();
		corsa.setPlaca("ISM1234");
		corsa.setMarca("Chevrolet");
		corsa.setModelo("Corsa Sedan");
		corsa.setCor("Prata");
		corsa.setAno(2018);
		
		 Moto cg= new Moto();
		 cg.setPlaca("ASD1234");
		 cg.setCor("Prata");
		 cg.setCilindradas(125);
		 
	     System.out.print(cg.getPlaca() + " - " + cg.getCilindradas());
//	  	 System.out.print(corsa.getMarca() + " - " + corsa.getModelo());
		
	}
	
	
	public static void main3 (String args[]) {
		System.out.print("Hello Java World!");
	}

}
