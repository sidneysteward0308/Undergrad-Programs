
let playerTurn = true; 
let computerMoveTimeout = 0; 


const gameStatus = {
  MORE_MOVES_LEFT: 1,
  HUMAN_WINS: 2,
  COMPUTER_WINS: 3,
  DRAW_GAME: 4,
};


document.addEventListener("DOMContentLoaded", domLoaded);

function domLoaded() {

  const newBtn = document.getElementById("newGameButton");
  newBtn.addEventListener("click", newGame);

  const buttons = getGameBoardButtons();
  for (let button of buttons) {
    button.addEventListener("click", function () {
      boardButtonClicked(button);
    });
  }


  newGame();
}

function getGameBoardButtons() {
  return document.querySelectorAll("#gameBoard > button");
}


function checkForWinner() {
  const buttons = getGameBoardButtons();


  const possibilities = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8], 
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8], 
    [0, 4, 8],
    [2, 4, 6],
  ];

  for (let indices of possibilities) {
    if (
      buttons[indices[0]].innerHTML !== "" &&
      buttons[indices[0]].innerHTML === buttons[indices[1]].innerHTML &&
      buttons[indices[1]].innerHTML === buttons[indices[2]].innerHTML
    ) {

      if (buttons[indices[0]].innerHTML === "X") {
        return gameStatus.HUMAN_WINS;
      } else {
        return gameStatus.COMPUTER_WINS;
      }
    }
  }

  for (let button of buttons) {
    if (button.innerHTML !== "X" && button.innerHTML !== "O") {
      return gameStatus.MORE_MOVES_LEFT;
    }
  }

  return gameStatus.DRAW_GAME;
}
function newGame() {
  clearTimeout(computerMoveTimeout); 
  computerMoveTimeout = 0;

  const buttons = getGameBoardButtons();
  for (let i = 0; i < buttons.length; i++) {
    buttons[i].innerHTML = ""; 
    buttons[i].removeAttribute("disabled"); 
    buttons[i].removeAttribute("class"); 
  }

  playerTurn = true; 
  document.getElementById("turnInfo").innerHTML = "Your Turn"; 
}


function boardButtonClicked(button) {
  if (playerTurn === true && button.innerHTML === "") {
    button.innerHTML = "X"; 
    button.classList.add("x"); 
    button.disabled = true; 
    switchTurn();
  }
}

function switchTurn() {
  const result = checkForWinner(); 

  if (result === gameStatus.MORE_MOVES_LEFT) {

    playerTurn = !playerTurn; 
    const turnInfo = document.getElementById("turnInfo");

    if (playerTurn) {
      turnInfo.innerHTML = "Your Turn"; 
    } else {
      turnInfo.innerHTML = "Computer's Turn"; 
      if (!playerTurn) {

        computerMoveTimeout = setTimeout(makeComputerMove, 1000);
      }
    }
  } else {

    playerTurn = false;
    const turnInfo = document.getElementById("turnInfo");

    if (result === gameStatus.HUMAN_WINS) {
      turnInfo.innerHTML = "You Win!";
    } else if (result === gameStatus.COMPUTER_WINS) {
      turnInfo.innerHTML = "Computer Wins!";
    } else {
      turnInfo.innerHTML = "Draw Game";
    }
  }
}

function makeComputerMove() {
  const buttons = getGameBoardButtons();
  const availableButtons = [];

  for (let button of buttons) {
    if (button.innerHTML === "") {
      availableButtons.push(button);
    }
  }

  if (availableButtons.length === 0) {

    return;
  }

  const randomIndex = Math.floor(Math.random() * availableButtons.length);
  const chosenButton = availableButtons[randomIndex];

  chosenButton.innerHTML = "O";
  chosenButton.classList.add("o");
  chosenButton.disabled = true;

  switchTurn(); 
}
