
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
		if(l<2)
			return true;

		int first = (int) (nbr % 10);
		int last = (int) (nbr / (Math.pow(10, (l - 1))));
		if (first != last)
			return false;

		nbr = (long) (nbr % Math.pow(10, (l - 1)));
		nbr = nbr / 10;
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
		int sommeG=0,sommeD=0;
		while(l>1) {
			sommeD+=(int) (nbr % 10);
			sommeG+=(int) (nbr / (Math.pow(10, (l - 1))));
			
			nbr = (long) (nbr % Math.pow(10, (l - 1)));
			nbr = nbr / 10;
			l=l-2;
		}
		return(sommeG==sommeD);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(equilibreIter(1103002));

	}

}
