package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class OrAlgorithem {
	static int player1Sum=0;
	static int player2Sum=0;
	static int diffrence=0;
	static int a=0;
	static int b=0;

	//find the max element in the list of numbers
	static int findMax(int arr[]) {
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {max=arr[i];}
		}
		return max;
	}

	//
	static void remove(int arr[],int num) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==num) {
				arr[i]=0;	break;
			}
		}
	}

	
	
	static int swapCurrentAndSum(int arr1[],int arr2[],int i,int j){
		int arr1Sum=0;
		int arr2Sum=0;
		int totalSum=0;
		//swap the elements and calculate
		int temp=arr1[i];
		arr1[i]=arr2[j];
		arr2[j]=temp;
	//done to swap , now calculating each temporary sum
		for(int t=0;t<arr1.length;t++) {
			arr1Sum=arr1Sum+arr1[t];
					arr2Sum=arr2Sum+arr2[t];
		}
		totalSum=Math.abs(arr1Sum-arr2Sum); // sum after the swap
		//swap agian
		 temp=arr1[i];
		arr1[i]=arr2[j];
		arr2[j]=temp;
		//return the temp sum after the swap
		return totalSum;
		 } 

	static int maximumSize(int arr1[],int arr2[]) {
		int size=arr1.length;
		if(arr2.length>size) {size=arr2.length;}
		return size;
	}
	
		 static void fix(int arr1[],int arr2[]) {
			 
			for(int t=0;t<arr1.length;t++) {
				//a is the size of element inserted to player1 sum
			 for(int i=0;i<arr1.length;i++) {
				 //b is the size of elements that inserted to player2 sum
				 for(int j=0;j<arr2.length;j++) {
					 //check if swap elements help to the diffrence between the sum of the players to get low diffrence
					 if(swapCurrentAndSum(arr1,arr2,i,j)<diffrence) {
						 player1Sum=(player1Sum-arr1[i]+arr2[j]);
						 player2Sum=(player2Sum-arr2[j]+arr1[i]);
							int temp=arr1[i];
							arr1[i]=arr2[j];
							arr2[j]=temp;
							//update the better diffrence
							diffrence=Math.abs(player1Sum-player2Sum);
							System.out.println("the current diffrence that found is: "+diffrence);
					 }
				 }
			 }
		  }
		 }
		 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of array: ");
		int size=sc.nextInt();
		int list[]=new int[size];
		int player1[]=new int[size];
		int player2[]=new int[size];


		//init the list with numbers
		for(int i=0;i<list.length;i++) {
			System.out.println("choose a number: ");
			list[i]=sc.nextInt(); 
		}
		//print the list of numbers

		System.out.println(Arrays.toString(list));

		//initialize the players array
		for(int i=0;i<list.length;i++) {

			//check if the sum of player1 -player2 sum is bigger than the diffrence
			if((player1Sum-player2Sum)<=findMax(list)) {
				player1Sum=player1Sum+findMax(list);
				diffrence=Math.abs(player1Sum-player2Sum);
				System.out.println("the currend diffrence that found is: "+diffrence);
				player1[i]=findMax(list);
				remove(list,findMax(list));
			}
			else { 
				player2Sum=player2Sum+findMax(list);
				diffrence=Math.abs(player1Sum-player2Sum);
				System.out.println("the currend diffrence that found is: "+diffrence);
				player2[i]=findMax(list);
				remove(list,findMax(list));
			}
		}//end init
		
		System.out.println("player1 numbers"+Arrays.toString(player1));
		System.out.println("player2 numbers"+Arrays.toString(player2));
		fix(player1,player2);
		System.out.println("player1 numbers after distributing"+Arrays.toString(player1));
		System.out.println("player2 numbers after distributing"+Arrays.toString(player2));
	}

}
