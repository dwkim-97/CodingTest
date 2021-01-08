from functools import reduce
def solution(a, b):
    if a > b:
        return reduce(lambda x,y:x+y, range(b,a+1),0)
    else:
        return reduce(lambda x,y:x+y, range(a,b+1),0)