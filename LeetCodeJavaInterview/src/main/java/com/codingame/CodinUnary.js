const MESSAGE = "%";
let binaryMess="";
for(let i = 0; i<MESSAGE.length; i++){
    binaryMess += MESSAGE.charCodeAt(i).toString(2);
}
const regex = /(1*)(0*)/g;
const answer = binaryMess.replace(regex, (str, g1, g2)=>{
    let a="", b="";
    if(g1)a = "0 "+"0".repeat(g1.length);
    if(g2)b = "00 "+"0".repeat(g2.length);

    if(a&&b){return a + " " + b + " ";}
    else if(a){return a + " "}
    else if(b){return b + " "}
    else{return ""}
});



console.log(answer.trim());