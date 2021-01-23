def solution(m, musicinfos):
    m = m.replace("D#", "d").replace("C#", "c").replace("F#", "f").replace("A#", "a").replace("G#", "g")
    candidate = (0,'')
    for info in musicinfos:
        splitted = info.split(",")
        start_time, end_time = splitted[0], splitted[1]
        times = int(end_time[-2:]) - int(start_time[-2:])
        if start_time[:2] != end_time[:2]:
            times += 60*(int(end_time[:2])-int(start_time[:2]))
        raw_melody = splitted[3].replace("D#","d").replace("C#","c").replace("F#","f").replace("A#","a").replace("G#","g")
        melody = (raw_melody * (times // len(raw_melody) + 1))[:times]
        print("m", m, melody)
        if m in melody and candidate[0] < times:
            candidate = (times, splitted[2])

    if candidate[0] == 0:
        return '(None)'
    else:
        return candidate[1]



print(solution('ABCDEFG',	['12:00,12:14,HELLO,CDEFGAB', '13:00,13:05,WORLD,ABCDEF']))
print(solution('CC#BCC#BCC#BCC#B'	,['03:00,03:30,FOO,CC#B', '04:00,04:08,BAR,CC#BCC#BCC#B']))
print(solution('ABC',	['12:00,12:14,HELLO,C#DEFGAB', '13:00,13:05,WORLD,ABCDEF']))
print(solution('ABC',	['12:50,13:30,HELLO,C#DEFGABC#DBABC', '12:50,13:30,WORLD,C#DEFGAB']))