function solution(scores) {
    let answer = '';
    const length = scores.length;
    for(let i = 0; i < length; i++){
        const arr = getArr(scores, i);
        const selfScore = arr[i];
        arr.sort((a,b) => a - b);
        const [min, max] = [arr[0], arr[length-1]];
        if(min === selfScore && arr[1] !== min){
            arr.splice(0, 1);
        }else if(max === selfScore && arr[length - 2] !== max){
            arr.splice(length - 1, 1);
        }
        const avg = getAverage(arr);
        const grade = getGrade(avg);
        answer += grade;
    }
    return answer;
}

const getArr = (scores, idx) => 
    scores.reduce((acc, cur) => {
        acc.push(cur[idx]);
        return acc;
    }, []);


const getAverage = arr => 
    arr.reduce((acc, cur) => {
        return acc + cur;
    }, 0) / arr.length;

const getGrade = score => 
    score >= 90 ? 'A'
    : score >= 80 ? 'B'
    : score >= 70 ? 'C'
    : score >= 50 ? 'D'
    : 'F'
