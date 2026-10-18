# G04_SE-G07_Assignment
## Java-based String Encoder with GUI (TMF 2954 Group Assignment)

This project implements a custom Caesar cipher-style encoder using Java Swing. It features a unique, traceable encoding process driven by a hidden group-specific shift key derived from a hashed Group ID. Designed for the Semester 2, 2025/26 Java Programming course

## 🚀 Project Objective
[cite_start]To design a Java Swing application that generates an encoded version of a string using an internal shift key[cite: 5].

## 🛠️ Encoding Rules
1. [cite_start]**Validation**: Only lowercase `a-z`, `0-9`, and spaces[cite: 17, 23].
2. **Shift Calculation**: 
   - [cite_start]`groupShift`: Derived from the `hashCode()` of our Group ID (Value: 1-10)[cite: 27, 28].
   - [cite_start]`finalShift`: `groupShift` + count of non-space characters[cite: 30].
3. **Cipher**: 
   - [cite_start]Letters: `(c - 'a' + finalShift) % 26 + 'a'`[cite: 35].
   - [cite_start]Digits: `(c - '0' + finalShift) % 10 + '0'`[cite: 36].

## 👥 Team Responsibilities
* *Member 1**: Core `Encoded` class & Validation[cite: 9, 23].
* *Member 2**: Hashing (`hashCode`) & Cipher logic[cite: 27, 31].
* *Member 3**: Java Swing GUI components[cite: 49].
* *Member 4**: Integration (`Assignment.java`) & Final Report[cite: 62, 65].
