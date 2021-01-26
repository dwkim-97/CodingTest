from itertools import combinations
def solution(info, query):
    answer = []
    db = {}
    for i in info:
        temp = i.split()
        conditions = temp[:-1]
        score = int(temp[-1])
        for n in range(5):
            combi = list(combinations(range(4), n))
            for c in combi:
                t_c = conditions.copy()
                for v in c:
                    t_c[v] = '-'
                changed_t_c = '/'.join(t_c)
                if changed_t_c in db:
                    db[changed_t_c].append(score)
                else:
                    db[changed_t_c] = [score]

    for value in db.values():
        value.sort()

    for q in query:
        qry = [i for i in q.split() if i != 'and']
        qry_cnd = '/'.join(qry[:-1])
        qry_score = int(qry[-1])
        if qry_cnd in db:
            data = db[qry_cnd]
            if len(data) > 0:
                start, end = 0, len(data)
                while start != end and start != len(data):
                    if data[(start + end) // 2] >= qry_score:
                        end = (start + end) // 2
                    else:
                        start = (start + end) // 2 + 1
                answer.append(len(data) - start)
        else:
            answer.append(0)

    return answer




print(solution(
    ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
     "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"], \
    ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
     "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
     "- and - and - and - 150"]))

# def solution(info, query):
#     answer = []
#     trie = Trie()
#
#     for d in info:
#         temp = d.split(' ')
#         trie.add(temp[:-1], temp[-1])
#     print(trie.children)
#
#     for q in query:
#         temp = [i for i in q.split() if i != 'and']
#         print('new conditions!', temp)
#         count = trie.search(temp, temp[-1])
#         print('count!!', count)
#         answer.append(count)
#     return answer
#
#
# class Trie:
#     def __init__(self):
#         self.children = {}
#
#
#     def add(self, conditions, score):
#         node = self.children
#         for con in conditions:
#             if con not in node:
#                 node[con] = {}
#             node = node[con]
#         if 'score' in node:
#             node['score'].append(score)
#         else:
#             node['score'] = [score]
#
#     def search(self, conditions, score):
#         node = self.children
#         print('c', conditions)
#         for c in range(len(conditions)):
#             con = conditions[c]
#             print('n', node)
#             if 'score' in node:
#                 count = 0
#                 for s in node['score']:
#                     print('score', s)
#                     print('con score', score)
#                     if int(score) <= int(s):
#
#                         count += 1
#                         print('r1_count', count)
#
#                 return count
#             if con not in node and con != '-':
#                 return 0
#             else:
#                 if con == '-':
#                     count = 0
#                     print('keys', node.keys())
#                     for key in node.keys():
#                         print('key', key)
#                         conditions[c] = key
#                         print('changed', conditions)
#                         print('r2')
#                         count += self.search(conditions, score)
#                         conditions[c] = '-'
#
#                     return count
#                 else:
#                     node = node[con]


# def solution(info, query):
#     answer = []
#     db = {}
#     all_candidates = []
#     for d_index in range(len(info)):
#         temp = info[d_index].split(' ')
#         score = int(temp[-1])
#         for t in range(len(temp)-1):
#             if temp[t] in db:
#                 db[temp[t]].append((d_index, score))
#             else:
#                 db[temp[t]] = [(d_index, score)]
#             all_candidates.append((d_index, score))
#
#     for q in query:
#         temp = [i for i in q.split() if i != 'and']
#         score = int(temp[-1])
#         candidates = set(all_candidates)
#         for t in temp[:-1]:
#             if t != '-':
#                 candidates = candidates & set(db[t])
#
#         cnt = 0
#         for c in list(candidates):
#             if c[1] >= score:
#                 cnt += 1
#         answer.append(cnt)
#
#     return answer
