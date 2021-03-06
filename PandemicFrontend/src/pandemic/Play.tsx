import React, { useState } from "react";
import { GameState } from "./gameState";
import styled from "styled-components";


<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet"></link>


const Interface = styled.div`
  margin: auto;
  width: 50%;
  font-family: 'VT323', monospace;
`

const GameHeader = styled.div`
font-size: 100%;
text-align: left;
padding: 2px;
color: #228B22;
`

const PaperTitle = styled.span`
font-weight: bold;
`

const Day = styled.span`
font-weight: bold;
`

const ScreenText = styled.div`
width: 50%;
margin: auto;
`

const GameScreen = styled.div`
display: inline-block;
border: 3px solid;
width: 99%;
min-height: 400px;
text-align: center;
background-color: white;

`
const GameButton1 = styled.button`
vertical-align: top;
font-size: 80%;
display: inline-block;
border: 3px solid;
width: calc(100%);
height: 75px;
text-align: center;
background-color: white;
font-family: 'VT323', monospace;
&:hover{
        color: #228B22;
}
`
const GameButton2 = styled.button`
vertical-align: top;
font-size: 80%;
display: inline;
border: 3px solid;
width: calc(50%);
height: 75px;
text-align: center;
background-color: white;
font-family: 'VT323', monospace;
&:hover{
        color: #228B22;
}
`
const ButtonWrapper = styled.span`
width: 103%;
`
const BarWrap = styled.span`
width: calc(33%);
text-align: center;
display: inline-block;
`
const BarLabels = styled.span`
width: calc(33%);
text-align: center;
display: inline-block;
font-size: 70%;
`
;

interface PlayProps {
    gameState: GameState;
    setGameState: any;
}

export function Play({ gameState, setGameState}: PlayProps ) {
    let [count, setCount] = useState(0);
    const [title, setTitle] = useState(gameState.paperTitle);
    const [content, setContent] = useState(gameState.paperContent);
    const [button1, setButton1] = useState(gameState.buttonsPaper);
    const [button2, setButton2] = useState(undefined);
    const [social, setSocial] = useState(gameState.social);
    const [virusc, setVirusc] = useState(gameState.virusc);
    const [money, setMoney] = useState(gameState.money);
    const [toiletPaper, setToiletPaper] = useState(gameState.toilet);

    var gameName = [
        "<pre><code>@@@@@@@    @@@@@@   @@@  @@@  @@@@@@@   @@@@@@@@  @@@@@@@@@@   @@@   @@@@@@@",
        "@@@@@@@@  @@@@@@@@  @@@@ @@@  @@@@@@@@  @@@@@@@@  @@@@@@@@@@@  @@@  @@@@@@@@ ",
        "@@!  @@@  @@!  @@@  @@!@!@@@  @@!  @@@  @@!       @@! @@! @@!  @@!  !@@ ",
        "!@!  @!@  !@!  @!@  !@!!@!@!  !@!  @!@  !@!       !@! !@! !@!  !@!  !@! ",
        "@!@@!@!   @!@!@!@!  @!@ !!@!  @!@  !@!  @!!!:!    @!! !!@ @!@  !!@  !@! ",
        "!!@!!!    !!!@!!!!  !@!  !!!  !@!  !!!  !!!!!:    !@!   ! !@!  !!!  !!! ",
        "!!:       !!:  !!!  !!:  !!!  !!:  !!!  !!:       !!:     !!:  !!:  :!! ",
        ":!:       :!:  !:!  :!:  !:!  :!:  !:!  :!:       :!:     :!:  :!:  :!: ",
        " ::       ::   :::   ::   ::   :::: ::   :: ::::  :::     ::    ::   ::: :::",
        " :         :   : :  ::    :   :: :  :   : :: ::    :      :    :     :: :: :",
        "</code></pre>",
      ].join('\n');

     var wrappedASCII = {__html: gameName };


        return <div><Interface><GameHeader><span dangerouslySetInnerHTML={wrappedASCII}></span></GameHeader>
        <GameScreen>
        <BarWrap><progress max="100" value={social}></progress></BarWrap> 
        <BarWrap> <progress max="100" value={virusc}><span></span></progress></BarWrap> 
        <BarWrap> {gameState.name}   ${money}  </BarWrap> 
        <BarLabels> Sociale Batterij: {social}%</BarLabels> 
        <BarLabels> Infectiekans: {virusc}%</BarLabels> 
        <BarLabels> {printToiletPaper(toiletPaper)}</BarLabels> 
        <ScreenText> <PaperTitle><p> {gameState.day} </p> </PaperTitle> 
                    <PaperTitle><p> {title} </p> </PaperTitle> 
                    <p> {content}</p> </ScreenText>  </GameScreen>
        {renderButtons(button1, setButton1, gameState, setGameState, count, setCount, setTitle, setContent, button2, setButton2, setSocial, setMoney, setVirusc, setToiletPaper)}
        </Interface></div>
}

function printToiletPaper(toilet: any){
    if(toilet){ 
        return <span> WC-papier: {toilet} </span>
    }
}



