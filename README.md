# G04_SE-G07_Assignment
## Java-based String Encoder with GUI (TMF 2954 Group Assignment)

This project implements a custom Caesar cipher-style encoder using Java Swing. It features a unique, traceable encoding process driven by a hidden group-specific shift key derived from a hashed Group ID. Designed for the Semester 2, 2025/26 Java Programming course

## 🚀 Project Objective
To design a Java Swing application that generates an encoded version of a string using an internal shift key.

## 🛠️ Encoding Rules
1. **Validation**: Only lowercase `a-z`, `0-9`, and spaces.
2. **Shift Calculation**: 
   - `groupShift`: Derived from the `hashCode()` of our Group ID (Value: 1-10).
   - `finalShift`: `groupShift` + count of non-space characters.
3. **Cipher**: 
   - Letters: `(c - 'a' + finalShift) % 26 + 'a'`.
   - Digits: `(c - '0' + finalShift) % 10 + '0'`.

## 👥 Team Responsibilities
* *Member 1**: Core `Encoded` class & Validation.
* *Member 2**: Hashing (`hashCode`) & Cipher logic.
* *Member 3**: Java Swing GUI components.
* *Member 4**: Integration (`Assignment.java`) & Final Report.
