

## Yahtzee Game API Documentation

Welcome to the JavaYahtzee API! This API allows you to interact with the game's core functionalities like rolling dice, holding dice, and scoring.

### Endpoints

#### 1. Roll Dice
- **Endpoint**: `/roll`
- **Method**: `GET`
- **Description**: Rolls the dice and returns the current state of the dice and the number of turns left.
- **Response**:
  - `dice`: Array of integers representing the values of each die.
  - `turnsRemaining`: Integer representing the number of turns left.

#### Example Response
```json
{
  "dice": [1, 3, 5, 6, 2],
  "turnsRemaining": 2
}
```

---

#### 2. Hold Dice
- **Endpoint**: `/hold`
- **Method**: `POST`
- **Description**: Updates the hold status of a die.
- **Request Body**:
  - `index`: Integer representing the index of the die to hold.
- **Response**:
  - `holdList`: Array of booleans representing the hold status of each die.

#### Example Request
```json
{
  "index": 2
}
```

#### Example Response
```json
{
  "holdList": [false, false, true, false, false]
}
```

---

#### 3. Score
- **Endpoint**: `/score`
- **Method**: `POST`
- **Description**: Calculates the score based on the selected category.
- **Request Body**:
  - `section`: String representing either "UPPER" or "LOWER" scoring section.
  - `category`: String representing the scoring category.
- **Response**:
  - `category`: String of the selected category.
  - `score`: Integer score for the selected category.
  - `upperTotal`: Integer representing the total score for the upper section.
  - `lowerTotal`: Integer representing the total score for the lower section.

#### Example Request
```json
{
  "category": "upper",
  "scoringSection": "fives"
}
```

#### Example Response
```json
{
  "category": "FIVES",
  "score": 15,
  "upperTotal": 26,
  "lowerTotal": 25
}
```

---

### General Information

- **Base URL**: The base URL for all API endpoints is `http://localhost:8080`.
- **Content-Type**: All requests and responses are in JSON format. Please ensure to set `Content-Type: application/json` in your HTTP request headers.


---

## Getting Started

To get started with the Yahtzee Game API, start by making a `GET` request to the `/roll` endpoint to roll the dice. Based on the game's progress, use the `/hold` endpoint to hold specific dice, and `/score` to calculate and retrieve scores for different categories.


---
