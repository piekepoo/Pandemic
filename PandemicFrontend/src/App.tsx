import React, { useState } from "react";
import styled from "styled-components";
//import { Play } from "./pandemic/Play";

<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet"></link>

const Interface = styled.div`
  margin: auto;
  width: 50%;
  font-family: 'VT323', monospace;
`;

const GameHeader = styled.div`
font-size: 1rem;
text-align: left;
color: #228B22;
padding: 2px;

`;

const PaperTitle = styled.span`
font-weight: bold;
`;

const ScreenText = styled.div`
text-align: justify;
width: 50%;
margin: auto;
/* padding: 50px; */
/* padding-top: 30px;
padding-left: 100px;
padding-right: 100px; */
`;

const GameScreen = styled.span`
display: inline-block;
border: 3px solid;
width: 100%;
height: 380px;
text-align: center;

`;

const GameButton = styled.button`
display: inline-block;
border: 3px solid;
width: 101%;
height: 50px;
line-height: 50px;
text-align: center;
background-color: white;
&:hover{
        color: #228B22;
}
`;

export function App() {
  let screenMessage;
  
try {
  fetch(`pandemic/api/getPaper`, {
    headers : { 
      'Content-Type': 'application/json',
      'Accept': 'application/json'
     }

  })
  .then((response) => response.text())
  .then((messages) => {console.log(messages);
    screenMessage = messages;
});
    } catch (error) {
    console.log(error);
    }



    var gameTitle = [
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
    var wrappedASCII = {__html: gameTitle };

    return <div><Interface><GameHeader><span dangerouslySetInnerHTML={wrappedASCII}></span></GameHeader>
    <GameScreen> <ScreenText><PaperTitle><p> CHINEES VIRUS IN HET LAND {screenMessage} </PaperTitle> </p>
    <p>Een eng en gevaarlijk virus heeft zich in het land gevestigd en is verspreid vanuit China! Tot nu toe weten we nog niet zoveel, maar we weten wel dat het eng is. Dit is dus een oproep om voorzichtig te zijn, wat voorzichtig dan ook mag betekenen in deze context. Misschien dat als je een virus ziet, je het niet aan probeert te raken. Of zoiets.</p> </ScreenText>  </GameScreen><GameButton>OK</GameButton>
    </Interface></div>
}


