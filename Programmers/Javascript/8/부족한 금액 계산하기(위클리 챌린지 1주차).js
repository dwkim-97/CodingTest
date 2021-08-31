function solution(price, money, count) {
    const coefficient = calcSum(count);
    const totalPrice = coefficient * price;
    return totalPrice > money ? totalPrice - money : 0;
}

const calcSum = (num) => {
    let sum = 0;
    for(let n = 0; n <= num; n++){
        sum += n;        
    }
    return sum;
}
