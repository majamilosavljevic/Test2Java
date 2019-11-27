package test2;

import java.util.Scanner;

public class Zadatak1 {

	public static int studentData(int a) {

		int b = 0;
		int correct = 0;
		int incorrect = 0;
		int result = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Unesite ime i prezime studenta:");
		String studentName = scan.nextLine();

		for (; b < a; b++) {
			System.out.println("Unesite da li je student tacno ili netacno odgovorio na " + (b + 1) + ". pitanje.");
			String answer = scan.next();

			if (answer.equals("tacno"))
				correct++;

			if (answer.equals("netacno"))
				incorrect++;

			if (!answer.equals("tacno") && !answer.equals("netacno")) {
				System.out.println("Molimo unesite 'tacno' ili 'netacno'");
				answer = scan.next();
			}
		}

		result = a - incorrect;
		result = (result * 100) / a;

		return result;
	}

	public static String testResult(int result) {

		String res = "Polozio sa " + result + "% tacnih odgovora";
		int toPass = 50 - result;

		if (result < 50)
			res = "Pao sa " + result + "% tacnih odgovora, potrebno jos " + toPass + "% za prolaz.";

		return res;

	}

	public static void main(String[] args) {
		/*
		 * Napisati program koji od korisnika trazi da unese koliko na testu ima
		 * pitanja.
		 */
		/*
		 * Zatim, koristeci metodu, ucitava ime i prezime studenta, kao i da li je za
		 * svako pitanje odgovor koji je student dao tacan ili netacan.
		 */
		/*
		 * Napraviti( i na odgovarajucem mestu pozvati) metodu kojoj je povratna
		 * vrednost String i ispisati poruku koja daje informaciju o tome da li je
		 * student pao ili polozio ispit, kao i koliko ima tacnih odgovora. (Polozio je
		 * ako ima vise od 50%)
		 */
		/*
		 * Ukoliko student nije polozio, napisati koliko poena mu fali da bi ocena bila
		 * prelazna. Moguce je iskoristiti metodu iz prethodne tacke i dopuniti je.
		 */
		/*
		 * Omoguciti korisniku (profesoru) da unosi informacije o studentima sve dok ne
		 * unese rec ‘stop’. (Broj pitanja na testu unosi samo jednom, na pocetku
		 * izvrsavanja programa)
		 */

		Scanner scan = new Scanner(System.in);

		int n = 0;
		while (n <= 0) {
			System.out.println("Unesite koliko pitanja ima na testu:");
			n = scan.nextInt();
		}
		String exit = "go";

		while (!exit.contentEquals("stop")) {
			int result = studentData(n);
			System.out.println(testResult(result));
			System.out.println(
					"Ukoliko ste zavrsili sa unosom podataka, ukucajte rec 'stop', u suprotnom ukucajte rec 'dalje'");
			exit = scan.next();
		}
	}
}
