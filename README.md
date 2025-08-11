<div align="left" style="position: relative;">
<img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="right" width="30%" style="margin: -20px 0 0 20px;">
<h1>QC-TASK</h1>
<p align="left">
	<em><code>❯ A compact QC portfolio: Test Design, Ambiguity Analysis, API CRUD (Postman), SQL basics, and Java UI automation.</code></em>
</p>
<p align="left">Built with the tools and technologies:</p>
<p align="left">
	<a href="https://skillicons.dev">
		<img src="https://skillicons.dev/icons?i=java,maven,selenium,postman,mysql,sqlite,md">
	</a>
</p>
</div>
<br clear="right">

## 🔗 Table of Contents

- [📍 Overview](#-overview)
- [👾 Features](#-features)
- [📁 Project Structure](#-project-structure)
  - [📂 Project Index](#-project-index)
- [🚀 Getting Started](#-getting-started)
  - [☑️ Prerequisites](#-prerequisites)
  - [⚙️ Installation](#-installation)

---

## 📍 Overview

This repo collects my solutions for a QC task. It includes:
- 🧪 test cases for a telephone billing calculator (Regular vs Premium plans)
- 🧭 ambiguity analysis for HR vacation rules
- 🔌 a Postman CRUD collection for a dummy Employees API
- 🗃️ SQL scripts for a simple `Users` table with example queries
- 🤖 a Java UI test (Page Object + TestNG) that registers a new user on nopCommerce

---

## 👾 Features

- Clear, human-readable folder structure with small, focused artifacts
- API collection with basic assertions and an environment file
- Boundary and negative test cases for billing logic
- Ambiguity findings with suggested clarifications/acceptance criteria
- SQL schema + data + sample queries you can run in any SQL client
- UI automation using Java, Maven, Selenium, and the Page Factory pattern

---

## 📁 Project Structure

```sh
└── QC-Task/
    ├── API CRUD Collection
    │   ├── CRUD Environment.postman_environment.json
    │   ├── Employees API CRUD.postman_collection.json
    │   └── Postman Collection README.md
    ├── Ambiguity Analysis Task
    │   ├── Ambiguity Analysis.pdf
    │   └── INFO README.md
    ├── Automation Task
    │   ├── .gitignore
    │   ├── .idea
    │   ├── Drivers
    │   ├── TestSuite1.xml
    │   ├── TestSuite2.xml
    │   ├── pom.xml
    │   └── src
    ├── SQL Scripts
    │   └── SQL scripts.sql
    └── Test Cases
        └── Cellular Telephone Company Testing Suite.xlsx
