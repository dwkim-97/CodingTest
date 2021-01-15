def solution(s):
    title_s = s.title()
    words = title_s.split(" ")
    print(words)
    for i in range(len(words)):
        if len(words[i]) != 0 and words[i][0].isdigit():
            words[i] = words[i].lower()

    return " ".join(words)

solution("he  llo")