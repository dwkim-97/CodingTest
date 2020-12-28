import math
def solution(progresses, speeds):
    answer = []
    while len(progresses) != 0 : 
        count = 1 #정답에 넣어줄 값. 한번에 배포될 수
        if len(progresses) == 1: #한개 남았을 때, 밑으로 돌 필요없다.
            answer.append(1) 
            break
        cur_prog = progresses.pop(0) #현재 첫번째 값 빼와서
        cur_speed = speeds.pop(0)
        days = math.ceil((100 - cur_prog) / cur_speed) # 현재 첫번째 값 기준으로 소요일수 계산
        ended = []
        
        for i in range(len(progresses)): #해당 일수 만큼 지났을 때 값으로 전부 업데이트
            progresses[i] += int(speeds[i]*days)
            
        #만약 업데이트 된 값중 100이 넘는 값들이 존재하는지 앞에서부터 확인. 중간에 하나라도 아니면 그 이후는 패스
        while len(progresses) != 0: 
            j = progresses[0]
            if j >= 100:
                progresses.pop(0)
                speeds.pop(0)
                count += 1
            else:
                break
        answer.append(count)
    return answer