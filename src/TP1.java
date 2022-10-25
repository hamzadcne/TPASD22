
public class TP1 {

	public static boolean palindromeIter(long nbr) {
		int l = longeur(nbr);
		while (l >= 2) {
			int first = (int) (nbr % 10);
			int last = (int) (nbr / (Math.pow(10, (l - 1))));
			if (first != last)
				return false;

			nbr = (long) (nbr % Math.pow(10, (l - 1)));
			nbr = nbr / 10;

			l = l - 2;
		}
		return true;
	}

	public static boolean palindromeRec(long nbr) {
		int l = longeur(nbr);
		if (l < 2)
			return true;

		int first = (int) (nbr % 10);
		int last = (int) (nbr / (Math.pow(10, (l - 1))));
		if (first != last)
			return false;

		nbr = (long) (nbr % Math.pow(10, (l - 1)));
		nbr = nbr / 10;
		l = l - 2;
		while (l > 2 && (int) (nbr / (Math.pow(10, (l - 1)))) == 0) {
			if (nbr % 10 == 0) {
				l = l - 2;
				nbr = nbr / 10;
			} else
				return false;
		}
		return palindromeRec(nbr);
	}

	private static int longeur(long nbr) {
		int l = 0;
		while (nbr > 0) {
			l++;
			nbr = nbr / 10;
		}
		return l;
	}

	public static boolean equilibreIter(long nbr) {
		int l = longeur(nbr);
		int sommeG = 0, sommeD = 0;
		while (l > 1) {
			sommeD += (int) (nbr % 10);
			sommeG += (int) (nbr / (Math.pow(10, (l - 1))));

			nbr = (long) (nbr % Math.pow(10, (l - 1)));
			nbr = nbr / 10;
			l = l - 2;
		}
		return (sommeG == sommeD);
	}

	public static boolean equilibreRec(long nbr) {
		int l = longeur(nbr);
		if (l <= 1)
			return true;

		if (l == 2) {
			return nbr / 10 == nbr % 10;
		}

		int left, right, left1, right1;

		if (l % 2 == 0) {
			left = (int) (nbr / Math.pow(10, (l / 2)));
			right = (int) (nbr % Math.pow(10, (l / 2)));
		} else {
			left = (int) (nbr / Math.pow(10, (l / 2 + 1)));
			right = (int) (nbr % Math.pow(10, (l / 2)));
		}

		left1 = left % 10;
		left = left / 10;

		right1 = right % 10;
		right = right / 10;

		if (left1 != right1) {
			if (left1 > right1)
				left += left1 - right1;
			else
				right += right1 - left1;
		}
		return equilibreRec((long) (left * Math.pow(10, (l / 2 - 1))) + right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startPalindromeIter= System.nanoTime();
		boolean palIter = palindromeIter(1103011);
		long endPalindromeIter=System.nanoTime();
		long tempsPalindromeIter = endPalindromeIter - startPalindromeIter;
		System.out.println("Temps d'execution PalindromeIter (ms):"
				+tempsPalindromeIter);
		
		
		
		long startPalindromeRec= System.nanoTime();
		boolean palRec = palindromeRec(1103011);
		long endPalindromeRec=System.nanoTime();
		long tempsPalindromeRec = endPalindromeRec - startPalindromeRec;
		System.out.println("Temps d'execution PalindromeRec (ms):"
				+tempsPalindromeRec);
		
//		long startEquilibIter= System.nanoTime();
//		boolean equilibreIter = equilibreIter(1103011);
//		long endEquilibreIter=System.nanoTime();
//		long tempsEquilibreIter = endEquilibreIter - startEquilibIter;
//		System.out.println("Temps d'execution EquilibreIter (ms):"
//				+tempsEquilibreIter);

	}

}
