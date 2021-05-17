# **Button Combo Puzzle**

This project of mine showcases a puzzle dealing with one's memory and coordination skills. It involves eight buttons, each with a linked combination to one another.
This is no traditional code lock. Each button needs to be pushed in a certain order. It doesn't matter which button you start from, just know that one button always has to be pressed before and after a specific button. 
**Click on src folder to view my code**

## **Jar Download**

[Puzzle.jar](https://github.com/abdulnad/ButtonComboPuzzleJAVA/raw/main/Puzzle.jar)

## **What this showcases**

This project showcases my knowledge of inheritance, linked lists, and basic java swing (GUI). Linked Lists was the primary data structure utilzed in this project. This project consists of a linkled lists build from scratch of a class of ButtonNode. ButtonNode extends JButton which is then used to create a linkedlist of ButtonNode classes. Feel free to navigate to the src file and view the open source of my class files. 

## **Demo**

Here we have eight buttons. Each of them are unpressed at the moment.

<img src="https://i.imgur.com/rqipHgG.png" alt="drawing" length = "400" width="500"/>

We need to find the sequence pattern to unlock this combination. Let's do some trial and error.

<img src="https://media.giphy.com/media/xn8TbcrB8s6JLf94Eb/giphy.gif" alt="drawing" length = "400" width="500"/>

We found one sequence that's starts with button 1 to button 7.

<img src="https://media.giphy.com/media/g6N5rGjOUknIJQGMEn/giphy.gif" alt="drawing" length = "400" width="500"/> <img src="https://media.giphy.com/media/Xg4VWSo7ldlkIymBgI/giphy.gif" alt="drawing" length = "400" width="500"/>

Here, we have a new sequence where button 5 can be pressed before button 1. So now we have a new sequence that goes from button 5-1-7. We can keep trying to figure out what comes after button 7 or what comoes befofore button 5, either way works.

<img src="https://i.imgur.com/OCoXkfV.png" alt="drawing" length = "400" width="500"/>

After the combination is fully unlocked, we have won!







