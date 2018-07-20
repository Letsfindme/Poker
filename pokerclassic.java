import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;


public class pokerclassic {



	// crée array vide que peux contenire 52 valeur mais c'est vide

	static int[] cartes = new int[52]; // 52 valeur 


	public static String[] color = {"Hearts", "Diamonds", "Spades", "Clubs"};

	public static String[] nomber = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

	public static List<String> carti = new ArrayList<>();   // contains 52 cards with index 0 > 51
	public static List<String> cardontable = new ArrayList<>();
	public static List<String> player1 = new ArrayList<>();
	public static List<String> player2 = new ArrayList<>();
	
	//the hmap is onlly for the value of the cards
	//[Ace of Hearts, 2 of Hearts, 3 of Hearts, 4 of Hearts, 5 of Hearts, 6 of Hearts]
	static HashMap<String, Integer> hmap = new HashMap<String, Integer>();



	// mettre des valeur dans cartes
	public static void cartesvaleur() {

		for (int i = 0; i < cartes.length; i++){

			cartes[i] += i;
		}
	}

	// melanger cartes[]
	public static void melanger() {



		for (int i = 0; i < cartes.length; i++){
			int randx = (int)(Math.random() * cartes.length);
			int x = cartes[i]; // le but c'est changer les valeur entre carte[i] et carte[randx]
			cartes[i] = cartes[randx];
			cartes[randx] = x;
			//System.out.print(+ cartes[i]+"/");
		}
	}

	// fill carti and hmap with cards
	public static void  fillcarti() {


		for (int col = 0; col < 4 ; col++) {
			for(int nom = 0; nom < 13; nom++) {
				//String rank="";	
				//String suit = "";
				/*suit +=color[col];  // the color of the card
					suit +=nomber[nom];*/  // the nomber of the card
				hmap.put(nomber[nom] + " of " + color[col], nom);
				carti.add(nomber[nom] + " of " + color[col]);
				//System.out.println("index "+nom+"is: "+nomber[nom] + " of " + color[col]);
			}
		}

		//System.out.println("the is " + carti.size() +" card in the deck" );
		


		/*for(int o=0; o<52; o++) {
			System.out.print(" "+carti.get(o)+",");
		}
		//String var= hmap.get("King of Clubs");
		System.out.println("\n"+hmap.get(carti.get(0)));*/
	}

	// distribuée les cartes[]
	public static String distribuée(int nombrdecarte) {

		String suit="";
		//String rank="";
		for (int i = 0; i < nombrdecarte ; i++){			
			suit += " "+color[cartes[i] / 13]+" of ";  //52/13=4 the color of the card
			suit +=nomber[cartes[i] % 13]+",";  //51%13=12 the nomber of the card
		}
		return(suit);
	}

	//check if a card is in the index
	public static void check() {
		String search  = "Diamonds";

		if (carti.get(0).contains(search)) {

			System.out.println("I found the keyword");

		} else {

			System.out.println("not found");

		}

	}

	//put cards on the table
	public static void filltable() {

		for(int i=0; i<4; i++) {
			int randx = (int)(Math.random() * carti.size());
			cardontable.add(carti.get(randx));
			player1.add(carti.get(randx));
			player2.add(carti.get(randx));
			//System.out.println("\n !!!"+carti.get(randx)+",");
			//System.out.println("*** "+cardontable.get(i)+",");
			carti.remove(carti.get(randx));
		}
	}

	//put cards on the player1
	public static void fillplayer1() {

		for(int i=0; i<2; i++) {
			int randx = (int)(Math.random() * carti.size());
			player1.add(carti.get(randx));
			carti.remove(carti.get(randx));
		}
	}

	//put cards on the player2
	public static void fillplayer2() {

		for(int i=0; i<2; i++) {
			int randx = (int)(Math.random() * carti.size());
			player2.add(carti.get(randx));
			carti.remove(carti.get(randx));
		}
		
		
		for(int i=0; i < player1.size(); i++) {
			System.out.println("player1 : "+player1.get(i)+",");
		}
	}



	public static void main(String[] args) {
		//cartesvaleur();
		//melanger();
		//distribuée();
		fillcarti();
		filltable();
		fillplayer1();
		fillplayer2();
		//String n = distribuée(4);
		//System.out.println(n);
	}

}




