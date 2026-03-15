# N2 Exercise 1 - Custom @JsonSerializable Annotation

## 📌 Exercise Description
Create a custom annotation that serializes Java objects to JSON files using Java Reflection API.

## ✨ Functionalities
- Custom @JsonSerializable annotation with directory parameter
- JsonSerializer reads annotation at runtime via Reflection
- Serializes annotated classes (Person, Car) to .json files
- Rejects non-annotated classes (Pet) with a clear error message
- Uses default value for directory parameter if not specified

## 🛠 Technologies
- Java 21
- Java Reflection API (Class, Field, getAnnotation)
- Custom annotation (@interface)
- @Retention(RUNTIME), @Target(TYPE)
- Maven

