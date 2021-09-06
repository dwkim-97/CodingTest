function solution(weights, head2head) {
    const data = [];
    weights.map((w, i) => {
        let winningHeavier = 0;
        let winningCount = 0;
        let totalFightCount = 0;
        const log = head2head[i].split('');
        log.map((result, j) => {
            if(result !== 'N'){
                totalFightCount++;
                if(result === 'W'){
                    if(weights[i] < weights[j]){
                        winningHeavier++;
                    }
                    winningCount++;
                }
            }
        });
        const winningRate = totalFightCount ? winningCount / totalFightCount : 0;
        data.push({
            idx: i,
            weight: w,
            winningHeavier,
            winningRate
        })
    })

    data.sort((a,b) => {
        if(a.winningRate !== b.winningRate){
            return - (a.winningRate - b.winningRate);
        }else if(a.winningHeavier !== b.winningHeavier){
            return - (a.winningHeavier - b.winningHeavier);
        }else if(a.weight !== b.weight){
            return - (a.weight - b.weight);
        }else{
            return a.idx - b.idx;
        }
    });
    
    return data.reduce((ans, d) => {
        ans.push(d.idx+1);
        return ans;
    }, []);
}
