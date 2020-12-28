import math
def solution(progresses, speeds):
    answer = []
    while len(progresses) != 0 : 
        count = 1 #���信 �־��� ��. �ѹ��� ������ ��
        if len(progresses) == 1: #�Ѱ� ������ ��, ������ �� �ʿ����.
            answer.append(1) 
            break
        cur_prog = progresses.pop(0) #���� ù��° �� ���ͼ�
        cur_speed = speeds.pop(0)
        days = math.ceil((100 - cur_prog) / cur_speed) # ���� ù��° �� �������� �ҿ��ϼ� ���
        ended = []
        
        for i in range(len(progresses)): #�ش� �ϼ� ��ŭ ������ �� ������ ���� ������Ʈ
            progresses[i] += int(speeds[i]*days)
            
        #���� ������Ʈ �� ���� 100�� �Ѵ� ������ �����ϴ��� �տ������� Ȯ��. �߰��� �ϳ��� �ƴϸ� �� ���Ĵ� �н�
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