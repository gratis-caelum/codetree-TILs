MAX_ARRAY = 100

n = int(input())

arr = [0] * MAX_ARRAY

# 문제에서 주어진 조건 배열에 저장
for _ in range(n):
    pos, alpha = input().split()
    pos = int(pos) - 1
    arr[pos] = alpha

result = -1

# p = 탐색구간의 길이 즉, 사진의 크기
for p in range(len(arr)):
    # i = 탐색 구간의 시작 위치
    for i in range(len(arr)-p-1):
        cntG, cntH = 0,0
        pic_length = 0

        # 구간의 시작점과 끝점에 알파벳이 없으면 계산하지 않는다.
        if arr[i] == 0 or arr[i+p] == 0:
            continue

        # 구간의 시작점과 끝점에 알파벳이 있어야 구간의 길이를 계산한다.
        for j in range(i,i+p+1):
            
            # G, H의 등장 횟수를 카운트한다
            if arr[j] == 'G':
                cntG += 1
            elif arr[j] == 'H':
                cntH += 1
            
        # 오로지 G로만 혹은 H로만 이루어져 있거나, G와 H가 정확히 같은 개수만큼 나오게 사진을 찍고싶을 때,
        if cntG == cntH or cntG == 0 or cntH == 0:
            # 배열의 길이 저장
            pic_length = p
        
        # 최댓값 갱신
        result = max(pic_length,result)

print(result)