---
applyTo: "src/test/java/com/nichethyself/tests/**/*.java"
---

# Copilot Custom Instructions: Test Classes

- Place all UI and API test classes in the `src/test/java/com/nichethyself/tests/` directory (and subfolders for organization).
- Each test class should focus on a single feature or end-to-end scenario (e.g., `LoginTest`, `EndToEndScenariosTest`).
- Use TestNG annotations (`@Test`, `@BeforeMethod`, `@AfterMethod`) for test structure.
- Import and use page objects for all UI interactions.
- Keep tests independent and stateless where possible.
- Use assertions to validate outcomes.
- Do not put page locators or business logic in test classes.
- Example file names: `LoginTest.java`, `ContactUsTest.java`.
