package lab6;

import cse131.NotYetImplementedException;
import lab5.BinarySearch;
import lab5.Strings;
import studio5x.MergeCombiner;

public class MergeSort {
	/**
	 * @param a
	 *            a sorted array
	 * @param b
	 *            another sorted array
	 * @return a new array which contains the contents of both a and b, sorted.
	 */
	private static String[] mergeCombine(String[] a, String[] b) {
		final boolean IS_USE_OF_STUDIO_DESIRED = false;
		if (IS_USE_OF_STUDIO_DESIRED) {
			return MergeCombiner.createMergeCombinedArray(a, b);
		} else {
			String[] result = new String[a.length + b.length];

			int aReadIndex = 0;
			int bReadIndex = 0;

			int writeIndex = 0;


			while (aReadIndex < a.length && bReadIndex < b.length) {
				if (Strings.isLessThan(a[aReadIndex], b[bReadIndex])) {
					result[writeIndex] = a[aReadIndex];
					aReadIndex++;
				} else {
					result[writeIndex] = b[bReadIndex];
					bReadIndex++;
				}
				writeIndex++;
			}

			// copy over the remaining items from a, if it was not the one that completed.
			while (aReadIndex < a.length) {
				result[writeIndex] = a[aReadIndex];
				aReadIndex++;
				writeIndex++;
			}
			// copy over the remaining items from b, if it was not the one that completed.
			while (bReadIndex < b.length) {
				result[writeIndex] = b[bReadIndex];
				bReadIndex++;
				writeIndex++;
			}

			return result;
		}
	}



	/**
	 * @param array
	 *            an array
	 * @param min
	 *            the minimum index of the range (inclusive)
	 * @param maxExclusive
	 *            the maximum index of the range (exclusive)
	 * @return a sorted array of the subrange of contents in the specified array
	 *         from [min, maxExclusive).
	 */
	
	public static String[] createSortedArrayInRange(String[] array, int min, int maxExclusive) {


		String[] newArray= new String[(maxExclusive-min)];
		String[] mcombine = new String[maxExclusive-min];
			

		if (maxExclusive-min ==1) {
			String[] minval = {array[min]};
			return minval;
		}
		else if (min<maxExclusive && min >=0 && maxExclusive<=array.length){
			String[] half1 = createSortedArrayInRange(array, min, (min + maxExclusive)/2);
			String[] half2 = createSortedArrayInRange(array, ((min+maxExclusive)/2), maxExclusive); 
			mcombine = mergeCombine(half1, half2);
			return  mcombine; 
		}
		
		else {

			return newArray;
		}


	}


	/**
	 * @param array
	 *            an array
	 * @return a sorted copy of the array
	 */
	public static String[] createSortedArray(String[] array) {
		if (array.length > 0) {
			return createSortedArrayInRange(array, 0, array.length);
		} else {
			return new String[0];
		}
	}
}
