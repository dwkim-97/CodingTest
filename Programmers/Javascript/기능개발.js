function solution(progresses, speeds) {
    let answer = [];
    while(progresses.length > 0){
        let last_days = Math.ceil((100 - progresses[0]) / speeds[0]);
        for(const i in progresses){
            progresses[i] += last_days * speeds[i];
        }

        let count = 0;
        while(progresses[0] >= 100){
            progresses.shift();
            speeds.shift();
            count++;
        }
        if(count !== 0){
            answer.push(count);
        }
    }
    
    return answer;
}
