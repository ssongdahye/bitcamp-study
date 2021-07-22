package com.eomcs.pms;

public class Test {

  // 배열에서 해당 항목의 값을 삭제한다.
  // 배열 뒤의 항목은 -1로 설정한다.
  // 배열을 출력할 때는 -1인 항목은 출력하지 않는다.

  static void deleteValue(int[] arr, int value) {

    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == value) {
        //System.out.println("i : " + i);
        for(int j = i + 1; j < arr.length; j++) {
          arr[j - 1] = arr[j];
          if(j == arr.length - 1) {
            arr[arr.length - 1] = -1;            
          }
        }
      }
    }
  }

  public static void main(String[] args) {

    int[] arr = {100, 200, 300};
    deleteValue(arr, 400);

    for(int value : arr) {
      if (value == -1)
        break;
      System.out.println(value);
    }
  }
}
