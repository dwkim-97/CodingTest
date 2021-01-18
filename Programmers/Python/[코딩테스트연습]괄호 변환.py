def solution(p):
    return modify(p)

def modify(v):
    if len(v) == 0:
        return v
    else:
        check_right = True
        op_cnt = 0
        cl_cnt = 0
        for i in range(len(v)):
            if v[i] == "(":
                op_cnt += 1
            else:
                cl_cnt += 1

            if op_cnt == cl_cnt:
                break
            elif op_cnt < cl_cnt:
                check_right = False

        u = v[:i+1]
        if check_right:
            return u + modify(v[i+1:])
        else:
            new_u = "(" + modify(v[i+1:]) + ")"
            for i in u[1:-1]:
                if i == ")":
                    new_u += "("
                else:
                    new_u += ")"

            return new_u

print(solution("()))((()"))