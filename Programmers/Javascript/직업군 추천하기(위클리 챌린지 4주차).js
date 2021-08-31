const JOB_IDX = 0
const LIST_MAX_LENGTH = 6;

function solution(table, languages, preference) {
    const map = generateMap(table, languages);
    const jobScores = map.scores.map(scores => {
        return languages.reduce((acc, cur, idx) => scores[cur] 
                                ? acc + preference[idx] * scores[cur] 
                                : acc, 0);
    });
    
    return jobScores.reduce((acc, cur, idx) => {
        return cur > acc.max ? 
            {
                max: cur,
                answer: map.jobs[idx]
            } : acc;
        }, {
        max: 0,
        answer: '',
    }).answer;
}

const generateMap = (table, languages) => {
    const map = {
        jobs: ['CONTENTS', 'GAME', 'HARDWARE', 'PORTAL', 'SI'],
        scores: Array(5),
    };
    table.forEach(str => {
        const list = str.split(' ');
        let jobListIdx;
        const container = {};
        list.forEach((item, idx) => {
            if(idx === JOB_IDX){
                jobListIdx = map.jobs.indexOf(item);
            }else{
                container[item] = LIST_MAX_LENGTH - idx;
            }
        });
        map.scores[jobListIdx] = container;
    });
    
    return map;
}
