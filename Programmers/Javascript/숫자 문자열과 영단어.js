function solution(s) {
    let answer = '';
    let i = 0;
    
    const numbers = {
        zero: { len: 4, char: '0' },
        one: { len: 3, char: '1' },
        two: { len: 3, char: '2' },
        three: { len: 5, char: '3' },
        four: { len: 4, char: '4' },
        five: { len: 4, char: '5' },
        six: { len: 3, char: '6' },
        seven: { len: 5, char: '7' },
        eight: { len: 5, char: '8' },
        nine: { len: 4, char: '9' },
    }
    
    const update = char => {
        if(numbers[char]){
            answer += numbers[char].char;
            return numbers[char].len;
        }else{
            answer += char;
            return 1;
        }
    }
    
    while(i < s.length){
        const char = s.charAt(i);
        const nextChar = s.charAt(i+1);
        i += char === 'z' 
            ? update('zero')
            : char === 'o' 
            ? update('one')
            : char === 'e'
            ? update('eight')
            : char === 'n'
            ? update('nine')
            : char === 't'
            ? nextChar === 'w'
                ? update('two')
                : update('three')
            : char === 'f'
            ? nextChar === 'o'
                ? update('four')
                : update('five')
            : char === 's'
            ? nextChar === 'i'
                ? update('six')
                : update('seven')
            : update(char);
    }
    return Number(answer);
}
