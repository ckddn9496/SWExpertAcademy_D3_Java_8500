# SWExpertAcademy_D3_Java_8500

## SW Expert Academy D3 8500. 극장 좌석

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemList.do

input으로 키보드로 입력을 받아 가능한 극장 좌석의 최소 값을 구하는 문제. N개의 정수값은 자신의 양옆에 비어있는 좌석의 갯수를 말한다. 즉 값이 `Ai`라면 `i`번째 사람의 왼쪽과 오른쪽으로 적어도 `Ai`개의 좌석이 연속해서 비어있다는 것이다. 추가적으로, 사람들은 번호 순서대로 극장에 앉아 있는 것이 아니다.



[입력]

> 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(1 ≤ N ≤ 104)이 주어진다.
> 두 번째 줄에는 N개의 정수 A1, A2, ⋯, AN(0 ≤ Ai ≤ 104)이 공백 하나로 구분되어 주어진다.

[출력]

> 각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
> 각 테스트 케이스마다 극장의 좌석 개수로 가능한 수의 최소값을 출력한다.

### 2. 풀이

사람들이 번호 순서대로 극장에 앉아 있는것이 아니므로, 최소한의 좌석수를 만족할 수 있는 사람들이 배치를 생각해 보았다. 양옆에 더 많은 연속된 빈 좌석을 아는 사람에게 그 수와 비슷한 많은 연속된 빈 좌석을 아는 사람이 있을 수록 빈좌석을 더 많이 생기지 않는다는것을 알게 되었고 이를 위해 **정렬**후 좌석 수를 계산하는것이 최소의 좌석수를 만족함을 알 수 있었다.

매 테스트케이스에 대해, 첫번째 줄에서 받아온 `N`을 이용하여 정수형 배열을 선언한다. 두번째 줄에서 받아온 값을 위에서 생성한 정수형 배열에 담아 그 배열을 정렬한다. 기본적인 `Arrays.sort()`를 사용하였을 때 오름차순으로 정렬이되며 `i`번째 사람은 왼쪽으로 `Ai`개의 연속된 빈 좌석과 자신의 자리를 가지며, 오른쪽의 연속된 빈 좌석의 개수는 자신보다 크거나 같은 `i+1`번째 사람이 알 고 있는 빈좌석의 갯수를 따른다. 그렇기 때문에 `0`부터 `N-2`까지 반복하여 `Ai + 1`개의 좌석을 더한다. 가장 마지막 `n-1`번째 사람은 가장 많은 빈좌석수를 알고있는 사람이기 때문에 왼쪽과 오른쪽 동일하게 `An-1`의 연속된 빈 좌석수를 가진다. `2An-1 + 1`을 마지막으로 더해주어 이를 출력하여 완성하였다.

```java
int N = Integer.parseInt(sc.nextLine());
StringTokenizer stringTokenizer = new StringTokenizer(sc.nextLine());	
int[] nums = new int[stringTokenizer.countTokens()];
for (int i = 0; i < nums.length; i++) {
  nums[i] = Integer.parseInt(stringTokenizer.nextToken());
}
Arrays.sort(nums);
int seatNum = 0;
for (int i = 0; i < nums.length-1; i++) {
  seatNum += nums[i]+1;
}

seatNum += nums[nums.length-1]*2 + 1;
System.out.println("#"+test_case+" "+seatNum);

```
