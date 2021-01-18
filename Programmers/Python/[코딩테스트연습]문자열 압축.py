def solution(s):
    shortest_length = len(s)
    for i in range(1, len(s)):
        check = 0
        units = []
        for j in range(len(s)):
            if j - check == i:
                units.append(s[check:j])
                check = j
        units.append(s[check:])

        counts = [1]
        for u in range(1, len(units)):
            if units[u - 1] == units[u]:
                counts[-1] += 1
            else:
                counts.append(1)

        new_length = 0
        for c in counts:
            if c == 1:
                new_length += i
            else:
                new_length += i + len(str(c))

        if len(units[-1]) != i:
            new_length -= i - len(units[-1])

        if new_length < shortest_length:
            shortest_length = new_length

    return shortest_length
