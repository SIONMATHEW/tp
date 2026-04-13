# Saayuj Ion's Project Portfolio Page

## Project: InternTrack

## Overview
InternTrack is a command-line application designed to help users efficiently manage internship applications. It supports adding, editing, filtering, and organising applications through a structured CLI workflow, with a focus on clarity, robustness, and ease of use.

---

## Summary of contributions

### Code contributed
[View my code contribution (RepoSense)](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=W10&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=SIONMATHEW&tabRepo=AY2526S2-CS2113-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

My contributions span multiple core components including command handling, parsing, model updates, storage integration, and UI output. I focused primarily on implementing complex features such as `edit`, `undo`, and archive-related functionality, ensuring correctness across the entire system.

---

### Enhancements implemented

#### 1. Edit Command (Core Feature)
- Designed and implemented a flexible `edit` command supporting partial updates using prefixed inputs.
- Introduced an `EditDetails` abstraction to encapsulate optional updates cleanly.
- Implemented validation for duplicate prefixes, invalid inputs, and empty fields before model mutation.
- Integrated across Parser, ApplicationList, Storage, and UI components.
- Added unit tests and defensive checks (logging, assertions).

**Highlights:**
- Required careful design to support multiple optional fields while preserving separation of concerns.
- Ensured scalability of the command as additional editable fields can be added without modifying method signatures.

**PRs:** [#14](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/14), [#22](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/22)

---

#### 2. Undo Command (Core Feature)
- Designed and implemented a snapshot-based undo mechanism.
- Used deep copy logic to preserve historical states and prevent reference sharing.
- Integrated undo support across all modifying commands (`add`, `edit`, `delete`, `archive`, `unarchive`).
- Ensured consistency between in-memory state and persisted storage.

**Highlights:**
- Required system-wide integration and careful handling of edge cases (e.g., empty history).
- Demonstrates understanding of state management and data integrity in CLI applications.

**PR:** [#34](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/34)

---

#### 3. Archive / Unarchive Feature
- Implemented soft-delete functionality using an `isArchived` flag.
- Designed archive system to preserve data while excluding archived entries from active operations.
- Integrated seamlessly with filtering, listing, sorting, and undo functionality.

**Highlights:**
- Required design trade-off between soft delete vs hard delete.
- Ensured compatibility with existing commands without duplicating logic.

---

### Contributions to the User Guide
- Authored sections for:
    - `archive`
    - `unarchive`
    - `listarchived`
- Provided clear command formats, examples, and expected outputs.
- Ensured consistency and readability through structured formatting.

---

### Contributions to the Developer Guide
- Wrote and refined major sections of the DG, including:
    - Parser component design and class diagram
    - Implementation of `edit`, `undo`, and archive features
- Designed and corrected UML diagrams:
    - Sequence diagrams for `edit`, `undo`, and archive workflows
    - Class diagram for Parser component
- Ensured diagrams follow strict SE-EDU UML conventions (method-based arrows, correct abstraction level).

**PRs:** [#24](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/24), [#40](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/40), [#51](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/51)

---

### Contributions to team-based tasks
- Set up and enforced GitHub fork-based workflow for the team.
- Guided team members on branching, PR workflow, and resolving merge issues.
- Managed releases (v1.0, v2.0, v2.1), including:
    - Generating JAR files
    - Uploading release assets
    - Ensuring documentation consistency

---

### Review / mentoring contributions
- Reviewed multiple PRs across features (summary, delete, DG updates, testing, UG updates).
- Provided feedback on:
    - Code correctness and edge cases
    - UML diagram accuracy
    - Documentation clarity and consistency
- Helped teammates debug issues and align with project architecture.

---

### Contributions beyond the project team
- Reported bugs and evaluated other teams’ products during the Practical Exam Dry Run.
- Applied SE-EDU bug classification guidelines (functionality bug, feature flaw, UG bug).