# 9205 맥주 마시면서 걸어가기

### Solution
* 첫 번째 방법
	* BFS로 집 -> 편의점 -> 페스티벌까지 1000(50m * 20(개수))m 안으로 갈 수 있는 지 확인
* 두 번째 방법
	* 플로이드 와샬 알고리즘을 이용해 거리 계산
	* 0번째 (집) -> N+2 번째(페스티벌)까지 거리가 INF이상이 아니면 갈 수 있다.

### Classification
* 플로이드 와샬
* BFS

### link
https://www.acmicpc.net/problem/9205