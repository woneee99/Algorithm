# 11729 하노이 탑 이동 순서

### solution
* 출발(from), 경유(by), 목적지(to) 설정
* 1번째 탑을 2번째로 옮기기 -> hanoi(n-1, from, to, by)
* 2번째 탑을 3번째로 옮기기 -> hanoi(n-1, by, from, to)
* n이 1일 때 멈추기 -> 무한루프 제거

### Classification
* 재귀

### link
https://www.acmicpc.net/problem/11729