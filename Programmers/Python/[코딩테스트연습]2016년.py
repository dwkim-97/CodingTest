from functools import reduce


def solution(a, b):
    week = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    return week[int(reduce(lambda x, y: x + y, days[:a]) + b - 1) % 7]