function solution(left, right) {
    let answer = 0;
    const signs = [];
    for(let i = 0; i <= right; i++){
        signs.push('+');
    }

    for(let i = 1; i <= right; i++){
        let j = i;
        while(j <= right){
            signs[j] = signs[j] === '+' ? '-' : '+';
            j += i;
        }
    }
    
    for(let i = left; i <= right; i++){
        answer += signs[i] === '+' ? i : -i;
    }
    return answer;
}
