---
applyTo: "src/main/java/com/nichethyself/reports/**/*.java"
---

# Copilot Custom Instructions: Reports

- Place all reporting-related classes in the `src/main/java/com/nichethyself/reports/` directory.
- Use clear, descriptive class and method names for report generation, formatting, and export (e.g., `ReportManager`, `HtmlReportGenerator`).
- Ensure reports are generated in standard formats (HTML, PDF, XML, etc.) as required by the project.
- Separate report configuration, data collection, and rendering logic for maintainability.
- Document any third-party libraries or frameworks used for reporting (e.g., ExtentReports, Allure).
- Provide utility methods for attaching screenshots, logs, and test metadata to reports.
- Avoid hardcoding file paths; use configuration files or environment variables.
- Ensure thread safety if reports are generated in parallel test execution.
- Follow the same code quality and documentation standards as the rest of the project.
