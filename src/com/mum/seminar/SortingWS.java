/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.seminar;


/**
 *
 * @author Manoj
 */
public class SortingWS {

	public int[] sort(int[] arr) {
		
		return mergeSort(arr);
	}

	private int[] mergeSort(int[] arr) {

		// Base case. A list of zero or one elements is sorted, by definition.
		if (arr.length <= 1) {

			return arr;
		}

		// Recursive case. First, divide the list into equal-sized sublists.
		int middleIndex = (arr.length + 1) / 2;

		int[] left = new int[middleIndex];
		int[] right = new int[arr.length - middleIndex];

		System.arraycopy(arr, 0, left, 0, middleIndex);

		for (int i = middleIndex, j = 0; i < arr.length; i++, j++) {
			right[j] = arr[i];
		}

		// Recursively sort both sublists
		left = mergeSort(left);
		right = mergeSort(right);

		// Then merge the now-sorted sublists.
		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right) {

		int[] mergedArray = new int[left.length + right.length];

		int leftPointer = 0;
		int rightPointer = 0;

		int mergePointer = 0;

		while (leftPointer < left.length && rightPointer < right.length) {

			if (left[leftPointer] < right[rightPointer]) {

				mergedArray[mergePointer++] = left[leftPointer++];

			} else {

				mergedArray[mergePointer++] = right[rightPointer++];
			}
		}

		while (leftPointer < left.length) {

			mergedArray[mergePointer++] = left[leftPointer++];
		}

		while (rightPointer < right.length) {

			mergedArray[mergePointer++] = right[rightPointer++];
		}

		return mergedArray;
	}
}
