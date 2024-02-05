# 1504 특정한 최단 경로

### Solution
* 최댓값을 987654321으로 두면 오버플로우 발생
 -> long으로 변경해서 계산하거나 최댓값을 (간선의 최대 개수)200,000 * (거리)1,000으로 설정

### Classification
* 다익스트라

### link
https://www.acmicpc.net/problem/1504