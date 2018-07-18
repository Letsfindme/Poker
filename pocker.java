import java.util.Random;


public class pocker {


	// crée array vide que peux contenire 52 valeur mais c'est vi

	static int[] cartes = new int[52]; // how many total

	public static String[] type = {"Hearts", "Diamonds", "Spades", "Clubs"};

	public static String[] nomber = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

	public static void cartevaleur() {

		// mettre des valeur dans cartes

		for (int i = 0; i < cartes.length; i++){

			cartes[i] += i;
		}
	}

	public static void melanger() {

		// melanger cartes[]

		for (int i = 0; i < cartes.length; i++){
			int randx = (int)(Math.random() * cartes.length);
			int x = cartes[i]; // le but c'est changer les valeur entre carte[i] et carte[randx]
			cartes[i] = cartes[randx];
			cartes[randx] = x;
			//System.out.print(+ cartes[i]+"/");
		}
	}

	public static String distribuée() {

		// distribuée les cartes
		String suit="";
		String rank="";
		for (int i = 0; i < 4; i++){			
			suit += type[cartes[i] / 13];  //52/13=4
			rank += nomber[cartes[i] % 13];  //51%13=12
			//System.out.println("Tu as "+ rank  + " de " + suit);
			//System.out.println(suit);
		}
	
		return(suit);
		
	}

	public static void main(String[] args) {
		cartevaleur();
		melanger();
		String n = distribuée();
		System.out.println(n);
	}

}