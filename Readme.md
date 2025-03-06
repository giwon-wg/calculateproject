# Java Console Calculator

## Project Overview

This project is a **Java console-based calculator** that supports basic arithmetic operations as well as various mathematical functions (trigonometric functions, exponentiation, logarithm, modulus operations, etc.).  
It parses the user’s input, converts it into valid operations, and displays the result.

The program provides two modes:
- **Basic mode**, which performs only basic arithmetic operations.
- **Extended mode**, which includes enhanced functionalities for convenience.

**Note:** Parentheses and polynomial calculations are not supported.

---

## Key Features

### **1. Basic Arithmetic Operations**

| Operator | Description  |
| -------- | ----------- |
| `+`      | Addition    |
| `-`      | Subtraction |
| `*`      | Multiplication |
| `/`      | Division    |

### **2. Extended Operations Support**

| Operator  | Description         |
| --------- | ------------------- |
| `%`       | Modulus (`mod`)     |
| `^`       | Exponentiation (`pow`) |
| `qrt(x)`  | Square Root (`sqrt(x)`) |
| `log(x)`  | Natural Logarithm (`log(x)`) |

### **3. Trigonometric Functions**

| Operator  | Description            |
| --------- | ---------------------- |
| `sin(x)`  | Sine function (Degree Input) |
| `cos(x)`  | Cosine function (Degree Input) |
| `tan(x)`  | Tangent function (Degree Input) |

---

## Project Structure

```
calculateproject
│── Main.java         # Program execution (Calls App.java)
│── App.java          # Handles user input and operations
│── Calculator.java   # Performs calculations and manages history
│── OperatorType.java # Defines operator enums
```

---

## Execution Guide

### **Environment Requirements**

- **Java 11 or higher**
- **Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)**

### **Run the Program**

```sh
javac Main.java
java Main
```

---

## Example Input & Output

### **1. Basic Mode Arithmetic Operations**

```
Input: 10
Input: +
Input: 5

Output: 10 + 5 = 15.0
```

### **2. Extended Mode Arithmetic Operations**

```
Input: 8 * 4
Output: 8 * 4 = 32.0
```

### **3. Extended Operations**

```
Input: qrt(16)
Output: qrt(16) = 4.0
```

```
Input: log(10)
Output: log(10) = 2.30
```

```
Input: 2 ^ 3
Output: 2 ^ 3 = 8.0
```

### **4. Trigonometric Functions**

```
Input: sin(30)
Output: sin(30) = 0.50
```

```
Input: cos(45)
Output: cos(45) = 0.71
```

```
Input: tan(60)
Output: tan(60) = 1.73
```

### **5. View Calculation History**

```
Input: y
Output: Recent Calculation Results
	 ===========  
     15.0  
     32.0  
     4.0  
     2.30  
     8.0  
     5.0  
     ...  
     ===========  
```

---

## Planned Improvements & Additional Features

- **Parentheses support (`()` )**
- **Polynomial calculations (with operator precedence)**
- **Extended logarithmic operations (`log`, `ln`)**
- **Additional functions like factorial (`!`), absolute value (`|x|`), etc.**

---

