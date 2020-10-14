import React, { useState } from "react";
import styled from "styled-components";

<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet"></link>


const Interface = styled.div`
  margin: auto;
  width: 50%;
  font-family: 'VT323', monospace;

  
  
`;
const ErrorMessage = styled.p`
    color: #228B22;
`

const GameHeader = styled.div`
font-size: 100%;
text-align: left;
padding: 2px;

`

const PaperTitle = styled.span`
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
const Input = styled.input`
::placeholder,
  ::-webkit-input-placeholder {
    font-family: 'VT323', monospace;
    color: #228B22;
  }
  :-ms-input-placeholder {
    font-family: 'VT323', monospace;
    color: #228B22;
  }
`

const GameButton = styled.button`
display: inline-block;
border: 3px solid;
width: calc(100%);
height: 75px;
line-height: 80px;
text-align: center;
background-color: white;
font-family: 'VT323', monospace;
&:hover{
        color: #228B22;
}
`;


interface StartGameProps {
    message: string;
    onPlayersConfirmed(playerOne: string, playerTwo: string): void;
}


/**
 * Allows the players to enter their name.
 */
export function StartGame({ message, onPlayersConfirmed }: StartGameProps) {

    const [ playerName, setPlayerName ] = useState("");
    const [ playerAge, setPlayerAge ] = useState("");


//               try {
//   fetch(`pandemic/api/getPaper`, {
//     headers : { 
//       'Content-Type': 'application/json',
//       'Accept': 'application/json'
//      }

//   })
//   .then((response) => response.text());
//     } catch (error) {
//     console.log(error);
//     }


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
        <GameScreen> <ScreenText><PaperTitle><p> Welkom bij Pandemic! </p> </PaperTitle> 
        <p> Ga jij de pandemie overleven? <br></br><br></br>Om te beginnen zouden we graag je naam en leeftijd willen weten.</p>
        <p><Input value={playerName}
               placeholder="Je naam"
               onChange={(e) => setPlayerName(e.target.value)}
        /> </p>
                <p><Input value={playerAge}
               placeholder="Je leeftijd"
               onChange={(e) => setPlayerAge(e.target.value)}
        /></p>
        <ErrorMessage>{message}</ErrorMessage>
         </ScreenText>  </GameScreen><GameButton onClick={() => onPlayersConfirmed(playerName, playerAge)}>
            Verzenden
        </GameButton>
        </Interface></div>

}

