public class quick{

	 static void swap(int dizi[],int i,int j)
	 {
    
		 int temp = dizi[i];
		 dizi[i] = dizi[j];
		 dizi[j] = temp;
	 }


	 static int parcalama(int dizi [], int low, int high)
	 {
	

		 int pivot = dizi[high];
	

		 int i = (low - 1);

	 	 for(int j = low; j <= high - 1; j++)
	 	 {
		

			 if (dizi[j] < pivot)
		 	{
			

			 i++;
			 swap(dizi, i, j);
		 	 }
 	 	 }
 		 swap(dizi, i + 1, high);
		 return (i + 1);
}


	static void quickSort(int dizi[], int low, int high)
	{
		if (low < high)
		{

			 int pi = parcalama(dizi, low, high);

			 quickSort(dizi, low, pi - 1);
			 quickSort(dizi, pi + 1, high);
		}
	}

	static void print(int dizi[], int size)
	{
		 for(int i = 0; i < size; i++)
		 System.out.print(dizi[i] + " ");
		
		 System.out.println();
	}

	 public static void main(String[] args)
 	 {
		 int dizi[] = { 10, 7, 8, 9, 1, 5 };
		 int n = dizi.length;
	
		 quickSort(dizi, 0, n - 1);
		 System.out.println("sıralanmış dizi: ");
		 print(dizi, n);
	 }
}


