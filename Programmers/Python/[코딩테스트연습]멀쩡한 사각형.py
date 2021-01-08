def solution(w, h):
    smaller = (w if w < h else h)
    for i in range(1, smaller + 1):
        if w % i == 0 and h % i == 0:
            LCM = i

    return w * h - (w / LCM + h / LCM - 1) * LCM