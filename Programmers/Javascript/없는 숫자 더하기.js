function solution(numbers) {
    const arr = new Array(10);
    for(let i = 0; i < 10; i++){
        arr[i] = numbers.indexOf(i) === -1 ? true : false;
    }
    
    return arr.reduce((ans, val, idx) => val ? ans + idx : ans, 0);
}
