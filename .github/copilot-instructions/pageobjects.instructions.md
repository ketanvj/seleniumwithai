---
applyTo: "src/main/java/com/nichethyself/pageobjects/**/*.java"
---

# Copilot Custom Instructions: Page Objects

- Place all Page Object Model (POM) classes for web pages and reusable components in the `src/main/java/com/nichethyself/pageobjects/` directory.
- Each class should represent a single page or a significant UI component (e.g., `LoginPage`, `HomePage`).
- Use `@FindBy` annotations for element locators and initialize with `PageFactory`.
- Encapsulate all page interactions as public methods (e.g., `login()`, `search()`).
- Keep locators private and expose only business actions.
- Do not include test logic or assertions in page objects.
- Example file names: `LoginPage.java`, `HomePage.java`, `ContactUsPage.java`.
