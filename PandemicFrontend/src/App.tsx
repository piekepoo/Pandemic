import React, { useState } from "react";
import styled from "styled-components";

<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet"></link>

const Interface = styled.div`
  margin: auto;
  width: 50%;
  font-family: 'VT323', monospace;
`;

const GameHeader = styled.div`
font-size: 100%;
text-align: left;
padding: 2px;

`;

const PaperTitle = styled.span`
font-weight: bold;
`;

const ScreenText = styled.div`
text-align: justify;
width: 50%;
margin: auto;
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

import { StartGame } from "./pandemic/StartGame";
import { Play } from "./pandemic/Play";
import { GameState } from "./pandemic/gameState";

export function App() {

    const [ gameState, setGameState ] = useState<GameState | undefined>(undefined);
    const [ errorMessage, setErrorMessage ] = useState("");

    async function tryStartGame(playerName: string, playerAge: string) {
        if (!playerName) {
            setErrorMessage("Voer een naam in!");
            return;
        }

        if (!playerAge) {
            setErrorMessage("Voer een geldige leeftijd in!");
            return;
        }

        setErrorMessage("");

        try {
            const response = await fetch('pandemic/api/setPlayer', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ namePlayer: playerName , agePlayer: playerAge })

            });
            if (response.ok) {
                const gameState = await response.json();
                setGameState(gameState);
            }
            setErrorMessage("Het is niet gelukt het spel te starten. Probeer het opnieuw.");
        } catch (error) {
            setErrorMessage(error.toString());
        }
    }

    

    if (!gameState) {
        return <StartGame onPlayersConfirmed={tryStartGame}
                          message={errorMessage}
        />
    }

    return <Play gameState={gameState} setGameState={setGameState} />

}








// export interface GameState {
//   dataString: String;
//   title: String;
//   text: String;
// }

// interface PlayProps {
//   gameState: GameState;
//   setGameState: any;
// }

// export function Play({ gameState, setGameState }: PlayProps ) {
//   let screenMessage;


//   try {
//   fetch(`pandemic/api/getPaper`, {
//     headers : { 
//       'Content-Type': 'application/json',
//       'Accept': 'application/json'
//      }

//   })
//   .then((response) => response.text())
//   .then((messages) => {console.log(messages);
//     dataString = messages;
//     //console.log(dataString[2]);
//     title = dataString[2];
// });
//     } catch (error) {
//     console.log(error);
//     }

  // title = "CHINEES VIRUS IN HET LAND";
  // text = "Een eng en gevaarlijk virus heeft zich in het land gevestigd en is verspreid vanuit China! Tot nu toe weten we nog niet zoveel, maar we weten wel dat het eng is. Dit is dus een oproep om voorzichtig te zijn, wat voorzichtig dan ook mag betekenen in deze context. Misschien dat als je een virus ziet, je het niet aan probeert te raken. Of zoiets.";

//     var gameName = [
//       "<pre><code>@@@@@@@    @@@@@@   @@@  @@@  @@@@@@@   @@@@@@@@  @@@@@@@@@@   @@@   @@@@@@@",
//       "@@@@@@@@  @@@@@@@@  @@@@ @@@  @@@@@@@@  @@@@@@@@  @@@@@@@@@@@  @@@  @@@@@@@@ ",
//       "@@!  @@@  @@!  @@@  @@!@!@@@  @@!  @@@  @@!       @@! @@! @@!  @@!  !@@ ",
//       "!@!  @!@  !@!  @!@  !@!!@!@!  !@!  @!@  !@!       !@! !@! !@!  !@!  !@! ",
//       "@!@@!@!   @!@!@!@!  @!@ !!@!  @!@  !@!  @!!!:!    @!! !!@ @!@  !!@  !@! ",
//       "!!@!!!    !!!@!!!!  !@!  !!!  !@!  !!!  !!!!!:    !@!   ! !@!  !!!  !!! ",
//       "!!:       !!:  !!!  !!:  !!!  !!:  !!!  !!:       !!:     !!:  !!:  :!! ",
//       ":!:       :!:  !:!  :!:  !:!  :!:  !:!  :!:       :!:     :!:  :!:  :!: ",
//       " ::       ::   :::   ::   ::   :::: ::   :: ::::  :::     ::    ::   ::: :::",
//       " :         :   : :  ::    :   :: :  :   : :: ::    :      :    :     :: :: :",
//       "</code></pre>",
//     ].join('\n');

//     // dangerouslySetInnerHTML expects an object like this:
//     var wrappedASCII = {__html: gameName };

//     return <div><Interface><GameHeader><span dangerouslySetInnerHTML={wrappedASCII}></span></GameHeader>
//     <GameScreen> <ScreenText><PaperTitle><p> {} </p> </PaperTitle> 
//     <p>{} </p> </ScreenText>  </GameScreen><GameButton>OK</GameButton>
//     </Interface></div>
// }}