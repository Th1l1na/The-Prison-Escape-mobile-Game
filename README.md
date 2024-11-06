# The Prison Escape

**The Prison Escape** is an engaging mobile game that immerses players in the challenge of escaping from a prison. The game offers a thrilling experience where users must quickly and strategically interact with a dynamic button under time pressure. The game consists of two main activities: the Main Screen and the Gameplay Screen. This is one of my coursework which belongs to mobile application development at SLIIT in Y2S2.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Gameplay](#gameplay)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Instructions](#instructions)
- [Future Enhancements](#future-enhancements)
- [Contributors](#contributors)

## Introduction

**The Prison Escape** is designed to test your reflexes and strategy in a time-constrained environment. Players have 40 seconds to score as many points as possible by clicking a dynamic button whose state unpredictably alternates between clickable and non-clickable. Players must avoid penalties while aiming for the highest score, which is saved across sessions.

## Features

- **Intuitive Main Screen**: A clean interface with a prominent "Start" button to begin the game.
- **High Score Tracking**: The highest score is displayed on the Main Screen and updated using `ViewModel` and stored with `SharedPreferences` for persistence.
- **Timed Gameplay**: A 40-second timer challenges players to earn points by clicking the button.
- **Dynamic Button Interaction**: The button switches randomly between clickable and non-clickable states, adding unpredictability.
- **Score Penalties**: Clicking the button when it’s non-clickable results in a 5-point deduction.
- **Visual Elements**: Thoughtfully integrated image buttons enhance the user interface, providing an immersive experience.
- **Persistent High Scores**: High scores are saved and displayed across game sessions.

## Gameplay

1. **Main Screen**: Features a "Start" button that launches the game and displays the all-time high score.
2. **Gameplay Screen**: 
   - Players have 40 seconds to score by clicking a button.
   - The button randomly changes between clickable and non-clickable.
   - Points are awarded for each successful click when the button is clickable, while a penalty is incurred for incorrect clicks.
3. **End of Game**: 
   - The game concludes when the timer reaches zero.
   - If a new high score is achieved, it is saved for future reference.
4. **Hidden Objective**: Discover the hidden objective to unlock a special winner screen.

## Tech Stack

- **Android Studio**: IDE used for development.
- **Kotlin/Java**: Programming languages used for building the app.
- **ViewModel**: Used to manage UI-related data, including high scores.
- **SharedPreferences**: For persistent storage of high scores across game sessions.
- **XML Layouts**: For designing the user interface with image buttons and other visual elements.

## Installation

1. **Clone the repository**:
    ```bash
    [git clone https://github.com/your-username/prison-escape-game.git](https://github.com/Th1l1na/The-Prison-Escape-mobile-Game)
    ```
2. **Open the project in Android Studio**:
   - Launch Android Studio and open the project folder.
   
3. **Build the project**:
   - Ensure all necessary dependencies are installed.
   - Connect your Android device or emulator.
   
4. **Run the app**:
   - Click on the "Run" button in Android Studio to install the app on your connected device or emulator.

## Instructions for play

1. **Main Screen**:
   - Tap the "Start" button to begin the game.
   - The Main Screen also displays the highest score achieved.

2. **Gameplay Screen**:
   - Tap the "Start" button on this screen to begin the game.
   - A 40-second timer starts, and the button’s state alternates randomly between clickable and non-clickable.

3. **Scoring**:
   - Earn points by clicking the button while it's in a clickable state.
   - Be cautious: clicking the button when it’s non-clickable deducts 5 points from your score.

4. **End of Game**:
   - The game ends when the timer reaches zero.
   - If you set a new high score, it will be saved and displayed on the Main Screen for future sessions.

5. **Hidden Objective**:
   - Uncover the hidden objective to unlock the special winner screen and celebrate your success!

## Future Enhancements

- **Additional Levels**: Introduce multiple levels with increasing difficulty.
- **Leaderboards**: Add online leaderboards for global high score comparisons.
- **Bonus Objectives**: Include more hidden objectives and achievements.
- **Sound Effects & Animations**: Add immersive sound effects and animations for a richer experience.
- **Multiplayer Mode**: Implement a multiplayer mode for competitive play.

## Contributors

- [Thilina Samarasekara](https://github.com/Th1l1na)
