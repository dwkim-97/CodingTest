import collections
from functools import reduce

def solution(clothes):
    answer = 1
    #print(clothes)
    #print(collections.Counter(clothes))
    
    clothes = dict(clothes) # clothes dictionaryȭ
    val = list(clothes.values()) # �� ������ ��������
    counter = collections.Counter(val) # �� ������ ���� ���
    #print(kind in clothes)
    
    answer = reduce(lambda x,y : x*(y+1), counter.values(),1) -1
    
  
    return answer

    #lambda�� ��� ����, reduce�� ó������ ������, 1�� �ʱⰪ
    
    #valCount = list(counter.values()) # ������ ����Ʈ�� ��������
    #print(valCount)
    #for i in valCount:
    #    answer *= i+1 # i�� �ε����ϱ� +1�ؾ� ������ �ȴ�.
    #    print(answer, i)
    
    #return answer-1