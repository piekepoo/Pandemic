import * as React from "react";
import ReactDOM from "react-dom";
import { App } from "./App";
import styled from "styled-components";


const Fullscreen = styled.div`
    padding: 0;
    position: absolute;
    top: 0px;  
    left: 0px;
    height: 100%;
    width: 100%; 
    background-color: black;
`;


ReactDOM.render(  
    <Fullscreen> <App/></Fullscreen>,
    document.getElementById("root")
)