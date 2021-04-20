function solution(absolutes, signs) {
    var answer = 0;
    let idx;
    for(idx = 0 ; idx < absolutes.length; idx++){
        answer += signs[idx] ? absolutes[idx] : -absolutes[idx];
    }
    return answer;
}
