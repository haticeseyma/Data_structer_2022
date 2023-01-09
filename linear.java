class LinearSearch {  
public static int search(int arr[], int x) { 
    int n = arr.length; 
    for(int i = 0; i < n; i++) { 
        if(arr[i] == x) 
            return i; 
    } 
    return -1; 
} 
  
public static void main(String args[]) { 
    int arr[] = { 1, 3, 5, 7, 9 };  
    int x = 9;
      
    int result = LinearSearch.search(arr, x); 
    if(result == -1) 
        System.out.print("Eleman bulunamadı"); 
    else
        System.out.print(" Elemanın indexi  " + result  ); 
    } 
}