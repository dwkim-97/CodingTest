let inBound;

function solution(game_board, table) {
    let answer = 0;
    const length = game_board.length;
    inBound = isValueInBound(length);
    const puzzles = [];
    for(let r = 0; r < length; r++){
        for(let c = 0; c < length; c++){
            if(table[r][c]){
                puzzles.push(getPieces(table, r, c, 0, 0));
            }
        }
    }
    
    for(let rotate = 0; rotate < 4; rotate++){
        for(let r = 0; r < length; r++){
            for(let c = 0; c < length; c++){
                if(!game_board[r][c]){
                    for(let i = 0; i < puzzles.length; i++){
                        const puzzle = puzzles[i];
                        const emptySize = getEmptySize(game_board, r, c);
                        if(emptySize !== puzzle.length){
                            continue;
                        }
                        const check = checkPuzzleFit(game_board, puzzle, r, c);
                        if(check){
                            puzzles.splice(i, 1);
                            updateBoard(game_board, puzzle, r, c);
                            answer += puzzle.length;
                            break;
                        }
                    }
                }
            }
        }
        game_board = rotateMatrix(game_board);
    }
    return answer;
}

const checkPuzzleFit = (board, puzzle, r, c) => 
    puzzle.every(piece => {
        const {row, col} = piece;
        return inBound(r+row) && inBound(c+col) && board[r + row][c + col] === 0;
    })


const updateBoard = (board, puzzle, r, c) => {
    puzzle.map(piece => {
        const {row, col} = piece;
        board[r+row][c+col] = 1;
    })
}

const isValueInBound = len => val => val >= 0 && val < len;

const getPieces = (table, r, c, r_off, c_off) => {
    const len = table.length;
    table[r][c] = 0;
    const pieces = [{
        row: r_off, col: c_off
    }]
    if(inBound(r+1) && table[r+1][c]){
        pieces.push(...getPieces(table, r+1, c, r_off+1, c_off));
    }
    if(inBound(r-1) && table[r-1][c]){
        pieces.push(...getPieces(table, r-1, c, r_off-1, c_off));
    }
    if(inBound(c+1) && table[r][c+1]){
        pieces.push(...getPieces(table, r, c+1, r_off, c_off+1));
    }
    if(inBound(c-1) && table[r][c-1]){
        pieces.push(...getPieces(table, r, c-1, r_off, c_off-1));
    }
    return pieces;
}

const getEmptySize = (board, r, c, visited = []) => {
    visited.push({
        row: r, col: c
    });
    const isVisited = (row, col) => 
        visited.some(piece => piece.row === row && piece.col === col)
    
    let count = 1;
    if(!isVisited(r+1, c) && inBound(r+1) && !board[r+1][c]){
        count += getEmptySize(board, r+1, c, visited);
    }
    if(!isVisited(r-1, c) && inBound(r-1) && !board[r-1][c]){
        count += getEmptySize(board, r-1, c, visited);
    }
    if(!isVisited(r, c+1) && inBound(c+1) && !board[r][c+1]){
        count += getEmptySize(board, r, c+1, visited);
    }
    if(!isVisited(r, c-1) && inBound(c-1) && !board[r][c-1]){
        count += getEmptySize(board, r, c-1, visited);
    }
    return count;
}

const rotateMatrix = matrix => {
    const length = matrix.length;
    const newMatrix = createNewMatrix(length);
    for(let r = 0; r < length; r++){
        for(let c = 0; c < length; c++){
            newMatrix[c][length-1-r] = matrix[r][c];
        }
    }
    return newMatrix;
}

const createNewMatrix = length => {
    const newMatrix = new Array(length);
    for(let i = 0; i < length; i++){
        newMatrix[i] = new Array(length);
    }
    return newMatrix;
}
