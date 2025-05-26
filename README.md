# 📱 Programming Languages Explorer

This is a simple yet functional Android demo application that displays a list of various programming languages along with their brief details. It is built using **Java**, **RecyclerView**, **Glide**, and **Volley**. This app is intended as a learning project and demonstrates API usage, image loading, search filtering, and detailed activity navigation.

---

## 🔍 Features

- 📋 Displays a list of programming languages in a RecyclerView.
- 🖼️ Loads programming language logos using Glide from URLs.
- 🌐 Fetches programming language data dynamically using Volley from a GitHub-hosted JSON.
- 🔍 Includes a **Search** feature to filter languages by name or release year.
- 📄 On clicking any programming language, it opens a **Detail Activity** that displays:
  - Full Name
  - Original/Old Name (if any)
  - Created By (Developer/Organization)
  - Release Year
  - Programming Language Logo
- 📚 Educational use: helps in learning basic facts about different programming languages.

---

## 🧑‍💻 Built With

- **Java**
- **Android SDK**
- **RecyclerView**
- **Glide** – for image loading
- **Volley** – for network requests
- **JSON** – hosted on GitHub
- **Material UI** – for a clean and modern layout

---

## 📸 Screenshots

### 🏠 Home Screen

Displays the list of programming languages with logos.

![Home Screen](https://github.com/user-attachments/assets/41f09f5f-317b-48fa-aee5-d98796a655c7)

---

### 📄 Detail Screen

Displays full information about the selected programming language.

![Detail Screen 1](https://github.com/user-attachments/assets/9e0f6a26-96e6-4d5c-9a9f-810fea7aed57)
![Detail Screen 2](https://github.com/user-attachments/assets/1065fc70-8f06-4f4b-b15f-c0bf9a991afb)

---

### 🔎 Search Feature

Search by name or release year.

![Search Screen 1](https://github.com/user-attachments/assets/ccd0a349-3154-4762-b1a3-c336e574ee46)
![Search Screen 2](https://github.com/user-attachments/assets/225d9600-0b30-4996-be44-484a67e3ff69)

---

## 🎥 Demo Video

> 📌 *Watch the working of this app in action!*  
> 🔗 [Click here to watch the demo video](https://github.com/user-attachments/assets/f2991b2b-17d3-4363-a0a5-9554c3ffab2b
)  


https://github.com/user-attachments/assets/f2991b2b-17d3-4363-a0a5-9554c3ffab2b


## Search



https://github.com/user-attachments/assets/1a377aa3-c328-4f8a-8087-cdc7b431ab26




---

## 💡 Notes

- This is a **demo project for learning purposes** – bugs and optimizations are expected.
- All images are fetched from public URLs via Glide.
- Data is statically hosted on GitHub for ease of use.
- Error handling can be improved in future updates.

---

## 🔍 Search Feature

The search allows filtering by:

- ✅ Programming Language Name
- ✅ Release Year

This makes it easier to find a language quickly from a long list.

---

## 📦 JSON Structure Example

```json

  {
    "name": "Java",
    "oldName": "Oak",
    "developer": "James Gosling",
    "year": "1995",
    "imageUrl": "https://example.com/java.png"
  }
 
