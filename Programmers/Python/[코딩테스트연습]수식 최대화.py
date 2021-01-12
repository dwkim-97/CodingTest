def solution(expression):
    answer = 0
    operations = [('*', '+', '-'),  # 6가지 operation 순위 사전 정의
                  ('*', '-', '+'),
                  ('+', '-', '*'),
                  ('+', '*', '-'),
                  ('-', '*', '+'),
                  ('-', '+', '*')]

    for oper in operations:  # 정의된 operation에 따라 calc 재귀 진행
        result = abs(int(calc(oper, 0, expression)))  # 얻어낸 결과값 절대값 취함.
        if result > answer:  # 기존의 결과값과 비교
            answer = result

    return answer


def calc(operation, seq, exp):
    if exp.isdigit():  # 더이상 exp에 연산자가 없으면
        return str(exp)  # 숫자를 그대로 리턴
    else:  # operation의 현 순위 연산자에 따라 진행
        if operation[seq] == "*":
            splitted = exp.split("*")  # 연산자로 쪼개고
            temp = []
            for s in splitted:  # 쪼개진 각 부분에 대해 재귀 실행
                temp.append(calc(operation, seq + 1, s))
            return str(eval("*".join(temp)))  # 재귀 실행 결과를 담은 배열에 대해 eval()함수 실행

        if operation[seq] == "+":
            splitted = exp.split("+")
            temp = []
            for s in splitted:
                temp.append(calc(operation, seq + 1, s))
            return str(eval("+".join(temp)))

        if operation[seq] == "-":
            splitted = exp.split("-")
            temp = []
            for s in splitted:
                temp.append(calc(operation, seq + 1, s))
            return str(eval("-".join(temp)))