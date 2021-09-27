function solution(sizes) {
    const lower = [];
    const higher = [];
    sizes.map(([s0, s1]) => {
        if(s0 > s1){
            higher.push(s0);
            lower.push(s1);
        }else{
            lower.push(s0);
            higher.push(s1);
        }
    })
    return Math.max(...higher) * Math.max(...lower);
}
