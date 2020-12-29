def solution(skill, skill_trees):
    answer = 0

    for skill_tree in skill_trees:
        total_used_skill = 0
        continuosly_found_skill = 0
        i = 0
        for s in skill:
            if s in skill_tree:
                total_used_skill += 1
            while i < len(skill_tree):
                print(s, skill_tree[i], i)
                if skill_tree[i] == s:
                    continuosly_found_skill += 1
                    break
                else:
                    i += 1
            print(continuosly_found_skill, total_used_skill)
        if total_used_skill == continuosly_found_skill:
            answer += 1

    return answer