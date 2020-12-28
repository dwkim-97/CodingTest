def solution(bridge_length, weight, truck_weights):
    answer = 0+1
    answer += len(truck_weights)*2
    for current_truck in range(len(truck_weights)):
        weight_on_bridge = truck_weights[current_truck]
        next_truck = current_truck+1
        while next_truck < len(truck_weights) or weight_on_bridge + truck_weights[next_truck] < weight:
            next_truck = next_truck + 1
            answer -= 1
    
    return answer

solution(2, 10, [7,4,5,6])