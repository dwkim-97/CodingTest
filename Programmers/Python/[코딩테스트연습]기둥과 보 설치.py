PILLAR, BEAM = 0, 1


def solution(n, build_frame):
    answer = []
    for b in build_frame:
        x, y, kind, oper = b
        if oper == 1:  # 설치인데
            if kind == PILLAR:  # 기둥일 경우
                if pillar_check([x, y], answer):
                    answer.append(b[:3])
            else:  # 보일 경우
                if beam_check([x, y], answer):
                    answer.append(b[:3])
        else:  # 삭제인데
            temp = answer.copy()
            temp.remove(b[:3])
            check = True
            for t in temp:
                x, y, kind = t
                if kind == PILLAR:
                    if not pillar_check([x, y], temp):
                        check = False
                        break
                else:
                    if not beam_check([x, y], temp):
                        check = False
                        break
            if check:
                answer = temp.copy()

    answer.sort()
    return answer


def pillar_check(pillar_pos, answer):
    x, y = pillar_pos
    if y == 0:  # 바닥일 경우는 그냥 설치
        return True
    # 바닥이 아니고 다른 기둥 위에 있거나 보의 한쪽 끝 부분 위에 있는지
    if [x, y - 1, PILLAR] in answer or [x - 1, y, BEAM] in answer or [x, y, BEAM] in answer:
        return True
    return False


def beam_check(beam_pos, answer):
    x, y = beam_pos
    if [x, y - 1, PILLAR] in answer or [x + 1, y - 1, PILLAR] in answer:  # 한쪽 끝 부분이 기둥위에 있거나
        return True
    if [x - 1, y, BEAM] in answer and [x + 1, y, BEAM] in answer:  # 양쪽 끝 부분이 다른 보와 동시에 연결되어 있거나
        return True
    return False