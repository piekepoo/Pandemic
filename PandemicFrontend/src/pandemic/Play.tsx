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

`

const PaperTitle = styled.span`
font-weight: bold;
`

const Day = styled.span`
font-weight: bold;
`

const ScreenText = styled.div`
/* text-align: justify; */
width: 50%;
margin: auto;
`

const GameScreen = styled.span`
display: inline-block;
border: 3px solid;
width: 99%;
height: 380px;
text-align: center;
`
const GameButton1 = styled.button`
vertical-align: top;
font-size: 80%;
display: inline-block;
border: 3px solid;
width: calc(100%);
height: 75px;
/* line-height: 80px; */
text-align: center;
background-color: white;
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
/* line-height: 80px; */
text-align: center;
background-color: white;
&:hover{
        color: #228B22;
}
`
const ButtonWrapper = styled.span`
width: 103%;
`

;


interface PlayProps {
    gameState: GameState;
    setGameState: any;
}

export function Play({ gameState, setGameState }: PlayProps ) {
    let [count, setCount] = useState(0);
    const [title, setTitle] = useState(gameState.paperTitle);
    const [content, setContent] = useState(gameState.paperContent);
    const [button1, setButton1] = useState(gameState.buttonsPaper);
    const [button2, setButton2] = useState(undefined);
    // let title = gameState.paperTitle;
    // let content = gameState.paperContent;
    // let button = gameState.buttonsPaper;

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

          // dangerouslySetInnerHTML expects an object like this:
     var wrappedASCII = {__html: gameName };

    return <div><Interface><GameHeader><span dangerouslySetInnerHTML={wrappedASCII}></span></GameHeader>
        <GameScreen> <ScreenText>
            <PaperTitle><p> {gameState.day} </p> </PaperTitle> 
            <PaperTitle><p> {title} </p> </PaperTitle> 
            <p> {content}</p>
         </ScreenText>  </GameScreen>
        {renderButtons(button1, setButton1, gameState, count, setCount, setTitle, setContent, button2, setButton2)}


        </Interface></div>

}

function renderButtons(button1: any, setButton1: any, gameState: GameState, count: any, setCount: any, setTitle: any, setContent: any, button2: any, setButton2: any){
    if(!button2){
        return <span><GameButton1 onClick={() => changeInterface(gameState, count, setCount, setTitle, setContent, setButton1, setButton2)}>
        {button1}
        </GameButton1></span>
    }
    if(button2){
    return <span><ButtonWrapper><GameButton2 onClick={() => changeInterface(gameState, count, setCount, setTitle, setContent, setButton1, setButton2)}>
    {button1}
    </GameButton2>
    <GameButton2 onClick={() => changeInterface(gameState, count, setCount, setTitle, setContent, setButton1, setButton2)}>
        {button2}
        </GameButton2></ButtonWrapper></span>
    }
}

function changeInterface(gameState: GameState, counter: any, setCount: any, setTitle: any, setContent: any, setButton1: any, setButton2: any){
   setCount(counter+=1);
   if (counter == 1){
        setTitle("");
        setContent(gameState.goToWork);
        setButton1(gameState.buttonsWork1);
        setButton2(gameState.buttonsWork2);
    }
    else if (counter == 2){
        setTitle("");
        setContent(gameState.afterWork);
        setButton1(gameState.buttonAw1);
        setButton2(gameState.buttonAw2);
    }
    else{
        
    }

}