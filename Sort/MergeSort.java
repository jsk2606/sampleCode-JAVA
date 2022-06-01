public class MergeSort {

    public static int[] src;
    public static int[] tmp;

    public static void main(String[] args) {

        src = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 6};
        tmp = new int[src.length];

        System.out.print("before:");
        printArray(src);

        mergeSort(0, src.length-1);

        System.out.print("after:");
        printArray(src);
    }

    /**
     -합병정렬-
     1. 리스트의 길이가 0 또는 1이면 이미 정렬된 것으로 본다. 그렇지 않은 경우에는
     2. 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
     3. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
     4. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
     */
    public static void mergeSort(int start, int end) {

        //리스트 길이가 0 또는 1인지 확인
        if (start<end) {

            /** 분리 시작 */

            //리스트의 절반 인덱스
            int mid = (start+end) / 2;

            //분리된 리스트 좌측
            mergeSort(start, mid);
            //분리된 리스트 우측
            mergeSort(mid+1, end);

            /** 분리 종료 */


            int p   = start;
            int q   = mid + 1;
            int idx = p;

            /**
             루프조건 :   시작 인덱스가 중간인덱스 보다 작거나 같을때
                        or
                        중간 인덱스+1 이 종료인덱스 보다 작거나 같을때
             */
            while (p<=mid || q<=end) {

                if (q>end || (p<=mid && src[p]<src[q])) {
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx++] = src[q++];
                }

            }

            for (int i=start;i<=end;i++) {
                src[i]=tmp[i];
            }
        }
    }

    public static void printArray(int[] a) {

        for (int i=0;i<a.length;i++) System.out.print(a[i]+" ");
        System.out.println();
    }
}

/** by - https://yunmap.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%89%AC%EC%9A%B4-Merge-Sort-%EB%B3%91%ED%95%A9-%EC%A0%95%EB%A0%AC-%ED%95%A9%EB%B3%91-%EC%A0%95%EB%A0%AC */