function renderButtons(button1: any, setButton1: any, gameState: GameState, setGameState: any, count: any, setCount: any, setTitle: any, setContent: any, button2: any, setButton2: any, setSocial: any, setMoney: any, setVirusc: any, setToiletPaper: any){
    if(!button2){
        return <span><GameButton1 onClick={() => {changeInterface(1, gameState, setGameState, count, setCount, setTitle, setContent, setButton1, setButton2, setSocial, setMoney, setVirusc, setToiletPaper)}}>
        {button1}
        </GameButton1></span>
    }
    if(button2){
    return <span><ButtonWrapper><GameButton2 onClick={() => changeInterface(1, gameState, setGameState, count, setCount, setTitle, setContent, setButton1, setButton2, setSocial, setMoney, setVirusc, setToiletPaper)}>
    {button1}
    </GameButton2>
    <GameButton2 onClick={() => changeInterface(2, gameState, setGameState, count, setCount, setTitle, setContent, setButton1, setButton2, setSocial, setMoney, setVirusc, setToiletPaper)}>
        {button2}
        </GameButton2></ButtonWrapper></span>
    }
}

function changeInterface(choice: any, gameState: GameState, setGameState: any, counter: any, setCount: any, setTitle: any, setContent: any, setButton1: any, setButton2: any, setSocial: any, setMoney: any, setVirusc: any, setToiletPaper: any){
   setCount(counter+=1);
   console.log(counter);
   if(gameState.buttonsPaper === "EINDE"){
        if (counter == 1){
            setTitle("JOUW SCORE: " + gameState.score);
            showRanklist(gameState.name, gameState.score, setContent);
        }
   }
   else{
   if (gameState.cycle == 1){
        if (counter == 1){
            console.log(gameState.cycle);
            setTitle("");
            setContent(gameState.goToWork);
            setButton1(gameState.buttonsWork1);
            setButton2(gameState.buttonsWork2);
        }
        else if(counter == 2){
            setCount(0);
            nextDay(gameState, setGameState, setContent, setTitle);
        }
   }
   else if (gameState.cycle > 1 && gameState.cycle < 7 ){
        if (counter == 1){
            setTitle("");
            setContent(gameState.goToWork);
            setButton1(gameState.buttonsWork1);
            setButton2(gameState.buttonsWork2);
    }
        else if (counter == 2 ){
            setTitle("");
            if(choice == "1"){
                saveAnswer("GoToWork", choice, setSocial, setMoney, setVirusc, setToiletPaper);
                setContent(gameState.ifOv);
            }
            else if(choice == "2"){
                saveAnswer("GoToWork", choice, setSocial, setMoney, setVirusc, setToiletPaper);
                setContent(gameState.ifBike);
            }
            setButton1(gameState.ifButton);
            setButton2("");
        }
        else if(counter == 3){
            setTitle("");
            setContent(gameState.afterWork);
            setButton1(gameState.buttonAw1);
            setButton2(gameState.buttonAw2);
        }
        else if(counter == 4){
            if(choice == "1"){
                saveAnswer("AfterWork", choice, setSocial, setMoney, setVirusc, setToiletPaper);
            }
            else if(choice == "2"){
                saveAnswer("AfterWork", choice, setSocial, setMoney, setVirusc, setToiletPaper);
            }
            nextDay(gameState, setGameState, setContent, setTitle);
            setButton1(gameState.buttonsPaper);
            setButton2("");
            setCount(0);
        }
    }
}

    function saveAnswer(event: string, choice: any, setSocial: any, setMoney: any, setVirusc: any, setToiletPaper: any){
        const putMethod = {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
           }
           
           fetch('pandemic/api/saveAnswer/' + event + "/" + choice, putMethod)
           .then(response => response.json())
           .then(data => {
            setSocial(data.social);
            setMoney(data.money);
            setVirusc(data.virusc);
            setToiletPaper(data.toilet);
        }) 
           .catch(err => console.log(err))
        }

    function nextDay(gameState: GameState, setGameState: any, setContent: any, setTitle: any){
         const putMethod = {
             method: 'PUT', 
             headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json'
             },
            }
            
            fetch('pandemic/api/nextDay/', putMethod)
            .then(response => response.json())
            .then(data => {
             gameState = data as GameState;
            setGameState(gameState);
            setTitle(gameState.paperTitle);
            setContent(gameState.paperContent);
         }) 
            .catch(err => console.log(err))
         }

         function showRanklist(name: string, score: any, setContent: any){
            const postMethod = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ namePlayer: name, scorePlayer: score })
            };
            fetch('pandemic/api/setScore', postMethod)
            .then(response => response.json())
            .then(data => {console.log(data);
            let display_txt = ["1. " + data.name1 + ": " + data.score1, <br/>, "2. " + data.name2 + ": " + data.score2, <br/>, "3. " + data.name3 + ": " + data.score3 , <br/>, "4. " + data.name4 + ": " + data.score4, <br/>, "5. " + data.name5 + ": " + data.score5, <br/>, "6. " + data.name6 + ": " + data.score6, <br/>, "7. " + data.name7 + ": " + data.score7, <br/>, "8. " + data.name8 + ": " + data.score8, <br/>, "9. " + data.name9 + ": " + data.score9, <br/>, "10. " + data.name10 + ": " + data.score10];
            setContent(display_txt);});
        }
}