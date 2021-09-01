function solution(s) {
    let answer = '';
    let i = 0;
    
    while(i < s.length){
        const checker = checkChar(s.charAt(i));
        
        switch(char){
            case 'z':
                i += 4;
                answer += '0';
                break;
            case 'o':
                i += 3;
                answer += '1';
                break;
            case 'e':
                i += 5;
                answer += '8';
                break;
            case 'n':
                i += 4;
                answer += '9';
                break;
            case 't':
                if(s.charAt(i+1) === 'w'){
                    i += 3;
                    answer += '2';
                }else{
                    i += 5;
                    answer += '3';
                }
                break;
            case 'f':
                if(s.charAt(i+1) === 'i'){
                    answer += '5';
                }else{
                    answer += '4';
                }
                i += 4;
                break;
            case 's':
                if(s.charAt(i+1) === 'i'){
                    i += 3;
                    answer += '6';
                }else{
                    i += 5;
                    answer += '7';
                }
                break;
            default:
                i++;
                answer += char;
        }
    }
    return Number(answer);
}
