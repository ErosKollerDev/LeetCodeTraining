/**
 * Don't let the machines win. You are humanity's last hope...
 **/

const width = parseInt(readline()); // the number of cells on the X axis
const height = parseInt(readline()); // the number of cells on the Y axis
let x1 = '';
let y1 = '';
let x2 = '';
let y2 = '';
let x3 = '';
let y3 = '';
const grid = [];


// Write an action using console.log()
// To debug: console.error('Debug messages...');

for (y = 0; y < height; y++) {
    const line = readline();// width characters, each either 0 or .
    grid.push(line.split(''));
}

for (let y = 0; y < height; y++) {
    for (let x = 0; x < width; x++) {
        if (grid[y][x] != 0) {
            x++;
        } else if (grid[y][x] == 0) {
            x1 = x;
            y1 = y;
            if (x + 1 < width) {
                for (let xx = x + 1; xx < width; xx++) {
                    if (grid[y][xx] == 0) {
                        x2 = xx;
                        y2 = y;
                        break
                    } else {
                        x2 = -1;
                        y2 = -1;
                    }
                }
            } else {
                x2 = -1;
                y2 = -1;
            }

            if (y + 1 < height) {
                for (let yy = y + 1; yy < height; yy++) {
                    if (grid[yy][x] == 0) {
                        x3 = x;
                        y3 = yy;
                        break;
                    } else {
                        x3 = -1;
                        y3 = -1;
                    }
                }
            } else {
                x3 = -1;
                y3 = -1;
            }
            console.log(x1, y1, x2, y2, x3, y3);  //if I put concole.log here, I pass tests 1 through 3 and 7.
        }

    }
    //if I put the console log here, I pass tests 3 and 6.
}

// Three coordinates: a node, its right neighbor, its bottom neighbor
// console.log('0 0 1 0 0 1');
