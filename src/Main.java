import java.util.Arrays;

public class Main {

  private static void mergeSort(int [] arr, int start, int end) {
    if(start >= end)
      return;

    int mid = (start + end) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);

    merge(arr, start, end);
  }

  private static void merge(int[] arr, int start, int end) {
    int [] merged = new int[end - start + 1];
    int mid = (start + end) / 2;

    int i = start, j = mid + 1, k = 0;

    while(i <= mid && j <= end) {
      if(arr[i] < arr[j]) {
        merged[k++] = arr[i++];
      } else {
        merged[k++] = arr[j++];
      }
    }

    while(i <= mid) {
      merged[k++] = arr[i++];
    }

    while(j <= end) {
      merged[k++] = arr[j++];
    }

    for(int l = 0; l < merged.length; l++) {
      arr[start + l] = merged[l];
    }
  }

  private static void quickSort(int [] arr, int low, int high) {
    if(low >= high)
      return;

    int s = low;
    int e = high;
    int mid = s + (e - s) / 2;
    int pivot = arr[mid];

    while(s <= e) {
      while(arr[s] < pivot) {
        s++;
      }

      while(arr[e] > pivot) {
        e--;
      }

      if(s <= e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        s++;
        e--;
      }
    }

    quickSort(arr, low, e);
    quickSort(arr, s, high);
  }

  public static void main(String[] args) {
    int [] arr = {1, 2, 3, 5, 4};
//    mergeSort(arr, 0, arr.length - 1);
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
