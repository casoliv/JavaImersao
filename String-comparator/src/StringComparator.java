
public class StringComparator {
	
	public static void main (String args[]) {
		if (args.length != 2) {
			System.out.println("Quantidade de argumentos diferente de 2!");
		} else {
			System.out.println(" = =  " + args[0] == args[1]);	
			System.out.println("EQUALS " + args[0].equals(args[1]));		
		}
	
	}

}
