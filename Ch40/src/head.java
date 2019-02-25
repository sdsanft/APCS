import java.util.Random;

public class head {

	public static void main(String[] args) {
		int size = 1000;
		int bounds = 1000;
		int original[] = new int[size];
		Random rand = new Random();
		
		for (int i = 0; i < size; i++) {
			original[i] = rand.nextInt(bounds);
		}
		
		int theArray[] = original;
		bubbleSort(theArray);
		for(int j = 0; j < theArray.length; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println(" ");
		
		theArray = original;
		selectionSort(theArray);
		for(int j = 0; j < theArray.length; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println(" ");
		
		theArray = original;
		insertionSort(theArray);
		for(int j = 0; j < theArray.length; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println(" ");
		
		theArray = original;
		quickSort(theArray, 0, theArray.length - 1);
		for(int j = 0; j < theArray.length; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println(" ");
	}

	public static void bubbleSort(int a[]) {
		boolean loopSomeMore;
		do {
			loopSomeMore = false;
			for(int j = 0; j < a.length -1; j++) {
				if(a[j] > a[j+1]) {
					//swap a[j] and a[j+1]
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					loopSomeMore = true;
				}
			}
		} while(loopSomeMore);
	}
	
	public static void selectionSort(int a[ ]) {
		int min, minIndex;
		for(int i = 0;i < a.length; ++i) {
			min = a[i];
			minIndex = i;
			for (int j = i + 1; j < a.length; ++j) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			a[minIndex] = a[i]; // swap
			a[i] = min;
		}
	}
	
	public static void insertionSort(int a[ ] ) { //This will do an ascending sort
		int itemToInsert, j;
		boolean keepGoing;
		
		for(int k = 1; k < a.length; k++) {
			//Go backwards through the list, looking for the slot to insert a[k]
			itemToInsert = a[k];
			j = k - 1;
			keepGoing = true;
			while((j >= 0) && keepGoing) {
				if (itemToInsert < a[j] ) {
					a[j + 1] = a[j]; //Salient feature
					j--;
					if(j == -1) //special case for inserting an item at [0]
						a[0] = itemToInsert;
				} else {
					keepGoing = false;
					a[j + 1] = itemToInsert;
				}
			}
		}
	}
	
	public static void quickSort(int a[ ], int left, int right)
	{
		if (left >= right) return;
		int k = left;
		int j = right;
		int pivotValue = a[ (left + right) / 2 ]; // salient feature
		while ( k < j ) {
			while (a[k] < pivotValue) {
				k++;
			}
		
			while ( pivotValue < a[j] ) {
				j--;
			}
			
			if (k <= j) {
				int temp = a[k]; //swap a[k] and a[j]
				a[k] = a[j];
				a[j] = temp;
				k++;
				j--;
			}
		}
		quickSort(a, left, j); //salient feature (recursion)
		quickSort(a, k, right);
	}

}