# Java Console Calculator

## 📌 Project Overview
This project is a **Java console-based calculator** that supports basic arithmetic operations as well as various mathematical functions (trigonometric functions, exponentiation, logarithm, modulus operations, etc.).  
It analyzes the input expression, converts it into the appropriate operator, and outputs the result.

---

## 📌 Key Features
### ✅ **1. Basic Arithmetic Operations**
| Operator | Description |
|---------|------------|
| `+`     | Addition |
| `-`     | Subtraction |
| `*`     | Multiplication |
| `/`     | Division |

### ✅ **2. Extended Operations Support**
| Operator | Description |
|---------|------------|
| `%`     | Modulus operation (`mod`) |
| `^`     | Exponentiation (`pow`) |
| `sqrt(x)` | Square root (`sqrt(x)`) |
| `log(x)` | Natural logarithm (`log(x)`) |

### ✅ **3. Trigonometric Functions**
| Operator | Description |
|---------|------------|
| `sin(x)` | Sine function (Degree input) |
| `cos(x)` | Cosine function (Degree input) |
| `tan(x)` | Tangent function (Degree input) |

---

## 📌 Project Structure
```
📂 calculateproject
│── 📄 Main.java         # Program execution (Calls App.java)
│── 📄 App.java          # Handles user input and calculations
│── 📄 Calculator.java   # Performs calculations and manages history
│── 📄 OperatorType.java # Defines operator Enum
```

---

## 📌 How to Run
### **1️⃣ Execution Environment**
- **Java 11 or higher**
- **Java execution environment such as IntelliJ IDEA, Eclipse, VS Code**

### **2️⃣ Running the Program**
```sh
javac Main.java
java Main
```

---

## 📌 Example Inputs & Outputs
### ✅ **1. Arithmetic Operations**
```
Input: 10 + 5
Output: 10 + 5 = 15.0
```
```
Input: 8 * 4
Output: 8 * 4 = 32.0
```

### ✅ **2. Extended Operations**
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

### ✅ **3. Trigonometric Functions**
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

---

## 📌 Future Improvements & Features
- **Support for Parentheses (`(2 + 3) * 4`)**
- **Polynomial Expression Handling (`2 + 3 * 4` → Operator Precedence Applied)**
- **Expand Logarithm Functions (`log2(x)`, `log10(x)`)**
- **Additional Operations such as Factorial (`n!`), Absolute Value (`abs(x)`)**

---

## 📌 License
This project is licensed under the **MIT License**.
```
MIT License
Copyright ...
```

---

🚀 **Run your powerful calculator now!** 😊🔥
```sh
javac Main.java
java Main
```

