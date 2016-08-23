package sortMethodTest;

import java.util.Random;

import sort.BubbleSort;
import sort.BucketSort;
import sort.CountingSort;
import sort.HeapSort;
import sort.HeapSortTwo;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.RadixSort;
import sort.SelectSort;
import sort.ShellSort;
import sort.SortMethod;

public class SortMethodTest {
	int testNum = 10000;
	int length = 1000;
	int numRange = 1000;
	
	public SortMethodTest(int testNum, int length, int numRange){
		this.testNum = testNum;
		this.length = length;
		this.numRange = numRange;	
	}
	
	public boolean sortTest(SortMethod instance) {
		Random random = new Random();
		int testNum = this.testNum;
		int length = this.length;
		int numRange = this.numRange;
		
		int[][] matrix = new int[testNum][length];
		
		for (int i = 0; i < testNum; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = random.nextInt(numRange);
			}
		}
		//before
		//printMatrix(matrix);
		long time = System.currentTimeMillis();
		for (int i = 0; i < testNum; i++) {
			instance.sort(matrix[i]);
		}
		long diff = System.currentTimeMillis()-time;
		//after
		//printMatrix(matrix);
		for (int i = 0; i < testNum; i++) {
			for (int j = 0; j < length-1; j++) {
				if (matrix[i][j] > matrix[i][j + 1])
					return false;
			}
		}
		System.out.println(diff);
		return true;
	}
	
//	private void printMatrix(int[][] matrix){
//		for(int i = 0; i < matrix.length; i++){
//			for(int j = 0; j < matrix[0].length; j++){
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------------------------");
//	}

	public static void main(String[] args) {
		int testNum = 1000;
		int length = 1000;
		int numRange = 1000;
		SortMethodTest instance = new SortMethodTest(testNum, length, numRange);
		//
		System.out.println("QuickSort");
		System.out.println("Result Test: " + instance.sortTest(new QuickSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("MergeSort");
		System.out.println("Result Test: " + instance.sortTest(new MergeSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("InsertionSort");
		System.out.println("Result Test: " + instance.sortTest(new InsertionSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("ShellSort");
		System.out.println("Result Test: " + instance.sortTest(new ShellSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("BubbleSort");
		System.out.println("Result Test: " + instance.sortTest(new BubbleSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("SelectSort");
		System.out.println("Result Test: " + instance.sortTest(new SelectSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("HeapSort");
		System.out.println("Result Test: " + instance.sortTest(new HeapSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("HeapSort using java PriorityQueue");
		System.out.println("Result Test: " + instance.sortTest(new HeapSortTwo()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("RadixSort");
		System.out.println("Result Test: " + instance.sortTest(new RadixSort()));
		System.out.println("----------------------------------------------");
		//
		System.out.println("CountingSort");
		System.out.println("Result Test: " + instance.sortTest(new CountingSort(numRange)));
		System.out.println("----------------------------------------------");
		//
		System.out.println("BucketSort");
		System.out.println("Result Test: " + instance.sortTest(new BucketSort(numRange)));
		System.out.println("----------------------------------------------");
	}
}
