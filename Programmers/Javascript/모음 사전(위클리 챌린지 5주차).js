const CHAR_DIC = {
    A: 1,
    E: 2,
    I: 3,
    O: 4,
    U: 5
}

function solution(word) {
    var answer = 0; 
    return word.split('').reduce((acc, cur, idx) => {
        const coef = getCoefficient(idx);
        return acc + coef * (CHAR_DIC[cur] - 1) + 1;
    }, 0);
}

const getCoefficient = idx => {
    let coef = 0;
    for(let i = idx; i < 5; i++){
        coef = coef * 5 + 1;
    }
    return coef;
}
