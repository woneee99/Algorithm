# 5052 전화번호 목록

### Classification
* 정렬

### Solution
- startsWith()는 문자열이 특정 문자열로 시작하는지 확인하는 메서드이다.
- 처음에는 substring으로 그 전 길이만큼 끊어서 확인했는 데 런타임 에러(NullPointer)가 떴다.
    - 사전순으로 정렬을 하면 길이가 더 긴 것이 앞에 온다는 생각을 못했다.

### link
https://www.acmicpc.net/problem/5052