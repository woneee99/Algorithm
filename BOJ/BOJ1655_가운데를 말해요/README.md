# 1655 가운데를 말해요

### Solution
* PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
	* Comparator.reverseOrder() 를 적용하면 내림차순 정렬이 된다.
* 가운데를 기준으로 왼, 오로 나누어 PriorityQueue에 저장
* 내림차순으로 정렬된 왼쪽의 첫 번째 값과 오른쪽의 첫 번째 값을 비교해서 오른쪽이 더 작으면 swap

### Classification
* 자료구조

### link
https://www.acmicpc.net/problem/1655